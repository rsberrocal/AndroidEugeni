package com.richard.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

    public final int[] BOTONESMENU = {R.id.linterna,R.id.musica,R.id.nivel};

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View miMenu= inflater.inflate(R.layout.fragment_menu, container, false);

        ImageButton botonMenu;

        for (int i=0;i<BOTONESMENU.length;i++){
            botonMenu = (ImageButton) miMenu.findViewById(BOTONESMENU[i]);

            final int queboton=i;

            botonMenu.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Activity estaActividad = getActivity();
                    ((ComunicaMenu)estaActividad).menu(queboton);
                }
            });
        }


        return miMenu;
    }

}
