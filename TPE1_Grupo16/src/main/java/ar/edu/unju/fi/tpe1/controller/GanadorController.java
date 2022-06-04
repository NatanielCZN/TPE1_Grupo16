package ar.edu.unju.fi.tpe1.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.tpe1.service.IGanadorService;

@Controller
@RequestMapping("/ganador")
public class GanadorController {

	@Autowired
	@Qualifier("GanadorServiceImp")
	private IGanadorService ganadorService;
	
	private static final Log LOGGER = LogFactory.getLog(GanadorController.class);
	
	@GetMapping("/lista")
	public String getGanadoresPage(Model model) {
		model.addAttribute("ganadores", ganadorService.getListaGanador().getListaGanadores());
		return "lista_ganadores";
	}	
}