package me.mahakagg.tabexperiment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment {
    //Button b1;


    public TabFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
       // b1 = v.findViewById(R.id.button_tab1);
        return v;

    }

}
