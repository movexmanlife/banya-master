package com.forezp.banya.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 */
public abstract class BaseSource {
    protected Map<Integer, String[]> mTagMaps = new HashMap<>();

    public static final String getRandomTag(List<String> list) {
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
