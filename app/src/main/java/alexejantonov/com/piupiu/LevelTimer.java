package alexejantonov.com.piupiu;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LevelTimer extends CountDownTimer {

	private GameActivity activity;

	private Button menuButton;
	private ImageView replayButton;

	public LevelTimer(long millisInFuture, long countDownInterval, Activity activity) {
		super(millisInFuture, countDownInterval);
		this.activity = (GameActivity) activity;
	}

	@Override
	public void onTick(long millisUntilFinished) {
		activity.progressBar.setProgress((int) millisUntilFinished / 1000);
		activity.secondsField.setText(
				String.format(activity.getString(R.string.seconds_left), (millisUntilFinished / 1000))
		);
	}

	@Override
	public void onFinish() {
		activity.pauseImage.setEnabled(false);
		activity.progressBar.setProgress(0);
		activity.secondsField.setText(R.string.time_is_up);

		View view = activity.getLayoutInflater().inflate(R.layout.dialog_game_over, null);
		menuButton = view.findViewById(R.id.menuButton);
		replayButton = view.findViewById(R.id.replayButton);
		menuButton.setOnClickListener(view12 -> {
			activity.finish();
		});

		AlertDialog dialog = new AlertDialog.Builder(activity, R.style.Theme_AppCompat_Light_Dialog)
				.setView(view)
				.create();
		dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		dialog.show();

		replayButton.setOnClickListener(view1 -> {
			dialog.dismiss();
			activity.replayGame();
		});
	}
}
