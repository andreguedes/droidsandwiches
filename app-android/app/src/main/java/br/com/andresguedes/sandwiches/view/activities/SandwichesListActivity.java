package br.com.andresguedes.sandwiches.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.andresguedes.sandwiches.R;
import br.com.andresguedes.sandwiches.contract.SandwichesMVP;
import br.com.andresguedes.sandwiches.pojo.Sandwich;
import br.com.andresguedes.sandwiches.presenter.SandwichesPresenter;
import br.com.andresguedes.sandwiches.view.adapters.SandwichesAdapter;

public class SandwichesListActivity extends AppCompatActivity implements SandwichesMVP.SandwichesViewImpl {

    private RecyclerView rvLanches;
    private List<Sandwich> sandwiches = new ArrayList<>();

    private SandwichesAdapter adapter;
    private SandwichesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwiches_list);

        rvLanches = (RecyclerView) findViewById(R.id.rvSandwiches);
        rvLanches.setHasFixedSize(true);
        rvLanches.setLayoutManager(new LinearLayoutManager(this));

        adapter = new SandwichesAdapter(this, sandwiches);
        rvLanches.setAdapter(adapter);

        if (presenter == null)
            presenter = new SandwichesPresenter(this);

        presenter.carregarLanches();
    }

    @Override
    public void exibirProgressBar(int visibility) {
        findViewById(R.id.includeProgressBar).setVisibility(visibility);
    }

    @Override
    public void atualizarLanches(List<Sandwich> items) {
        adapter.updateItems(items);
    }

}