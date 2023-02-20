package com.example.shoppingchecklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recView;
    private ArrayList<Product> products = new ArrayList<>();
    Button camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();
        recView = findViewById(R.id.recycler_view);
        ProductAdapter studentAdapter = new ProductAdapter(this, products);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(studentAdapter);
        camera = (Button)findViewById(R.id.button);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });;

}

    private void initializeData() {
        products.add(new Product("Хлеб"));
        products.add(new Product("Яйца"));
        products.add(new Product("Молоко"));
        products.add(new Product("Печенье"));
        products.add(new Product("Сахар"));
        products.add(new Product("Соль"));
        products.add(new Product("Рулет"));
        products.add(new Product("Печень"));
        products.add(new Product("Курица"));
        products.add(new Product("Картошка"));
        products.add(new Product("Вафли"));
        products.add(new Product("Кукурузные палочки"));
        products.add(new Product("Мука"));
        products.add(new Product("Разрыхлитель"));
        products.add(new Product("Сода"));
    }
}