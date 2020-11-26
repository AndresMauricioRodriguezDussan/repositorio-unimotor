package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Usuario;

@Named
@ViewScoped
public class UsuarioBean implements Serializable{

	@EJB
	private UnimotorEJB unimotorEJB;
	private Usuario usuario;
	private List<Ciudad> ciudades;
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void inicializar() {
		ciudades = unimotorEJB.obtenerListaCiudad();
		usuario = new Usuario();
	}
	
	

	public void registrarUsuario() {
		
		try {
			unimotorEJB.registrarUsuario(usuario);
			
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","¡Registro exitoso!");
			FacesContext.getCurrentInstance().addMessage("registro_usuarios", msj);
		
		} catch (Exception e) {
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
			FacesContext.getCurrentInstance().addMessage("registro_usuarios", msj);
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public String irARegristroUsuario() {
		return "registrarUsuario?faces-redirect=true";
	}
	
}
