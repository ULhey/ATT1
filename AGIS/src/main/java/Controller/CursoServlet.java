package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Curso;
import Persistence.CursoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Curso> cursos = new ArrayList<>();

	public CursoServlet() {
		try {
			CursoDAO cdao = new CursoDAO();
			cursos.addAll(cdao.listar());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("curso.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idCurso = request.getParameter("idCurso");
		String idCurso2 = request.getParameter("idCurso2");
		String nomeCurso = request.getParameter("nomeCurso");
		String cargaHorario = request.getParameter("cargaHorario");
		String sigla = request.getParameter("sigla");
		String turno = request.getParameter("turno");
		String ENADE = request.getParameter("ENADE");

		try {
			switch (request.getParameter("botao")) {
			case "Cadastrar":
				inserir(Integer.parseInt(idCurso), nomeCurso, cargaHorario, sigla, turno, Float.parseFloat(ENADE));
				break;
			case "Buscar":
				request.setAttribute("curso", buscar(Integer.parseInt(idCurso2)));
				break;
			case "Alterar":
				atualizar(Integer.parseInt(idCurso), nomeCurso, cargaHorario, sigla, turno, Float.parseFloat(ENADE));
				break;
			case "Excluir":
				remover(Integer.parseInt(idCurso));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("cursos", cursos);
			RequestDispatcher rd = request.getRequestDispatcher("curso.jsp");
			rd.forward(request, response);
		}
	}

	private void inserir(int idCurso, String nomeCurso, String cargaHorario, String sigla, String turno, float ENADE)
			throws ClassNotFoundException, SQLException {
		Curso c = new Curso();
		CursoDAO cdao = new CursoDAO();

		c.setIdCurso(idCurso);
		c.setNomeCurso(nomeCurso);
		c.setCargaHorario(cargaHorario);
		c.setSigla(sigla);
		c.setENADE(ENADE);

		cdao.crudCurso("i", c);
		cursos.add(c);
	}

	private void atualizar(int idCurso, String nomeCurso, String cargaHorario, String sigla, String turno, float ENADE)
			throws ClassNotFoundException, SQLException {
		for (Curso c : cursos) {
			if (c.getIdCurso() == idCurso) {
				CursoDAO cdao = new CursoDAO();

				c.setIdCurso(idCurso);
				c.setNomeCurso(nomeCurso);
				c.setCargaHorario(cargaHorario);
				c.setSigla(sigla);
				c.setENADE(ENADE);

				cdao.crudCurso("u", c);
				break;
			}
		}
	}

	public Curso buscar(int idCurso) throws ClassNotFoundException, SQLException {
		for (Curso c : cursos) {
			if (c.getIdCurso() == idCurso) {
				CursoDAO cdao = new CursoDAO();
				return cdao.buscar(c);
			}
		}
		return null;
	}

	private void remover(int idCurso) throws ClassNotFoundException, SQLException {
		for (Curso c : cursos) {
			if (c.getIdCurso() == idCurso) {
				CursoDAO cdao = new CursoDAO();
				cdao.crudCurso("d", c);
				cursos.remove(c);
				break;
			}
		}
	}
}