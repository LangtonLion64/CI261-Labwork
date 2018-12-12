package utility;

import com.badlogic.gdx.graphics.Color;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.*;

public class Constants {
    public static final Color BACKGROUND_COLOR = new Color(0,0,0,1);
    public static final String SIZE = "android/assets/data/smallSize.png";
    public static final String SAW_ATLAS = "android/assets/texture_atlas/saw_assets.atlas";
    public static final String BALL_ATLAS = "android/assets/texture_atlas/ball_assets.atlas";
    public static final String fontPath = "android/assets/font/stencil.fnt";
    public static final String BUMPER = "android/assets/gfx/bumper.png";

    public static final Map<String, String> LEVEL_SOUNDS =
            Collections.unmodifiableMap(new HashMap<String, String>() {
                {
                    put("back", "android/assets/sfx/back.ogg");
                    put("diamond", "android/assets/sfx/diamond.ogg");
                    put("jump", "android/assets/sfx/jump.ogg");
                    put("bounce", "android/assets/sfx/bounce.ogg");
                }
            });
}
