package ar.edu.unju.fi.tpe1.service;

import ar.edu.unju.fi.tpe1.model.Candidato;
import ar.edu.unju.fi.tpe1.util.ListaCandidato;

/*
 * El cuerpo de la interface contiene las declaraciones de metodos abstractos
 */
public interface ICandidatoService {
	
	public Candidato getCandidato();
	public boolean verificarCodigo(Candidato candidato);
	public boolean guardarCandidato(Candidato candidato);	
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(String codigo);
	public ListaCandidato getListaCandidato();
	public Candidato buscarCandidato(String codigo);
	public void sumarVoto(String codigo);
	public int getCantidadTotalVotos();
	public void modificarPorcentajeCandidato(int votos);
}