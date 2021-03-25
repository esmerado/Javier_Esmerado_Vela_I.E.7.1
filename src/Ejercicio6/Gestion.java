package Ejercicio6;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase de unión para todos los métodos.
 * 
 * @author esmer
 *
 */
public class Gestion {

	public static void main(String[] args) {
		Map<String, Alumno> alumnos = new HashMap();
		
		alumnos.put("34678904", new Alumno("34678904", "Pepe"));
		alumnos.put("34678904", new Alumno("34678904", "Pepe", 125d));
		
		
		
	}
	
	
	
}
