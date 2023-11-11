package com.kronae.ai.color;

import com.kronae.ai.color.exception.AlreadyLearnColorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ColorAiBuilder {
    private final Map<String, ArrayList<RGBA>> data = new HashMap<>();
    public ColorAiBuilder learn(String clazz, RGBA color) {
        ArrayList<RGBA> colors = data.putIfAbsent(clazz, new ArrayList<>());

        Objects.requireNonNull(colors); // Go away NULL

        if(!colors.contains(color))
            colors.add(color);

        data.put(clazz, colors);
        return this;
    }
    public ColorAI build() {
        return new ColorAI(data);
    }
}
