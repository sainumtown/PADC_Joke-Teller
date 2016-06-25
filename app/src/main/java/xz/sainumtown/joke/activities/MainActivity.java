package xz.sainumtown.joke.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import xz.sainumtown.joke.R;
import xz.sainumtown.joke.fragments.FirstFragment;
import xz.sainumtown.joke.fragments.SecondFragment;
import xz.sainumtown.joke.fragments.ThirdFragment;


public class MainActivity extends AppCompatActivity {
    private Integer pageNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //  check savedInstanceState for creating fragment
        // if savedInstanceState have data , not created fragment
        if (savedInstanceState == null) {
            FirstFragment fragment = new FirstFragment();
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
                switch (pageNumber) {
                    case 1:
                        SecondFragment secondFragment = new SecondFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fl_container, secondFragment)
                                .commit();
                        pageNumber++;
                        break;
                    case 2:
                        ThirdFragment thirdFragment = new ThirdFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fl_container, thirdFragment)
                                .commit();
                        pageNumber++;
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "No Post to show", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Previous Button
        Button btnPrevious = (Button) findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (pageNumber) {
                    case 3:
                        SecondFragment secondFragment = new SecondFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fl_container, secondFragment)
                                .commit();
                        pageNumber--;
                        break;
                    case 2:
                        FirstFragment firstFragment = new FirstFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fl_container, firstFragment)
                                .commit();
                        pageNumber--;
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "No Post to show", Toast.LENGTH_SHORT).show();
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
