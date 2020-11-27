package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Usuario;

@Named
@SessionScoped
public class SeguridadBean implements Serializable{

	@EJB
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private boolean autenticado;
	
	@NotBlank
	@Email
	private String emailLogin;
	@NotBlank
	private String contrasenaLogin;
	
	@PostConstruct
	public void inicializar() {
		usuario = new Usuario();
		autenticado = false;
	}
	
	public String autenticarUsuario() throws Exception{
		try {
			Usuario u = unimotorEJB.iniciarSesion(emailLogin, contrasenaLogin);
			
			if(u!=null) {
				autenticado=true;
				usuario=u;
				
				return "/index?faces-redirect=true";
			}
		} catch (Exception e) {
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
			FacesContext.getCurrentInstance().addMessage("mensaje_sesion", msj);
		}
		return null;
	}
	
	public void enviarCorreo() {
		
	}
	
	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index?faces-redirect=true";
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getContrasenaLogin() {
		return contrasenaLogin;
	}

	public void setContrasenaLogin(String contrasenaLogin) {
		this.contrasenaLogin = contrasenaLogin;
	}
	
}
