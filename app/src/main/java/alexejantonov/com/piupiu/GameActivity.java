package alexejantonov.com.piupiu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {

	private static final int INITIAL_SCORE = 0;
	protected static final int MAX_TIME = 150;

	private LevelTimer timer;
	private int bufferProgress;
	private boolean isPaused = false;
	private FragmentManager fragmentManager;
	private BaseGameFragment currentFragment;
	protected int score = 0;

	@BindView(R.id.backgroundImage) ImageView backgroundImage;
	@BindView(R.id.progressBar) ProgressBar progressBar;
	@BindView(R.id.seconds) TextView secondsField;
	@BindView(R.id.score) TextView scoreField;
	@BindView(R.id.pause) ImageView pauseImage;
	@BindView(R.id.replay) ImageView replayImage;
	@BindView(R.id.fragmentContainer) FrameLayout fragmentContainerLayout;

	public static Intent newIntent(Context packageContext) {
		Intent i = new Intent(packageContext, GameActivity.class);
		return i;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		ButterKnife.bind(this);

		init();
	}

	@Override
	protected void onDestroy() {
		timer.cancel();
		super.onDestroy();
	}

	protected void init() {
		pauseImage.setEnabled(true);
		progressBar.setMax(MAX_TIME);
		scoreField.setText(String.valueOf(INITIAL_SCORE));

		pauseImage.setOnClickListener(view -> {
			if (!isPaused) {
				replayImage.setVisibility(View.INVISIBLE);
				backgroundImage.setImageResource(R.drawable.pause_background);
				backgroundImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				pauseImage.setColorFilter(
						ContextCompat.getColor(this, R.color.score_and_pok_background_color),
						PorterDuff.Mode.MULTIPLY);
				fragmentContainerLayout.setVisibility(View.INVISIBLE);
				bufferProgress = progressBar.getProgress();
				timer.cancel();
				pauseImage.setImageResource(R.drawable.ic_play_circle_outline_white_24dp);
				isPaused = true;
			} else {
				replayImage.setVisibility(View.VISIBLE);
				backgroundImage.setImageResource(R.drawable.level_one_background);
				backgroundImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
				pauseImage.setColorFilter(android.R.color.white);
				fragmentContainerLayout.setVisibility(View.VISIBLE);
				timerStart(bufferProgress);
				pauseImage.setImageResource(R.drawable.ic_pause_circle_outline_white_24dp);
				isPaused = false;
			}
		});

		replayImage.setOnClickListener(view -> {
			timer.cancel();
			replayGame();
		});

		fragmentManager = getSupportFragmentManager();
		BaseGameFragment fragment = (BaseGameFragment) fragmentManager.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			currentFragment = BaseGameFragment.newInstance(0);
			fragmentManager.beginTransaction()
					.replace(R.id.fragmentContainer, currentFragment)
					.commitAllowingStateLoss();
		} else {
			currentFragment = fragment;
		}

		timerStart(MAX_TIME);
	}

	protected void replayGame() {
		pauseImage.setEnabled(true);
		progressBar.setMax(MAX_TIME);
		scoreField.setText(String.valueOf(INITIAL_SCORE));
		score = 0;

		currentFragment = BaseGameFragment.newInstance(currentFragment.getFragmentId());

		fragmentManager.beginTransaction()
				.replace(R.id.fragmentContainer, currentFragment)
				.commitAllowingStateLoss();

		timerStart(MAX_TIME);
	}

	private void timerStart(int currentProgress) {

		secondsField.setText(String.format(getString(R.string.seconds_left), currentProgress));

		timer = new LevelTimer(currentProgress * 1000, 1000, this);

		timer.start();
	}

	protected void complete() {
		pauseImage.setEnabled(false);
		timer.cancel();
		new AlertDialog.Builder(this, R.style.Theme_AppCompat_Light_Dialog)
				.setTitle("Победа!")
				.setPositiveButton("Следующий уровень", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {

					}
				})
				.setNegativeButton("Меню", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {

					}
				})
				.create().show();
	}
}
