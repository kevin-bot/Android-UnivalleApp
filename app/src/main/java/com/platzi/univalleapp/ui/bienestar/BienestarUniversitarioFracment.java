package com.platzi.univalleapp.ui.bienestar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.platzi.univalleapp.R;

import static androidx.navigation.Navigation.findNavController;

public class BienestarUniversitarioFracment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private Button btnArte_cultu,btnDeprote_disca,btnExitoEstudiantil,btndiversidadygenero;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_bienestaruniversitario, container, false);
        //btn=root.findViewById(R.id.btnabrirOtro);

        btnArte_cultu=view.findViewById(R.id.buttonArte);
        btnDeprote_disca=view.findViewById(R.id.buttonDeporte);
        btnExitoEstudiantil=view.findViewById(R.id.buttonExitoacademiuco);
        btndiversidadygenero=view.findViewById(R.id.btndiversidadygenero);
       /* final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

//findNavController(v).navigate(R.id.action_nav_bienestar_to_shareFragment);
        btnArte_cultu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_nav_bienestar_to_shareFragment);

            }
        });
        btnDeprote_disca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_nav_bienestar_to_sendFragment);
            }
        });
        btnExitoEstudiantil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_nav_bienestar_to_exitoAcademicoFragment);
            }
        });

        btndiversidadygenero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_nav_bienestar_to_diversidadYgenero);
            }
        });

        return view;
    }


}