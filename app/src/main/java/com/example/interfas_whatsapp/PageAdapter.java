package com.example.interfas_whatsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.interfas_whatsapp.Fragment.tabChat;
import com.example.interfas_whatsapp.Fragment.tabEstado;
import com.example.interfas_whatsapp.Fragment.tabLlamada;

public class PageAdapter extends FragmentPagerAdapter {

    private int numftabs;

    public PageAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numftabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new tabChat();
            case 1:
                return new tabEstado();
            case 2:
                return new tabLlamada();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numftabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
