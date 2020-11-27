package co.edu.uniquindio.unimotor.ejb;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.unimotor.entidades.Caracteristica;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Favorito;
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
	public Ciudad obtenerCiudad(Integer id) {
		return entityManager.find(Ciudad.class, id);
	}
	
	@Override
	public Modelo obtenerModelo(Integer id) {
		return entityManager.find(Modelo.class, id);
	}
	
	@Override
	public Usuario obtenerUsuario(Integer id) {
		return entityManager.find(Usuario.class, id);
	}
	
	@Override
	public Caracteristica obtenerCaracteristica(Integer id) {
		return entityManager.find(Caracteristica.class, id);
	}
	
	@Override
	public Vehiculo obtenerVehiculo(Integer id) {
		return entityManager.find(Vehiculo.class,id);
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
	public List<Vehiculo> obtenerListaVehiculo() {
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("LISTA_VEHICULOS", Vehiculo.class);
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
}
