package mimiz.week6;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl = (TabLayout) findViewById(R.id.tl);
        tl.addTab(tl.newTab().setIcon(R.drawable.profile));
        tl.addTab(tl.newTab().setIcon(R.drawable.chat));
        tl.addTab(tl.newTab().setIcon(R.drawable.disney));
        tl.addTab(tl.newTab().setIcon(R.drawable.threedots));
        tl.setTabGravity(TabLayout.GRAVITY_FILL);

        vp = (ViewPager)findViewById(R.id.vp);

        vp.setAdapter(new TabPagerAdapter(getSupportFragmentManager(), tl.getTabCount()));
        vp.setCurrentItem(0);

        // Creating TabPagerAdapter adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tl.getTabCount());
        vp.setAdapter(pagerAdapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));

        // Set TabSelectedListener
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

        View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            vp.setCurrentItem(tag);
        }
    };
}
