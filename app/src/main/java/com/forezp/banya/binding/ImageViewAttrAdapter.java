package com.forezp.banya.binding;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.forezp.banya.MyApp;
import com.forezp.banya.utils.DisplayImgUtis;

public class ImageViewAttrAdapter {

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, String imgUrl) {
        DisplayImgUtis.getInstance().display(MyApp.getInstance(), imgUrl, view);
    }
}