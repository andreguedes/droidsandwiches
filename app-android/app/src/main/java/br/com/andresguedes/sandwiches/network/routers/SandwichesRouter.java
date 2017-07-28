package br.com.andresguedes.sandwiches.network.routers;

import java.util.List;

import br.com.andresguedes.sandwiches.contract.SandwichesMVP;
import br.com.andresguedes.sandwiches.network.api.API;
import br.com.andresguedes.sandwiches.pojo.Sandwich;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andre on 27/07/17.
 */

public class SandwichesRouter {

    private API api;
    private SandwichesMVP.SandwichesPresenterImpl presenter;

    public SandwichesRouter(API api, SandwichesMVP.SandwichesPresenterImpl presenter) {
        this.api = api;
        this.presenter = presenter;
    }

    public void getLanches() {
        if (api != null) {
            api.getLanches().enqueue(new Callback<List<Sandwich>>() {
                @Override
                public void onResponse(Call<List<Sandwich>> call, Response<List<Sandwich>> response) {
                    if (presenter != null) {
                        List<Sandwich> sandwiches = response.body();
                        if (sandwiches != null)
                            presenter.atualizarLanches(sandwiches);
                    }
                }

                @Override
                public void onFailure(Call<List<Sandwich>> call, Throwable t) {
                    if (presenter != null)
                        presenter.atualizarLanches(null);
                }
            });
        }
    }

}