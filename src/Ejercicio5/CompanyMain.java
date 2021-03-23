package Ejercicio5;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Main
 * 
 * @author esmer
 *
 */
public class CompanyMain {

	public static void main(String[] args) {

		Map<Integer, Empleado> empleados = new HashMap();
		
		empleados.put(111, new EmpleadoAsalario("Javier", "Esmerado", 111, 1500d));
		empleados.put(112, new EmpleadoPorHoras("Nadia", "Gutierrez", 112, 1300d, 43d));
		empleados.put(113, new EmpleadoPorComision("Manu", "Fernandez", 113, 320d, 200d));
		empleados.put(114, new EmpleadoBaseMasComision("Javi", "Ramos", 114, 220d, 210d));
		
		Company c = new Company(empleados);
		
		c.acceder();

	}

}
