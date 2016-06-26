package xz.sainumtown.joke.data.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import xz.sainumtown.joke.JokeApp;
import xz.sainumtown.joke.R;
import xz.sainumtown.joke.data.vos.JokeVO;

/**
 * Created by asus on 6/25/2016.
 */
public class JokeModel {
    private static JokeModel objInstance;

    private List<JokeVO> jokeList;

    public JokeModel() {
        jokeList = setUpInitialJokes();
    }

    public static JokeModel getInstance() {
        if (objInstance == null) {
            objInstance = new JokeModel();
        }
        return objInstance;
    }

    private List<JokeVO> setUpInitialJokes() {
        Context context = JokeApp.getContext();

        List<JokeVO> jokeList = new ArrayList<>();
        jokeList.add(new JokeVO(context.getString(R.string.title_first), context.getString(R.string.body_first), R.drawable.joke_1));
        jokeList.add(new JokeVO(context.getString(R.string.title_second), context.getString(R.string.body_second), R.drawable.joke_2));
        jokeList.add(new JokeVO(context.getString(R.string.title_third), context.getString(R.string.body_third), R.drawable.joke_3));

        return jokeList;
    }

    public JokeVO getJoke(int index) {
        return jokeList.get(index);
    }
}
