package mimiz.week6;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter
{
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount)
    {
        super(fm);
        this.tabCount= tabCount;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                FirstFragment firstFragment = new FirstFragment();
                return firstFragment;
            case 1:
                SecondFragment secondFragment = new SecondFragment();
                return secondFragment;
            case 2:
                ThirdFragment thirdFragment = new ThirdFragment();
                return thirdFragment;
            case 3:
                ForthFragment forthFragment = new ForthFragment();
                return forthFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return tabCount;
    }
}