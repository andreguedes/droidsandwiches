package br.com.andresguedes.sandwiches.helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import br.com.andresguedes.sandwiches.pojo.Ingredient;

/**
 * Created by Andre on 27/07/17.
 */

public class TextHelper {

    public static String formatPrice(double price) {
        DecimalFormat format = (DecimalFormat) NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        Currency currency;
        try {
            currency = Currency.getInstance("BRL");
            if (currency != null) {
                format.setCurrency(currency);
            }
        } catch (Exception ignored) {

        }
        return format.format(price);
    }

    public static String formatIngredients(List<Ingredient> ingredients) {
        String ingredientes = "";
        for (Ingredient ingredient : ingredients) {
            ingredientes += ingredient.getName().concat(", ");
        }
        return ingredientes;
    }
}