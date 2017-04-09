package com.example.aarshad.smellslikebakin;

/**
 * Created by aarshad on 4/9/17.
 */
public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.onRecipeSeletedInterface mListener;


    public GridAdapter(GridFragment.onRecipeSeletedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }


}