package br.com.andresguedes.sandwiches.contract;

import java.util.List;

import br.com.andresguedes.sandwiches.pojo.Sandwich;

/**
 * Created by Andre on 26/07/17.
 */

public interface SandwichesMVP {

    interface SandwichesModelImpl {
        void getLanches();
    }

    interface SandwichesViewImpl {
        void exibirProgressBar(int visibility);
        void atualizarLanches(List<Sandwich> items);
    }

    interface SandwichesPresenterImpl {
        void carregarLanches();
        void atualizarLanches(List<Sandwich> items);
    }

}