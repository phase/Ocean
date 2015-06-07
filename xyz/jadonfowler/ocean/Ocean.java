package xyz.jadonfowler.ocean;

import org.lwjgl.opengl.Display;
import xyz.jadonfowler.ocean.module.ModuleManager;

public class Ocean {
    
    public static final String NAME = "Ocean";
    public static final double VERSION = 0.1;
    
    public static final Ocean instance = new Ocean();
    
    public static ModuleManager mm;
    
    public static void start(){
        Display.setTitle(NAME + " v" + VERSION);
        mm = new ModuleManager();
    }
    
}
