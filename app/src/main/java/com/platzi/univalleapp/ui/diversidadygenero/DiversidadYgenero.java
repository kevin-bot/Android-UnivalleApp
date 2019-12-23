package com.platzi.univalleapp.ui.diversidadygenero;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.platzi.univalleapp.R;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiversidadYgenero extends Fragment {



    Button btncomunidadesetnicas, btngenero;

    public DiversidadYgenero() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_diversidad_ygenero, container, false);

            btncomunidadesetnicas=view.findViewById(R.id.btncomunidadetnicas);
            btngenero=view.findViewById(R.id.btngenero);

            btngenero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_diversidadYgenero_to_generoFragment);
                }
            });

            btncomunidadesetnicas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    findNavController(view).navigate(R.id.action_diversidadYgenero_to_comunidadesetnicas);
                }
            });

        return view;
    }

}
