package br.com.andresguedes.sandwiches.network.retrofit;

import br.com.andresguedes.sandwiches.network.api.API;

/**
 * Created by Andre on 27/07/17.
 */

public class Service {

    public static API getService() {
        return Client.getClient().create(API.class);
    }

}