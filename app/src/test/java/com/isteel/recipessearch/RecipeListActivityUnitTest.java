package com.isteel.recipessearch;

import androidx.annotation.NonNull;

import com.isteel.recipessearch.Content.RecipeResponse;
import com.isteel.recipessearch.Repository.DefaultRecipeRepository;
import com.isteel.recipessearch.Repository.RepositoryProvider;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListActivity;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListPresenter;
import com.isteel.recipessearch.Screen.RecipeListActivity.RecipeListView;
import com.isteel.recipessearch.utils.KeyValueStorage;
import com.isteel.recipessearch.utils.TypeSearchPrefence;
import com.orhanobut.hawk.Hawk;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;

import static junit.framework.Assert.assertNotNull;

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
    MyApplication myApplication;

    RecipeResponse recipeResponse;
    Disposable disposable;
    KeyValueStorage mStorage;


    public ExampleUnitTest() {
    }

    @Before
    public void setUp() throws Exception {
        myApplication = Mockito.mock(MyApplication.class);
        myApplication.onCreate();

       // initMocks(this);
        disposable = Disposables.empty();
        RepositoryProvider.setmKeyValueStorage(new KeyValueTest());
        RepositoryProvider.setRecipeRepository(new TestRepo());

        mView = Mockito.mock(RecipeListView.class);
        activity = Mockito.mock(RecipeListActivity.class);

        mPresenter = new RecipeListPresenter(mView, activity);
        recipeResponse = Mockito.mock(RecipeResponse.class);

    }

    @Test
    public void testCreated() throws Exception {
        assertNotNull(mPresenter);
    }

    @Test
    public void testError() throws Exception{
        mPresenter.init();
        //TypeSearchPrefence.setType("vegetarian");

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
        public Observable<RecipeResponse> recipe(String diet) {
            return Observable.empty();
        }
    }
}


