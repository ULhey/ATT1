package Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Curso {
	private int idCurso;
	private String nomeCurso;
	private String cargaHorario;
	private String sigla;
	private float ENADE;
}