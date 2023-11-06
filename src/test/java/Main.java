import com.kronae.ai.color.ColorAI;
import com.kronae.ai.color.ColorAiAnswer;
import com.kronae.ai.color.ColorAiBuilder;
import com.kronae.ai.color.RGBA;

public class Main {
    public static void main(String[] args) {
        ColorAiBuilder builder = new ColorAiBuilder();
        builder.learn("Black"  , new RGBA(0  , 0  , 0  , 255));
        builder.learn("Red"    , new RGBA(255, 0  , 0  , 255));
        builder.learn("Green"  , new RGBA(0  , 255, 0  , 255));
        builder.learn("Blue"   , new RGBA(0  , 0  , 255, 255));
        builder.learn("Yellow" , new RGBA(255, 255, 0  , 255));
        builder.learn("Cyan"   , new RGBA(0  , 255, 255, 255));
        builder.learn("Purple" , new RGBA(255, 0  , 255, 255));
        builder.learn("White"  , new RGBA(255, 255, 255, 255));

        ColorAI ai = builder.build();
        ColorAiAnswer ans = ai.detect(new RGBA(136,93,172, 255));
        System.out.printf("Color: %s\n", ans.color());
        for (String clazz : ans.getClassList()) {
            double val = ans.value(clazz);
            System.out.printf("%s: %s\n", clazz, val * 100 + "%");
        }
    }
}
