package com.github.talrey.createdeco.connected;

import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

public class SheetMetalSlabCTBehaviour extends SheetMetalCTBehaviour {
  public SheetMetalSlabCTBehaviour (CTSpriteShiftEntry layerShift) { super (layerShift); }
  public SheetMetalSlabCTBehaviour (CTSpriteShiftEntry layerShift, CTSpriteShiftEntry topShift) { super(layerShift, topShift); }

  @Override
  public boolean connectsTo(BlockState state, BlockState other, IBlockDisplayReader reader, BlockPos pos, BlockPos otherPos, Direction face) {
    if (slabTouching(state, pos, other, otherPos) && super.connectsTo(state, other, reader, pos, otherPos, face)) {
      return true;
    }
    else return isSameMaterial(state, other);
  }

  protected boolean slabTouching (BlockState state, BlockPos pos, BlockState other, BlockPos otherPos) {
    if (!other.contains(BlockStateProperties.SLAB_TYPE)) return false;
    switch (state.get(BlockStateProperties.SLAB_TYPE)) {
      case TOP:
        return !other.get(BlockStateProperties.SLAB_TYPE).equals(SlabType.TOP);
      case BOTTOM:
        return !other.get(BlockStateProperties.SLAB_TYPE).equals(SlabType.BOTTOM);
      case DOUBLE:
        if (pos.getY() - otherPos.getY() > 0) { // we're above them
          return !other.get(BlockStateProperties.SLAB_TYPE).equals(SlabType.BOTTOM);
        }
        else return !other.get(BlockStateProperties.SLAB_TYPE).equals(SlabType.TOP);
    }
    return false;
  }
}
