package co.edu.uniquindio.unimotor.ejb;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniquindio.unimotor.entidades.Caracteristica;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Marca;
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
	
	Ciudad obtenerCiudad(Integer id) throws Exception;
	
	Modelo obtenerModelo(Integer id) throws Exception;
	
	Marca obtenerMarca(Integer id) throws Exception;
	
	Usuario obtenerUsuario(Integer id) throws Exception;
	
	Usuario obtenerUsuarioEmail(String emailLogin) throws Exception;
	
	Caracteristica obtenerCaracteristica(Integer id) throws Exception;
	
	Vehiculo obtenerVehiculo(Integer id) throws Exception;
	
	List<TipoVehiculo> obtenerListaTipoVehiculo();
	
	List<TipoCombustible> obtenerListaTipoCombustible();
	
	List<Transmision> obtenerListaTransmision();
	
	List<Ciudad> obtenerListaCiudad();
	
	List<Modelo> obtenerListaModelo();
	
	List<Marca> obtenerListaMarca();

	List<Vehiculo> obtenerListaVehiculo();
	
	List<Usuario> obtenerListaUsuario();
	
	List<Vehiculo> obtenerListaVehiculoUsuario(Integer id);

	List<Caracteristica> obtenerListaCaracteristicaVehiculo(Integer id);
	
	List<Pregunta> obtenerListaPreguntasVehiculo(Integer id);
	
	List<Pregunta> obtenerListaPreguntasUsuario(Integer id);
	
	List<Respuesta> obtenerListaRespuestasPregunta(Integer id);
	
	List<Caracteristica> obtenerListaCaracteristica();
	
	List<Vehiculo> obtenerListaFavorito(Integer id);
	
	Pregunta hacerPregunta(Usuario u,Vehiculo v, String p) throws Exception;
	
	void guardarFavorito(Usuario u,Vehiculo v) throws Exception;
	
	void guardarMarca(Marca marca) throws Exception;
	
	void eliminarFavorito(Usuario u,Vehiculo v) throws Exception;
	
	void eliminarVehiculo(Integer id) throws Exception;
	
	void eliminarMarca(Integer id) throws Exception;

	void actualizarMarca(Marca marca) throws Exception;

	void actualizarVehiculo(Vehiculo vehiculo) throws Exception;

	void actualizarUsuario(Usuario usuario) throws Exception;

	void eliminarUsuario(Integer id) throws Exception;

	void enviarEmail(String asunto, String mensaje, String destinatario) throws Exception;

	void eliminarVehiculos(Integer id) throws Exception;

	

	

	
	
}
