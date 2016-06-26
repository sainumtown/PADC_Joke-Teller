package xz.sainumtown.joke.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import xz.sainumtown.joke.R;
import xz.sainumtown.joke.fragments.JokeFragment;
import xz.sainumtown.joke.utils.JokeTellerConstants;


public class MainActivity extends AppCompatActivity {
    private Integer jokeIndex = -1;
    private FrameLayout flContainer;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        flContainer = (FrameLayout) findViewById(R.id.fl_container);
        //  check savedInstanceState for creating fragment
        // if savedInstanceState have data , not created fragment
        if (savedInstanceState == null) {
            jokeIndex++;
            JokeFragment fragment = JokeFragment.newInstance(jokeIndex);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }

        // Next Button
        Button btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jokeIndex++;
                if (jokeIndex < JokeTellerConstants.TOTAL_JOKES) {
                    JokeFragment fragment = JokeFragment.newInstance(jokeIndex);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();
                } else {
                    jokeIndex = JokeTellerConstants.TOTAL_JOKES - 1;
                    Toast.makeText(getApplicationContext(), "There is no joke", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Previous Button
        Button btnPrevious = (Button) findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jokeIndex--;
                if (jokeIndex >= 0) {
                    JokeFragment fragment = JokeFragment.newInstance(jokeIndex);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fl_container, fragment)
                            .commit();
                } else {
                    jokeIndex = 0;
                    Toast.makeText(getApplicationContext(), "There is no joke", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
