package com.example.movies_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Movie> movieList = new ArrayList<>();
    private    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView;
          Adapter myAdapter;
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager LM = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(LM);
       Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure",                "2015");
        movieList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);
        movie = new Movie("Star Wars: Episode VII - The Force Awakens",
                "Action", "2015");
        movieList.add(movie);
        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);
      /*  movie = new Movie("The Martian", "Science Fiction & Fantasy",
                "2015");
        movieList.add(movie);
        movie = new Movie("Mission: Impossible Rogue Nation", "Action",
                "2015");
        movieList.add(movie);
        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);
        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);
        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);
        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);
        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);
        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);
        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);
        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure",
                "1981");
        movieList.add(movie);
        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);
        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);*/
        //Déclaration de la liste
     //   List<Movie> movieList = new ArrayList<>();
//Ajout des données à la liste
       /* Movie movie = new Movie("Mad Max: Fury Road",R.drawable.madmax);
        movieList.add(movie);
        movie = new Movie("The Martian", R.drawable.themartian);
        movieList.add(movie);
        movie = new Movie("Shaun the Sheep",R.drawable.shaun);
        movieList.add(movie);
        movie = new Movie("Star Wars",R.drawable.starwars);
        movieList.add(movie);
        movie = new Movie("Inside Out",R.drawable.insideout);
        movieList.add(movie);*/
        myAdapter = new Adapter(movieList);
        recyclerView.setAdapter(myAdapter);
    }

}