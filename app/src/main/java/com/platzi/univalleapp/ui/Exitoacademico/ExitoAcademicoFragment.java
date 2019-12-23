package com.platzi.univalleapp.ui.Exitoacademico;

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

public class ExitoAcademicoFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    Button btnmonitoria, btnjovenesenaccion, btncasadeestudiantes, btnBonoestudiantes, btnapollores, btncafeteria, btngeneracionE, btnrevisionddhh;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View view = inflater.inflate(R.layout.fragment_exitoacademico, container, false);

        /*final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        btnmonitoria=view.findViewById(R.id.btnmonitoria);
        btnmonitoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_exitoAcademicoFragment_to_monitoriaFragment);
            }
        });
        btnjovenesenaccion=view.findViewById(R.id.btnjovenesenaccion);
        btnjovenesenaccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_exitoAcademicoFragment_to_jovenesaccionFragment);
            }
        });
        btncasadeestudiantes=view.findViewById(R.id.btncasadeestudiantes);
        btncasadeestudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_exitoAcademicoFragment_to_casaestudiantilFragment);
            }
        });
        btnBonoestudiantes=view.findViewById(R.id.btnbonoestudiantil);
        btnBonoestudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_exitoAcademicoFragment_to_bonoFragment);
            }
        });
        btnapollores=view.findViewById(R.id.btnapollo050);
        btnapollores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_exitoAcademicoFragment_to_apollo050Fragment);
            }
        });
        btncafeteria=view.findViewById(R.id.btncafeteria);
        btncafeteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_exitoAcademicoFragment_to_cafeteriaFragment);
            }
        });

        btngeneracionE=view.findViewById(R.id.btnGenereacioneEquidad);
        btngeneracionE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_exitoAcademicoFragment_to_generacionEFragment);
            }
        });
        btnrevisionddhh=view.findViewById(R.id.btnderechosHumanos);
        btnrevisionddhh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findNavController(view).navigate(R.id.action_exitoAcademicoFragment_to_revicionDDHHFragment);            }
        });


        return view;
    }



}