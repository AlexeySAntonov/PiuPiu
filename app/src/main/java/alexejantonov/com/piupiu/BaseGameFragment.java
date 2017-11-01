package alexejantonov.com.piupiu;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseGameFragment extends Fragment {

	protected GameActivity activity;
	protected int[] imagesResources = {
			R.drawable.pok1, R.drawable.pok2, R.drawable.pok3, R.drawable.pok4, R.drawable.pok5,
			R.drawable.pok6, R.drawable.pok7, R.drawable.pok8, R.drawable.pok9, R.drawable.pok10,
			R.drawable.pok11, R.drawable.pok12, R.drawable.pok13, R.drawable.pok14, R.drawable.pok15,
			R.drawable.pok16, R.drawable.pok17, R.drawable.pok18, R.drawable.pok19, R.drawable.pok20,
			R.drawable.pok21, R.drawable.pok22, R.drawable.pok23, R.drawable.pok24, R.drawable.pok25,
			R.drawable.pok26, R.drawable.pok27, R.drawable.pok28, R.drawable.pok29, R.drawable.pok30,
			R.drawable.pok31, R.drawable.pok32
	};
	protected List<Integer> tags = new ArrayList<Integer>() {{
		add(0);
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		add(6);
		add(7);
		add(8);
		add(9);
		add(10);
		add(11);
		add(12);
		add(13);
		add(14);
		add(15);
		add(16);
		add(17);
		add(18);
		add(19);
		add(20);
		add(21);
		add(22);
		add(23);
		add(24);
		add(25);
		add(26);
		add(27);
		add(28);
		add(29);
		add(30);
		add(31);
		add(0);
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		add(6);
		add(7);
		add(8);
		add(9);
		add(10);
		add(11);
		add(12);
		add(13);
		add(14);
		add(15);
		add(16);
		add(17);
		add(18);
		add(19);
		add(20);
		add(21);
		add(22);
		add(23);
		add(24);
		add(25);
		add(26);
		add(27);
		add(28);
		add(29);
		add(30);
		add(31);
		add(0);
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		add(6);
		add(7);
		add(8);
		add(9);
		add(10);
		add(11);
		add(12);
		add(13);
		add(14);
		add(15);
		add(16);
		add(17);
		add(18);
		add(19);
		add(20);
		add(21);
		add(22);
		add(23);
		add(24);
		add(25);
		add(26);
		add(27);
		add(28);
		add(29);
		add(30);
		add(31);
		add(0);
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		add(6);
		add(7);
		add(8);
		add(9);
		add(10);
		add(11);
		add(12);
		add(13);
		add(14);
		add(15);
		add(16);
		add(17);
		add(18);
		add(19);
		add(20);
		add(21);
		add(22);
		add(23);
		add(24);
		add(25);
		add(26);
		add(27);
		add(28);
		add(29);
		add(30);
		add(31);
	}};

	public static BaseGameFragment newInstance(int fragmentId) {
		switch (fragmentId) {
			case 0:
				return LevelOneFragment.newInstance();
		}
		throw new IllegalArgumentException("Unknown id = " + fragmentId);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		activity = (GameActivity) getActivity();
	}

	@IdRes
	public abstract int getFragmentId();
}
