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

public class CursoDAO {
	private Connection c;

	public CursoDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gdao = new GenericDAO();
		c = gdao.conexao();
	}

	public void crudCurso(String acao, Curso cc) throws SQLException {
		String sql = "{CALL crudCURSO (?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, acao);
		cs.setInt(2, cc.getIdCurso());
		cs.setString(3, cc.getNomeCurso());
		cs.setString(4, cc.getCargaHorario());
		cs.setString(5, cc.getSigla());
		cs.setFloat(6, cc.getENADE());
		cs.registerOutParameter(7, Types.VARCHAR);
		cs.execute();
		cs.close();
		c.close();
	}

	public Curso buscar(Curso cc) throws SQLException {
		String sql = "SELECT nomeCurso, cargaHorario, sigla, ENADE FROM Curso WHERE idCurso = ? ";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cc.getIdCurso());

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			cc.setNomeCurso(rs.getString("nomeCurso"));
			cc.setCargaHorario(rs.getString("cargaHorario"));
			cc.setSigla(rs.getString("sigla"));
			cc.setENADE(rs.getFloat("ENADE"));
		}

		rs.close();
		ps.close();

		c.close();

		return cc;
	}

	public List<Curso> listar() throws SQLException {
		String sql = "SELECT idCurso, nomeCurso, cargaHorario, sigla, ENADE FROM Curso";

		List<Curso> cursos = new ArrayList<>();

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Curso c = new Curso();

			c.setIdCurso(rs.getInt("idCurso"));
			c.setNomeCurso(rs.getString("nomeCurso"));
			c.setCargaHorario(rs.getString("cargaHorario"));
			c.setSigla(rs.getString("sigla"));
			c.setENADE(rs.getFloat("ENADE"));
			
			cursos.add(c);
		}

		rs.close();
		ps.close();

		c.close();

		return cursos;
	}
}