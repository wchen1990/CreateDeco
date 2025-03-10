package com.github.talrey.createdeco.connected;

import com.github.talrey.createdeco.Registration;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.HorizontalCTBehaviour;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

public class SheetMetalCTBehaviour extends HorizontalCTBehaviour {
  public SheetMetalCTBehaviour (CTSpriteShiftEntry layerShift) { super (layerShift); }
  public SheetMetalCTBehaviour (CTSpriteShiftEntry layerShift, CTSpriteShiftEntry topShift) { super(layerShift, topShift); }

  @Override
  public boolean connectsTo(BlockState state, BlockState other, IBlockDisplayReader reader, BlockPos pos, BlockPos otherPos, Direction face) {

    if (!face.getAxis().isVertical() && super.connectsTo(state, other, reader, pos, otherPos, face)) {
      return true;
    }
    else return isSameMaterial(state, other);
  }

  protected boolean isSameMaterial (BlockState state, BlockState other) {
    Block me = state.getBlock();
    Block it = other.getBlock();
    String material = me.getRegistryName().toString().replace("createdeco:","");
    return it.getRegistryName().toString().replace("createdeco:","").startsWith(material.substring(0, material.indexOf("_")));
  }
}
