package br.com.andresguedes.sandwiches.contract;

import java.util.List;

import br.com.andresguedes.sandwiches.pojo.Ingredient;
import br.com.andresguedes.sandwiches.pojo.Sandwich;

/**
 * Created by Andre on 27/07/17.
 */

public interface SandwichDetailMVP {

    interface SandwichesDetailViewImpl {
        void exibirImagem(String imagem);
        void exibirPreco(String preco);
        void exibirIngredientes(List<Ingredient> ingredientes);
    }

    interface SandwichesDetailPresenterImpl {
        void preencherDetalhes(Sandwich sandwich);
        void adicionarLancheAoCarrinho(Sandwich sandwich);
    }

}