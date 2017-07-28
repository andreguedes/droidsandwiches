package br.com.andresguedes.sandwiches;

import android.app.Application;

import java.io.File;

import br.com.andresguedes.sandwiches.helper.InternetHelper;

/**
 * Created by Andre on 27/07/17.
 */

public class SandwichesApplication extends Application {

    private static SandwichesApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static boolean isNetworkAvailable() {
        return InternetHelper.isNetworkAvailable(instance.getApplicationContext());
    }

    public static File getFileCacheDir() {
        return instance.getCacheDir();
    }

}