package ar.edu.unju.fi.tpe1.service;

import ar.edu.unju.fi.tpe1.model.Usuario;
import ar.edu.unju.fi.tpe1.util.ListaUsuario;

public interface IUsuarioService {

	public Usuario getUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public ListaUsuario getListaUsuario();
	public void descontarVoto();
}