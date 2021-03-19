package ejercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionMain {

	public static void main(String[] args) {

		Map<String, Admin> adminMap = new HashMap();
		Map<String, Moderadores> modMap = new HashMap();
		
		adminMap.put("esme@gmail.com", new Admin("esme@gmail.com", "Javi"));
		adminMap.put("gutierrez@gmail.com", new Admin("gutierrez@gmail.com", "Nadia"));
		modMap.put("esmerado@gmail.com", new Moderadores("esmerado@gmail.com", "Javi"));
		modMap.put("guti@gmail.com", new Moderadores("guti@gmail.com", "Nadia"));
		
		Gestion g = new Gestion(modMap, adminMap);
		
		g.acceder();
	}

}
