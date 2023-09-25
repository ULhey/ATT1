package Persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.Curso;

public class AlunoDAO {
	private Connection c;

	public AlunoDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gdao = new GenericDAO();
		c = gdao.conexao();
	}

	public String getRA() throws SQLException {
		String sql = "{CALL criarRA (?)}";
		CallableStatement cs = c.prepareCall(sql);

		cs.registerOutParameter(1, Types.VARCHAR);
		cs.execute();

		String RA = cs.getString(1);
		cs.close();
		return RA;
	}

	public boolean crudAluno(String acao, Aluno a) throws SQLException {
		String sql = "{CALL crudALUNO (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, acao);
		cs.setString(2, a.getRA());
		cs.setString(3, a.getCPF());
		cs.setString(4, a.getNome());
		cs.setString(5, a.getNomeSocial());
		cs.setString(6, a.getDataNasc());
		cs.setString(7, a.getTelefone());
		cs.setString(8, a.getEmail());
		cs.setString(9, a.getDataMedio());
		cs.setString(10, a.getInstituicaoMedio());
		cs.setDouble(11, a.getPontVestibular());
		cs.setInt(12, a.getPosiVestibular());
		cs.setInt(13, a.getCurso().getIdCurso());
		cs.setString(14, a.getTurno());
		cs.registerOutParameter(15, Types.BIT);
		cs.execute();
		boolean validade = cs.getBoolean(15);
		cs.close();
		c.close();
		
		return validade;
	}

	public Aluno buscar(Aluno a) throws SQLException {
		String sql = "SELECT * FROM MatriculaCurso WHERE RA = ? ";

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getRA());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			a.setRA(rs.getString("RA"));
			a.setCPF(rs.getString("CPF"));
			a.setNome(rs.getString("nome"));
			a.setNomeSocial(rs.getString("nomeSocial"));
			a.setDataNasc(rs.getString("dataNasc"));
			a.setTelefone(rs.getString("telefone"));
			a.setEmail(rs.getString("email"));
			a.setEmailCorp(rs.getString("emailCorp"));
			a.setDataMedio(rs.getString("dataMedio"));
			a.setInstituicaoMedio(rs.getString("instituicaoMedio"));
			a.setPontVestibular(rs.getInt("pontVestibular"));
			a.setPosiVestibular(rs.getInt("posiVestibular"));
			a.setAnoInicio(rs.getInt("anoInicio"));
			a.setSemesInicio(rs.getInt("semesInicio"));
			a.setSemesConclusao(rs.getInt("semesConclusao"));
			a.setAnoLimite(rs.getInt("anoLimite"));
			a.setTurno(rs.getString("turno"));
			
			Curso c = new Curso();

			c.setIdCurso(rs.getInt("idCurso"));
			c.setNomeCurso(rs.getString("nomeCurso"));
			c.setCargaHorario(rs.getString("cargaHorario"));
			c.setSigla(rs.getString("sigla"));
			c.setENADE(rs.getFloat("ENADE"));
			
			a.setCurso(c);
		}

		rs.close();
		ps.close();

		c.close();

		return a;
	}

	public List<Aluno> listar() throws SQLException {
		String sql = "SELECT * FROM MatriculaCurso";

		List<Aluno> alunos = new ArrayList<>();

		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Aluno a = new Aluno();

			a.setRA(rs.getString("RA"));
			a.setCPF(rs.getString("CPF"));
			a.setNome(rs.getString("nome"));
			a.setNomeSocial(rs.getString("nomeSocial"));
			a.setDataNasc(rs.getString("dataNasc"));
			a.setTelefone(rs.getString("telefone"));
			a.setEmail(rs.getString("email"));
			a.setEmailCorp(rs.getString("emailCorp"));
			a.setDataMedio(rs.getString("dataMedio"));
			a.setInstituicaoMedio(rs.getString("instituicaoMedio"));
			a.setPontVestibular(rs.getInt("pontVestibular"));
			a.setPosiVestibular(rs.getInt("posiVestibular"));
			a.setAnoInicio(rs.getInt("anoInicio"));
			a.setSemesInicio(rs.getInt("semesInicio"));
			a.setSemesConclusao(rs.getInt("semesConclusao"));
			a.setAnoLimite(rs.getInt("anoLimite"));
			a.setTurno(rs.getString("turno"));

			Curso c = new Curso();

			c.setIdCurso(rs.getInt("idCurso"));
			c.setNomeCurso(rs.getString("nomeCurso"));
			c.setCargaHorario(rs.getString("cargaHorario"));
			c.setSigla(rs.getString("sigla"));
			c.setENADE(rs.getFloat("ENADE"));
			
			a.setCurso(c);
			
			alunos.add(a);
		}

		rs.close();
		ps.close();

		c.close();

		return alunos;
	}
}