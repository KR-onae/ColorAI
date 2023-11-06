package com.kronae.ai.color;

import com.kronae.ai.color.exception.AlreadyLearnClassException;
import com.kronae.ai.color.exception.AlreadyLearnColorException;

import java.util.HashMap;
import java.util.Map;

public class ColorAiBuilder {
    private Map<String, RGBA> data;
    public ColorAiBuilder() {
        data = new HashMap<>();
    }
    public ColorAiBuilder learn(String clazz, RGBA color) {
        if(data.containsKey(clazz))
            throw new AlreadyLearnColorException("Already learned class name: " + clazz);

        if(data.containsValue(color))
            throw new AlreadyLearnClassException("Already learned color value: " + color);

        data.put(clazz, color);
        return this;
    }

    public ColorAI build() {
        return new ColorAI(data);
    }
}
