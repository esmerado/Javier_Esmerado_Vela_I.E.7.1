package Ejercicio6;

import java.time.LocalDate;
import java.util.Map;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Clase curso
 * 
 * @author esmer
 *
 */
public abstract class Curso {

	private String titulo;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private int numDias;
	private Double precio;
	private static int numAlum = 0;
	protected Map<String, Alumno> alumnos;

	public Curso(String titulo, LocalDate fechaInicio, LocalDate fechaFinal, int numDias, Double precio,
			Map<String, Alumno> alumnos) {
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.numDias = numDias;
		this.precio = precio;
		this.alumnos = alumnos;
		numAlum++;
	}

	public String getTitulo() {
		return titulo;
	}

	/**
	 * Método para inscribir un alumno a una clase.
	 * 
	 * @param alumno
	 */
	public void inscribirse(Alumno alumno) {
		if (alumnos.containsKey(alumno.getDni())) {
			System.err.println("[ERROR]: No puedes inscribirte en este curso.");
			System.err.println("Ya está inscrito en este curso.");
		} else {
			if (alumno.getSaldo() >= precio) {
				System.out.println("Inscribiendose................");
				alumnos.put(alumno.getDni(), alumno);
				alumno.decrementarSaldo(precio);
				alumno.addCursoMatriculado(this);
				System.out.println("Inscrito con éxito!!!");
			} else {
				System.err.println("[ERROR]: Lo sentimos no hay saldo suficiente para inscribirse.");
			}
		}
	}

	public void solicitarTitulo(Alumno alumno) {
		if (LocalDate.now().compareTo(fechaFinal) > 0 && alumnos.containsKey(alumno.getDni())
				&& alumno.cursosMatriculado.containsKey(this.titulo)) {
			alumno.cursosRealizados.put(this.titulo, this);
			System.out.println("----DIPLOMA----");
			System.out.println("D/Da " + alumno.getNombre() + " ha realizado con aprovechamiento el curso: " + titulo
					+ ", \n en la modalidad X, con una duración de " + numDias + ".");
		} else {
			System.err.println("[ERROR]: Lo sentimos no cumple los requisitos mínimos.");
		}
	}

	@Override
	public String toString() {
		return "Curso [titulo=" + titulo + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", numDias="
				+ numDias + ", precio=" + precio + ", alumnos=" + alumnos + "]";
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public int getNumDias() {
		return numDias;
	}

	public Double getPrecio() {
		return precio;
	}

}
