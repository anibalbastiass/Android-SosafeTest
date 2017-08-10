package cl.sosafe.sosafetest.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import cl.sosafe.sosafetest.R;
import cl.sosafe.sosafetest.ui.GlideRotateTransformation;

/**
 * Created by anibalbastias on 10-08-17.
 * Clase de metodos utiles concurrentes
 */

public class SSUtils {

    public static void loadUrlRotatedImage(final Context context, String url, final ImageView imageView,
                                           final ProgressBar mProgress) {
        mProgress.setVisibility(View.VISIBLE);

        Glide
                .with(context)
                .load(url)
                .asBitmap()
                .transform(new GlideRotateTransformation(context, 180f))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new SimpleTarget<Bitmap>(300, 300) {
                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        mProgress.setVisibility(View.GONE);
                        imageView.setImageResource(R.mipmap.ic_error);
                    }

                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        mProgress.setVisibility(View.GONE);
                        imageView.setImageBitmap(resource);
                    }
                });
    }
}
