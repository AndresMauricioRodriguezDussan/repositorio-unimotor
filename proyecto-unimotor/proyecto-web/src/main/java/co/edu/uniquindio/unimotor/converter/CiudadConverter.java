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
import co.edu.uniquindio.unimotor.entidades.Ciudad;

@FacesConfig(version = Version.JSF_2_3)
@Named
@ApplicationScoped
public class CiudadConverter implements Converter<Ciudad>, Serializable {

	@EJB
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
	
	@Override
	public Ciudad getAsObject(FacesContext context, UIComponent component, String value) {
		Ciudad ciudad=null;
		
		if(value!=null) {
			try {
				ciudad=unimotorEJB.obtenerCiudad(Integer.parseInt(value));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ciudad;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Ciudad value) {
		
		if(value!=null) {
			return ""+value.getId();
		}
		
		return "";
	}

}
