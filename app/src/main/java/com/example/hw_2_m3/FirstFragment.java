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

public class FirstFragment extends Fragment implements View.OnClickListener {
    EditText editText;
    EditText editTextTwo;
    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        editText = requireActivity().findViewById(R.id.enter_username);
        editTextTwo = requireActivity().findViewById(R.id.last_name);
        submit = requireActivity().findViewById(R.id.sumbitOne);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = editText.getText().toString(),surname = editTextTwo.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("last_name", surname);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, secondFragment).commit();
    }
}