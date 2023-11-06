package com.kronae.ai.color;

import java.util.Map;

public class ColorAI {
    private final Map<String, RGBA> data;
    protected ColorAI(Map<String, RGBA> data) {
        this.data = data;
    }
    public ColorAiAnswer detect(RGBA color) {
        ColorAiAnswer answer = new ColorAiAnswer();
        for (String clazz : data.keySet()) {
            RGBA value = data.get(clazz);
            int r = Math.abs(color.getR() - value.getR());
            int g = Math.abs(color.getG() - value.getG());
            int b = Math.abs(color.getB() - value.getB());
            int a = Math.abs(color.getA() - value.getA());
            answer.put(clazz, 1 - ( (double) (r + g + b + a) / 4 ) / 255);
        }
        return answer;
    }
}
