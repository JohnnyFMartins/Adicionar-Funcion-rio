package br.com.cadastrofuncionario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastrofuncionario.model.Funcionario;

public class FuncionarioDao {
	private Connection conexao;

	// PedidoDao = new PedidoDao();
	public FuncionarioDao() {
		conexao = ConnectionFactory.conectar();
	}

	public void inserir(Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios (nome, cargo, email, telefone, data_admissao, status_funcionario)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		// java.sql
		PreparedStatement smtp; // Executar a consulta sql
		try {

			smtp = conexao.prepareStatement(sql);
			// Preencher a posição 1 com o nome
			smtp.setString(1, funcionario.getNome());
			smtp.setString(2, funcionario.getCargo());
			smtp.setString(3, funcionario.getEmail());
			smtp.setString(4, funcionario.getTelefone());
			smtp.setDate(5, funcionario.getData());
			smtp.setString(6, funcionario.getStatus());

			smtp.execute(); // Executar
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println("Deu erro: " + e.getMessage());
		}
	}

	public List<Funcionario> listar() {
		String sql = "SELECT * FROM funcionarios";

		PreparedStatement smtp;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			smtp = conexao.prepareStatement(sql);
			// resultado = Listadepizza[], [ {}, {} ]
			// java.sql
			ResultSet resultado = smtp.executeQuery();
			// resultado (Lista de Pedidos <ResultSet>)
			while (resultado.next()) {
				Funcionario func = new Funcionario();
				// pegando o nome da coluna
				func.setId(resultado.getLong("id"));
				func.setNome(resultado.getString("nome"));
				func.setCargo(resultado.getString("cargo"));
				func.setEmail(resultado.getString("email"));
				func.setTelefone(resultado.getString("telefone"));
				func.setData(resultado.getDate("data_admissao"));
				func.setStatus(resultado.getString("status_funcionario"));
				funcionarios.add(func);
			}
			resultado.close();
			smtp.close();
			conexao.close();
			return funcionarios;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public Funcionario buscar(Long id) {
		String sql = "SELECT * FROM funcionarios WHERE id = ?";
		
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Funcionario f = null; // não instanciando
			
			while (resultado.next()) {
				f = new Funcionario();
				f.setId(resultado.getLong("id"));
				f.setNome(resultado.getString("nome"));
				f.setCargo(resultado.getString("cargo"));
				f.setEmail(resultado.getString("email"));
				f.setTelefone(resultado.getString("telefone"));
				f.setData(resultado.getDate("data_admissao"));
				f.setStatus(resultado.getString("status_funcionario"));
			}
			
			smtp.close();
			resultado.close();
			conexao.close();
			return f;
			
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}
	
	public void excluir(Long id) {
		String sql = "DELETE FROM funcionarios WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id); // id = ?
			
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void atualizar(Long id, Funcionario f) {
		String sql = "UPDATE funcionarios SET nome=?, cargo=?, email=?, telefone=?, data_admissao=?, status_funcionario=? WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			// 1 => nome, 2 => cargo, 3 => email, 4 => telefone, 5 => data_admissao, 6 => status_funcionario, 7 => id
			smtp = conexao.prepareStatement(sql);
			smtp.setString(1, f.getNome());
			smtp.setString(2, f.getCargo());
			smtp.setString(3, f.getEmail());
			smtp.setString(4, f.getTelefone());
			smtp.setDate(5, f.getData());
			smtp.setString(6, f.getStatus());
			smtp.setLong(7, id); // id = ?
			
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
