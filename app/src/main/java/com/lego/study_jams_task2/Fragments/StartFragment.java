package com.lego.study_jams_task2.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lego.study_jams_task2.R;

/**
 * @author Lego on 04.04.2016.
 */
public class StartFragment extends Fragment {

    private CallBack callBack;

    private Button About;
    private Button Transports;
    private Button Countries;
    private Button Fruits;
    private Button Animals;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.start_menu, container, false);
        callBack = (CallBack) getActivity();

        About = (Button) rootView.findViewById(R.id.about_btn);
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Execute(v);
            }
        });

        Transports = (Button) rootView.findViewById(R.id.Transport_btn);
        Transports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Execute(v);
            }
        });

        Countries = (Button) rootView.findViewById(R.id.Countries_btn);
        Countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Execute(v);
            }
        });

        Fruits = (Button) rootView.findViewById(R.id.Fruits_btn);
        Fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Execute(v);
            }
        });

        Animals = (Button) rootView.findViewById(R.id.Animals_btn);
        Animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.Execute(v);
            }
        });

        return rootView;
    }
}
