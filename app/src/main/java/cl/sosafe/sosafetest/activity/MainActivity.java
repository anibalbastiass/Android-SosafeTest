package cl.sosafe.sosafetest.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import cl.sosafe.sosafetest.R;
import cl.sosafe.sosafetest.util.SSUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SAVED_INSTANCE_IMAGE = "image";
    private ImageView mImage;
    private EditText mEditText;
    private AppCompatButton mButton;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();

        if (savedInstanceState != null) {
            Bitmap bitmap = savedInstanceState.getParcelable(SAVED_INSTANCE_IMAGE);
            mImage.setImageBitmap(bitmap);
        }
    }

    private void setView() {
        mImage = findViewById(R.id.activity_main_image);
        mEditText = findViewById(R.id.activity_main_txt);
        mButton = findViewById(R.id.activity_main_btn);
        mProgress = findViewById(R.id.activity_main_progress);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_btn:
                String url = mEditText.getText().toString();
                if (!url.isEmpty())
                    SSUtils.loadUrlRotatedImage(this, url, mImage, mProgress);
                else
                    Toast.makeText(this, getString(R.string.activity_main_error_image),
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        BitmapDrawable drawable = (BitmapDrawable) mImage.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        
        if(bitmap != null)
            outState.putParcelable(SAVED_INSTANCE_IMAGE, bitmap);

        super.onSaveInstanceState(outState);
    }
}
