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
import Model.Disciplina;
import Model.Matricula;

public class MatriculaDAO {
	private Connection c;

	public MatriculaDAO() throws ClassNotFoundException, SQLException {
		GenericDAO gdao = new GenericDAO();
		c = gdao.conexao();
	}

	public void crudMATRICULA(String acao, Matricula m) throws SQLException {
		String sql = "{CALL crudMATRICULA (?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, acao);
		cs.setInt(2, m.getIdMatricula());
		cs.setString(3, m.getAprovacao());
		cs.setString(4, m.getAluno().getRA());
		cs.setInt(5, m.getDisciplina().getIdDisciplina());
		cs.registerOutParameter(6, Types.VARCHAR);
		cs.execute();
		cs.close();
		c.close();
	}

	public List<Disciplina> buscaDisciplinas(Aluno a) throws SQLException {
		String sql = "SELECT * FROM MatriculaDisciplina WHERE ra = ?";

		List<Disciplina> disciplinas = new ArrayList<>();

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, a.getRA());

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

		return disciplinas;
	}

	public List<Matricula> buscaMatriculas(Aluno aa) throws SQLException {
		String sql = "SELECT * FROM Matricula WHERE ra = ?";

		List<Matricula> matriculas = new ArrayList<>();

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, aa.getRA());

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Matricula m = new Matricula();
			
			m.setIdMatricula(rs.getInt("idMatricula"));
			m.setAno(rs.getInt("ano"));
			m.setSemestreMatricula(rs.getInt("semestreMatricula"));
			m.setAprovacao(rs.getString("aprovacao"));
			
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
			
			m.setAluno(a);
			
			Curso c = new Curso();

			c.setIdCurso(rs.getInt("idCurso"));
			c.setNomeCurso(rs.getString("nomeCurso"));
			c.setCargaHorario(rs.getString("cargaHorario"));
			c.setSigla(rs.getString("sigla"));
			c.setENADE(rs.getFloat("ENADE"));
			
			a.setCurso(c);
			
			Disciplina d = new Disciplina();
			
			d.setIdDisciplina(rs.getInt("idDisciplina"));
			d.setNomeDisciplina(rs.getString("nomeDisciplina"));
			d.setHorarioSemanal(rs.getString("horarioSemanal"));
			d.setAula(rs.getInt("aula"));
			d.setTipoConteudo(rs.getString("tipoConteudo"));
			
			m.setDisciplina(d);

			d.setCurso(c);

			matriculas.add(m);
		}

		return matriculas;
	}
}