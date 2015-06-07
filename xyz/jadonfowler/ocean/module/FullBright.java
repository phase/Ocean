package xyz.jadonfowler.ocean.module;

import org.lwjgl.input.Keyboard;
import xyz.jadonfowler.ocean.utils.Wrapper;

public class FullBright extends Module {

    public FullBright() {
        super("Fullbright", Keyboard.KEY_B, Category.WORLD);
    }

    public void onUpdate() {
        Wrapper.mc.gameSettings.gammaSetting = this.isEnabled() ? 10f : 1f;
    }
}
