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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpe1.model.Candidato;
import ar.edu.unju.fi.tpe1.service.ICandidatoService;
import ar.edu.unju.fi.tpe1.service.IUsuarioService;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	// Inyecto una implementacion de una interface
	@Autowired
	// Elijo a cual implementacion hago referencia
	@Qualifier("CandidatoServiceImp")
	private ICandidatoService candidatoService;
	
	@Autowired
	@Qualifier("UsuarioServiceImp")
	private IUsuarioService usuarioService;
	
	// Creo una constante de clase tipo Log
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	
	/**
	 * Obtengo la URL de la pagina "lista_candidatos".
	 * Esta mostrara el listado de candidatos.
	 * @param model
	 * @return
	 */
	@GetMapping("/lista")
	public String getCandidatosPage(Model model) {
		if(usuarioService.getListaUsuario().getListaUsuarios().size() > 3) {
			LOGGER.info("METHOD: getCandidatosPage() - INFO: Se agrega al contenido de la pagina una lista de Candidatos");
			model.addAttribute("candidatos", candidatoService.getListaCandidato().getListaCandidatos());
			return "lista_candidatos";
		}
		else {
			LOGGER.info("METHOD: getCandidatosPage() - INFO: Se debe completar un formulario para acceder para visualizar el contenido de la pagina");
			return "msg_llenarformulario";
		}		
	}
	
	/**
	 * Obtengo la URL de la pagina "nuevo_candidato".
	 * Esta mostrara el formulario para agregar un nuevo candidato.
	 * @param model
	 * @return
	 */
	@GetMapping("/nuevo")
	public String getNuevoCandidatoPage(Model model) {
		LOGGER.info("METHOD: getNuevoCandidatoPage() - INFO: Se agrega al contenido de la pagina un objeto de tipo Candidato");
		model.addAttribute("candidato", candidatoService.getCandidato());
		return "nuevo_candidato";
	}
	
	/**
	 * Metodo que agregara un Candidato a la lista, pasado por parametro
	 * @param nuevoCandidato
	 * @param bindingR
	 * @return
	 */
	@PostMapping("/guardar")
	public ModelAndView guardarNuevoCandidato(@Validated @ModelAttribute("candidato") Candidato nuevoCandidato, BindingResult bindingR) {
		/*
		 * @Validated proviene de Spring Framework Validation
		 * El objeto "bindingR" contiene el resultado de la validacion.
		 * (Errores que pueden haber ocurrido)
		 */
		if(bindingR.hasErrors()) {
			LOGGER.info("METHOD: guardarNuevoCandidato() - INFO: Se detecto un error mediante las validaciones");
			ModelAndView modelAV = new ModelAndView("nuevo_candidato");
			modelAV.addObject("candidato", nuevoCandidato);
			return modelAV;
		}		
		
		if(candidatoService.verificarCodigo(nuevoCandidato)) {
			ModelAndView modelAV = new ModelAndView("redirect:/candidato/lista");
			if(candidatoService.guardarCandidato(nuevoCandidato)) {
				LOGGER.info("METHOD: guardarNuevoCandidato() - INFO: Se agrego un objeto a la lista de Candidatos");
			}
			else {
				LOGGER.info("METHOD: getNuevoUsuario() - INFO: No se pudo agregar un objeto a la lista de Candidatos");
			}			
			return modelAV;
		}
		else {
			LOGGER.info("METHOD: getNuevoUsuario() - INFO: El codigo del objeto que intento agregar a la lista ya se encuentra en uso");
			ModelAndView modelAV = new ModelAndView("msg_codigoincorrecto");
			return modelAV;
		}	
	}
	
	/**
	 * Obtengo la URL de la pagina "edicion_candidato" de acuerdo a su codigo.
	 * Esta mostrara el formulario para edicion.
	 * "{codigo}" es una variable que viene en la URL.
	 * @param codigo
	 * @return
	 */
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarDatosCandidatoPage(@PathVariable(value = "codigo") String codigo) {
		LOGGER.info("METHOD: getEditarDatosCandidatoPage() - INFO: Se busca un Candidato en la lista, de acuerdo a su codigo");
		ModelAndView modelAV = new ModelAndView("edicion_candidato");
		Candidato candidato = candidatoService.buscarCandidato(codigo);
		modelAV.addObject("candidato", candidato);
		
		return modelAV;
	}
	
	/**
	 * Metodo que modificara los datos de un Candidato de acuerdo a los cambios hechos en el formulario.
	 * @param candidatoMod
	 * @param bindingR
	 * @return
	 */
	@PostMapping("/modificar")
	public ModelAndView editarDatosCandidato(@Validated @ModelAttribute("candidato") Candidato candidatoMod, BindingResult bindingR) {
		if(bindingR.hasErrors()) {
			LOGGER.info("METHOD: editarDatosCandidato() - INFO: Se detecto un error mediante las validaciones");
			ModelAndView modelAV = new ModelAndView("edicion_candidato");
			modelAV.addObject("candidato", candidatoMod);
			return modelAV;
		}
		
		LOGGER.info("METHOD: editarDatosCandidato() - INFO: Se modificaron los datos de un Candidato");
		ModelAndView mav = new ModelAndView("redirect:/candidato/lista");
		candidatoService.modificarCandidato(candidatoMod);
		return mav;
	}
	
	/**
	 * Metodo que eliminara un Candidato de la lista.
	 * @param codigo
	 * @return
	 */
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarCandidato(@PathVariable("codigo") String codigo) {
		LOGGER.info("METHOD: eliminarCandidato() - INFO: Se elimina un Candidato en la lista, de acuerdo a su codigo");
		ModelAndView modelAV = new ModelAndView("redirect:/candidato/lista");
		candidatoService.eliminarCandidato(codigo);
		return modelAV;
	}
	
	/**
	 * Obtengo la URL de la pagina "votos_candidato".
	 * Esta mostrara el listado con la cantidad de votos de los candidatos.
	 * @param model
	 * @return
	 */
	@GetMapping("/votos")
	public String getVotosCandidatosPage(Model model) {
		LOGGER.info("METHOD: getVotosCandidatosPage() - INFO: Se agrega al contenido de la pagina el total de votos");
		int total = candidatoService.getCantidadTotalVotos();
		model.addAttribute("total", total);
		LOGGER.info("METHOD: getVotosCandidatosPage() - INFO: Se agrega al contenido de la pagina una lista de Candidatos con sus votos actualizados");
		candidatoService.modificarPorcentajeCandidato(total);		
		model.addAttribute("candidatos", candidatoService.getListaCandidato().getListaCandidatos());
		return "votos_candidato";
	}
	
	/**
	 * Metodo que agregara un voto al Candidato
	 * "{codigo}" es una variable que viene en la URL.
	 * @param codigo
	 * @return
	 */
	@GetMapping("/votar/{codigo}")
	public ModelAndView getAgregarVotoCandidatoPage(@PathVariable(value = "codigo") String codigo) {
		ModelAndView modelAV = new ModelAndView("redirect:/usuario/mensajeVoto");
		if(usuarioService.getUltimoUsuario().getVotosDisponibles() > 0) {
			LOGGER.info("METHOD: getAgregarVotoCandidatoPage() - INFO: Se agrega un voto a un Candidato de acuerdo a su codigo");
			candidatoService.sumarVoto(codigo);
		}
		else {
			LOGGER.info("METHOD: getAgregarVotoCandidatoPage() - INFO: No se pudo agregar un voto a un Candidato porque ya no dispone de votos");
		}
		
		return modelAV;
	}
}