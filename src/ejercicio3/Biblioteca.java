package ejercicio3;

import java.util.Map;
import java.util.Scanner;

import org.junit.validator.PublicClassValidator;

/**
 * Clase general para la implementación de métodos.
 * 
 * @author esmer
 *
 */
public class Biblioteca {

	Scanner sc = new Scanner(System.in);
	Map<Integer, Libro> libros;
	Map<Integer, Revista> revistas;

	public Biblioteca(Map<Integer, Libro> libros, Map<Integer, Revista> revistas) {
		super();
		this.libros = libros;
		this.revistas = revistas;
	}

	/**
	 * Método para saber los libros que están prestados
	 * 
	 * @param g
	 */
	public void cuentaPrestados() {
		System.out.println("Estos son los libros que están prestados: ");
		libros.values().stream().filter(l -> l.prestado() == true).map(l -> l.toString()).forEach(System.out::println);

	}

	/**
	 * Método para obtener los titulos de libros y revistas publicaciones antes de
	 * la fecha indicada.
	 * 
	 * @param g
	 * @param ano
	 */
	public void publicacionesAnteriores() {
		System.out.println("Introduzca un año: ");
		int ano = sc.nextInt();
		System.out.println("Las publicaciones publicadas antes del año " + ano + " son: ");
		libros.values().stream().filter(l -> l.getAnoPublicacion() < ano).map(l -> l.toString())
				.forEach(System.out::println);

		revistas.values().stream().filter(l -> l.getAnoPublicacion() < ano).map(l -> l.toString())
				.forEach(System.out::println);

	}

	/**
	 * Método para terminar el programa
	 */
	public void exit() {
		System.out.println("VUELTA PRONTO!!!");
		System.exit(1);
	}

	/**
	 * Método para mostrar todos los datos
	 */
	public void mostrarDatos() {
		libros.values().stream().forEach(System.out::println);
		revistas.values().stream().forEach(System.out::println);
	}

	/**
	 * Método para prestar libros
	 */
	public void prestarLibro() {
		try {
			System.out.println("Estos son los libros disponibles");
			libros.values().stream().filter(l -> l.prestado() == false).map(l -> l.toString())
					.forEach(System.out::println);
			System.out.println("Introduzca el código del libro que desea llevarse: ");
			int num = sc.nextInt();
			Libro l = libros.get(num);
			l.prestar();

		} catch (Exception e) {
			System.err.println("[ERROR]: ALGO HA SALIDO MAL, VUELVA A INTENTARLO");
		}
	}

	/**
	 * Método para devolver libros
	 */
	public void devolverLibro() {
		try {
			System.out.println("Estos son los libros disponibles para devolver");
			libros.values().stream().filter(l -> l.prestado() == true).map(l -> l.toString())
					.forEach(System.out::println);
			System.out.println("Introduzca el código del libro que desea llevarse: ");
			int num = sc.nextInt();
			Libro l = libros.get(num);
			l.devolver();

		} catch (Exception e) {
			System.err.println("[ERROR]: ALGO HA SALIDO MAL, VUELVA A INTENTARLO");
		}
	}

	/**
	 * Método general para unificar el programa.
	 */
	public void acceso() {
		do {
			menu();
			int num = sc.nextInt();
			switch (num) {
			case 1:
				mostrarDatos();
				break;
			case 2:
				prestarLibro();
				break;
			case 3:
				devolverLibro();
				break;
			case 4:
				cuentaPrestados();
				break;
			case 5:
				publicacionesAnteriores();
				break;
			case 6:
				exit();
			}
		} while (true);

	}

	/**
	 * Método con el menú
	 */
	private void menu() {
		System.out.println("--->BIENVENIDO<---");
		System.out.println("Qué operación desea realizar: ");
		System.out.println("1.- Mostrar datos");
		System.out.println("2.- Prestar libro");
		System.out.println("3.- Devolver libro");
		System.out.println("4.- Mostrar número de libros prestados");
		System.out.println("5.- Mostrar publicaciones anteriores");
		System.out.println("6.- Salir");
	}

}
