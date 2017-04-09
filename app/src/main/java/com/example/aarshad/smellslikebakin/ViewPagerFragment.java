package com.example.aarshad.smellslikebakin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by aarshad on 4/6/17.
 */

public class ViewPagerFragment extends Fragment {

    public static final String KEY_RECIPE_INDEX = "recipe_index";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);

        View view = inflater.inflate(R.layout.fragment_viewpager,container,false);

        final IngredientsFragment ingredientsFragments = new IngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        ingredientsFragments.setArguments(bundle);


        final DirectionsFragment directionsFragments = new DirectionsFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        directionsFragments.setArguments(bundle);


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        // getChildFragmentManager() is used when we deal with Fragement within Fragments
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? ingredientsFragments : directionsFragments ;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position==0 ? "Ingredients" : "Directions" ;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;

    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getString(R.string.app_name));
    }

}
