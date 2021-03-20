package ejercicio3;

import java.util.HashMap;
import java.util.Map;

public class BMain {

	public static void main(String[] args) {

		Map<Integer, Libro> libros = new HashMap<>();
		Map<Integer, Revista> revistas = new HashMap<>();

		libros.put(1112, new Libro(1112, "Charles you are p1", 2012));
		libros.put(1113, new Libro(1113, "Smooth operator", 2009));
		libros.put(1114, new Libro(1114, "Lewis Box now", 2011));
		revistas.put(2112, new Revista(1, 2112, "La odisea de Vettel", 2020));
		revistas.put(2113, new Revista(2, 2113, "Its sunday then", 2008));
		revistas.put(2114, new Revista(3, 2114, "SIIIIIIII", 2005));
		Biblioteca b = new Biblioteca(libros, revistas);
		b.acceso();
	}

}
