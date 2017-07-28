package br.com.andresguedes.sandwiches.model;

import br.com.andresguedes.sandwiches.contract.SandwichesMVP;
import br.com.andresguedes.sandwiches.network.retrofit.Service;
import br.com.andresguedes.sandwiches.network.routers.LanchesRouter;

/**
 * Created by Andre on 27/07/17.
 */

public class SandwichesModel implements SandwichesMVP.SandwichesModelImpl {

    private SandwichesMVP.SandwichesPresenterImpl presenter;
    private LanchesRouter lanchesRouter;

    public SandwichesModel(SandwichesMVP.SandwichesPresenterImpl presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getLanches() {
        new LanchesRouter(Service.getService(), presenter).getLanches();
    }

}