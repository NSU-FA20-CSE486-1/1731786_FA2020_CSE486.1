package com.salmaabdulhai.khadok;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Chef_reg_Frag extends Fragment {

    Button signup_chef;
    EditText bio, outlet, mobilenumber, password;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chef_registration_fragment, container,false);

        return view;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //remove the menu option
        setHasOptionsMenu(true);
        signup_chef = view.findViewById(R.id.ChefSignup_btn);
        bio = (EditText) view.findViewById(R.id.bio);
        outlet = (EditText) view.findViewById(R.id.outlet);
        mobilenumber = (EditText) view.findViewById(R.id.ChefMobile);
        password = (EditText) view.findViewById(R.id.ChefPass);





        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        preferences = getActivity().getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        String userMobile = preferences.getString("mobileUser", "");


        mobilenumber.setText(userMobile);
        signup_chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(getContext());

                boolean isInserted = dbHelper.insertChef(outlet.getText().toString(),bio.getText().toString());
                if(isInserted){
                    Toast.makeText(getContext(), "You have successfully created an account", Toast.LENGTH_SHORT).show();}


                else {
                    Toast.makeText(getContext(), "Error creating an account. Try again!", Toast.LENGTH_SHORT).show();}



                Fragment fragment = new Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new Chef_dashboard());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });





    }

    //remove the menu option
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}
