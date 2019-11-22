package com.isteel.recipessearch;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.Api.RecipeService;
import com.isteel.recipessearch.Content.Result;
import com.isteel.recipessearch.Content.Steps.Ingredients.IngredResponse;
import com.isteel.recipessearch.Content.Steps.ResponseStep;
import com.isteel.recipessearch.Repository.DefaultRecipeRepository;
import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListActivity;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListPresenter;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    RecipeListActivity activity;
    RecipeListView mView;
    RecipeListPresenter mPresenter;
    public Throwable throwable;

    Result result;
    Disposable disposable;

    public ExampleUnitTest() {
    }

    @Before
    public void setUp() throws Exception {
       // initMocks(this);
        disposable = Disposables.empty();
        RepositoryProvider.setRecipeRepository(new TestRepo());

        mView = Mockito.mock(RecipeListView.class);
        activity = Mockito.mock(RecipeListActivity.class);

        mPresenter = new RecipeListPresenter(mView, activity);
        result = Mockito.mock(Result.class);
    }

    @Test
    public void testCreated() throws Exception {
        assertNotNull(mPresenter);
    }

    @Test
    public void testError() throws Exception{
        mPresenter.init();

        Mockito.verify(mView,Mockito.times(1)).error();
    }

    @Test
    public void testSuccess() {
      //  RepositoryProvider.setRecipeRepository(new DefaultRecipeRepository());
        mPresenter.init();
        Mockito.verify(mView).error();
    }

    private class TestR extends DefaultRecipeRepository{
        @NonNull
        @Override
        public Observable<Result> recipe() {
            return Observable.empty();
        }
    }
}


