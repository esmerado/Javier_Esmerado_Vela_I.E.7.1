package Ejercicio6;

import java.util.Map;

/**
 * Clase alumno.
 * 
 * @author esmer
 *
 */
public class Alumno {

	private String dni;
	private String nombre;
	private Double saldo = 100d;
	Map<String, Curso> cursosRealizados;
	Map<String, Curso> cursosMatriculado;

	public Alumno(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.cursosRealizados = cursosRealizados;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void incrementarSaldo(Double iSaldo) {
		this.saldo += iSaldo;
		System.out.println("Saldo incrementado con éxito!!");
	}

	public void decrementarSaldo(Double dSaldo) {
		if (dSaldo < saldo) {
			System.err.println("[ERROR]: No hay dinero suficiente.");
		} else {
			this.saldo -= dSaldo;
			System.out.println("Saldo decrementado con éxito.");
		}
	}

	/**
	 * Con este método vamos a añadir un curso ya realizado.
	 */
	public void addCursoRealizado(Curso curso) {
		cursosRealizados.put(curso.getTitulo(), curso);
	}

	public void addCursoMatriculado(Curso curso) {
		cursosMatriculado.put(curso.getTitulo(), curso);
	}

	@Override
	public String toString() {
		return "dni=" + dni + ", nombre=" + nombre + ", saldo=" + saldo;
	}

	public void showCursosRealizados() {
		cursosRealizados.values().stream().forEach(System.out::println);
	}

	public void showCursosMatriculados() {
		cursosMatriculado.values().stream().forEach(System.out::println);
	}

}
