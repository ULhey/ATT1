package Persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Model.Curso;
import Model.Disciplina;

public class DisciplinaDAO {
	private Connection c;

	public DisciplinaDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gdao = new GenericDAO();
		c = gdao.conexao();
	}

	public void crudDisciplina(String acao, Disciplina d) throws SQLException {
		String sql = "{CALL crudDISCIPLINA (?,?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, acao);
		cs.setInt(2, d.getIdDisciplina());
		cs.setString(3, d.getNomeDisciplina());
		cs.setString(4, d.getHorarioSemanal());
		cs.setInt(5, d.getAula());
		cs.setString(6, d.getTipoConteudo());
		cs.setInt(7, d.getCurso().getIdCurso());
		cs.registerOutParameter(8, Types.VARCHAR);
		cs.execute();
		cs.close();
		c.close();
	}

	public Disciplina buscar(Disciplina d) throws SQLException {
		String sql = "SELECT * FROM CursoDisciplina WHERE idDisciplina = ?";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, d.getIdDisciplina());

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			d.setIdDisciplina(rs.getInt("idDisciplina"));
			d.setNomeDisciplina(rs.getString("nomeDisciplina"));
			d.setHorarioSemanal(rs.getString("horarioSemanal"));
			d.setAula(rs.getInt("aula"));
			d.setTipoConteudo(rs.getString("tipoConteudo"));

			Curso c = new Curso();

			c.setIdCurso(rs.getInt("idCurso"));
			c.setNomeCurso(rs.getString("nomeCurso"));
			c.setCargaHorario(rs.getString("cargaHorario"));
			c.setSigla(rs.getString("sigla"));
			c.setENADE(rs.getFloat("ENADE"));

			d.setCurso(c);
		}

		rs.close();
		ps.close();

		c.close();

		return d;
	}

	public List<Disciplina> listar() throws SQLException {
		String sql = "SELECT * FROM CursoDisciplina";

		List<Disciplina> disciplinas = new ArrayList<>();

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Disciplina d = new Disciplina();

			d.setIdDisciplina(rs.getInt("idDisciplina"));
			d.setNomeDisciplina(rs.getString("nomeDisciplina"));
			d.setHorarioSemanal(rs.getString("horarioSemanal"));
			d.setAula(rs.getInt("aula"));
			d.setTipoConteudo(rs.getString("tipoConteudo"));

			Curso c = new Curso();

			c.setIdCurso(rs.getInt("idCurso"));
			c.setNomeCurso(rs.getString("nomeCurso"));
			c.setCargaHorario(rs.getString("cargaHorario"));
			c.setSigla(rs.getString("sigla"));
			c.setENADE(rs.getFloat("ENADE"));

			d.setCurso(c);

			disciplinas.add(d);
		}

		rs.close();
		ps.close();

		c.close();

		return disciplinas;
	}
}