
package ejercicio1;

import java.util.Scanner;

public class Admin extends Usuario {

	Scanner scanner = new Scanner(System.in);
	private int nBaneos = 0;

	public Admin() {
	}

	public Admin(String email, String nick) {
		super(email, nick);
	}

	public int getnBaneos() {
		return nBaneos;
	}

	public void setnBaneos(int nBaneos) {
		this.nBaneos = nBaneos;
	}

	// Cambiamos el nick del administrador
	public void cambiarNick() {
		String nNick = null;
		try {
			System.out.println("Introduce el nuevo nick: ");
			nNick = sc.nextLine();
		} catch (Exception e) {
			System.err.println("Lo sentimos el nick introducido no es v�lido");
		}
	}

	// A�adimos un baneo
	public void bannear() {
		System.out.println("Banneo realizado con �xito!!");
		nBaneos++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nBaneos;
		return result;
	}

	@Override
	public String toString() {
		return "email: " + getEmail() + "nick: " + getNick() + "mensajes: " + getMensajes() + "pepelera: "
				+ getPapelera() + "nBaneos: " + nBaneos;
	}

}
