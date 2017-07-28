package br.com.andresguedes.sandwiches.presenter;

import android.view.View;

import java.util.List;

import br.com.andresguedes.sandwiches.contract.SandwichesMVP;
import br.com.andresguedes.sandwiches.model.SandwichesModel;
import br.com.andresguedes.sandwiches.pojo.Sandwich;

/**
 * Created by Andre on 26/07/17.
 */

public class SandwichesPresenter implements SandwichesMVP.SandwichesPresenterImpl {

    private SandwichesMVP.SandwichesViewImpl view;
    private SandwichesMVP.SandwichesModelImpl model;

    public SandwichesPresenter(SandwichesMVP.SandwichesViewImpl view) {
        this.view = view;
        this.model = new SandwichesModel(this);
    }

    @Override
    public void carregarLanches() {
        view.exibirProgressBar(View.VISIBLE);
        model.getLanches();
    }

    @Override
    public void atualizarLanches(List<Sandwich> items) {
        view.exibirProgressBar(View.GONE);
        if (items != null)
            view.atualizarLanches(items);
    }

}