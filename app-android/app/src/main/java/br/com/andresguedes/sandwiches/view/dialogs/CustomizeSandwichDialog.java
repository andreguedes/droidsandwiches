package br.com.andresguedes.sandwiches.view.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import br.com.andresguedes.sandwiches.R;
import br.com.andresguedes.sandwiches.pojo.Sandwich;
import br.com.andresguedes.sandwiches.view.activities.SandwichDetailActivity;
import br.com.andresguedes.sandwiches.view.adapters.CustomizeIngredientsAdapter;

/**
 * Created by Andre on 02/08/17.
 */

public class CustomizeSandwichDialog extends DialogFragment {

    public static final String CUSTOM_SANDWICH = "customSandwich";

    private Sandwich sandwich;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        sandwich = (Sandwich) args.getSerializable(CUSTOM_SANDWICH);

        View view = inflater.inflate(R.layout.customize_sandwich_dialog, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(sandwich.getName());

        RecyclerView rvIngredients = (RecyclerView) view.findViewById(R.id.rvSandwiches);
        rvIngredients.setHasFixedSize(true);
        rvIngredients.setLayoutManager(new LinearLayoutManager(getContext()));

        CustomizeIngredientsAdapter adapter = new CustomizeIngredientsAdapter(getActivity(), sandwich.getIngredientsList());
        rvIngredients.setAdapter(adapter);

        Button btnOk = (Button) view.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sandwich.isCustom()) {
                    sandwich.setCustom(true);
                    sandwich.setName(sandwich.getName().concat(getString(R.string.custom)));
                }
                ((SandwichDetailActivity) getActivity()).onReturnCustomSandwich(sandwich);

                getDialog().dismiss();
            }
        });

        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

}