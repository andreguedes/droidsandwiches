package br.com.andresguedes.sandwiches;

import org.junit.Test;

import br.com.andresguedes.sandwiches.helper.TextHelper;

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

}