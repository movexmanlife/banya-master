package com.forezp.banya.viewimpl.other;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.forezp.banya.AboutBinding;
import com.forezp.banya.R;
import com.forezp.banya.base.BaseActivity;
import com.forezp.banya.utils.ThemeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by forezp on 16/10/2.
 */
public class AboutActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    AboutBinding mAboutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAboutBinding = DataBindingUtil.setContentView(this, R.layout.activity_about);
        mAboutBinding.setPresenter(new Presenter());

        ButterKnife.bind(this);
        applyKitKatTranslucency();
        toolbar.setTitle("关于");
        toolbar.setBackgroundColor(ThemeUtils.getToolBarColor());
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backThActivity();
            }
        });
    }

    @Override
    public String setActName() {
        return null;
    }

    public class Presenter {
        public void update(View view) {
            Toast.makeText(getApplicationContext(), "当前为最新版本！", Toast.LENGTH_SHORT).show();
        }
    }
}
