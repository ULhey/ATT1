package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.Disciplina;
import Model.Matricula;
import Persistence.AlunoDAO;
import Persistence.DisciplinaDAO;
import Persistence.MatriculaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Disciplina> disciplinas = new ArrayList<>();
	private List<Aluno> alunos = new ArrayList<>();
	private List<Matricula> matriculas = new ArrayList<>();
	private String RA;

	public MatriculaServlet() {
		try {
			AlunoDAO adao = new AlunoDAO();
			alunos.addAll(adao.listar());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("matricula.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RA = request.getParameter("RA");
		String idDisciplina = request.getParameter("idDisciplina");

		try {
			switch (request.getParameter("botao")) {
			case "Buscar":
				disciplinas.addAll(buscar(RA));
				request.setAttribute("disciplina", disciplinas);
				this.RA = RA;
				break;
			case "Matricular":
				inserir(this.RA, Integer.parseInt(idDisciplina));
				break;
			case "Listar":
				request.setAttribute("matriculas", listar(this.RA));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("matricula.jsp");
			rd.forward(request, response);
		}
	}

	private void inserir(String RA, int idDisciplina) throws ClassNotFoundException, SQLException {
		Matricula m = new Matricula();
		MatriculaDAO mdao = new MatriculaDAO();

		m.setIdMatricula(201 + matriculas.size());

		for (Aluno a : alunos) {
			if (a.getRA().equals(RA)) {
				m.setAluno(a);
			}
		}

		for (Disciplina d : disciplinas) {
			if (d.getIdDisciplina() == idDisciplina) {
				m.setDisciplina(d);
			}
		}

		m.setAprovacao("Cursando");

		mdao.crudMATRICULA("i", m);
		matriculas.add(m);
	}

	private List<Disciplina> buscar(String RA) throws ClassNotFoundException, SQLException {
		for (Aluno a : alunos) {
			if (a.getRA().equals(RA)) {
				MatriculaDAO mdao = new MatriculaDAO();
				return mdao.buscaDisciplinas(a);

			}
		}
		return null;
	}

	private List<Matricula> listar(String RA) throws ClassNotFoundException, SQLException {
		for (Aluno a : alunos) {
			if (a.getRA().equals(RA)) {
				MatriculaDAO mdao = new MatriculaDAO();
				return mdao.buscaMatriculas(a);
			}
		}
		return null;
	}
}