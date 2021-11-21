package ru.compass.logic;

import java.util.HashMap;
import java.util.Map;

public class Compass {
    private static final Compass instance = new Compass();
    Map<String, String> range;

    public Compass() {
        range = new HashMap<>();
        range.put("North", "337-21");
        range.put("North-East", "22-66");
        range.put("East", "67-111");
        range.put("South-East", "112-156");
        range.put("South", "157-201");
        range.put("South-West", "202-246");
        range.put("West", "247-291");
        range.put("North-West", "292-336");
    }

    public Compass(Map<String, String> range) {
        this.range = range;
    }

    public Map<String, String> getRange() {
        return range;
    }

    public void setRange(Map<String, String> range) {
        this.range = range;
    }

    public static Compass getInstance() {
        return instance;
    }

    public boolean isBetween(String interval, int degree){
        int delimiter = interval.indexOf("-");
        int start = Integer.parseInt(interval.substring(0, delimiter));
        int end = Integer.parseInt(interval.substring(delimiter+1));
        return (start < end && degree > start && degree < end) || (start > end && (degree > start || degree < end));
    }

    public Map<String, String> getSide(int degree) {
        Map<String,String> side = new HashMap<>();
        for (Map.Entry<String,String> entry : range.entrySet()) {
            if (isBetween(entry.getValue(), degree)) {
                side.put("Side",entry.getKey());
                return side;
            }
        }
        return null;
    }
}
