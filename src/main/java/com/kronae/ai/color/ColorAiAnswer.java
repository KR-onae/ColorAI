package com.kronae.ai.color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorAiAnswer {
    private final Map<String, Double> map;
    private String mxc;

    protected ColorAiAnswer() {
        map = new HashMap<>();
    }
    protected void put(String c, double p) {
        map.put(c, p);
    }
    public List<String> getClassList() {
        return new ArrayList<>(map.keySet());
    }
    public String color() {
        if(mxc == null) {
            double mx = -1;
            for (String clazz : map.keySet()) {
                double val = map.get(clazz);
                if(val > mx) {
                    mx = val;
                    mxc = clazz;
                }
            }
        }
        return mxc;
    }
    public double value(String clazz) {
        return map.get(clazz);
    }
}
