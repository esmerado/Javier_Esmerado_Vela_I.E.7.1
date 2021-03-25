package Ejercicio6;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CursoPresencial extends Curso {

	private Double cupo;
	private Double horasDia;
	private Double numMinAsistencia;
	private Integer asistencias = 1;
	private Integer cupoLibre;

	public CursoPresencial(String titulo, LocalDate fechaInicio, LocalDate fechaFinal, int numDias, Double precio,
			Map<String, Alumno> alumnos, Double cupo, Double horasDia, Double numMinAsistencia) {
		super(titulo, fechaInicio, fechaFinal, numDias, precio, alumnos);
		this.cupo = cupo;
		this.horasDia = horasDia;
		this.numMinAsistencia = numMinAsistencia;
	}

	@Override
	public void inscribirse(Alumno alumno) {
		if (alumno.cursosRealizados.containsKey(this)) {
			alumno.cursosMatriculado.put(getTitulo(), this);
			this.alumnos.put(alumno.getDni(), alumno);
			System.out.println("Alumno inscrito con éxito.");
		}else {
			System.err.println("[ERROR]: No cumple los requisitos.");
		}
	}

	@Override
	public void solicitarTitulo(Alumno alumno) {
		super.solicitarTitulo(alumno);
	}

	
	
}
