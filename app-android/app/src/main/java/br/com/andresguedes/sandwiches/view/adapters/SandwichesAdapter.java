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
import br.com.andresguedes.sandwiches.pojo.Sandwich;

/**
 * Created by Andre on 26/07/17.
 */

public class SandwichesAdapter extends RecyclerView.Adapter<SandwichesAdapter.SandwichesViewHolder> {

    private Activity activity;
    private List<Sandwich> sandwiches;

    public SandwichesAdapter(Activity activity, List<Sandwich> sandwiches) {
        this.activity = activity;
        this.sandwiches = sandwiches;
    }

    @Override
    public SandwichesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sandwiche_item_list, parent, false);
        return new SandwichesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SandwichesViewHolder holder, int position) {
        Sandwich sandwich = sandwiches.get(position);
        if (sandwich != null) {
            holder.txtNome.setText(sandwich.getName());
            holder.txtPreco.setText(String.valueOf(sandwich.getPrice()));
            holder.txtIngredientes.setText(sandwich.getIngredients());
            ImageHelper.loadImages(activity, sandwich.getImage(), holder.imgFoto);
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return this.sandwiches != null ? sandwiches.size() : 0;
    }

    public void updateItems(List<Sandwich> sandwichList) {
        this.sandwiches.clear();
        this.sandwiches.addAll(sandwichList);
        notifyDataSetChanged();
    }

    class SandwichesViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private ImageView imgFoto;
        private TextView txtNome;
        private TextView txtPreco;
        private TextView txtIngredientes;

        SandwichesViewHolder(View itemView) {
            super(itemView);

            view = itemView;
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            txtNome = (TextView) itemView.findViewById(R.id.txtNome);
            txtPreco = (TextView) itemView.findViewById(R.id.txtPreco);
            txtIngredientes = (TextView) itemView.findViewById(R.id.txtIngredientes);
        }

    }

}