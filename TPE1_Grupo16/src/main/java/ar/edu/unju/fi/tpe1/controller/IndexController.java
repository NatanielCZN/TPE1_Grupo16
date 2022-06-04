package ar.edu.unju.fi.tpe1.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	private static final Log LOGGER = LogFactory.getLog(IndexController.class);
	
	@GetMapping("/home")
	public String getIndexPage() {
		LOGGER.info("METHOD: getIndexPage() - INFO: Se obtiene la URL de index");
		return "index";		
	}
}