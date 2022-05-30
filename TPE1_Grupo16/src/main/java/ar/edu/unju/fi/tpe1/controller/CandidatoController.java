package ar.edu.unju.fi.tpe1.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	// Creo una constante de clase tipo Log
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	
	/**
	 * Obtengo la URL de la pagina "lista_candidatos".
	 * Esta mostrara el listado de docentes.
	 * @param model
	 * @return
	 */
	@GetMapping("/lista")
	public String getCandidatosPage(Model model) {
		model.addAttribute("candidatos", model);
		return "lista_candidatos";
	}
	
	/**
	 * Obtengo la URL de la pagina "nuevo_candidato".
	 * Esta mostrara el formulario para agregar un nuevo docente.
	 * @param model
	 * @return
	 */
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		model.addAttribute("candidato", model );
		return "nuevo_candidato";
	}
	
}
