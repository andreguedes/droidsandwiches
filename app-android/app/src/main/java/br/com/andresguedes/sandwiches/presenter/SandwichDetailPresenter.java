package br.com.andresguedes.sandwiches.presenter;

import br.com.andresguedes.sandwiches.contract.SandwichDetailMVP;
import br.com.andresguedes.sandwiches.helper.TextHelper;
import br.com.andresguedes.sandwiches.model.SandwichDetailModel;
import br.com.andresguedes.sandwiches.pojo.Sandwich;

/**
 * Created by Andre on 27/07/17.
 */

public class SandwichDetailPresenter implements SandwichDetailMVP.SandwichesDetailPresenterImpl {

    private SandwichDetailMVP.SandwichesDetailViewImpl view;
    private SandwichDetailMVP.SandwichesDetailModelImpl model;

    public SandwichDetailPresenter(SandwichDetailMVP.SandwichesDetailViewImpl view) {
        this.view = view;
        this.model = new SandwichDetailModel(this);
    }

    @Override
    public void preencherDetalhes(Sandwich sandwich) {
        view.exibirImagem(sandwich.getImage());
        view.exibirPreco(TextHelper.formatPrice(sandwich.getPrice()));
        view.exibirIngredientes(sandwich.getIngredientsList());
    }

    @Override
    public void adicionarLancheAoCarrinho(Sandwich sandwich) {
        model.putPedido(sandwich.getId());
    }

    @Override
    public void exibirMensagemPedido(String mensagem) {
        view.exibirMensagemPedido(mensagem);
    }

}