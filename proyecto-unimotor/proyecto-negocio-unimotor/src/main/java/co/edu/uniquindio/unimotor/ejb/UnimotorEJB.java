package co.edu.uniquindio.unimotor.ejb;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

/**
 * Session Bean implementation class UsuarioEJB
 */
@Stateless
@LocalBean
public class UnimotorEJB implements UnimotorEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor. 
	 */
	public UnimotorEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registrarUsuario(Usuario usuario) throws Exception {

		if(buscarEmail(usuario.getCorreo())) {
			throw new Exception ("El email ya se encuentra en uso");
		}

		entityManager.persist(usuario); 		
	}

	public boolean buscarEmail(String correo) {
		TypedQuery<Usuario> q = entityManager.createNamedQuery("BUSCAR_CORREO", Usuario.class);
		q.setParameter("correo",correo);

		List<Usuario> l = q.getResultList();

		if( l.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) throws Exception {

		if(buscarPlaca(vehiculo.getPlaca())) {
			throw new Exception ("Esta placa ya ha sido registrada en otro vehiculo");
		}

		entityManager.persist(vehiculo); 		
	}

	public boolean buscarPlaca(String placa) {
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("BUSCAR_VEHICULO_PLACA", Vehiculo.class);
		q.setParameter("placa",placa);

		List<Vehiculo> l = q.getResultList();

		if( l.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public List<Vehiculo> buscarVehiculoNombre(String busqueda){
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("LISTA_VEHICULO_NOMBRE", Vehiculo.class);
		q.setParameter("nombre", "%"+busqueda+"%");

		return q.getResultList();
	}

	@Override
	public Usuario iniciarSesion(String correo, String contrasena) throws Exception {
		TypedQuery<Usuario> q = entityManager.createNamedQuery("AUTENTICAR_USUARIO", Usuario.class);
		q.setParameter("correo", correo);
		q.setParameter("contrasena", contrasena);

		List<Usuario> l = q.getResultList();

		if( l.isEmpty()) {
			throw new Exception ("Los datos de autenticacion son incorrectos");
		}
		return l.get(0);
	}


	@Override
	public Ciudad obtenerCiudad(Integer id) throws Exception {
		Ciudad m = entityManager.find(Ciudad.class, id);
		if(m!=null) {
			return m;
		}else {
			throw new Exception("La ciudad no existe");
		}
	}

	@Override
	public Modelo obtenerModelo(Integer id) throws Exception {
		Modelo m = entityManager.find(Modelo.class, id);
		if(m!=null) {
			return m;
		}else {
			throw new Exception("El modelo no existe");
		}
	}

	@Override
	public Marca obtenerMarca(Integer id) throws Exception {
		Marca m = entityManager.find(Marca.class, id);
		if(m!=null) {
			return m;
		}else {
			throw new Exception("la marca no existe");
		}
	}

	@Override
	public Usuario obtenerUsuario(Integer id) throws Exception {
		Usuario m = entityManager.find(Usuario.class, id);
		if(m!=null) {
			return m;
		}else {
			throw new Exception("El usuario no existe");
		}
	}
	
	@Override
	public Usuario obtenerUsuarioEmail(String emailLogin) throws Exception {
		TypedQuery<Usuario> q = entityManager.createNamedQuery("BUSCAR_CORREO", Usuario.class);
		q.setParameter("correo", emailLogin);
		
		List<Usuario> l = q.getResultList();
		if(!l.isEmpty()) {
			return l.get(0);
		}
		else {
			throw new Exception("No hay ningun usuario registrado con este correo");
		}
		
	}

	@Override
	public Caracteristica obtenerCaracteristica(Integer id) throws Exception {
		Caracteristica m = entityManager.find(Caracteristica.class, id);
		if(m!=null) {
			return m;
		}else {
			throw new Exception("La caracteristica no existe");
		}
	}

	@Override
	public Vehiculo obtenerVehiculo(Integer id) throws Exception {
		Vehiculo m = entityManager.find(Vehiculo.class, id);
		if(m!=null) {
			return m;
		}else {
			throw new Exception("El vehiculo no existe");
		}
	}

	@Override
	public List<TipoVehiculo> obtenerListaTipoVehiculo() {
		return Arrays.asList(TipoVehiculo.values());
	}

	@Override
	public List<TipoCombustible> obtenerListaTipoCombustible() {
		return Arrays.asList(TipoCombustible.values());
	}

	@Override
	public List<Transmision> obtenerListaTransmision() {
		return Arrays.asList(Transmision.values());
	}

	@Override
	public List<Ciudad> obtenerListaCiudad() {
		TypedQuery<Ciudad> q = entityManager.createNamedQuery("LISTA_CIUDADES", Ciudad.class);
		return q.getResultList();
	}

	@Override
	public List<Modelo> obtenerListaModelo() {
		TypedQuery<Modelo> q = entityManager.createNamedQuery("LISTA_MODELOS", Modelo.class);
		return q.getResultList();
	}

	@Override
	public List<Marca> obtenerListaMarca() {
		TypedQuery<Marca> q = entityManager.createNamedQuery("LISTA_MARCAS", Marca.class);
		return q.getResultList();
	}

	@Override
	public List<Vehiculo> obtenerListaVehiculo() {
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("LISTA_VEHICULOS", Vehiculo.class);
		return q.getResultList();
	}

	@Override
	public List<Usuario> obtenerListaUsuario() {
		TypedQuery<Usuario> q = entityManager.createNamedQuery("LISTA_USUARIOS", Usuario.class);
		return q.getResultList();
	}

	@Override
	public List<Vehiculo> obtenerListaVehiculoUsuario(Integer id) {
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("LISTA_VEHICULOS_USUARIO", Vehiculo.class);
		q.setParameter("id",id);

		return q.getResultList();
	}

	@Override
	public List<Caracteristica> obtenerListaCaracteristica() {
		TypedQuery<Caracteristica> q = entityManager.createNamedQuery("LISTA_CARACTERISTICAS", Caracteristica.class);
		return q.getResultList();
	}

	@Override
	public List<Caracteristica> obtenerListaCaracteristicaVehiculo(Integer id) {
		TypedQuery<Caracteristica> q = entityManager.createNamedQuery("LISTA_CARACTERISTICAS_VEHICULO", Caracteristica.class);
		q.setParameter("id",id);

		return q.getResultList();
	}

	@Override
	public List<Pregunta> obtenerListaPreguntasVehiculo(Integer id) {
		TypedQuery<Pregunta> q = entityManager.createNamedQuery("LISTA_PREGUNTAS_VEHICULO", Pregunta.class);
		q.setParameter("id",id);

		return q.getResultList();

	}

	@Override
	public List<Pregunta> obtenerListaPreguntasUsuario(Integer id) {
		TypedQuery<Pregunta> q = entityManager.createNamedQuery("LISTA_PREGUNTAS_USUARIO", Pregunta.class);
		q.setParameter("id",id);

		return q.getResultList();
	}

	@Override
	public List<Respuesta> obtenerListaRespuestasPregunta(Integer id) {
		TypedQuery<Respuesta> q = entityManager.createNamedQuery("LISTA_RESPUESTAS_PREGUNTA", Respuesta.class);
		q.setParameter("id",id);

		return q.getResultList();
	}

	@Override
	public Pregunta hacerPregunta(Usuario u, Vehiculo v, String p) throws Exception {
		try {
			Pregunta pregunta=null;

			if(u!=null && v!=null) {
				pregunta = new Pregunta(p, new Date(), v,u);
				entityManager.persist(pregunta);
			}
			else {
				throw new Exception("Es necesario definir un usuario y un vehiculo al hacer una pregunta");
			}
			return pregunta;
		}catch(Exception e){
			throw new Exception("Hubo un error al registrar la pregunta");
		}
	}

	@Override
	public List<Vehiculo> obtenerListaFavorito(Integer id) {
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("OBTENER_LISTA_FAVORITOS_USUARIO", Vehiculo.class);
		q.setParameter("id",id);

		return q.getResultList();
	}

	@Override
	public void guardarFavorito(Usuario u, Vehiculo v) throws Exception{
		if(u!=null && v!=null) {
			Favorito favorito = null;
			try {
				favorito = new Favorito(u, v);
				entityManager.persist(favorito);
			}catch(Exception e) {
				throw new Exception("Hubo un error al registrar el favorito");
			}
		}
		else {
			throw new Exception("Es necesario definir un usuario y un vehiculo para marcar un favorito");
		}
	}

	@Override
	public void guardarMarca(Marca marca) throws Exception {
		if( buscarNombreMarca(marca.getNombre())) {
			throw new Exception("La marca ya ha sido registrada");
		}
		else {
			entityManager.persist(marca);
		}
	}

	private boolean buscarNombreMarca(String nombre) {
		TypedQuery<Marca> q = entityManager.createNamedQuery("LISTA_MARCA_NOMBRE", Marca.class);
		q.setParameter("nombre",nombre);

		List<Marca> l= q.getResultList();

		if(l.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void eliminarFavorito(Usuario u, Vehiculo v) throws Exception{
		if(u!=null && v!=null) {
			Favorito favorito = null;
			try {
				favorito = new Favorito(u, v);
				entityManager.remove(favorito);
			}catch(Exception e) {
				throw new Exception("Hubo un error al eliminar el favorito");
			}
		}
		else {
			throw new Exception("Es necesario definir un usuario y un vehiculo para eliminar un favorito");
		}
	}

	@Override
	public void eliminarVehiculo(Integer id) throws Exception {
		if(id!=null) {
			Vehiculo vehiculo = null;
			try {
				vehiculo = entityManager.find(Vehiculo.class, id);
				entityManager.remove(vehiculo);
			}catch(Exception e) {
				throw new Exception("Hubo un error al eliminar la publicacion");
			}
		}
		else {
			throw new Exception("Es necesario definir una publicacion para eliminarla");
		}
	}

	@Override
	public void eliminarMarca(Integer id) throws Exception {
		Marca marca= entityManager.find(Marca.class, id);

		if(marca!=null) {
			entityManager.remove(marca);
		}else {
			throw new Exception("la marca no existe");
		}
	}

	@Override
	public void eliminarUsuario(Integer id) throws Exception {
		Usuario usuario= entityManager.find(Usuario.class, id);

		if(usuario!=null) {
			entityManager.remove(usuario);
		}else {
			throw new Exception("El usuario no existe");
		}

	}
	
	@Override
	public void eliminarVehiculos(Integer id) throws Exception {
		List<Vehiculo> l = obtenerListaVehiculoUsuario(id);
		if(!l.isEmpty()) {
			for (Vehiculo v : l) {
				entityManager.remove(v);
			}
		}
		else {
			throw new Exception("El usuario no tenia vehiculos");
		}
		

	}

	@Override
	public void actualizarMarca(Marca marca) throws Exception {
		if(marca!=null) {
			entityManager.merge(marca);
		}else {
			throw new Exception("la marca no existe");
		}
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) throws Exception {
		if(vehiculo!=null) {
			entityManager.merge(vehiculo);
		}else {
			throw new Exception("El vehiculo no existe");
		}

	}

	@Override
	public void actualizarUsuario(Usuario usuario) throws Exception {
		if(usuario!=null) {
			entityManager.merge(usuario);
		}else {
			throw new Exception("El usuario no existe");
		}
	}

	@Override
	public void enviarEmail(String asunto, String mensaje, String destinatario) throws Exception {
		// TODO Auto-generated method stub
		// codigo tomado de:
		// https://www.campusmvp.es/recursos/post/como-enviar-correo-electronico-con-java-a-traves-de-gmail.aspx

		String remitente = ""; // Para la direcci�n nomcuenta@gmail.com
		String clave = "";
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // El servidor SMTP de Google
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", clave); // La clave de la cuenta
		props.put("mail.smtp.auth", "true"); // Usar autenticaci�n mediante usuario y clave
		props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(remitente));
			message.addRecipients(Message.RecipientType.TO, destinatario); // Se podr�an a�adir varios de la misma
																			// manera
			message.setSubject(asunto);
			message.setText(mensaje);
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, clave);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException me) {
			me.printStackTrace(); // Si se produce un error
		}
	}

}
