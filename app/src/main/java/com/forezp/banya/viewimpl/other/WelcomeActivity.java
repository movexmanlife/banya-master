package com.forezp.banya.viewimpl.other;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ImageView;

import com.forezp.banya.R;
import com.forezp.banya.WelcomeBinding;
import com.forezp.banya.viewimpl.MainActivity;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindArray;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 欢迎页
 */
public class WelcomeActivity extends Activity {

    @BindInt(R.integer.animationTime)
    int mAnimationTime;
    @BindArray(R.array.scaleXValue)
    String[] mScaleXValue;
    @BindArray(R.array.scaleYValue)
    String[] mScaleYValue;
    WelcomeBinding mWelcomeBinding;

    private static final int[] IMAGES = {
            R.drawable.ic_screen_default,
            R.drawable.splash0,
            R.drawable.splash1,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash5,
            R.drawable.splash6,
            R.drawable.splash7,
            R.drawable.splash8,
            R.drawable.splash9,
            R.drawable.splash10,
            R.drawable.splash11,
            R.drawable.splash12,
            R.drawable.splash13,
            R.drawable.splash14,
            R.drawable.splash15,
            R.drawable.splash16,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWelcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
        ButterKnife.bind(this);

        Random random = new Random(SystemClock.elapsedRealtime());
        mWelcomeBinding.setResImgId(IMAGES[random.nextInt(IMAGES.length)]);

        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startAnim();
                    }
                });
    }

    private void startAnim() {
        PropertyValuesHolder scaleXHolder = PropertyValuesHolder.ofFloat("scaleX", Float.valueOf(mScaleXValue[0]), Float.valueOf(mScaleXValue[1]));
        PropertyValuesHolder scaleYHolder = PropertyValuesHolder.ofFloat("scaleY", Float.valueOf(mScaleYValue[0]), Float.valueOf(mScaleYValue[1]));

        ObjectAnimator objAnimator = ObjectAnimator.ofPropertyValuesHolder(mWelcomeBinding.splashImg, scaleXHolder, scaleYHolder);
        objAnimator.setDuration(mAnimationTime);
        objAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                gotoMainActivity();
            }
        });
        objAnimator.start();
    }

    private void gotoMainActivity() {
        MainActivity.start(this);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}


