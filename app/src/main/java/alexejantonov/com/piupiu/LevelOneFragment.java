package alexejantonov.com.piupiu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LevelOneFragment extends BaseGameFragment {

	private boolean isPressed = false;
	private ImageView bufferImageView;

	@BindViews
			({
					R.id.pok1, R.id.pok2, R.id.pok3, R.id.pok4, R.id.pok5, R.id.pok6, R.id.pok7, R.id.pok8,
					R.id.pok9, R.id.pok10, R.id.pok11, R.id.pok12, R.id.pok13, R.id.pok14,
					R.id.pok15, R.id.pok16, R.id.pok17, R.id.pok18, R.id.pok19, R.id.pok20,
					R.id.pok21, R.id.pok22, R.id.pok23, R.id.pok24, R.id.pok25, R.id.pok26,
					R.id.pok27, R.id.pok28, R.id.pok29, R.id.pok30, R.id.pok31, R.id.pok32,
					R.id.pok33, R.id.pok34, R.id.pok35, R.id.pok36, R.id.pok37, R.id.pok38,
					R.id.pok39, R.id.pok40, R.id.pok41, R.id.pok42, R.id.pok43, R.id.pok44,
					R.id.pok45, R.id.pok46, R.id.pok47, R.id.pok48, R.id.pok49, R.id.pok50,
					R.id.pok51, R.id.pok52, R.id.pok53, R.id.pok54, R.id.pok55, R.id.pok56,
					R.id.pok57, R.id.pok58, R.id.pok59, R.id.pok60, R.id.pok61, R.id.pok62,
					R.id.pok63, R.id.pok64, R.id.pok65, R.id.pok66, R.id.pok67, R.id.pok68,
					R.id.pok69, R.id.pok70, R.id.pok71, R.id.pok72, R.id.pok73, R.id.pok74,
					R.id.pok75, R.id.pok76, R.id.pok77, R.id.pok78, R.id.pok79, R.id.pok80,
					R.id.pok81, R.id.pok82, R.id.pok83, R.id.pok84, R.id.pok85, R.id.pok86,
					R.id.pok87, R.id.pok88, R.id.pok89, R.id.pok90, R.id.pok91, R.id.pok92,
					R.id.pok93, R.id.pok94, R.id.pok95, R.id.pok96, R.id.pok97, R.id.pok98,
					R.id.pok99, R.id.pok100, R.id.pok101, R.id.pok102, R.id.pok103, R.id.pok104,
					R.id.pok105, R.id.pok106, R.id.pok107, R.id.pok108, R.id.pok109, R.id.pok110,
					R.id.pok111, R.id.pok112, R.id.pok113, R.id.pok114, R.id.pok115, R.id.pok116,
					R.id.pok117, R.id.pok118, R.id.pok119, R.id.pok120, R.id.pok121, R.id.pok122,
					R.id.pok123, R.id.pok124, R.id.pok125, R.id.pok126, R.id.pok127, R.id.pok128})
	List<ImageView> poks;

	public LevelOneFragment() {
	}

	public static LevelOneFragment newInstance() {
		LevelOneFragment levelOneFragment = new LevelOneFragment();
		return levelOneFragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_level_one, container, false);
		ButterKnife.bind(this, view);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		activity = (GameActivity) getActivity();

		for (int i = 0; i < poks.size(); i++) {
			poks.get(i).setVisibility(View.VISIBLE);
		}

		Collections.shuffle(tags);
		Log.d("TAGS", tags.toString());

		for (int i = 0; i < poks.size(); i++) {
			poks.get(i).setImageResource(imagesResources[tags.get(i)]);
			poks.get(i).setTag(tags.get(i));
		}
	}

	@Override
	public void onDestroyView() {
		activity = null;
		super.onDestroyView();
	}

	@Override
	public int getFragmentId() {
		return 0;
	}

	@OnClick({R.id.pok1, R.id.pok2, R.id.pok3, R.id.pok4, R.id.pok5, R.id.pok6, R.id.pok7, R.id.pok8,
			R.id.pok9, R.id.pok10, R.id.pok11, R.id.pok12, R.id.pok13, R.id.pok14,
			R.id.pok15, R.id.pok16, R.id.pok17, R.id.pok18, R.id.pok19, R.id.pok20,
			R.id.pok21, R.id.pok22, R.id.pok23, R.id.pok24, R.id.pok25, R.id.pok26,
			R.id.pok27, R.id.pok28, R.id.pok29, R.id.pok30, R.id.pok31, R.id.pok32,
			R.id.pok33, R.id.pok34, R.id.pok35, R.id.pok36, R.id.pok37, R.id.pok38,
			R.id.pok39, R.id.pok40, R.id.pok41, R.id.pok42, R.id.pok43, R.id.pok44,
			R.id.pok45, R.id.pok46, R.id.pok47, R.id.pok48, R.id.pok49, R.id.pok50,
			R.id.pok51, R.id.pok52, R.id.pok53, R.id.pok54, R.id.pok55, R.id.pok56,
			R.id.pok57, R.id.pok58, R.id.pok59, R.id.pok60, R.id.pok61, R.id.pok62,
			R.id.pok63, R.id.pok64, R.id.pok65, R.id.pok66, R.id.pok67, R.id.pok68,
			R.id.pok69, R.id.pok70, R.id.pok71, R.id.pok72, R.id.pok73, R.id.pok74,
			R.id.pok75, R.id.pok76, R.id.pok77, R.id.pok78, R.id.pok79, R.id.pok80,
			R.id.pok81, R.id.pok82, R.id.pok83, R.id.pok84, R.id.pok85, R.id.pok86,
			R.id.pok87, R.id.pok88, R.id.pok89, R.id.pok90, R.id.pok91, R.id.pok92,
			R.id.pok93, R.id.pok94, R.id.pok95, R.id.pok96, R.id.pok97, R.id.pok98,
			R.id.pok99, R.id.pok100, R.id.pok101, R.id.pok102, R.id.pok103, R.id.pok104,
			R.id.pok105, R.id.pok106, R.id.pok107, R.id.pok108, R.id.pok109, R.id.pok110,
			R.id.pok111, R.id.pok112, R.id.pok113, R.id.pok114, R.id.pok115, R.id.pok116,
			R.id.pok117, R.id.pok118, R.id.pok119, R.id.pok120, R.id.pok121, R.id.pok122,
			R.id.pok123, R.id.pok124, R.id.pok125, R.id.pok126, R.id.pok127, R.id.pok128})
	public void onPokClick(ImageView imageView) {
		if (!isPressed) {
			isPressed = true;
			bufferImageView = imageView;
			bufferImageView.setBackgroundResource(R.drawable.pok_background_pressed);
		} else {
			if (bufferImageView.getTag() == imageView.getTag() && !bufferImageView.equals(imageView)) {
				bufferImageView.setVisibility(View.INVISIBLE);
				imageView.setVisibility(View.INVISIBLE);
				activity.score += 100;
				activity.scoreField.setText(String.valueOf(((GameActivity) getActivity()).score));
			}
			bufferImageView.setBackgroundResource(R.drawable.pok_background);
			bufferImageView = null;
			isPressed = false;
		}
		if (activity.score == 6400) {
			activity.complete();
		}
	}
}
