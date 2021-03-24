package Ejercicio6;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CursoOnline extends Curso {

	List<String> cursosRequeridos;

	public CursoOnline(String titulo, LocalDate fechaInicio, LocalDate fechaFinal, int numDias, Double precio,
			Map<String, Alumno> alumnos, List<String> cursosRequeridos) {
		super(titulo, fechaInicio, fechaFinal, numDias, precio, alumnos);
		this.cursosRequeridos = cursosRequeridos;
	}

	@Override
	public String getTitulo() {
		return super.getTitulo();
	}

	@Override
	public void inscribirse(Alumno alumno) {
		List lista = alumno.cursosRealizados.values().stream().map(l -> l.getTitulo()).collect(Collectors.toList());
		if (lista.containsAll(cursosRequeridos)) {
			
		}
	}

	@Override
	public void solicitarTitulo(Alumno alumno) {
		if (LocalDate.now().compareTo(super.getFechaFinal()) > 0 && alumnos.containsKey(alumno.getDni())
				&& alumno.cursosMatriculado.containsKey(super.getTitulo())) {
			alumno.cursosRealizados.put(this.getTitulo(), this);
			System.out.println("----DIPLOMA----");
			System.out.println("D/Da " + alumno.getNombre() + " ha realizado con aprovechamiento el curso: " + getTitulo()
					+ ", \n en la modalidad X, con una duración de " + getNumDias() + ".");
		} else {
			System.err.println("[ERROR]: Lo sentimos no cumple los requisitos mínimos.");
		};
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
