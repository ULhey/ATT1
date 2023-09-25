package Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Matricula {
	private int idMatricula;	
	private int ano;
	private int semestreMatricula;
	private String aprovacao;
	private Aluno aluno;	
	private Disciplina disciplina;
}