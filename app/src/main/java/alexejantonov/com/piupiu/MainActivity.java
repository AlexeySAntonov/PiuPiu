package alexejantonov.com.piupiu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	@BindView(R.id.newGameBtn) Button newGameBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		newGameBtn.setOnClickListener(view -> launchGameActivity());
	}

	private void launchGameActivity() {
		Intent i = GameActivity.newIntent(this);
		startActivity(i);
	}
}
