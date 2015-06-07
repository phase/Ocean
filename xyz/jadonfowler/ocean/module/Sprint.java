package xyz.jadonfowler.ocean.module;

import org.lwjgl.input.Keyboard;
import xyz.jadonfowler.ocean.utils.Wrapper;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", Keyboard.KEY_R, Category.PLAYER);
    }

    public void onUpdate() {
        if (!this.isEnabled()) return;
        if (!(Wrapper.mc.thePlayer.isCollidedHorizontally) && Wrapper.mc.thePlayer.moveForward > 0.0f) Wrapper.mc.thePlayer
                .setSprinting(true);
        else Wrapper.mc.thePlayer.setSprinting(false);
    }
}
