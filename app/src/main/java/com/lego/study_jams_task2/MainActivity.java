package com.lego.study_jams_task2;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.support.design.widget.Snackbar;
import android.widget.TextView;

import com.lego.study_jams_task2.Fragments.Animals;
import com.lego.study_jams_task2.Fragments.CallBack;
import com.lego.study_jams_task2.Fragments.Countries;
import com.lego.study_jams_task2.Fragments.Fruits;
import com.lego.study_jams_task2.Fragments.StartFragment;
import com.lego.study_jams_task2.Fragments.Transports;

public class MainActivity extends AppCompatActivity implements CallBack {

    private FragmentManager manager;

    private StartFragment startFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mMenuLabel = (TextView) findViewById(R.id.LabelMenu);

        startFragment = new StartFragment();

        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.Container, startFragment).commit();

        //create color text
        Spanned str = Html.fromHtml("<font color=\"red\">What</font> <font color=\"yellow\">Is </font> <font color=\"blue\">This</font><font color=\"black\">?</font>");
        mMenuLabel.setText(str);
        mMenuLabel.setShadowLayer(10, 1, 1, Color.BLACK);


    }

    /**
     * processes button click from fragments
     *
     * @param view
     */
    @Override
    public void Execute(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                manager.beginTransaction().replace(R.id.Container, startFragment).commit();
                break;
            case R.id.Transport_btn:
                Transports transports = new Transports();
                manager.beginTransaction().replace(R.id.Container, transports).commit();
                break;
            case R.id.Countries_btn:
                Countries countries = new Countries();
                manager.beginTransaction().replace(R.id.Container, countries).commit();
                break;
            case R.id.Fruits_btn:
                Fruits fruits = new Fruits();
                manager.beginTransaction().replace(R.id.Container, fruits).commit();
                break;
            case R.id.Animals_btn:
                Animals animals = new Animals();
                manager.beginTransaction().replace(R.id.Container, animals).commit();
                break;
            case R.id.about_btn:
                Snackbar.make(view, getString(R.string.about_text), Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
                break;
        }
    }
}
