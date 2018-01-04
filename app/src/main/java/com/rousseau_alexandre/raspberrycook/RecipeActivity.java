package com.rousseau_alexandre.raspberrycook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final Recipe recipe = getRecipe();
        System.out.println("Recipe loaded with id = " + recipe.id);

        // set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(recipe.getTitle());
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipe.delete(RecipeActivity.this);
                finish();
            }
        });
    }

    /**
     * Fetch recipe from intent
     * @return
     */
    private Recipe getRecipe(){
        Intent intent = getIntent();
        return (Recipe) intent.getSerializableExtra(MainActivity.EXTRA_RECIPE);
    }

}
