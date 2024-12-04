package br.com.cadastrofuncionario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cadastrofuncionario.dao.ConnectionFactory;
import br.com.cadastrofuncionario.dao.FuncionarioDao;
import br.com.cadastrofuncionario.model.Funcionario;

// Anotação
@Controller
public class IndexController {

	@RequestMapping("/")
	public String inicio() {
		// Conectar ao banco de dados
		ConnectionFactory.conectar();
		// Redirecionar para rota /home
		return "redirect:home";

	}

	@RequestMapping("/home") // http://localhost:8080 /
	// String -> Retorno de uma pagina
	public String index(Model model) { // org.springframework
		FuncionarioDao dao = new FuncionarioDao();
		
		// items="${pedidos}"
		model.addAttribute("funcionarios", dao.listar());
		
		return "index"; // home.html

	}

	@RequestMapping("/form")
	public String form(Long idFuncionario, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
		
		Funcionario f = new Funcionario();
		
		if (idFuncionario != null) {
			f = dao.buscar(idFuncionario);
		}
		
		model.addAttribute("funcionario", f);
		
		return "form"; // form.html

	}

	@RequestMapping("/funcionario")
	public String funcionario(Long idFuncionario, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
		model.addAttribute("funcionario", dao.buscar(idFuncionario));
		return "funcionario";

	}
	
	@RequestMapping(value = "adicionarFuncionario", method = RequestMethod.POST)
	public String adicionarFuncionario(Funcionario funcionario) {
		FuncionarioDao dao = new FuncionarioDao();
		dao.inserir(funcionario);
		return "redirect:home";	// Volta para home e atualiza	
	}
	
	// /atualizarPedido (nome do value) / GET | POST | PUT | DELETE (tipos de method)
	/**
	 * GET - Buscar informações
	 * POST - Criar informaçoões
	 * PUT - Atualizar informações
	 * DELETE - Deleta informações
	 */
	
	@RequestMapping(value = "atualizarFuncionario", method = RequestMethod.POST)
	public String atualizarFuncionario(Long idFuncionario, Funcionario f) {
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.atualizar(idFuncionario, f);
		
		return "redirect:home"; 
	}
	
	
	@RequestMapping("deletarFuncionario")
	public String deletarFuncionario(Long idFuncionario) {
		
		FuncionarioDao dao = new FuncionarioDao();
		dao.excluir(idFuncionario);
		
		return "redirect:home";
	}

}
