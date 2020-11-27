package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Favorito
 * @author Andres Mauricio Rodriguez Dussan
 * @date 1/10/2020
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "TODOS_FAVORITOS", query = "select f from Favorito f"),
	@NamedQuery(name = "OBTENER_LISTA_FAVORITOS_USUARIO", query = "select f.vehiculo from Favorito f where f.usuario.id = :id")
})

public class Favorito implements Serializable {

	   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="usuario_id",nullable=false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="vehiculo_id",nullable=false)
	private Vehiculo vehiculo;
	
	
	private static final long serialVersionUID = 1L;

	public Favorito() {
		super();
	}
	
	public Favorito(Usuario usuario, Vehiculo vehiculo) {
		super();
		this.usuario = usuario;
		this.vehiculo = vehiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorito other = (Favorito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorito [id=" + id + ", usuario=" + usuario + ", vehiculo=" + vehiculo + "]";
	}
	
	
   
}
