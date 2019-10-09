package com.example.nyt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // We declare variables up here so they can be referenced anywhere (e.g. inside an
    // onClickListener).
    private ConstraintLayout article1Layout;
    private ConstraintLayout article2Layout;
    private ImageView bookmarkButton1;
    private ImageView bookmarkButton2;
    private ImageView shareButton1;
    private ImageView shareButton2;
    private boolean button1State = false;
    private boolean button2State = false;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    private Article articleObject1;
    private Article articleObject2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_main);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArticleAdapter articleAdapter = new ArticleAdapter();
        articleAdapter.setData(FakeDatabase.getAllArticles());
        recyclerView.setAdapter(articleAdapter);

        // We are repeating all the code every time, for the second article.
        // This is obviously not ideal.
        // If we have 10 articles are we going to repeat the code 10 times? (No)
        // Next week we'll learn about the RecyclerView, which means we can write the code ONCE
        // and it'll create a list with as many items as we have data.
        //
        // Note that the way the code is written here, the code for the second article is EXACTLY
        // the same as the code for the first one except you just replace articleObject1 with
        // articleObject2. So really, the only thing that changes is the data we provide.
        // Thinking this way will help you next week.


}
