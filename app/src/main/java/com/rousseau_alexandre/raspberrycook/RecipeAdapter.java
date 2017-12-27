package com.rousseau_alexandre.raspberrycook;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter for list or recipes
 * @see https://github.com/florent37/TutosAndroidFrance/tree/master/ListViewSample
 *      http://tutos-android-france.com/listview-afficher-une-liste-delements/
 */
public class RecipeAdapter extends ArrayAdapter<Recipe> {


    public RecipeAdapter(Context context, List<Recipe> recipes) {
        super(context, 0, recipes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_recipe, parent, false);
        }

        RecipeViewHolder viewHolder = (RecipeViewHolder) convertView.getTag();

        if(viewHolder == null){
            viewHolder = new RecipeViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }

        // `getItem(position)` va récupérer l'item [position] de la List<Tweet> tweets
        Recipe recipe = getItem(position);

        // il ne reste plus qu'à remplir notre vue
        viewHolder.name.setText(recipe.name);

        return convertView;
    }

    private class RecipeViewHolder {
        public TextView name;
    }
}