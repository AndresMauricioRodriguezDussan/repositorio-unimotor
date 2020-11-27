package co.uniquindio.edu.unimotor.prueba;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.unimotor.entidades.Caracteristica;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Favorito;
import co.edu.uniquindio.unimotor.entidades.Marca;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Pregunta;
import co.edu.uniquindio.unimotor.entidades.Respuesta;
import co.edu.uniquindio.unimotor.entidades.TipoCombustible;
import co.edu.uniquindio.unimotor.entidades.TipoVehiculo;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Usuario;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@RunWith(Arquillian.class)
public class ModeloTest {

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
	
	/**
	 * metodo de prueba que busca una caracteristica en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"caracteristica.json"})
	public void buscarCaracteristicaTest(){
		
		Caracteristica c = entityManager.find(Caracteristica.class,"002");
		Assert.assertNotNull(c);
	}
	
	/**
	 * metodo de prueba que busca una ciudad en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"ciudad.json"})
	public void buscarCiudadTest(){
		
		Ciudad c = entityManager.find(Ciudad.class,"003");
		Assert.assertNotNull(c);
	}
	
	/**
	 * metodo de prueba que busca un favorito en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"favorito.json"})
	public void buscarFavoritoTest(){
		
		Favorito f = entityManager.find(Favorito.class,"10001");
		Assert.assertNotNull(f);
	}
	
	/**
	 * metodo de prueba que busca una marca en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"marca.json"})
	public void buscarMarcaTest(){
		
		Marca m = entityManager.find(Marca.class,"010");
		Assert.assertNotNull(m);
	}
	
	/**
	 * metodo de prueba que busca un modelo en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"modelo.json"})
	public void buscarModeloTest(){
		
		Modelo m = entityManager.find(Modelo.class,"0004");
		Assert.assertNotNull(m);
	}
	
	/**
	 * metodo de prueba que busca una pregunta en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"pregunta.json"})
	public void buscarPreguntaTest(){
		
		Pregunta p = entityManager.find(Pregunta.class,"1234");
		Assert.assertNotNull(p);
	}
	
	/**
	 * metodo de prueba que busca una respuesta en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"respuesta.json"})
	public void buscarRespuestaTest(){
		
		Respuesta r = entityManager.find(Respuesta.class,"0003");
		Assert.assertNotNull(r);
	}
	
	/**
	 * metodo de prueba que busca un usuario en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"usuario.json"})
	public void buscarUsuarioTest(){
		
		Usuario u = entityManager.find(Usuario.class,"0004");
		Assert.assertNotNull(u);
	}
	
	/**
	 * metodo de prueba que busca un vehiculo en la base de datos con la ayuda
	 * de entityManager.find()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json"})
	public void buscarVehiculoTest(){
		
		Vehiculo v = entityManager.find(Vehiculo.class,"0003");
		Assert.assertNotNull(v);
	}
	
	/**
	 * metodo de prueba que inserta una caracteristica en la base de datos con la
	 * ayuda de entityManager.persist()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"caracteristica.json"})
	public void registrarCaracteristicaTest() {
		
		Caracteristica c= new Caracteristica(5,"descapotable");
		entityManager.persist(c);
		
		Caracteristica cRegistrado=entityManager.find(Caracteristica.class,"005");
		Assert.assertNotNull(cRegistrado);
	}
	
	/**
	 * metodo de prueba que inserta una ciudad en la base de datos con la
	 * ayuda de entityManager.persist()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"ciudad.json"})
	public void registrarCiudadTest() {
		
		Ciudad c= new Ciudad(5,"Cartagena");
		entityManager.persist(c);
		
		Ciudad cRegistrado=entityManager.find(Ciudad.class,"005");
		Assert.assertNotNull(cRegistrado);
	}
	
	/**
	 * metodo de prueba que inserta un favorito en la base de datos con la
	 * ayuda de entityManager.persist()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"favorito.json","usuario.json","vehiculo.json"})
	public void registrarFavoritoTest() {
		
		Usuario u = entityManager.find(Usuario.class,"0001");
		Vehiculo v = entityManager.find(Vehiculo.class,"0003");
		
		Favorito f= new Favorito(u, v);
		entityManager.persist(f);
		
		Favorito fRegistrado=entityManager.find(Favorito.class,"10005");
		Assert.assertNotNull(fRegistrado);
	}
	
	/**
	 * metodo de prueba que inserta una marca en la base de datos con la
	 * ayuda de entityManager.persist()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"marca.json"})
	public void registrarMarcaTest() {
		
		Marca m= new Marca("Ford");
		entityManager.persist(m);
		
		Marca mRegistrado=entityManager.find(Marca.class,"004");
		Assert.assertNotNull(mRegistrado);
	}
	
	/**
	 * metodo de prueba que inserta un modelo en la base de datos con la
	 * ayuda de entityManager.persist()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"marca.json","modelo.json"})
	public void registrarModeloTest() {
		
		Marca marca=entityManager.find(Marca.class, "003");
		
		Modelo m= new Modelo("Camaro", marca);
		entityManager.persist(m);
		
		Modelo mRegistrado=entityManager.find(Modelo.class,"0005");
		Assert.assertNotNull(mRegistrado);
	}
	
	/**
	 * metodo de prueba que inserta una pregunta en la base de datos con la
	 * ayuda de entityManager.persist()
	 */	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"pregunta.json","usuario.json","vehiculo.json"})
	public void registrarPreguntaTest() {
		
		Usuario u = entityManager.find(Usuario.class,"0001");
		Vehiculo v = entityManager.find(Vehiculo.class,"0003");
		
		Pregunta p= new Pregunta("el vehiculo tiene parabrisas trasero?",new Date(), v , u);
		entityManager.persist(p);
		
		Pregunta pRegistrado=entityManager.find(Pregunta.class,"1237");
		Assert.assertNotNull(pRegistrado);
	}
	
	/**
	 * metodo de prueba que inserta una respuesta en la base de datos con la
	 * ayuda de entityManager.persist()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"respuesta.json","pregunta.json"})
	public void registrarRespuestaTest() {
		
		Pregunta p=entityManager.find(Pregunta.class,"1236");
		
		Respuesta r= new Respuesta(5,"no tiene ningun sistema de sonido",new Date(), p) ;
		entityManager.persist(r);
		
		Respuesta rRegistrado=entityManager.find(Respuesta.class,"0005");
		Assert.assertNotNull(rRegistrado);
	}
	
	/**
	 * metodo de prueba que inserta un usuario en la base de datos con la
	 * ayuda de entityManager.persist()
	 */	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"usuario.json","ciudad.json"})
	public void registrarUsuarioTest() {
		
		Ciudad c = entityManager.find(Ciudad.class,"003");
		
		Map<String,String> telefonos = new HashMap<String, String>();
    	telefonos.put("celular","3122867662");
		
		Usuario u=new Usuario("Andres","andres@gmail.com","andres01","calle 123",telefonos,c);
		entityManager.persist(u);
		
		Usuario uRegistrado=entityManager.find(Usuario.class,"0005");
		Assert.assertNotNull(uRegistrado);
	}
	
	/**
	 * metodo de prueba que inserta un vehiculo en la base de datos con la
	 * ayuda de entityManager.persist()
	 */	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"modelo.json","usuario.json","vehiculo.json","ciudad.json"})
	public void registrarVehiculoTest() {
		
		/*Usuario u = entityManager.find(Usuario.class,"0001");
		Modelo m = entityManager.find(Modelo.class, "0002");
		Ciudad c= entityManager.find(Ciudad.class, "004");
		
		
		Vehiculo v= new Vehiculo(5,520000000,null,0,2020, Color.NEGRO, TipoCombustible.GASOLINA, TipoVehiculo.CARRO, Transmision.MECANICA, m, c, u);*/
		Vehiculo v = new Vehiculo();
		entityManager.persist(v);
		
		Vehiculo vRegistrado=entityManager.find(Vehiculo.class,"0005");
		Assert.assertNotNull(vRegistrado);
	}
	
	/**
	 * metodo de prueba que elimina una caracteristica en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"caracteristica.json"})
	public void eliminarCaracteristicaTest() {
		
		Caracteristica c = entityManager.find(Caracteristica.class,"002");
		entityManager.remove(c);
		
		Caracteristica cRemovido = entityManager.find(Caracteristica.class,"002");
		Assert.assertNull(cRemovido);
	}
	
	/**
	 * metodo de prueba que elimina una ciudad en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"ciudad.json"})
	public void eliminarCiudadTest(){
		
		Ciudad c = entityManager.find(Ciudad.class,"003");
		entityManager.remove(c);
		
		Ciudad cRemovido= entityManager.find(Ciudad.class,"003");
		Assert.assertNull(cRemovido);
	}
	
	/**
	 * metodo de prueba que elimina un favorito en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"favorito.json"})
	public void eliminarFavoritoTest(){
		
		Favorito f = entityManager.find(Favorito.class,"10001");
		entityManager.remove(f);
		
		Favorito fRemovido=entityManager.find(Favorito.class,"10001");
		Assert.assertNull(fRemovido);
	}
	
	/**
	 * metodo de prueba que elimina una marca en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"marca.json"})
	public void eliminarMarcaTest(){
		
		Marca m = entityManager.find(Marca.class,"010");
		entityManager.remove(m);
		
		Marca mRemovido= entityManager.find(Marca.class,"010");
		Assert.assertNull(mRemovido);
	}
	
	/**
	 * metodo de prueba que elimina un modelo en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"modelo.json"})
	public void eliminarModeloTest(){
		
		Modelo m = entityManager.find(Modelo.class,"0004");
		entityManager.remove(m);
		
		Modelo mRemovido=entityManager.find(Modelo.class,"0004");
		Assert.assertNull(mRemovido);
	}
	
	/**
	 * metodo de prueba que elimina una pregunta en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"pregunta.json"})
	public void eliminarPreguntaTest(){
		
		Pregunta p = entityManager.find(Pregunta.class,"1234");
		entityManager.remove(p);
		
		Pregunta pRemovido=entityManager.find(Pregunta.class,"1234");
		Assert.assertNull(pRemovido);
	}
	
	/**
	 * metodo de prueba que elimina una respuesta en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"respuesta.json"})
	public void eliminarRespuestaTest(){
		
		Respuesta r = entityManager.find(Respuesta.class,"0003");
		entityManager.remove(r);
		
		Respuesta rRemovido= entityManager.find(Respuesta.class,"0003");
		Assert.assertNull(rRemovido);
	}
	
	/**
	 * metodo de prueba que elimina un usuario en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"usuario.json"})
	public void eliminarUsuarioTest(){
		
		Usuario u = entityManager.find(Usuario.class,"0004");
		entityManager.remove(u);
		
		Usuario uRemovido=entityManager.find(Usuario.class,"0004");
		Assert.assertNull(uRemovido);
	}
	
	/**
	 * metodo de prueba que elimina un vehiculo en la base de datos con la ayuda
	 * de entityManager.remove()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json"})
	public void eliminarVehiculoTest(){
		
		Vehiculo v = entityManager.find(Vehiculo.class,"0003");
		entityManager.remove(v);
		
		Vehiculo vRemovido=entityManager.find(Vehiculo.class,"0003");
		Assert.assertNull(vRemovido);
	}
	
	/**
	 * metodo de prueba que actualiza una caracteristica en la base de datos con la ayuda
	 * de entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"caracteristica.json"})
	public void actualizarCaracteristicaTest() {
		
		Caracteristica c = entityManager.find(Caracteristica.class,"002");
		c.setNombre("frenos mecanicos");
		
		entityManager.merge(c);
		
		Caracteristica cActualizado = entityManager.find(Caracteristica.class,"002");
		Assert.assertEquals("frenos mecanicos",cActualizado.getNombre());;
	}
	
	/**
	 * metodo de prueba que actualiza una ciudad en la base de datos con la ayuda
	 * de entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"ciudad.json"})
	public void actualizarCiudadTest(){
		
		Ciudad c = entityManager.find(Ciudad.class,"003");
		c.setNombre("Cartagena");
		
		entityManager.merge(c);
		
		Ciudad cActualizado= entityManager.find(Ciudad.class,"003");
		Assert.assertEquals("Cartagena",cActualizado.getNombre());;	
	}
	
	/**
	 * metodo de prueba que actualiza un favorito en la base de datos con la ayuda
	 * de entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"favorito.json"})
	public void actualizarFavoritoTest(){
		
		Favorito f = entityManager.find(Favorito.class,"10001");
		Usuario u = entityManager.find(Usuario.class,"0004");
		f.setUsuario(u);
		
		entityManager.merge(f);
		
		Favorito fActualizado=entityManager.find(Favorito.class,"10001");
		Assert.assertEquals(u,fActualizado.getUsuario());
	}
	
	/**
	 * metodo de prueba que actualiza una marca en la base de datos con la ayuda
	 * de entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"marca.json"})
	public void actualizarMarcaTest(){
		
		Marca m = entityManager.find(Marca.class,"010");
		m.setNombre("Harley Davidson");
		
		entityManager.merge(m);
		
		Marca mActualizado= entityManager.find(Marca.class,"010");
		Assert.assertEquals("Harley Davidson",mActualizado.getNombre());
	}
	
	/**
	 * metodo de prueba que actualiza un modelo en la base de datos con la ayuda
	 * de entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"modelo.json"})
	public void actualizarModeloTest(){
		
		Modelo m = entityManager.find(Modelo.class,"0004");
		m.setNombre("Spark GT");
		
		entityManager.merge(m);
		
		Modelo mActualizado=entityManager.find(Modelo.class,"0004");
		Assert.assertEquals("Spark GT",mActualizado.getNombre());
	}
	
	/**
	 * metodo de prueba que actualiza una pregunta en la base de datos con la ayuda
	 * de entityManager.merge()
	 * @throws ParseException 
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"pregunta.json"})
	public void actualizarPreguntaTest() throws ParseException{
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActualizada= sdf.parse("2020-04-15");
		
		Pregunta p = entityManager.find(Pregunta.class,"1234");
		p.setFecha(fechaActualizada);
		
		entityManager.merge(p);
		
		Pregunta pActualizado=entityManager.find(Pregunta.class,"1234");
		Assert.assertEquals(fechaActualizada, pActualizado.getFecha());
	}
	
	/**
	 * metodo de prueba que actualiza una respuesta en la base de datos con la ayuda
	 * de entityManager.merge()
	 * @throws ParseException 
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"respuesta.json"})
	public void actualizarRespuestaTest() throws ParseException{
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date fechaActualizada= sdf.parse("2020-05-05");
		
		Respuesta r = entityManager.find(Respuesta.class,"0003");
		r.setFecha(fechaActualizada);
		
		entityManager.merge(r);
		
		Respuesta rActualizado= entityManager.find(Respuesta.class,"0003");
		Assert.assertEquals(fechaActualizada, rActualizado.getFecha());
	}
	
	/**
	 * metodo de prueba que actualiza un usuario en la base de datos con la ayuda
	 * de entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"usuario.json"})
	public void actualizarUsuarioTest(){
		
		Usuario u = entityManager.find(Usuario.class,"0004");
		u.setDireccion(null);
		
		entityManager.merge(u);
		
		Usuario uActualizado=entityManager.find(Usuario.class,"0004");
		Assert.assertNull(uActualizado.getDireccion());
	}
	
	/**
	 * metodo de prueba que actualiza un vehiculo en la base de datos con la ayuda
	 * de entityManager.merge()
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"vehiculo.json"})
	public void actualizarVehiculoTest(){
		
		Vehiculo v = entityManager.find(Vehiculo.class,"0003");
		v.setDescripcion("es capaz de desarrollar desde 163 hasta 258 caballos.");
		
		entityManager.merge(v);
		
		Vehiculo vActualizado=entityManager.find(Vehiculo.class,"0003");
		Assert.assertEquals("es capaz de desarrollar desde 163 hasta 258 caballos.",vActualizado.getDescripcion());
	}

}

