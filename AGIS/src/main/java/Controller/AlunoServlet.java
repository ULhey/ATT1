package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.Curso;
import Persistence.AlunoDAO;
import Persistence.CursoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Aluno> alunos = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<>();
	
	public AlunoServlet() {
		try {
			AlunoDAO adao = new AlunoDAO();
			alunos.addAll(adao.listar());
			CursoDAO cdao = new CursoDAO();
			cursos.addAll(cdao.listar());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cursos", cursos);
		RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RA = request.getParameter("RA");
		String CPF = request.getParameter("CPF");
		String nome = request.getParameter("nome");
		String nomeSocial = request.getParameter("nomeSocial");
		String dataNasc = request.getParameter("dataNasc");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String dataMedio = request.getParameter("dataMedio");
		String instituicaoMedio = request.getParameter("instituicaoMedio");
		String pontVestibular = request.getParameter("pontVestibular");
		String posiVestibular = request.getParameter("posiVestibular");
		String turno = request.getParameter("turno");
		String idCurso = request.getParameter("idCurso");

		try {
			switch (request.getParameter("botao")) {
			case "Cadastrar":
				inserir(CPF, nome, nomeSocial, dataNasc, telefone, email, dataMedio, instituicaoMedio,
						Double.parseDouble(pontVestibular), Integer.parseInt(posiVestibular), turno,
						Integer.parseInt(idCurso));
				break;
			case "Buscar":
				request.setAttribute("aluno", buscar(RA));
				break;
			case "Alterar":
				atualizar(RA, CPF, nome, nomeSocial, dataNasc, telefone, email, dataMedio, instituicaoMedio,
						Double.parseDouble(pontVestibular), Integer.parseInt(posiVestibular), turno);
				break;
			case "Excluir":
				remover(RA);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("cursos", cursos);
			request.setAttribute("alunos", alunos);
			RequestDispatcher rd = request.getRequestDispatcher("aluno.jsp");
			rd.forward(request, response);
		}
	}

	private void inserir(String CPF, String nome, String nomeSocial, String dataNasc, String telefone, String email,
			String dataMedio, String instituicaoMedio, double pontVestibular, int posiVestibular, String turno,
			int idCurso) throws ClassNotFoundException, SQLException {
		Aluno a = new Aluno();
		AlunoDAO adao = new AlunoDAO();

		a.setRA(adao.getRA());
		a.setCPF(CPF);
		a.setNome(nome);
		a.setNomeSocial(nomeSocial);
		a.setDataNasc(dataNasc);
		a.setTelefone(telefone);
		a.setEmail(email);
		a.setDataMedio(dataMedio);
		a.setInstituicaoMedio(instituicaoMedio);
		a.setPontVestibular(pontVestibular);
		a.setPosiVestibular(posiVestibular);
		a.setTurno(turno);

		for (Curso c : cursos) {
			if (c.getIdCurso() == idCurso) {
				a.setCurso(c);
			}
		}

		if (adao.crudAluno("i", a)) {
			alunos.add(a);
		}
	}

	private String atualizar(String RA, String CPF, String nome, String nomeSocial, String dataNasc, String telefone,
			String email, String dataMedio, String instituicaoMedio, double pontVestibular, int posiVestibular,
			String turno) throws ClassNotFoundException, SQLException {
		for (Aluno a : alunos) {
			if (a.getRA().equals(RA)) {
				AlunoDAO adao = new AlunoDAO();

				a.setNome(nome);
				a.setNomeSocial(nomeSocial);
				a.setDataNasc(dataNasc);
				a.setTelefone(telefone);
				a.setEmail(email);
				a.setDataMedio(dataMedio);
				a.setInstituicaoMedio(instituicaoMedio);
				a.setPontVestibular(pontVestibular);
				a.setPosiVestibular(posiVestibular);
				a.setTurno(instituicaoMedio);

				adao.crudAluno("u", a);
			}
		}
		return null;
	}

	public Aluno buscar(String RA) throws ClassNotFoundException, SQLException {
		for (Aluno a : alunos) {
			if (a.getRA().equals(RA)) {
				AlunoDAO adao = new AlunoDAO();
				return adao.buscar(a);
			}
		}
		return null;
	}

	public String remover(String RA) throws ClassNotFoundException, SQLException {
		for (Aluno a : alunos) {
			if (a.getRA().equals(RA)) {
				AlunoDAO adao = new AlunoDAO();
				alunos.remove(a);
				adao.crudAluno("d", a);
			}
		}
		return null;
	}
}