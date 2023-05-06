package com.example.hw_2_m3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FourthFragment extends Fragment {
    TextView name, last_name, age, gender, stydy, work;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLayout();
        getBundle();
    }

    private void getLayout() {
        name = requireActivity().findViewById(R.id.get_username);
        last_name = requireActivity().findViewById(R.id.get_lastname);
        age = requireActivity().findViewById(R.id.get_age);
        gender = requireActivity().findViewById(R.id.get_gender);
        stydy = requireActivity().findViewById(R.id.get_study);
        work = requireActivity().findViewById(R.id.get_work);
    }

    @SuppressLint("SetTextI18n")
    private void getBundle() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String name = bundle.getString("name");
            String last_name = bundle.getString("last_name");
            String age = bundle.getString("age");
            String gender = bundle.getString("gender");
            String study = bundle.getString("place_of_study");
            String work = bundle.getString("place_of_work");
            this.name.setText("Name: " + name);
            this.last_name.setText("Last name: " + last_name);
            this.age.setText("Age: " + age);
            this.gender.setText("Gender: " + gender);
            stydy.setText("Place of study: " + study);
            this.work.setText("Place of work: " + work);
        } else {
            Toast.makeText(getActivity(), "Error: FIN IN ALL THE FIELDS!", Toast.LENGTH_LONG).show();
        }
    }
}