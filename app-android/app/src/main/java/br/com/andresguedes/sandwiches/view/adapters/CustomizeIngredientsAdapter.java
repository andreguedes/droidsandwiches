package br.com.andresguedes.sandwiches.view.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.andresguedes.sandwiches.R;
import br.com.andresguedes.sandwiches.helper.ImageHelper;
import br.com.andresguedes.sandwiches.pojo.Ingredient;

/**
 * Created by Andre on 02/08/17.
 */

public class CustomizeIngredientsAdapter extends RecyclerView.Adapter<CustomizeIngredientsAdapter.IngredientsViewHolder> {

    private Activity activity;
    private List<Ingredient> ingredients;

    public CustomizeIngredientsAdapter(Activity activity, List<Ingredient> ingredients) {
        this.activity = activity;
        this.ingredients = ingredients;
    }

    @Override
    public IngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customize_ingredient_item_list, parent, false);
        return new IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final IngredientsViewHolder holder, int position) {
        final Ingredient ingredient = ingredients.get(position);
        if (ingredient != null) {
            holder.txtNomeIngrediente.setText(ingredient.getName());
            ImageHelper.loadImages(activity, ingredient.getImage(), holder.imgFotoIngrediente);
            holder.edtQuantidade.setText(String.valueOf(ingredient.getQuantity()));
            holder.btnMenos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ingredient.getQuantity() > 1)
                        ingredient.setQuantity(ingredient.getQuantity() - 1);
                    holder.edtQuantidade.setText(String.valueOf(ingredient.getQuantity()));
                }
            });
            holder.btnMais.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ingredient.setQuantity(ingredient.getQuantity() + 1);
                    holder.edtQuantidade.setText(String.valueOf(ingredient.getQuantity()));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.ingredients != null ? ingredients.size() : 0;
    }

    class IngredientsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoIngrediente;
        private TextView txtNomeIngrediente;
        private Button btnMenos, btnMais;
        private EditText edtQuantidade;

        IngredientsViewHolder(View itemView) {
            super(itemView);

            imgFotoIngrediente = (ImageView) itemView.findViewById(R.id.imgFotoIngrediente);
            txtNomeIngrediente = (TextView) itemView.findViewById(R.id.txtNomeIngrediente);
            btnMenos = (Button) itemView.findViewById(R.id.btnMenos);
            btnMais = (Button) itemView.findViewById(R.id.btnMais);
            edtQuantidade = (EditText) itemView.findViewById(R.id.edtQuantidade);
        }

    }

}