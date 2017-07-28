package br.com.andresguedes.sandwiches.network.api;

import java.util.List;

import br.com.andresguedes.sandwiches.pojo.Sandwich;
import retrofit2.Call;
import retrofit2.http.GET;t

/**
 * Created by Andre on 27/07/17.
 */

public interface API {

    String END_POINT = "http://localhost:8080/api/";

    @GET("/lanche")
    Call<List<Sandwich>> getLanches();

}