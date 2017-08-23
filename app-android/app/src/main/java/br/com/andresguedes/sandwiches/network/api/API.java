package br.com.andresguedes.sandwiches.network.api;

import java.util.List;

import br.com.andresguedes.sandwiches.pojo.Sandwich;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Andre on 27/07/17.
 */

public interface API {

    String END_POINT = "http://10.0.3.2:8080/";

    @GET("/api/lanche")
    Call<List<Sandwich>> getLanches();

    @PUT("/api/pedido/{idLanche}")
    Call<Sandwich> putPedido(@Path("idLanche") int idLanche);

}