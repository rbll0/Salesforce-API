package fiap.tds.resources;

import fiap.tds.models.Cliente;
import fiap.tds.repositories.ClienteRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/clientes")
public class ClienteResource {

    private ClienteRepository clienteRepository = new ClienteRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarCliente(Cliente cliente) {
        try {
            clienteRepository.salvarCliente(cliente);
            return Response.status(Status.CREATED).entity(cliente).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao inserir cliente no banco de dados").build();
        }
    }
}
