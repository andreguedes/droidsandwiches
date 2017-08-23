package br.com.andresguedes.sandwiches.model;

import br.com.andresguedes.sandwiches.contract.SandwichDetailMVP;
import br.com.andresguedes.sandwiches.network.retrofit.Service;
import br.com.andresguedes.sandwiches.network.routers.SandwichDetailRouter;

/**
 * Created by Andre on 15/08/17.
 */

public class SandwichDetailModel implements SandwichDetailMVP.SandwichesDetailModelImpl {

    private SandwichDetailMVP.SandwichesDetailPresenterImpl presenter;

    public SandwichDetailModel(SandwichDetailMVP.SandwichesDetailPresenterImpl presenter) {
        this.presenter = presenter;
    }

    @Override
    public void putPedido(int idLanche) {
        new SandwichDetailRouter(Service.getService(), presenter).postPedido(idLanche);
    }

}