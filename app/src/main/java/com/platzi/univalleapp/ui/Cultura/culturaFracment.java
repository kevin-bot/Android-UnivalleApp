package com.platzi.univalleapp.ui.Cultura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.platzi.univalleapp.R;

import static androidx.navigation.Navigation.findNavController;

public class culturaFracment extends Fragment {

    private ShareViewModel shareViewModel;
    private Button btnmusica,btnteatro,btndanza,btncanto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View view = inflater.inflate(R.layout.fragment_cultura, container, false);
       /* final TextView textView = root.findViewById(R.id.text_share);
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        btnmusica=view.findViewById(R.id.btnmusica);
        btnteatro=view.findViewById(R.id.btnteatro);
        btndanza=view.findViewById(R.id.btndanza);
        btncanto=view.findViewById(R.id.btncanto);

        btnmusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_nav_arte_to_fracmentmusica);
            }
        });

       btnteatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_nav_arte_to_fracmentteatro);
            }
        });

         btndanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_nav_arte_to_fracmentodanza);
            }
        });

        btncanto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_nav_arte_to_fracmentoartesplasticas);
            }
        });

        return view;
    }
}