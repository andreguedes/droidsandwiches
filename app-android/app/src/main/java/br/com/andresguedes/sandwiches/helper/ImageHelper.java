package br.com.andresguedes.sandwiches.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import br.com.andresguedes.sandwiches.R;

/**
 * Created by Andre on 27/07/17.
 */

public class ImageHelper {

    public static void loadImages(Context context, String file, ImageView img) {
        Glide.with(context)
                .load(file)
                .fitCenter()
                .centerCrop()
                .override(80, 80)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .error(R.drawable.no_image)
                .placeholder(R.drawable.no_image)
                .into(img);
    }

}