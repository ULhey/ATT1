package Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Disciplina {
	private int idDisciplina;
	private String nomeDisciplina;
	private String horarioSemanal;
	private int aula;
	private String tipoConteudo;
	private Curso curso;
}