package com.platzi.univalleapp.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.platzi.univalleapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class HomeFragment extends Fragment {

    private ProgressBar progreso;
    private HomeViewModel homeViewModel;
    private TextView idtxtParrafoInfoUnvalle;

    private ViewFlipper vfContenedorIMG;

    private ImageView imageViewPubli, imageView2Publi, imageView3Publi;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        idtxtParrafoInfoUnvalle=view.findViewById(R.id.idtxtParrafoInfoUnvalle);

       /* final TextView textView = root.findViewById();
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        // METODO QUE SE ENCARGA DEL FUNCIONAMIENTO DEL VIEW FLIPPER  DE LA PANTALLA PRINCIPAL

        ejecutarwebservice("http://univalle.tuinvestigacion.com/app/jsn/consultarimgprincipal.php");
        vfContenedorIMG = view.findViewById(R.id.idviewFlipper);

        imageViewPubli = view.findViewById(R.id.img_frac_princi_rotativas);
        imageView2Publi = view.findViewById(R.id.img_frac_princi_rotativas2);
        imageView3Publi = view.findViewById(R.id.img_frac_princi_rotativas3);

        int vfImagenes[]= {R.mipmap.univallecaicedonia};

        for (int i=0;i<vfImagenes.length;i++){
            Llenar_ViewFlipper(vfImagenes[i]);
        }

        return view;
    }


    // METODO QUE SE ENCARGA DEL FUNCIONAMIENTO DEL VIEW FLIPPER  DE LA PANTALLA PRINCIPAL
    public void Llenar_ViewFlipper(int imagen){

        ImageView imageView= new ImageView(getContext());
        imageView.setBackgroundResource(imagen);

        vfContenedorIMG.addView(imageView);
        vfContenedorIMG.setFlipInterval(6000);
        vfContenedorIMG.setAutoStart(true);
        //vfContenedorIMG.isFlipping();

        vfContenedorIMG.setInAnimation(getContext(),android.R.anim.slide_in_left);
        vfContenedorIMG.setOutAnimation(getContext(),android.R.anim.slide_out_right);



    }

    public void ejecutarwebservice(String URL){
           // progreso.setVisibility(View.VISIBLE);
            JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    JSONObject jsonObject=null;
                    ImageView [] vectorimagenes={imageViewPubli,imageView2Publi,imageView3Publi};//ARRAY DE LA CANTIDAD DE INMAGENES QUE PUEDEN PASAR EL LA PANTALLA PRINCIPAL
                    for (int i=0;i<response.length();i++){
                        try {

                            jsonObject=response.getJSONObject(i);
                            //idtxtParrafoInfoUnvalle.setText(jsonObject.optString("nombre"));
                            vectorimagenes[i].setImageBitmap(Imagenesdejson(jsonObject.optString("ima")));



                        }catch(JSONException e){
                            Toast.makeText(getContext(),"ERROR RESPONSE",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);
    }

    //METODO ENCARGADO DE DECODIFICAR UN STRING  QUE BIENE POR EL JSON  A IMAGEN
    public Bitmap Imagenesdejson(String dato){
        Bitmap imagen=null;

        try {
            byte [] bytecode= Base64.decode(dato,Base64.DEFAULT);
            imagen= BitmapFactory.decodeByteArray(bytecode,0,bytecode.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return imagen;
    }



}