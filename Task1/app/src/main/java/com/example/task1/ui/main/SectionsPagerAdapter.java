package com.example.task1.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.task1.R;
import com.example.task1.Tab1.Fragment1;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

  @StringRes
  private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
  private final Context mContext;

  public SectionsPagerAdapter(Context context, FragmentManager fm) {
    super(fm);
    mContext = context;
  }

  @Override
  public Fragment getItem(int position) {

    switch (position) {
      case 0:
        Fragment1 fragment1 = new Fragment1();
        return fragment1;
      case 1:
        Fragment2 fragment2 = new Fragment2();
        return fragment2;
      case 2:
        Fragment3 fragment3 = new Fragment3();
        return fragment3;
      default:
        return null;
    }
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return mContext.getResources().getString(TAB_TITLES[position]);
  }

  @Override
  public int getCount() {
    // Show 2 total pages.
    return 3;
  }
}