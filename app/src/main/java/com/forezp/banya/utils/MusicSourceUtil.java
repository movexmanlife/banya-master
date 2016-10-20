package com.forezp.banya.utils;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class MusicSourceUtil extends BaseSource{
    public static final String MUSIC_TITLES[] = {"流行", "经典", "韩系", "欧美"};
    public static final String TAG_POPULAY[] = {"歌声", "青春", "回忆", "孙燕姿", "周杰伦", "林俊杰", "陈奕迅", "王力宏", "邓紫棋", "风声", "海边", "童话", "美女", "一生", "爱", "爱情", "远方", "缘分", "天空", "张国荣", "黄家驹", "　beyond", "黑豹乐队"};
    public static final String TAG_CLASSIC[] = {"张国荣", "黄家驹", "　beyond", "黑豹乐队", "王菲", "五月天", "陈奕迅", "古巨基", "杨千嬅", "叶倩文", "许嵩", "刘德华", "邓丽君", "张学友"};
    public static final String TAG_KEREA[] = {"bigbang", "rain", "PSY", "李弘基", "李承哲", "金钟国", "李孝利", "孝琳", "IU", "EXO", "T-ara", "东方神起", "Epik High", "Girl's Day", " 紫雨林", "Zebra"};
    public static final String TAG_AMERICAN[] = {"Jay-Z", "Justin Bieber", "James Blunt", "Eminem", "Akon", "Adele", "Avril Lavigne", "Beyoncé", "Lady GaGa", "Taylor Swift", "Alicia Keys", "Owl City", "Coldplay"};

    private static Map<Integer, String[]> sTagMaps = new HashMap<>();
    static {
        sTagMaps.put(0, TAG_POPULAY);
        sTagMaps.put(1, TAG_CLASSIC);
        sTagMaps.put(2, TAG_KEREA);
        sTagMaps.put(3, TAG_AMERICAN);
    }

    public static final String[] getApiTag(int pos) {
        return sTagMaps.get(pos);
    }
}
