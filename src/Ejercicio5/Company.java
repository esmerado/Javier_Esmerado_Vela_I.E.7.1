package Ejercicio5;

import java.awt.Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import junit.extensions.TestSetup;

/**
 * Clase para la unificación de métodos.
 * 
 * @author esmer
 *
 */
public class Company {

	Scanner sc = new Scanner(System.in);
	Map<Integer, Empleado> empleados = new HashMap();

	public Company(Map<Integer, Empleado> empleados) {
		super();
		this.empleados = empleados;
	}

	/**
	 * Método para añadir empleados.
	 */
	public void addEmpleado() {
		menu();
		int num = sc.nextInt();
		switch (num) {
		case 1:
			addEmpleadoAsalariado();
			break;

		case 2:
			addEmpleadoPorHoras();
			break;
		case 3:
			addEmpleadoPorComision();
			break;
		case 4:
			addEmpleadoBaseMasComision();
		default:
			exit();
			break;
		}

	}

	/**
	 * Método para salir del programa.
	 */
	public void exit() {
		System.out.println("HASTA PRONTO!!!");
		System.exit(0);
	}

	/**
	 * Método para añadir empleados base mas comision.
	 */
	private void addEmpleadoBaseMasComision() {
		try {
			System.out.println("Introduzca su nombre:");
			String nombre2 = sc.next();
			System.out.println("Introduzca su primer apellido:");
			String apellido2 = sc.next();
			System.out.println("Introduzca su número de la Seguridad Social:");
			int nss2 = sc.nextInt();
			System.out.println("Introduzca el volumen de ventas: ");
			Double vv = sc.nextDouble();
			System.out.println("Introduzca la tarifa: ");
			Double tarifa = sc.nextDouble();
			if (empleados.containsKey(nss2)) {
				System.err.println("[ERROR]: Está intentando introducir un usuario que ya se encuentra en el sistema.");
			} else {
				System.out.println("Añadiendo empleado..........");
				empleados.put(nss2, new EmpleadoBaseMasComision(nombre2, apellido2, nss2, vv, tarifa));
				System.out.println("Empleado añadido con éxito!!");
			}
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Método para añadir empelados por comision.
	 */
	private void addEmpleadoPorComision() {
		try {
			System.out.println("Introduzca su nombre:");
			String nombre = sc.next();
			System.out.println("Introduzca su primer apellido:");
			String apellido = sc.next();
			System.out.println("Introduzca su número de la Seguridad Social:");
			int nss = sc.nextInt();
			System.out.println("Introduzca el volumen de ventas: ");
			Double vv = sc.nextDouble();
			System.out.println("Introduzca la tarifa: ");
			Double tarifa = sc.nextDouble();
			if (empleados.containsKey(nss)) {
				System.err.println("[ERROR]: Está intentando introducir un usuario que ya se encuentra en el sistema.");
			} else {
				System.out.println("Añadiendo empleado..........");
				empleados.put(nss, new EmpleadoPorComision(nombre, apellido, nss, vv, tarifa));
				System.out.println("Empleado añadido con éxito!!");
			}
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/*
	 * Método para añadir empleados por hora.
	 */
	private void addEmpleadoPorHoras() {
		try {
			System.out.println("Introduzca su nombre:");
			String nombre = sc.next();
			System.out.println("Introduzca su primer apellido:");
			String apellido = sc.next();
			System.out.println("Introduzca su número de la Seguridad Social:");
			int nss = sc.nextInt();
			System.out.println("Introduzca el sueldo por hora: ");
			Double sph = sc.nextDouble();
			System.out.println("Introduzca las horas trabajadas: ");
			Double ht = sc.nextDouble();
			if (empleados.containsKey(nss)) {
				System.err.println("[ERROR]: Está intentando introducir un usuario que ya se encuentra en el sistema.");
			} else {
				System.out.println("Añadiendo empleado..........");
				empleados.put(nss, new EmpleadoPorHoras(nombre, apellido, nss, sph, ht));
				System.out.println("Empleado añadido con éxito!!");
			}
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Método para añadir empleados asalariados.
	 */
	private void addEmpleadoAsalariado() {
		try {
			System.out.println("Introduzca su nombre:");
			String nombre = sc.next();
			System.out.println("Introduzca su primer apellido:");
			String apellido = sc.next();
			System.out.println("Introduzca su número de la Seguridad Social:");
			int nss = sc.nextInt();
			System.out.println("Introduce el salario semanal: ");
			Double salario = sc.nextDouble();
			if (empleados.containsKey(nss)) {
				System.err.println("[ERROR]: Está intentando introducir un usuario que ya se encuentra en el sistema.");
			} else {
				System.out.println("Añadiendo empleado..........");
				empleados.put(nss, new EmpleadoAsalario(nombre, apellido, nss, salario));
				System.out.println("Empleado añadido con éxito!!");
			}
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Método para el menú de seleccion.
	 */
	private void menu() {
		System.out.println("Seleccione un tipo de empleado:");
		System.out.println("1.- Empleado Asalariado.");
		System.out.println("2.- Empleado por horas.");
		System.out.println("3.- Empleado por comision.");
		System.out.println("4.- Empleado base más comsion.");
		System.out.println("5.- Salir");
	}

	/**
	 * Método para mostrar todos los empleados.
	 */
	public void showEmpleados() {
		empleados.values().stream().forEach(System.out::println);
	}

	/**
	 * Método para eliminar empleados.
	 */
	public void removeEmpleado() {
		try {
			System.out.println("Seleccione uno de los empleados para eliminar: ");
			showEmpleados();
			System.out.println("Introduce el número de la SS para eliminar al empleado:");
			int nss = sc.nextInt();
			if (empleados.containsKey(nss)) {
				System.out.println("ELiminando al empleado.........");
				empleados.remove(nss);
				System.out.println("Empleado eliminado con éxito!!");
			} else {
				System.err.println("[ERROR]: El empleado que desea elmiminar no se encuentra en el sisteam.");
			}
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Metodo para modificar los datos del empleado.
	 */
	public void modificarEmpleado() {
		try {
			System.out.println("Qué empleado desea modificar: ");
			showEmpleados();
			System.out.println("Introduce el numero de la SS para modificarlo.");
			int nss = sc.nextInt();
			if (empleados.get(nss) instanceof EmpleadoAsalario) {
				modificarEmpleadoAsalariado(nss);
			} else if (empleados.get(nss) instanceof EmpleadoPorHoras) {
				modificarEmpleadoPorHoras(nss);
			} else if (empleados.get(nss) instanceof EmpleadoPorComision) {
				modificarEmpleadoPorComision(nss);
			} else if (empleados.get(nss) instanceof EmpleadoBaseMasComision) {
				modificarEmpleadoBaseMasComision(nss);
			}
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Método para modificar el empleado base mas comision.
	 * 
	 * @param nss
	 */
	private void modificarEmpleadoBaseMasComision(int nss) {
		try {
			EmpleadoBaseMasComision ebc = (EmpleadoBaseMasComision) empleados.get(nss);
			System.out.println("Introduce el nuevo nombre: ");
			String nombre = sc.next();
			System.out.println("Introduce el nuevo apellido: ");
			String apellido = sc.next();
			System.out.println("Introduce el nuevo número de la SS: ");
			Integer numSS = sc.nextInt();
			System.out.println("introduce el nuevo volumen de ventas: ");
			Double vv = sc.nextDouble();
			System.out.println("Introduce la nueva tarifa: ");
			Double tarifa = sc.nextDouble();
			System.out.println("");
			System.out.println("Modificando datos............");
			ebc.establecer(nombre, apellido, numSS);
			ebc.establecer(vv, tarifa);
			System.out.println("Datos modificados con éxito!!");
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Método para modificar el empleado por comision.
	 * 
	 * @param nss
	 */
	private void modificarEmpleadoPorComision(int nss) {
		try {
			EmpleadoPorComision ec = (EmpleadoPorComision) empleados.get(nss);
			System.out.println("Introduce el nuevo nombre: ");
			String nombre = sc.next();
			System.out.println("Introduce el nuevo apellido: ");
			String apellido = sc.next();
			System.out.println("Introduce el nuevo número de la SS: ");
			Integer numSS = sc.nextInt();
			System.out.println("introduce el nuevo volumen de ventas: ");
			Double vv = sc.nextDouble();
			System.out.println("Introduce la nueva tarifa: ");
			Double tarifa = sc.nextDouble();
			System.out.println("Modificando datos............");
			ec.establecer(nombre, apellido, numSS);
			ec.establecer(vv, tarifa);
			System.out.println("Datos modificados con éxito!!");
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Método para modificar el empleado por horas.
	 * 
	 * @param nss
	 */
	private void modificarEmpleadoPorHoras(int nss) {
		try {
			EmpleadoPorHoras eh = (EmpleadoPorHoras) empleados.get(nss);
			System.out.println("Introduce el nuevo nombre: ");
			String nombre = sc.next();
			System.out.println("Introduce el nuevo apellido: ");
			String apellido = sc.next();
			System.out.println("Introduce el nuevo número de la SS: ");
			Integer numSS = sc.nextInt();
			System.out.println("introduce el nuevo sueldo por horas: ");
			Double sueldo = sc.nextDouble();
			System.out.println("Introduce el nuevo número de horas trabajadas: ");
			Double horas = sc.nextDouble();
			System.out.println("Modificando datos............");
			eh.establecer(nombre, apellido, numSS);
			eh.establecer(sueldo, horas);
			System.out.println("Datos modificados con éxito!!");
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Método para modificar el empleado asalariado.
	 * 
	 * @param nss
	 */
	private void modificarEmpleadoAsalariado(int nss) {
		try {
			EmpleadoAsalario ea = (EmpleadoAsalario) empleados.get(nss);
			System.out.println("Introduce el nuevo nombre: ");
			String nombre = sc.next();
			System.out.println("Introduce el nuevo apellido: ");
			String apellido = sc.next();
			System.out.println("Introduce el nuevo número de la SS: ");
			Integer numSS = sc.nextInt();
			System.out.println("introduce el nuevo salario: ");
			Double salario = sc.nextDouble();
			System.out.println("Modificando datos............");
			ea.establecer(nombre, apellido, numSS);
			ea.establecer(salario);
			System.out.println("Datos modificados con éxito!!");
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	/**
	 * Método para saber el salario de un empleado.
	 */
	public void calcularSalario() {
		try {
			System.out.println("De qué empleado deseas saber el salario: ");
			showEmpleados();
			System.out.println("Introduce el numero de la SS para saber el salario.");
			int nss = sc.nextInt();
			if (empleados.get(nss) instanceof EmpleadoAsalario) {
				EmpleadoAsalario ea = (EmpleadoAsalario) empleados.get(nss);
				ea.ingresos();
			} else if (empleados.get(nss) instanceof EmpleadoPorHoras) {
				EmpleadoPorHoras eh = (EmpleadoPorHoras) empleados.get(nss);
				eh.ingresos();
			} else if (empleados.get(nss) instanceof EmpleadoPorComision) {
				EmpleadoPorComision ec = (EmpleadoPorComision) empleados.get(nss);
				ec.ingresos();
			} else if (empleados.get(nss) instanceof EmpleadoBaseMasComision) {
				EmpleadoBaseMasComision ebc = (EmpleadoBaseMasComision) empleados.get(nss);
				ebc.ingresos();
			}
		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido algún datos erróneo.");
		}
	}

	public void acceder() {
		System.out.println("--->BIENVENIDO<---");
		do {
			System.out.println("Que acción desea realizar: ");
			System.out.println("1.- Añadir empleado.");
			System.out.println("2.- Listar empleados.");
			System.out.println("3.- Modificar empleados.");
			System.out.println("4.- Eliminar empleados.");
			System.out.println("5.- Mostrar salario.");
			System.out.println("6.- Salir");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				addEmpleado();
				break;
			case 2:
				showEmpleados();
				break;
			case 3:
				modificarEmpleado();
				break;
			case 4:
				removeEmpleado();
				break;
			case 5:
				calcularSalario();
				break;
			default:
				exit();
				break;
			}
		} while (true);
	}

}
