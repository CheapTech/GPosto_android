package br.com.senacrs.gposto.WebApis;

import br.com.senacrs.gposto.LibClass.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface Interface {

    @GET("UsuarioGETid.php")
    Call<Usuario> logar(@Query(value = "email", encoded = true) String email, @Query(value = "senha", encoded = true) String senha);

    @POST("inserir.php")
    Call<Usuario> cadastrarUsuario(@Body Usuario usuario);
}
