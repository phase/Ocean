package xyz.jadonfowler.ocean.ui;

import java.awt.Color;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import xyz.jadonfowler.ocean.Ocean;
import xyz.jadonfowler.ocean.module.Module;
import xyz.jadonfowler.ocean.utils.Wrapper;

public class GuiIngameHook extends GuiIngame {

    public GuiIngameHook(Minecraft mcIn) {
        super(mcIn);
    }

    @Override public void func_175180_a(float p) {
        super.func_175180_a(p);
        Wrapper.fr.drawString(Ocean.NAME + " v" + Ocean.VERSION, 1, 1, 0xFFFFFF);
        renderArrayList();
    }

    private void renderArrayList() {
        int y = 1;
        for (Module m : Ocean.mm.activeMods) {
            m.onRender();
            Wrapper.fr.drawString("[" + Keyboard.getKeyName(m.getBind()) + "] " + m.getName(), 5, y * 10,
                    m.isEnabled() ? 0x00ff7f : Color.RED.getRGB());
            y++;
        }
    }
}
