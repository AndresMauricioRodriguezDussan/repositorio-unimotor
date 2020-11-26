package co.uniquindio.edu.unimotor.prueba;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.unimotor.entidades.Caracteristica;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Favorito;
import co.edu.uniquindio.unimotor.entidades.Marca;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Pregunta;
import co.edu.uniquindio.unimotor.entidades.Respuesta;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Usuario;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@RunWith(Arquillian.class)
public class JPQLTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class,

				"prueba.war").addPackage(Usuario.class.getPackage())
				.addAsResource("persistenceForTest.xml",

						"META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	public void test() {
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json"})
	public void listaVehiculoTest() {
		
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("TODOS_VEHICULOS",Vehiculo.class);
		List<Vehiculo> l = q.getResultList();
		
		for(Vehiculo v : l) {
			System.out.println(v);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json"})
	public void listaUsuarioTest() {
		
		TypedQuery<Usuario> q = entityManager.createNamedQuery("TODOS_USUARIOS",Usuario.class);
		List<Usuario> l = q.getResultList();
		
		for(Usuario u : l) {
			System.out.println(u);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json","pregunta.json","respuesta.json"})
	public void listaRespuestaTest() {
		
		TypedQuery<Respuesta> q = entityManager.createNamedQuery("TODOS_RESPUESTAS",Respuesta.class);
		List<Respuesta> l = q.getResultList();
		
		for(Respuesta r : l) {
			System.out.println(r);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json","pregunta.json","respuesta.json"})
	public void listaPreguntaTest() {
		
		TypedQuery<Pregunta> q = entityManager.createNamedQuery("TODOS_PREGUNTAS",Pregunta.class);
		List<Pregunta> l = q.getResultList();
		
		for(Pregunta p : l) {
			System.out.println(p);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json","pregunta.json","respuesta.json"})
	public void listaModeloTest() {
		
		TypedQuery<Modelo> q = entityManager.createNamedQuery("TODOS_MODELOS",Modelo.class);
		List<Modelo> l = q.getResultList();
		
		for(Modelo m : l) {
			System.out.println(m);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json","pregunta.json","respuesta.json"})
	public void listaMarcaTest() {
		
		TypedQuery<Marca> q = entityManager.createNamedQuery("TODOS_MARCAS",Marca.class);
		List<Marca> l = q.getResultList();
		
		for(Marca m : l) {
			System.out.println(m);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","favorito.json"})
	public void listaFavoritoTest() {
		
		TypedQuery<Favorito> q = entityManager.createNamedQuery("TODOS_FAVORITOS",Favorito.class);
		List<Favorito> l = q.getResultList();
		
		for(Favorito f : l) {
			System.out.println(f);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"ciudad.json"})
	public void listaCiudadTest() {
		
		TypedQuery<Ciudad> q = entityManager.createNamedQuery("TODOS_CIUDADES",Ciudad.class);
		List<Ciudad> l = q.getResultList();
		
		for(Ciudad c : l) {
			System.out.println(c);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"caracteristica.json"})
	public void listaCaracteristicaTest() {
		
		TypedQuery<Caracteristica> q = entityManager.createNamedQuery("TODOS_CARACTERISTICAS",Caracteristica.class);
		List<Caracteristica> l = q.getResultList();
		
		for(Caracteristica c : l) {
			System.out.println(c);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json"})
	public void listaVehiculoTransmisionTest() {
		
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("TODOS_VEHICULOS_TRANSMISION",Vehiculo.class);
		q.setParameter("transmision",Transmision.AUTOMATICA);
		
		List<Vehiculo> l = q.getResultList();
		
		for(Vehiculo v : l) {
			System.out.println(v);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"usuario.json","ciudad.json"})
	public void autenticacionUsuarioTest() {
		
		TypedQuery<Usuario> q = entityManager.createNamedQuery("AUTENTICAR_USUARIO",Usuario.class);
		q.setParameter("correo","carlos@email.com");
		q.setParameter("contrasena","0001a");
		
		List<Usuario> l = q.getResultList();
		
		if(!l.isEmpty()) {
			System.out.println(l);
		}
		else {
			System.out.println("los datos de autenticacion son incorrectos");
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json"})
	public void listaVehiculoAnioTest() {
		
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("TODOS_VEHICULOS_ANIO",Vehiculo.class);
		q.setParameter("inicio",2011);
		q.setParameter("fin",2019);
		
		List<Vehiculo> l = q.getResultList();
		
		for(Vehiculo v : l) {
			System.out.println(v);
		}
	}

	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json"})
	public void vehiculoPlacaTest() {
		
		TypedQuery<Object[]> q = entityManager.createNamedQuery("MODELO_VEHICULO_PLACA",Object[].class);
		q.setParameter("placa","BBB222");
		
		List<Object[]> l = q.getResultList();
		
		for(Object[] v : l) {
			System.out.println(v[0]+" "+v[1]+" "+v[2]);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json","favorito.json"})
	public void listaVehiculosFavoritosTest() {
		
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("LISTA_FAVORITOS_USUARIO",Vehiculo.class);
		q.setParameter("correo","carlos@email.com");
		
		List<Vehiculo> l = q.getResultList();
		
		for(Vehiculo v : l) {
			System.out.println(v);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json","favorito.json"})
	public void listaVehiculosFavoritos2Test() {
		
		TypedQuery<Object[]> q = entityManager.createNamedQuery("LISTA_FAVORITOS_USUARIO_2",Object[].class);
		q.setParameter("correo","carlos@email.com");
		
		List<Object[]> l = q.getResultList();
		
		for(Object[] v : l) {
			System.out.println(v[0]+" "+v[1]);
		}
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","ciudad.json","modelo.json","marca.json","caracteristica.json","favorito.json"})
	public void listaVehiculosUsuarioTest() {
		
		TypedQuery<Object[]> q = entityManager.createNamedQuery("LISTA_VEHICULOS_USUARIO",Object[].class);
		
		List<Object[]> l = q.getResultList();
		
		for(Object[] v : l) {
			System.out.println(v[0]+" "+v[1]);
		}
	}
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json","usuario.json","preguntas.json"})
	public void listaPreguntasVehiculoTest() {
		
		TypedQuery<Object[]> q = entityManager.createNamedQuery("LISTA_PREGUNTAS_VEHICULO",Object[].class);
		
		List<Object[]> l = q.getResultList();
		
		for(Object[] v : l) {
			System.out.println(v[0]+" "+v[1]);
		}
	}
}
