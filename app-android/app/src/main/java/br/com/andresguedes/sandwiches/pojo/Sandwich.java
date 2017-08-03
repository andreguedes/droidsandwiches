package br.com.andresguedes.sandwiches.pojo;

import java.io.Serializable;
import java.util.List;

import br.com.andresguedes.sandwiches.helper.TextHelper;

/**
 * Created by Andre on 26/07/17.
 */

public class Sandwich implements Serializable {

    private int id;
    private String name;
    private double price;
    private List<Ingredient> ingredients;
    private String image;
    private boolean custom;

    public Sandwich(String name, double price, List<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        double preco = 0;
        for (Ingredient ingredient : ingredients)
            preco += ingredient.getPrice();
        return preco;
    }

    public String getIngredients() {
        return TextHelper.formatIngredients(ingredients);
    }

    public List<Ingredient> getIngredientsList() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

}