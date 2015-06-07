package xyz.jadonfowler.ocean.module;

import java.util.ArrayList;

public class ModuleManager {

    public static ArrayList<Module> activeMods = new ArrayList<Module>();

    public ModuleManager() {
        Module[] ms = {new Sprint(), new FullBright(), new KillAura(), new Flight()};
        for(Module m : ms)
            activeMods.add(m);
    }
}
