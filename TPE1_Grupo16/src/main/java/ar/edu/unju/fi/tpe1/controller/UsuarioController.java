package ar.edu.unju.fi.tpe1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpe1.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("UsuarioServiceImp")
	private IUsuarioService usuarioService;
	
	@GetMapping("/lista")
	public String getUsuariosPage(Model model) {
		model.addAttribute("usuarios", usuarioService.getListaUsuario().getListaUsuarios());
		return "lista_usuarios";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoUsuarioPage(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "nuevo_usuario";
	}
}