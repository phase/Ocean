package xyz.jadonfowler.ocean.module;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import org.lwjgl.input.Keyboard;
import xyz.jadonfowler.ocean.utils.Wrapper;

public class KillAura extends Module {

    public KillAura() {
        super("KillAura", Keyboard.KEY_K, Category.COMBAT);
    }

    public void onUpdate() {
        if (this.isEnabled()) aura();
    }

    int delay;

    private void aura() {
        List list = Wrapper.mc.theWorld.loadedEntityList;
        delay++;
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i) instanceof EntityLivingBase)) continue;
            if (((EntityLivingBase) list.get(i)).getName() == Wrapper.mc.thePlayer.getName()) continue;
            Entity p = (Entity) list.get(1);
            if (Wrapper.mc.thePlayer.getDistanceToEntity(p) > Wrapper.mc.thePlayer.getDistanceToEntity((Entity) list
                    .get(i))) p = (EntityLivingBase) list.get(i);
            if (!(p instanceof EntityLivingBase)) continue;
            float f = Wrapper.mc.thePlayer.getDistanceToEntity(p);
            if (f < 4 && Wrapper.mc.thePlayer.canEntityBeSeen(p) && delay > 7) {
                faceEntity((EntityLivingBase)p);
                Wrapper.mc.playerController.attackEntity(Wrapper.mc.thePlayer, p);
                Wrapper.mc.thePlayer.swingItem();
            }
        }
    }

    private synchronized void faceEntity(EntityLivingBase p) {
        final float[] rotations = getRotationNeeded(p);
        if (rotations != null) {
            Wrapper.mc.thePlayer.rotationYaw = rotations[0];
            Wrapper.mc.thePlayer.rotationPitch = rotations[1] + 1.0f;
        }
    }

    private float[] getRotationNeeded(EntityLivingBase p) {
        if (p == null) return null;
        double dx = p.posX - Wrapper.mc.thePlayer.posX;
        double dy = p.posY + p.getEyeHeight() - Wrapper.mc.thePlayer.posY + Wrapper.mc.thePlayer.getEyeHeight();
        double dz = p.posZ - Wrapper.mc.thePlayer.posZ;
        if (p instanceof EntityLivingBase) {
            final EntityLivingBase entityLivingBase = (EntityLivingBase) p;
            dy = entityLivingBase.posY + entityLivingBase.getEyeHeight() - (Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight());
        } else {
            dy = (p.boundingBox.minY + p.boundingBox.maxY) / 2.0D - (Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight());
        }
        double d = MathHelper.sqrt_double(dx * dx + dz * dz);
        float yaw = (float) (Math.atan2(dz, dx) * 180d / Math.PI) - 90;
        float pitch = (float) -(Math.atan2(dy, d) * 180d / Math.PI);
        return new float[] {
                Wrapper.mc.thePlayer.rotationYaw
                        + MathHelper.wrapAngleTo180_float(yaw - Wrapper.mc.thePlayer.rotationYaw),
                Wrapper.mc.thePlayer.rotationPitch
                        + MathHelper.wrapAngleTo180_float(pitch - Wrapper.mc.thePlayer.rotationPitch) };
    }
}
