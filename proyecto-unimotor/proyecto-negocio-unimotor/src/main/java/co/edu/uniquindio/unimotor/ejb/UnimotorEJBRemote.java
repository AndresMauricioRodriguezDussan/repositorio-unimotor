package co.edu.uniquindio.unimotor.ejb;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.unimotor.entidades.Caracteristica;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Pregunta;
import co.edu.uniquindio.unimotor.entidades.Respuesta;
import co.edu.uniquindio.unimotor.entidades.TipoCombustible;
import co.edu.uniquindio.unimotor.entidades.TipoVehiculo;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Usuario;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Remote
public interface UnimotorEJBRemote {
	
	Usuario iniciarSesion (String correo, String contrasena)throws Exception;

	void registrarUsuario(Usuario usuario) throws Exception;
	
	void registrarVehiculo(Vehiculo vehiculo) throws Exception;
	
	List<Vehiculo> buscarVehiculoNombre(String busqueda);
	
	Ciudad obtenerCiudad(Integer id);
	
	Modelo obtenerModelo(Integer id);
	
	Usuario obtenerUsuario(Integer id);
	
	Caracteristica obtenerCaracteristica(Integer id);
	
	Vehiculo obtenerVehiculo(Integer id);
	
	List<TipoVehiculo> obtenerListaTipoVehiculo();
	
	List<TipoCombustible> obtenerListaTipoCombustible();
	
	List<Transmision> obtenerListaTransmision();
	
	List<Ciudad> obtenerListaCiudad();
	
	List<Modelo> obtenerListaModelo();

	List<Vehiculo> obtenerListaVehiculo();
	
	List<Vehiculo> obtenerListaVehiculoUsuario(Integer id);

	List<Caracteristica> obtenerListaCaracteristicaVehiculo(Integer id);
	
	List<Pregunta> obtenerListaPreguntasVehiculo(Integer id);
	
	List<Pregunta> obtenerListaPreguntasUsuario(Integer id);
	
	List<Respuesta> obtenerListaRespuestasPregunta(Integer id);
	
	List<Caracteristica> obtenerListaCaracteristica();
	
	List<Vehiculo> obtenerListaFavorito(Integer id);
	
	Pregunta hacerPregunta(Usuario u,Vehiculo v, String p) throws Exception;
	
	void guardarFavorito(Usuario u,Vehiculo v) throws Exception;
	
	void eliminarFavorito(Usuario u,Vehiculo v) throws Exception;
	
	void eliminarPublicacion(Integer id) throws Exception;
	
}
