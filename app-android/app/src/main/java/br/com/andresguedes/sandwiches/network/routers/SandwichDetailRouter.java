package br.com.andresguedes.sandwiches.network.routers;

import br.com.andresguedes.sandwiches.contract.SandwichDetailMVP;
import br.com.andresguedes.sandwiches.network.api.API;
import br.com.andresguedes.sandwiches.pojo.Sandwich;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andre on 15/08/17.
 */

public class SandwichDetailRouter {

    private API api;
    private SandwichDetailMVP.SandwichesDetailPresenterImpl presenter;

    public SandwichDetailRouter(API api, SandwichDetailMVP.SandwichesDetailPresenterImpl presenter) {
        this.api = api;
        this.presenter = presenter;
    }

    public void postPedido(int idLanche) {
        if (api != null) {
            api.putPedido(idLanche).enqueue(new Callback<Sandwich>() {
                @Override
                public void onResponse(Call<Sandwich> call, Response<Sandwich> response) {
                    if (presenter != null && response.isSuccessful())
                        presenter.exibirMensagemPedido("Pedido adicionado no carrinho");
                }

                @Override
                public void onFailure(Call<Sandwich> call, Throwable t) {
                    if (presenter != null)
                        presenter.exibirMensagemPedido("Erro ao adicionar pedido no carrinho");
                }
            });
        }
    }

}