package com.letrongmanh.letrongmanh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Coin> listdata = new ArrayList<>();
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref = FirebaseDatabase.getInstance().getReference("Coin");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listdata.clear();
                for(DataSnapshot coin : dataSnapshot.getChildren())
                {
                    Coin temp = coin.getValue(Coin.class);
                    listdata.add(temp);
                }
                ListView list = (ListView) findViewById(R.id.List);
                list.setAdapter(new CustomListviewAdapter(MainActivity.this,listdata));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void add (View v)
    {
        EditText name = (EditText) findViewById(R.id.editText2);
        EditText price = (EditText) findViewById(R.id.editText4);
        String _name = name.getText().toString();
        String _price = price.getText().toString();

        Coin coin = new Coin();
        coin.setName(_name);
        coin.setPrice(_price);
        String id = ref.push().getKey();
        coin.setId(id);
        ref.child(id).setValue(coin);
        listdata.add(coin);
        name.setText(null);
        price.setText(null);
    }
    public void delete (View v)
    {
        Integer index = (Integer)v.getTag();
//        ArrayList<Coin> data = listdata;
        Coin c = listdata.get(index);
        ref.child(c.getId()).removeValue();
        listdata.remove(c);
    }
}
