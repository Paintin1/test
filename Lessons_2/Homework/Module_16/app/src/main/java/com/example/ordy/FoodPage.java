package com.example.ordy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ordy.Helpers.FoodListAdapter;
import com.example.ordy.Models.Category;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FoodPage extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listView = findViewById(R.id.list_of_food);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table = database.getReference("Category");

        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ArrayList<String> allKeys = new ArrayList<>();
                ArrayList<Category> allFood = new ArrayList<>();
                for (DataSnapshot obj : snapshot.getChildren()) {
                    Category category = obj.getValue(Category.class);
                    allFood.add(category);
                    allKeys.add(obj.getKey());

                    FoodListAdapter arrayAdapter = new FoodListAdapter(FoodPage.this, R.layout.food_item_in_list, allFood, allKeys);
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
             public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FoodPage.this, "Нет интернет соединения", Toast.LENGTH_LONG).show();
            }
        });
    }
}