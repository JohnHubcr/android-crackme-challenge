package com.reoky.crackme.challengeeight.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.reoky.crackme.challengeeight.R;
import com.reoky.crackme.challengeeight.listeners.ChallengeEightFragmentOnClickListener;

import java.io.File;

public class ChallengeEightFragment extends Fragment {

    public ChallengeEightFragment() {}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final InputMethodManager immy = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        immy.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_challenge_one, container, false);

        // Handle the user checking their answer
        final Button buttonCheck = (Button) view.findViewById(R.id.challenge_one_button_check);
        buttonCheck.setOnClickListener(new ChallengeEightFragmentOnClickListener());

        // Wire button_write_file to ChallengeEightFragmentOnClickListener()
        final Button buttonWriteFile = (Button) view.findViewById(R.id.button_write_file);
        buttonWriteFile.setOnClickListener(new ChallengeEightFragmentOnClickListener());

        // Sometimes it takes someone outside the box to see why we really need a box at all
        // think about it...
        File file = view.getContext().getFileStreamPath("ANSWER");
        if (file.exists()) {
            buttonWriteFile.setText(R.string.string_challenge_delete_file);
        } else {
            buttonWriteFile.setText(R.string.string_challenge_write_file);
        }

        return view;
    }
}
