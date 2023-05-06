package com.example.hw_2_m3;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SecondFragment extends Fragment implements View.OnClickListener{
    EditText editText;
    EditText editTextTwo;
    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        editText = requireActivity().findViewById(R.id.enter_age);
        editTextTwo = requireActivity().findViewById(R.id.enter_gender);
        submit = requireActivity().findViewById(R.id.submitTwo);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String age = editText.getText().toString(), gender = editTextTwo.getText().toString();
        Bundle bundle = getArguments();
        bundle.putString("age", age);
        bundle.putString("gender", gender);
        ThirdFragment thirdFragment = new ThirdFragment();
        thirdFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, thirdFragment).commit();
    }
}