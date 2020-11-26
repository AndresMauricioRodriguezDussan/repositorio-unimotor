package co.edu.uniquindio.unimotor.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Marca;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Usuario;

/**
 * Session Bean implementation class StartupEJB
 */
@Singleton
@LocalBean
@Startup
public class StartupEJB {

	@PersistenceContext
	private EntityManager entityManager;
    
	/**
     * Default constructor. 
     */
    public StartupEJB() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void config() {
    	Ciudad c1 = new Ciudad();
    	c1.setNombre("Armenia");
    	
    	Ciudad c2 = new Ciudad();
    	c2.setNombre("Calarca");
    	
    	Ciudad c3 = new Ciudad();
    	c3.setNombre("Circasia");
    	
    	Ciudad c4 = new Ciudad();
    	c4.setNombre("Pereira");
    	
    	
    	entityManager.persist(c1);
    	entityManager.persist(c2);
    	entityManager.persist(c3);
    	entityManager.persist(c4);
    	 
    	Map<String,String> telefonos = new HashMap<String, String>();
    	telefonos.put("celular","3122867662");
    	telefonos.put("casa","7593042");
    	
    	Usuario u = new Usuario("Andres","andres@gmail.com","andres01","calle 123",telefonos,c1);
    	entityManager.persist(u);
    	
    	Marca m = new Marca("Kia");
    	entityManager.persist(m);
    	
    	
    	Modelo modelo = new Modelo("Picanto XTREME", m);
    	entityManager.persist(modelo);
    	
    	
    }

}
