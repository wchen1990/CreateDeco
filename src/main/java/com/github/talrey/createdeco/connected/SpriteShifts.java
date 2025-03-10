package com.github.talrey.createdeco.connected;

import com.github.talrey.createdeco.CreateDecoMod;
import com.github.talrey.createdeco.Registration;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter.CTType;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

public class SpriteShifts {
  public static final HashMap<String, CTSpriteShiftEntry> SHEET_METAL_SIDES = new HashMap<>();
  public static final HashMap<String, CTSpriteShiftEntry> CATWALK_TOPS      = new HashMap<>();

  static {
    populateMaps();
  }

  private static void populateMaps () {
    for (String metal : Registration.METAL_TYPES.keySet()) {
      String path = "palettes/sheet_metal/" + metal.toLowerCase() + "_sheet_metal";
      ResourceLocation blockTexture = new ResourceLocation(CreateDecoMod.MODID, "block/" + path);
      SHEET_METAL_SIDES.put(metal, CTSpriteShifter.getCT(CTType.VERTICAL, blockTexture, path));

      path = "palettes/catwalks/" + metal.toLowerCase() + "_catwalk";
      blockTexture = new ResourceLocation(CreateDecoMod.MODID, "block/" + path);
      CATWALK_TOPS.put(metal, CTSpriteShifter.getCT(CTType.OMNIDIRECTIONAL, blockTexture, path));
    }
  }
}
