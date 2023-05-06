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

public class ThirdFragment extends Fragment implements View.OnClickListener {
    EditText editText;
    EditText editTextTwo;
    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        editText = requireActivity().findViewById(R.id.enter_study);
        editTextTwo = requireActivity().findViewById(R.id.enter_work);
        submit = requireActivity().findViewById(R.id.submitThree);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = getArguments();
        String school = editText.getText().toString(), work = editTextTwo.getText().toString();
        bundle.putString("place_of_study", school);
        bundle.putString("place_of_work", work);
        FourthFragment fourthFragment = new FourthFragment();
        fourthFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, fourthFragment).commit();
    }
}