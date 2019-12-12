package com.platzi.univalleapp.ui.deporte;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.platzi.univalleapp.R;
import com.platzi.univalleapp.ui.Cultura.ShareViewModel;

import static androidx.navigation.Navigation.findNavController;

public class DeporteFragment extends Fragment {

    private ShareViewModel shareViewModel;
    private Button btnbaloncesto,btntenisdemesa,btnfutbol,btnfutbolsala, btnvolibol, btngimnasio, btnparque, btnnatacion, btnajedrez,btnatletismo;

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View view = inflater.inflate(R.layout.fragment_send, container, false);

        /*final TextView textView = root.findViewById(R.id.text_send);
        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        btnbaloncesto=view.findViewById(R.id.btnbaloncesto);
        btntenisdemesa=view.findViewById(R.id.btntenisdemesa);
        btnfutbol=view.findViewById(R.id.btnFutbol);
        btnfutbolsala=view.findViewById(R.id.btnFutbolsala);
        btnvolibol=view.findViewById(R.id.btnvoleibol);
        btngimnasio=view.findViewById(R.id.btngimnasio);
        btnparque=view.findViewById(R.id.btnparquerecreacional);
        btnnatacion=view.findViewById(R.id.btnnatacion);
        btnajedrez=view.findViewById(R.id.btnajedrez);
        btnatletismo=view.findViewById(R.id.btnatletismo);




            btnbaloncesto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_fragmentBaloncesto);
                }
            });
            btntenisdemesa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_tenisdemesaFragment);
                }
            });
            btnfutbol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_futbolFragment);
                }
            });
            btnfutbolsala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_fultbolSalaFragment);
                }
            });
            btnvolibol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_voleybolFragment);
                }
            });
            btngimnasio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_gimnasioFragment);
                }
            });
            btnparque.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_parquerecreacionalFragment);
                }
            });

            btnnatacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_natacionFragment);
                }
            });

            btnajedrez.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_ajedrezFragment);
                }
            });

            btnatletismo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findNavController(view).navigate(R.id.action_sendFragment_to_atletismoFragment);
                }
            });
            return view;
    }
}