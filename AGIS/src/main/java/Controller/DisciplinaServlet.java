package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Curso;
import Model.Disciplina;
import Persistence.CursoDAO;
import Persistence.DisciplinaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisciplinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Disciplina> disciplinas = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<>();

	public DisciplinaServlet() {
		try {
			DisciplinaDAO ddao = new DisciplinaDAO();
			disciplinas.addAll(ddao.listar());
			CursoDAO cdao = new CursoDAO();
			cursos.addAll(cdao.listar());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cursos", cursos);
		RequestDispatcher rd = request.getRequestDispatcher("disciplina.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idDisciplina = request.getParameter("idDisciplina");
		String nomeDisciplina = request.getParameter("nomeDisciplina");
		String horarioSemanal = request.getParameter("horarioSemanal");
		String aula = request.getParameter("aula");
		String tipoConteudo = request.getParameter("tipoConteudo");
		String idCurso = request.getParameter("idCurso");

		try {
			switch (request.getParameter("botao")) {
			case "Cadastrar":
				inserir(nomeDisciplina, horarioSemanal, Integer.parseInt(aula), tipoConteudo,
						Integer.parseInt(idCurso));
				break;
			case "Buscar":
				request.setAttribute("disciplina", buscar(Integer.parseInt(idDisciplina)));
				break;
			case "Alterar":
				atualizar(Integer.parseInt(idDisciplina), nomeDisciplina, horarioSemanal, Integer.parseInt(aula),
						tipoConteudo, Integer.parseInt(idCurso));
				break;
			case "Excluir":
				remover(Integer.parseInt(idDisciplina));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("cursos", cursos);
			request.setAttribute("disciplinas", disciplinas);
			RequestDispatcher rd = request.getRequestDispatcher("disciplina.jsp");
			rd.forward(request, response);
		}
	}

	private void inserir(String nomeDisciplina, String horarioSemanal, int aula, String tipoConteudo, int idCurso)
			throws ClassNotFoundException, SQLException {
		Disciplina d = new Disciplina();
		DisciplinaDAO ddao = new DisciplinaDAO();

		d.setIdDisciplina(1001 + disciplinas.size());
		d.setNomeDisciplina(nomeDisciplina);
		d.setHorarioSemanal(horarioSemanal);
		d.setAula(aula);
		d.setTipoConteudo(tipoConteudo);

		for (Curso c : cursos) {
			if (c.getIdCurso() == idCurso) {
				d.setCurso(c);
			}
		}

		ddao.crudDisciplina("i", d);
		disciplinas.add(d);
	}

	private void atualizar(int idDisciplina, String nomeDisciplina, String horarioSemanal, int aula,
			String tipoConteudo, int idCurso) throws ClassNotFoundException, SQLException {
		for (Disciplina d : disciplinas) {
			if (d.getIdDisciplina() == idDisciplina) {
				DisciplinaDAO ddao = new DisciplinaDAO();

				d.setIdDisciplina(idDisciplina);
				d.setNomeDisciplina(nomeDisciplina);
				d.setHorarioSemanal(horarioSemanal);
				d.setAula(aula);
				d.setTipoConteudo(tipoConteudo);

				for (Curso c : cursos) {
					if (c.getIdCurso() == idCurso) {
						d.setCurso(c);
					}
				}

				ddao.crudDisciplina("u", d);
				break;
			}
		}
	}

	private Disciplina buscar(int idDisciplina) throws ClassNotFoundException, SQLException {
		for (Disciplina d : disciplinas) {
			if (d.getIdDisciplina() == idDisciplina) {
				DisciplinaDAO ddao = new DisciplinaDAO();
				return ddao.buscar(d);
			}
		}
		return null;
	}

	private void remover(int idDisciplina) throws ClassNotFoundException, SQLException {
		for (Disciplina d : disciplinas) {
			if (d.getIdDisciplina() == idDisciplina) {
				DisciplinaDAO ddao = new DisciplinaDAO();
				ddao.crudDisciplina("d", d);
				disciplinas.remove(d);
				break;
			}
		}
	}
}