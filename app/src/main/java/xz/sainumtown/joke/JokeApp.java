package xz.sainumtown.joke;

import android.app.Application;
import android.content.Context;

/**
 * Created by asus on 6/24/2016.
 */
public class JokeApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
