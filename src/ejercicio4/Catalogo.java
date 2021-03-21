package ejercicio4;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

import javax.lang.model.element.Element;
import javax.swing.text.AbstractDocument.BranchElement;

import org.w3c.dom.ls.LSOutput;

/**
 * 
 * @author esmer
 *
 */
public class Catalogo {

	Scanner sc = new Scanner(System.in);
	Map<Integer, Escultura> esculturas;
	Map<Integer, Pinturas> pinturas;

	public Catalogo(Map<Integer, Escultura> esculturas, Map<Integer, Pinturas> pinturas) {
		super();
		this.esculturas = esculturas;
		this.pinturas = pinturas;
	}

	/**
	 * M�todo para a�adir obras.
	 */
	public void addObra() {
		try {
			System.out.println("Qu� tipo de obra deseas a�adir: ");
			System.out.println("1.- Escultura");
			System.out.println("2.- Pintura");
			System.out.println("3.- Salir");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				addEscultura();
				break;
			case 2:
				addPintura();
				break;
			default:
				exit();
				break;
			}

		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido alg�n valor err�neo.");
		}
	}

	/**
	 * M�todo generado con el extract method, el cual usamos para a�adir una
	 * pintura. Lo a�ado en un m�todo a parte para no tener t�ntas l�enas en el
	 * m�todo de addObra.
	 */
	private void addPintura() {
		System.out.println("Introduce el titulo de la pintura: ");
		String titulo = sc.nextLine();
		sc.nextLine();
		System.out.println("Introduce el n�mero de inventario: ");
		int numInve = sc.nextInt();
		System.out.println("Introduce el nombre del autor; ");
		String autor = sc.nextLine();
		sc.nextLine();
		System.out.println("Introduce el a�o de creaci�n de la escultura: ");
		String ano = sc.nextLine();
		System.out.println("Introduce la superficie de la pintura: ");
		double superficie = sc.nextDouble();
		System.out.println("Introduce el tipo de soporte: ");
		String soporte = sc.next();

		if (pinturas.containsKey(numInve)) {
			System.out.println("Esta obra ya est� a�adida.");
		} else {
			pinturas.put(numInve, new Pinturas(titulo, numInve, autor, ano, superficie, soporte));
			System.out.println("Escultura a�adida con �xito.");
		}
	}

	/**
	 * M�todo generado con el extract method, el cual usamos para a�adir una
	 * escultura. Lo a�ado en un m�todo a parte para no tener t�ntas l�enas en el
	 * m�todo de addObra.
	 */
	private void addEscultura() {
		System.out.println("Introduce el titulo de la escultura: ");
		String titulo = sc.nextLine();
		sc.nextLine();
		System.out.println("Introduce el n�mero de inventario: ");
		int numInve = sc.nextInt();
		System.out.println("Introduce el nombre del autor; ");
		String autor = sc.nextLine();
		sc.nextLine();
		System.out.println("Introduce el a�o de creaci�n de la escultura: ");
		String ano = sc.nextLine();
		System.out.println("Introduce el material de la escultura: ");
		String material = sc.next();
		System.out.println("Introduce la altura de la escultura");
		double altura = sc.nextDouble();

		if (esculturas.containsKey(numInve)) {
			System.out.println("Esta obra ya est� a�adida.");
		} else {
			esculturas.put(numInve, new Escultura(titulo, numInve, autor, ano, material, altura));
			System.out.println("Escultura a�adida con �xito.");
		}
	}

	/**
	 * M�todo para salir del programa.
	 */
	public void exit() {
		System.out.println("HASTA PRONTO!!!");
		System.exit(1);
	}

	/**
	 * M�todo para eliminar obras.
	 */
	public void removeObra() {
		try {
			System.out.println("Qu� tipo de obra deseas eliminar: ");
			System.out.println("1.- Escultura");
			System.out.println("2.- Pintura");
			System.out.println("3.- Salir");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				removeEscultura();
				break;
			case 2:
				removePintura();
				break;
			default:
				exit();
				break;
			}

		} catch (Exception e) {
			System.err.println("[ERROR]: Ha introducido alg�n valor err�neo.");
		}
	}

	/**
	 * M�todo para eliminar las pinturas.
	 */
	private void removePintura() {
		System.out.println("Estas son las pinturas disponibles: ");
		showPinturas();
		System.out.println("Introduzca el n�mero de inventario de la pintura que desea eliminar: ");
		int n2 = sc.nextInt();
		if (pinturas.containsKey(n2)) {
			pinturas.remove(n2);
			System.out.println("Pintura eliminada con �xito!!!");
		} else {
			System.err.println("[ERROR]: La obra seleccionada no se encuentra disponible");
		}
	}

	/**
	 * M�todo para eliminar las esculturas.
	 */
	private void removeEscultura() {
		System.out.println("Estas son las esculturas disponibles: ");
		showEscultura();
		System.out.println("Introduzca el n�mero de inventario de la escultura que desea eliminar: ");
		int n = sc.nextInt();
		if (esculturas.containsKey(n)) {
			esculturas.remove(n);
			System.out.println("Escultura eliminada con �xito!!!");
		} else {
			System.err.println("[ERROR]: La obra seleccionada no se encuentra disponible");
		}
	}

	/**
	 * M�todo para mostrar las esculturas.
	 */
	public void showEscultura() {
		esculturas.values().stream().forEach(System.out::println);
	}

	/**
	 * M�todo para mostrar las pinturas.
	 */
	public void showPinturas() {
		pinturas.values().stream().forEach(System.out::println);
	}

	/**
	 * M�todo para buscar una obra.
	 */
	public void searchObra() {
		System.out.println("Estas son las obras disponibles: ");
		showEscultura();
		showPinturas();
		System.out.println("Introduce el numero de inventario de la obra que desea buscar: ");
		int num = sc.nextInt();
		if (esculturas.containsKey(num)) {
			Escultura e = esculturas.get(num);
			e.muestra();
		} else if (pinturas.containsKey(num)) {
			Pinturas p = pinturas.get(num);
			p.muestra();
		} else {
			System.err.println("[ERROR]: El n�mero introducido no coincide con ninguna obra.");
		}
	}

	/**
	 * M�todo para obtener el numero de inventario de la escultura m�s alta.
	 */
	public void masAlta() {
		System.out.println("Buscando la escultura m�s alta........");
		Escultura maxAltura = esculturas.values().stream().max((x, y) -> x.getAltura().compareTo(y.getAltura())).get();
		System.out.println("El n�mero de inventario de la escultura m�s alta es " + maxAltura.getNumInvetario());
	}

	/**
	 * M�todo para obtener la suma de las superficies de las pinturas del museo.
	 */
	public double superficie() {
		System.out.println("Calculando la suma total........");
		System.out.println("La suma total de las superficies es: ");
		return pinturas.values().stream().mapToDouble(l -> l.getSuperficie()).sum();
	}
	
	/**
	 * M�todo de uni�n.
	 */
	public void acceso() {
		System.out.println("--->BIENVENIDO<---");
		System.out.println("Qu� acci�n desea realizar: ");
		// TODO: falta realizar la uni�n final.
	}
}
