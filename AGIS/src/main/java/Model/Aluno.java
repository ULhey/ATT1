package Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Aluno {
	private String RA;
	private String CPF;
	private String nome;
	private String nomeSocial;
	private String dataNasc;
	private String telefone;
	private String email;
	private String emailCorp;
	private String dataMedio;
	private String instituicaoMedio;
	private double pontVestibular;
	private int posiVestibular;
	private int anoInicio;
	private int semesInicio;
	private int semesConclusao;
	private int anoLimite;
	private String turno;
	private Curso curso;
}