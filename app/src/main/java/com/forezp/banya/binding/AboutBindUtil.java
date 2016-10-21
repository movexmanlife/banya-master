package com.forezp.banya.binding;

import com.forezp.banya.MyApp;
import com.forezp.banya.R;
import com.forezp.banya.utils.VersionUtil;

/**
 *
 */
public class AboutBindUtil {
    public static final String getVersionName() {
        return MyApp.getInstance().getResources().getString(R.string.version_name) + VersionUtil.getVersionName(MyApp.getInstance());
    }
}
