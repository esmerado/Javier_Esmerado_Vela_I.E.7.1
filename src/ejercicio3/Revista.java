package ejercicio3;

/**
 * Clase Revista
 * 
 * @author esmer
 *
 */
public class Revista extends General {
	/**
	 * Atributos principales
	 */
	private int numRevista;

	/**
	 * Constructor principal
	 * 
	 * @param numRevista
	 * @param codigo
	 * @param titulo
	 * @param anoPublicacion
	 */
	public Revista(int numRevista, int codigo, String titulo, int anoPublicacion) {
		super(codigo, titulo, anoPublicacion);
		this.numRevista = numRevista;
	}

	public int getNumRevista() {
		return numRevista;
	}

	public void setNumRevista(int numRevista) {
		this.numRevista = numRevista;
	}

	/**
	 * M�todo para saber el a�o de publicaci�n de la revista
	 */
	@Override
	public void knowDate() {
		System.out.println("Esta revista se public� en el a�o " + getAnoPublicacion());
	}

	/**
	 * M�todo para obtener el c�digo de la revista
	 */
	@Override
	public void knowCod() {
		System.out.println("El c�digo de esta revista es " + getCodigo());
		
	}

	@Override
	public String toString() {
		return "Numero Revista: " + numRevista + ", Codigo: " + getCodigo() + ", Titulo: " + getTitulo()
				+ ", A�o de Publicacion: " + getAnoPublicacion();
	}

}
