package br.com.andresguedes.sandwiches.view.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.andresguedes.sandwiches.R;
import br.com.andresguedes.sandwiches.helper.ImageHelper;
import br.com.andresguedes.sandwiches.pojo.Ingredient;

/**
 * Created by Andre on 28/07/17.
 */

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder> {

    private Activity activity;
    private List<Ingredient> ingredients;

    public IngredientsAdapter(Activity activity, List<Ingredient> ingredients) {
        this.activity = activity;
        this.ingredients = ingredients;
    }

    @Override
    public IngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_item_list, parent, false);
        return new IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IngredientsViewHolder holder, int position) {
        final Ingredient ingredient = ingredients.get(position);
        if (ingredient != null) {
            holder.txtNomeIngrediente.setText(ingredient.getName());
            ImageHelper.loadImages(activity, ingredient.getImage(), holder.imgFotoIngrediente);
        }
    }

    @Override
    public int getItemCount() {
        return this.ingredients != null ? ingredients.size() : 0;
    }

    public void updateItems(List<Ingredient> ingredientList) {
        this.ingredients.clear();
        this.ingredients.addAll(ingredientList);
        notifyDataSetChanged();
    }

    class IngredientsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoIngrediente;
        private TextView txtNomeIngrediente;

        IngredientsViewHolder(View itemView) {
            super(itemView);

            imgFotoIngrediente = (ImageView) itemView.findViewById(R.id.imgFotoIngrediente);
            txtNomeIngrediente = (TextView) itemView.findViewById(R.id.txtNomeIngrediente);
        }

    }

}