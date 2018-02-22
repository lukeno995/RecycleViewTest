package com.example.luca.recycleviewtest;

import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter mAdapter;
    private TextView textSpin;
    private TextView textNome;
    private TextView textCognome;
    private TextView textEta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textNome = (TextView) findViewById(R.id.nome);
        textCognome = (TextView) findViewById(R.id.cognome);
        textEta = (TextView) findViewById(R.id.eta);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new UserAdapter(usersList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        textSpin = (TextView) findViewById(R.id.textSpin);



        userData();
    }

    private void userData() {
        User user = new User("Antonio","Alberini","22");
        usersList.add(user);
        user = new User("Tizio","Blu","16");
        usersList.add(user);
        user = new User("Caio","Rossi","15");
        usersList.add(user);
        user = new User("Sempronio","Neri","10");
        usersList.add(user);
        user = new User("Pippo","Giallo","9");
        usersList.add(user);
        user = new User("Luca","Moggio","24");
        usersList.add(user);

        mAdapter.notifyDataSetChanged();
    }


    public void onFilter(View view) {
        view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet_dialog, null);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();
    }

    public void receiveData(){
        Intent i = getIntent();
        String nome = i.getStringExtra("NAME_KEY");
        String cognome = i.getStringExtra("SURNAME_KEY");
        int eta = i.getIntExtra("AGE_KEY",0);

        textNome.setText(nome);
        textCognome.setText(cognome);
        textEta.setText(String.valueOf(eta));



    }

    public void Filter(View view) {
        ArrayList<User> users = new ArrayList<>();
        if(view.getId()==R.id.under18){
            view = getLayoutInflater().inflate(R.layout.user_list_row, null);
            for(int i = 0; i<usersList.size();i++){
                int e = Integer.parseInt(usersList.get(i).getEta().toString());
                if(e<18){
                    User us = new User(usersList.get(i).getNome() ,  usersList.get(i).getCognome() , usersList.get(i).getEta());
                    users.add(us);
                }
            }
        }
        UserAdapter mAdapter = new UserAdapter(users);
        recyclerView.setAdapter(mAdapter);
        Toast.makeText(getApplicationContext(),"Spinner cliccato",Toast.LENGTH_LONG).show();
    }
}
