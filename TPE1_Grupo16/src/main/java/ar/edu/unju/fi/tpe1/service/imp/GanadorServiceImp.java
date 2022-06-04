package ar.edu.unju.fi.tpe1.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpe1.service.IGanadorService;
import ar.edu.unju.fi.tpe1.util.ListaGanador;

@Service("GanadorServiceImp")
public class GanadorServiceImp implements IGanadorService {

	@Autowired
	private ListaGanador listaGanador;
	
	@Override
	public ListaGanador getListaGanador() {		
		return this.listaGanador;
	}
}