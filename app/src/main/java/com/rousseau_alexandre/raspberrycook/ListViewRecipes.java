package com.rousseau_alexandre.raspberrycook;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom ListView for recipes
 */
public class ListViewRecipes extends ListView {

    /**
     * List of all recipes
     */
    private List<Recipe> recipes;

    public ListViewRecipes(Context context){
        super(context);
    }

    public ListViewRecipes(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewRecipes(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ListViewRecipes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Load all recipes
     *
     * @todo fetch this from https://raspberry-cook.fr
     * @param context
     */
    public void loadRecipes(Context context){
        //
        recipes = new ArrayList<Recipe>();
        recipes.add(new Recipe("Tarte aux pommes"));
        recipes.add(new Recipe("Boudin aux pommes"));
        recipes.add(new Recipe("Riz de veau"));

        final RecipeAdapter adapter = new RecipeAdapter(context, recipes);
        setAdapter(adapter);
    }
}