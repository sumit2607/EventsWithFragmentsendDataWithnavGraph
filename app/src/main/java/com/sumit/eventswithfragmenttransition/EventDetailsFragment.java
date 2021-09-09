package com.sumit.eventswithfragmenttransition;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EventDetailsFragment extends Fragment {

NavController navController;
    private EditText ettittle, etdescripiton;
    private Button mbtnnext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        initview(view);
    }

    private void initview(View view) {
        ettittle = view.findViewById(R.id.ettittle);
        etdescripiton = view.findViewById(R.id.etdescripiton);
        mbtnnext = view.findViewById(R.id.btnnext);
        mbtnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String tittle = ettittle.getText().toString();
                String description = etdescripiton.getText().toString();
                bundle.putString("tittle", tittle);
                bundle.putString("description", description);
                navController.navigate(R.id.action_eventDetailsFragment_to_timeAndDateFragment, bundle);
            }
        });
    }
}