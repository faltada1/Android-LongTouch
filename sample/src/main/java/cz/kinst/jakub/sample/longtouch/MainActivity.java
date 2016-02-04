package cz.kinst.jakub.sample.longtouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import cz.kinst.jakub.longtouch.LongTouchHelper;


public class MainActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
		findViewById(R.id.target).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
			}
		});
		final LongTouchHelper helper = LongTouchHelper.setup((FrameLayout) findViewById(R.id.root));
		helper.setRevealEffectEnabled(false);
		helper.protectTouchOnViews(findViewById(R.id.scroll_view));
		helper.addViewPopup(findViewById(R.id.target), LayoutInflater.from(this).inflate(R.layout.popup_hello, null));
		helper.addViewPopup(findViewById(R.id.target2), LayoutInflater.from(this).inflate(R.layout.popup_hello, null));
	}

}
