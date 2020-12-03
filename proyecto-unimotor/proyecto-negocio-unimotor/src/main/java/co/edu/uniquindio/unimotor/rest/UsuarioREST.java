package co.edu.uniquindio.unimotor.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Usuario;

@Path("/usuarios")
public class UsuarioREST {

	@EJB
	private UnimotorEJB unimotorEJB;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response obtenerUsuarios(){
		return Response.status(500).entity(unimotorEJB.obtenerListaUsuario()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response obtenerUsuario( @PathParam("id") Integer id) {
		try {
			Usuario usuario = unimotorEJB.obtenerUsuario(id);
			return Response.status(200).entity(usuario).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" : \""+e.getMessage()+"\"  }").build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response registrarUsuario(Usuario usuario) {
		try {
			unimotorEJB.registrarUsuario(usuario);
			return Response.status(200).entity("{ \"mensaje\" : \"El usuario se registro correctamente\"  }").type(MediaType.APPLICATION_JSON).build();
			
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" : \""+e.getMessage()+"\"  }").build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response actualizarUsuario(Usuario usuario) {
		try {
			unimotorEJB.actualizarUsuario(usuario);
			return Response.status(200).entity("{ \"mensaje\" : \"El usuario se actualizo correctamente\"  }").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" : \""+e.getMessage()+"\"  }").build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response eliminarUsuario(@PathParam("id") Integer id) {
		try {
			unimotorEJB.eliminarUsuario(id);
			return Response.status(200).entity("{ \"mensaje\" : \"El usuario se elimino correctamente\"  }").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" : \""+e.getMessage()+"\"  }").build();
		}
	}
}
