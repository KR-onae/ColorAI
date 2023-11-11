package com.kronae.ai.color;

import java.util.ArrayList;
import java.util.Map;

public class ColorAI {
    private final Map<String, ArrayList<RGBA>> data;
    protected ColorAI(Map<String, ArrayList<RGBA>> data) {
        this.data = data;
    }
    public ColorAiAnswer detect(RGBA color) {
        ColorAiAnswer answer = new ColorAiAnswer();
        for (String clazz : data.keySet()) {
            ArrayList<RGBA> value = data.get(clazz);

            double mx = 0;
            for (RGBA learned : value) {
                int r = Math.abs(color.getR() - learned.getR());
                int g = Math.abs(color.getG() - learned.getG());
                int b = Math.abs(color.getB() - learned.getB());
                int a = Math.abs(color.getA() - learned.getA());

                double v = 1 - ( (double) (r + g + b + a) / 4 ) / 255;

                if(v > mx)
                    mx = v;
            }
            answer.put(clazz, mx);
        }
        return answer;
    }
}
