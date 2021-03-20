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
	 * Método para saber el año de publicación de la revista
	 */
	@Override
	public void knowDate() {
		System.out.println("Esta revista se publicó en el año " + getAnoPublicacion());
	}

	/**
	 * Método para obtener el código de la revista
	 */
	@Override
	public void knowCod() {
		System.out.println("El código de esta revista es " + getCodigo());
		
	}

	@Override
	public String toString() {
		return "Numero Revista: " + numRevista + ", Codigo: " + getCodigo() + ", Titulo: " + getTitulo()
				+ ", Año de Publicacion: " + getAnoPublicacion();
	}

}
