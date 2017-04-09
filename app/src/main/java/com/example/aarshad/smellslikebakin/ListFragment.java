package com.example.aarshad.smellslikebakin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by aarshad on 4/6/17.
 */

public class ListFragment extends Fragment {


    public interface onRecipeSeletedInterface {
        public void onListRecipeSelected (int index);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        onRecipeSeletedInterface listener = (onRecipeSeletedInterface) getActivity();

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        // Since the listAdapters is the place where we set the OnClicklisteners so we pass this listener and set listener.onListRecipeSeleted
        ListAdapter listAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
