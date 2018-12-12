package sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.IntMap;

public class SoundLink {
    private IntMap<Sound> soundKeys;
    public SoundLink() {
        soundKeys = new IntMap<Sound>();
        Sound backSnd = Gdx.audio.newSound(Gdx.files.internal("sfx/back.ogg"));
        Sound diamondSnd = Gdx.audio.newSound(Gdx.files.internal("sfx/diamond.ogg"));
        Sound jumpSnd = Gdx.audio.newSound(Gdx.files.internal("sfx/jump.ogg"));

        soundKeys.put(1,backSnd);
        soundKeys.put(2,diamondSnd);
        soundKeys.put(3,jumpSnd);
    }

    public boolean play(int keycode) {
        Sound sound = soundKeys.get(keycode);
        if (sound != null) {sound.play();}
        return false;
    }

    public void dispose() {
        for (Sound sound:soundKeys.values()) {
            sound.dispose();
        }
    }
}
