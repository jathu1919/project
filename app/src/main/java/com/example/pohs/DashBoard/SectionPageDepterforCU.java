package com.example.pohs.DashBoard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class SectionPageDepterforCU extends FragmentPagerAdapter {

    public SectionPageDepterforCU(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                MaleItems maleItems = new MaleItems();
                return maleItems;

            case 1:
                FemaleItems femaleItems = new FemaleItems();
                return femaleItems;

            case 2:
                KidsItems kidsItems = new KidsItems();
                return kidsItems;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "MALE ITEMS";
            case 1:
                return "FEMALE ITEMS";
            case 2:
                return "KIDS ITEMS";
            default:
                return null;
        }


    }
}
