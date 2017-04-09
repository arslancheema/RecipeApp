package com.example.aarshad.smellslikebakin;

/**
 * Created by aarshad on 4/6/17.
 */

public class ListAdapter extends RecyclerAdapter {
    private final ListFragment.onRecipeSeletedInterface mListener;


    public ListAdapter(ListFragment.onRecipeSeletedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }


}
