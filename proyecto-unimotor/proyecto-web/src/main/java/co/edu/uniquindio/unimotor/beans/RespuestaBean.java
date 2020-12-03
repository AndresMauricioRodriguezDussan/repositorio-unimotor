package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;

@Named
@ViewScoped
public class RespuestaBean implements Serializable{

	@EJB
	UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void inicializar() {
		
	}
}
