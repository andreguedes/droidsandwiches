package br.com.andresguedes.sandwiches.presenter;

import br.com.andresguedes.sandwiches.contract.SandwichDetailMVP;
import br.com.andresguedes.sandwiches.helper.TextHelper;
import br.com.andresguedes.sandwiches.pojo.Sandwich;

/**
 * Created by Andre on 27/07/17.
 */

public class SandwichDetailPresenter implements SandwichDetailMVP.SandwichesDetailPresenterImpl {

    private SandwichDetailMVP.SandwichesDetailViewImpl view;

    public SandwichDetailPresenter(SandwichDetailMVP.SandwichesDetailViewImpl view) {
        this.view = view;
    }

    @Override
    public void preencherDetalhes(Sandwich sandwich) {
        view.exibirImagem(sandwich.getImage());
        view.exibirPreco(TextHelper.formatPrice(sandwich.getPrice()));
        view.exibirIngredientes(sandwich.getIngredientsList());
    }

    @Override
    public void adicionarLancheAoCarrinho(Sandwich sandwich) {

    }

}