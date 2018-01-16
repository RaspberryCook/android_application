package com.rousseau_alexandre.raspberrycook.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.rousseau_alexandre.raspberrycook.R;
import com.rousseau_alexandre.raspberrycook.models.Recipe;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final Recipe recipe = getRecipe();
        System.out.println("Recipe loaded with id = " + recipe.getId());

        // set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(recipe.getTitle());
        setSupportActionBar(toolbar);

        ((TextView) findViewById(R.id.descriptionText)).setText(recipe.getDescription());
        ((TextView) findViewById(R.id.stepsText)).setText(recipe.getSteps());
        ((TextView) findViewById(R.id.ingredientsText)).setText(recipe.getIngredients());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recipe, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.editMenuItem:
                // newGame();
                return true;
            case R.id.deleteMenuItem:
                getRecipe().delete(RecipeActivity.this);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
