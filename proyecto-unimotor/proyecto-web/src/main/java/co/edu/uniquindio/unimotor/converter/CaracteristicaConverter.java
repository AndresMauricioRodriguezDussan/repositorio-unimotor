package co.edu.uniquindio.unimotor.converter;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Caracteristica;

@FacesConfig(version = Version.JSF_2_3)
@Named
@ApplicationScoped
public class CaracteristicaConverter implements Converter<Caracteristica>, Serializable{
	
	private static final long serialVersionUID = 1L;
	@EJB
	private UnimotorEJB unimotorEJB;

	@Override
	public Caracteristica getAsObject(FacesContext context, UIComponent component, String value) {
		Caracteristica caracteristica=null;
		
		if(value!=null) {
			caracteristica=unimotorEJB.obtenerCaracteristica(Integer.parseInt(value));
		}
		return caracteristica;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Caracteristica value) {
		if(value!=null) {
			return ""+value.getId();
		}
		return "";
	}
}
