package com.lego.study_jams_task2.Fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lego.study_jams_task2.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * @author Lego on 04.04.2016.
 */
public class Countries extends Fragment {

    private CallBack callBack;

    private Button menu;
    private Button confirm;
    private ImageView imageView;
    private EditText editText;

    private String[] countriesMass = {"france","ukraine","usa"};
    private int currentIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.res_layout, container, false);

        callBack = (CallBack) getActivity();
        currentIndex = 0;
        imageView = (ImageView) rootView.findViewById(R.id.imageView);
        menu = (Button) rootView.findViewById(R.id.back_btn);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeybord();
                callBack.Execute(v);
            }
        });

        editText = (EditText) rootView.findViewById(R.id.editText);
        editText.setTextColor(getResources().getColor(R.color.colorAccent));

        confirm = (Button) rootView.findViewById(R.id.Confirm_btn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().toLowerCase().equals(countriesMass[currentIndex])) {
                    currentIndex++;
                    if (currentIndex == countriesMass.length) {
                        menu.callOnClick();
                        hideKeybord();
                        Toast.makeText(getContext(), R.string.finish_massage, Toast.LENGTH_LONG).show();
                    } else {
                        loadImageFromAsset(countriesMass[currentIndex]);
                        editText.setText("");
                        hideKeybord();
                        Toast.makeText(getContext(), R.string.correct_message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), R.string.wrong_message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        randSort();
        loadImageFromAsset(countriesMass[currentIndex]);

        return rootView;
    }

    /**
     * load image from assets
     * @param str
     */
    public void loadImageFromAsset(String str) {
        try {
            InputStream ims = getActivity().getAssets().open("Countries/"+str+ ".jpg");
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }

    /**
     * sort initial array of values
     */
    private void randSort() {
        Random rnd = new Random();
        String temp;
        for (int i = 0, randIndex; i < countriesMass.length; i++) {
            temp = countriesMass[i];
            countriesMass[i] = countriesMass[randIndex = rnd.nextInt(countriesMass.length)];
            countriesMass[randIndex] = temp;
        }
    }

    /**
     * hide keyboard
     */
    private void hideKeybord(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(menu.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
