package sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.IntMap;

public class SoundEffect implements InputProcessor {
    private IntMap<Sound> soundKeys;
    public SoundEffect() {
        soundKeys = new IntMap<Sound>();
        Sound backSnd = Gdx.audio.newSound(Gdx.files.internal("sfx/back.ogg"));
        Sound diamondSnd = Gdx.audio.newSound(Gdx.files.internal("sfx/diamond.ogg"));
        Sound jumpSnd = Gdx.audio.newSound(Gdx.files.internal("sfx/jump.ogg"));
        soundKeys.put(Input.Keys.NUM_1,backSnd);
        soundKeys.put(Input.Keys.NUM_2,diamondSnd);
        soundKeys.put(Input.Keys.NUM_3,jumpSnd);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        Sound sound = soundKeys.get(keycode);
        if (sound != null) {sound.play();}
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void dispose() {
        for (Sound sound:soundKeys.values()) {
            sound.dispose();
        }
    }
}
