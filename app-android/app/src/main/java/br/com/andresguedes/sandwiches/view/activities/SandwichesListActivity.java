package br.com.andresguedes.sandwiches.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.andresguedes.sandwiches.R;
import br.com.andresguedes.sandwiches.presenter.SandwichesPresenter;

public class SandwichesListActivity extends AppCompatActivity {

    private SandwichesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwiches_list);

        presenter = new SandwichesPresenter();
    }

}