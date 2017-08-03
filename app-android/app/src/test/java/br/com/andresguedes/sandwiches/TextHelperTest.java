package br.com.andresguedes.sandwiches;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import br.com.andresguedes.sandwiches.helper.TextHelper;
import br.com.andresguedes.sandwiches.pojo.Ingredient;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Andre on 27/07/17.
 */
public class TextHelperTest {

    @Test
    public void testInserirDoubleERetornarValorEmMoeda() {
        String valor = TextHelper.formatPrice(1.9);

        assertEquals("R$ 1,90", valor);
    }

    @Test
    public void testValidaIngreditentesFormatados() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(0, "Carne", 1, null, 1));
        ingredients.add(new Ingredient(0, "Pao", 1, null, 1));

        String ingredientesFormatados = TextHelper.formatIngredients(ingredients);

        assertEquals("Carne, Pao", ingredientesFormatados);
    }

}