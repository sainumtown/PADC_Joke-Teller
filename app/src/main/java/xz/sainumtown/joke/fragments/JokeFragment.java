package xz.sainumtown.joke.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import xz.sainumtown.joke.R;
import xz.sainumtown.joke.data.models.JokeModel;
import xz.sainumtown.joke.data.vos.JokeVO;


public class JokeFragment extends Fragment {

    private static final String BARG_JOKE_INDEX = "BARG_JOKE_INDEX";
    private int jokeIndex;
    private JokeVO joke;

    public static JokeFragment newInstance(int jokeIndex) {
        JokeFragment fragment = new JokeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BARG_JOKE_INDEX, jokeIndex);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            jokeIndex = bundle.getInt(BARG_JOKE_INDEX);
            joke = JokeModel.getInstance().getJoke(jokeIndex);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(joke.getJokeTitle());

        ImageView ivJoke = (ImageView) view.findViewById(R.id.iv_joke);
        ivJoke.setImageResource(joke.getJokeImage());

        TextView tvBody = (TextView) view.findViewById(R.id.tv_body);
        tvBody.setText(joke.getJokeContent());

        return view;
    }


}
