package br.com.andresguedes.sandwiches;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import br.com.andresguedes.sandwiches.contract.SandwichesMVP;
import br.com.andresguedes.sandwiches.network.routers.LanchesRouter;
import br.com.andresguedes.sandwiches.pojo.Sandwich;
import br.com.andresguedes.sandwiches.presenter.SandwichesPresenter;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Andre on 26/07/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class SandwichesPresenterTest {

    @Mock
    private SandwichesMVP.SandwichesViewImpl view;
    @Mock
    private SandwichesMVP.SandwichesModelImpl model;
    @Mock
    private LanchesRouter lanchesRouter;

    private SandwichesPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new SandwichesPresenter(view);
    }

    @Test
    public void testExibirTresLanchesQuandoCarregarLanches() {
        final List<Sandwich> sandwichList = new ArrayList<>();
        sandwichList.add(new Sandwich("X-Bacon", 5.5, null));
        sandwichList.add(new Sandwich("X-Burguer", 5.5, null));
        sandwichList.add(new Sandwich("X-Egg", 5.3, null));

        view.atualizarLanches(sandwichList);

        presenter.carregarLanches();

        assertEquals(3, sandwichList.size());
    }

}