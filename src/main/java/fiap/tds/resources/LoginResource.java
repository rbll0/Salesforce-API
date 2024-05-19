package fiap.tds.resources;

import fiap.tds.models.Login;
import fiap.tds.repositories.LoginRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

    private LoginRepository loginRepository;

    public LoginResource() {
        this.loginRepository = new LoginRepository();
    }

    @POST
    @Path("/autenticar")
    public Response autenticarLogin(Login login) {
        // Busca o login no repositório pelo email
        Login loginEncontrado = loginRepository.buscarLoginPorEmail(login.getEmail_log());

        // Verifica se encontrou o login e se a senha está correta
        if (loginEncontrado != null && loginEncontrado.getSenha_log().equals(login.getSenha_log())) {
            // Se autenticado com sucesso, retorna o login encontrado com status 200 OK
            return Response.ok(loginEncontrado).build();
        } else {
            // Se não autenticado, retorna status 401 Unauthorized
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
