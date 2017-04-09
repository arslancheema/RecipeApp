package com.example.aarshad.smellslikebakin;

/**
 * Created by aarshad on 4/8/17.
 */

public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
