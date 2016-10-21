package com.forezp.banya.binding;

import com.forezp.banya.MyApp;
import com.forezp.banya.R;
import com.forezp.banya.utils.VersionUtil;

/**
 *
 */
public class Top250FilmAdapterBindUtil {
    public static final String getRank(int position) {
        int index = position + 1;
        String rank = String.valueOf(index);
        if (index < 10) {
            rank = "0" + rank;
        }
        return rank;
    }
}
