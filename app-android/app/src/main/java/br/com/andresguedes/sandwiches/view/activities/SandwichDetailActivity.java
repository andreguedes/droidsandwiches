package br.com.andresguedes.sandwiches.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.andresguedes.sandwiches.R;
import br.com.andresguedes.sandwiches.contract.SandwichDetailMVP;
import br.com.andresguedes.sandwiches.helper.ImageHelper;
import br.com.andresguedes.sandwiches.pojo.Ingredient;
import br.com.andresguedes.sandwiches.pojo.Sandwich;
import br.com.andresguedes.sandwiches.presenter.SandwichDetailPresenter;
import br.com.andresguedes.sandwiches.view.adapters.IngredientsAdapter;

public class SandwichDetailActivity extends AppCompatActivity implements SandwichDetailMVP.SandwichesDetailViewImpl {

    public final static String SANDWICH = "sandwich";

    private List<Ingredient> ingredients = new ArrayList<>();

    private IngredientsAdapter adapter;
    private SandwichDetailPresenter presenter;

    private Sandwich sandwich;

    private ImageView imgFoto;
    private TextView txtPreco;
    private Button btnAdicionarAoCarrinho;
    private RecyclerView rvIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich_detail);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sandwich = (Sandwich) getIntent().getSerializableExtra(SANDWICH);

        setTitle(sandwich.getName());

        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        txtPreco = (TextView) findViewById(R.id.txtPreco);
        btnAdicionarAoCarrinho = (Button) findViewById(R.id.btnAdicionarAoCarrinho);

        rvIngredients = (RecyclerView) findViewById(R.id.rvIngredients);
        rvIngredients.setHasFixedSize(true);
        rvIngredients.setLayoutManager(new LinearLayoutManager(this));

        adapter = new IngredientsAdapter(this, ingredients);
        rvIngredients.setAdapter(adapter);

        btnAdicionarAoCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.adicionarLancheAoCarrinho(sandwich);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (sandwich != null) {
            presenter = new SandwichDetailPresenter(this);
            presenter.preencherDetalhes(sandwich);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sandwich_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                break;
            case R.id.action_modificar:
                // TODO Abrir dialog pra modificacao
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void exibirImagem(String imagem) {
        ImageHelper.loadImages(this, imagem, imgFoto);
    }

    @Override
    public void exibirPreco(String preco) {
        txtPreco.setText(preco);
    }

    @Override
    public void exibirIngredientes(List<Ingredient> ingredientes) {
        adapter.updateItems(ingredientes);
    }

}