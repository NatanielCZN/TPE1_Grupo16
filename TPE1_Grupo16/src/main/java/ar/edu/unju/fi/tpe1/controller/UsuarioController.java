package ar.edu.unju.fi.tpe1.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpe1.model.Usuario;
import ar.edu.unju.fi.tpe1.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("UsuarioServiceImp")
	private IUsuarioService usuarioService;
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	@GetMapping("/lista")
	public String getUsuariosPage(Model model) {
		LOGGER.info("METHOD: getUsuariosPage() - INFO: Se agrega al contenido de la pagina una lista de Usuarios");
		model.addAttribute("usuarios", usuarioService.getListaUsuario().getListaUsuarios());
		return "lista_usuarios";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoUsuarioPage(Model model) {
		LOGGER.info("METHOD: getNuevoUsuario() - INFO: Se agrega al contenido de la pagina un objeto de tipo Usuario");
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "nuevo_usuario";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarNuevoUsuario(@Validated @ModelAttribute("usuario") Usuario nuevoUsuario, BindingResult bindingR) {
		if(bindingR.hasErrors()) {
			LOGGER.info("METHOD: guardarNuevoUsuario() - INFO: Se detecto un error mediante las validaciones");
			ModelAndView modelAV = new ModelAndView("nuevo_usuario");
			modelAV.addObject("usuario", nuevoUsuario);
			return modelAV;
		}
		ModelAndView modelAV = new ModelAndView("redirect:/usuario/lista");
		
		if(usuarioService.guardarUsuario(nuevoUsuario)) {
			LOGGER.info("METHOD: guardarNuevoUsuario() - INFO: Se agrego un objeto a la lista de Usuarios");
		}
		else {
			LOGGER.info("METHOD: guardarNuevoUsuario() - INFO: No se pudo agregar un objeto a la lista de Usuarios");
		}
		
		return modelAV;
	}
	
	@GetMapping("/mensajeVoto")
	public String getMensajeVotoPage(Model model) {
		LOGGER.info("METHOD: getMensajeVotoPage() - INFO: Se agrega al contenido de la pagina un objeto de tipo Usuario");
		usuarioService.descontarVoto();
		model.addAttribute("usuario", usuarioService.getUltimoUsuario());
		return "msg_votacionrealizada";
	}
}