package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Usuario;

@Named
@ViewScoped
public class PerfilBean implements Serializable{

	@EJB
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
	
	@Inject
	@ManagedProperty(value = "#{seguridadBean.usuario}")
	private Usuario usuario;

	public String eliminarCuenta() throws Exception{
		try {
			unimotorEJB.eliminarVehiculos(usuario.getId());
			unimotorEJB.eliminarUsuario(usuario.getId());
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "/index?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
			FacesContext.getCurrentInstance().addMessage("perfil_msj", msj);
		}
		return "/index?faces-redirect=true"; 
			
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
