package ar.edu.unju.fi.tpe1.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpe1.model.Candidato;
import ar.edu.unju.fi.tpe1.service.ICandidatoService;
import ar.edu.unju.fi.tpe1.util.ListaCandidato;

/*
 * Esta clase es un Bind de Spring y responde a un Service.
 * Ósea que es una clase especial que necesitamos para poder operar con la capa de servicios.
 */
@Service("CandidatoServiceImp")
public class CandidatoServiceImp implements ICandidatoService {

	@Autowired
	private ListaCandidato listaCandidato;
	
	@Override
	public Candidato getCandidato() {
		// Retorna un objeto de la clase Candidato
		return new Candidato();
	}

	@Override
	public boolean verificarCodigo(Candidato candidato) {
		for(Candidato cand : this.listaCandidato.getListaCandidatos()) {
			if(cand.getCodigo().equals(candidato.getCodigo())) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean guardarCandidato(Candidato candidato) {
		// Guarda un objeto Candidato en la lista de candidatos		
		return this.listaCandidato.getListaCandidatos().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		// Buscar el Candidato con el codigo especificado y actualizar sus atributos
		for(Candidato cand : this.listaCandidato.getListaCandidatos()) {
			if(cand.getCodigo().equals(candidato.getCodigo())) {
				cand.setNombre(candidato.getNombre());
				cand.setEmpresa(candidato.getEmpresa());
				cand.setDescripcion(candidato.getDescripcion());
			}
		}
	}

	@Override
	public void eliminarCandidato(String codigo) {
		// Elimino un Candidato de la lista de candidatos
		int posicion = 0;
		for(Candidato cand : this.listaCandidato.getListaCandidatos()) {
			if(cand.getCodigo().equals(codigo)) {
				this.listaCandidato.getListaCandidatos().remove(posicion);
				break;
			}
			posicion++;
		}		
	}

	@Override
	public ListaCandidato getListaCandidato() {
		// Retorna el objeto que accede a la lista de candidatos
		return this.listaCandidato;
	}

	@Override
	public Candidato buscarCandidato(String codigo) {
		// Busca un Candidato por codigo y devuelve el objeto asociado al codigo
		Optional<Candidato> candidato = this.listaCandidato.getListaCandidatos().stream().filter(c -> c.getCodigo().equals(codigo)).findFirst();

		return candidato.get();
	}
	
	@Override
	public void sumarVoto(String codigo) {
		// Suma un voto al candidato cuyo codigo sea igual al pasado por parametro
		for(Candidato cand : this.listaCandidato.getListaCandidatos()) {
			if(cand.getCodigo().equals(codigo)) {
				cand.setCantidadVotos(cand.getCantidadVotos() + 1);
				break;
			}
		}	
	}
	
	@Override
	public int getCantidadTotalVotos() {
		// Obtengo la cantidad total de votos
		int suma = 0;		
		for(Candidato cand : listaCandidato.getListaCandidatos()) {
			suma = suma + cand.getCantidadVotos();
		}		
		return suma;
	}
	
	@Override
	public void modificarPorcentajeCandidato(int votos) {
		float porcentaje = 0f;
		for(Candidato cand : listaCandidato.getListaCandidatos()) {
			try {
				porcentaje = cand.getCantidadVotos() * 100 / votos;
				cand.setPorcentaje(porcentaje);
			}
			catch(ArithmeticException ex) {
				cand.setPorcentaje(0f);
			}			
		}
	}
}