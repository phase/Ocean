package xyz.jadonfowler.ocean.module;

import org.lwjgl.input.Keyboard;
import xyz.jadonfowler.ocean.utils.Wrapper;

public class Flight extends Module {

    public Flight() {
        super("Flight", Keyboard.KEY_F, Category.PLAYER);
        // TODO Auto-generated constructor stub
    }
    
    public void onEnable(){
        Wrapper.mc.thePlayer.capabilities.isFlying = true;
    }
    
    public void onDisable(){
        Wrapper.mc.thePlayer.capabilities.isFlying = false;
    }
}
