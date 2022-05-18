package com.jsorrell.skyblock.helpers;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Set;

public class DolphinFindHeartGoal extends Goal {
  private static final float CHANCE_TO_FIND_HEART_OF_THE_SEA = 0.05f;
  private static final float NUM_DIGS = 10;
  private static final Set<Block> VALID_OCEAN_FLOORS = Set.of(Blocks.SAND, Blocks.GRAVEL);
  private final DolphinEntity dolphin;
  private int digCounter = 0;
  private boolean diggingPhase = false;

  public DolphinFindHeartGoal(DolphinEntity dolphin) {
    this.dolphin = dolphin;
    this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
  }

  @Nullable
  protected BlockPos determineTreasureLocation() {
    // Set Y 0 to make it swim to ocean floor
    BlockPos potentialTarget = new BlockPos(this.dolphin.getBlockX() + this.dolphin.world.random.nextInt(16) - 8, 0, this.dolphin.getBlockZ() + this.dolphin.world.random.nextInt(16) - 8);
    if (Biome.getCategory(this.dolphin.world.getBiome(potentialTarget.withY(this.dolphin.getBlockY()))) == Biome.Category.OCEAN) {
      return potentialTarget;
    }

    return null;
  }

  @Override
  public boolean canStop() {
    return false;
  }

  @Override
  public boolean canStart() {
    return this.dolphin.hasFish() && 100 <= this.dolphin.getAir();
  }

  @Override
  public void start() {
    if (!(this.dolphin.world instanceof ServerWorld world)) {
      return;
    }
    BlockPos treasurePos = this.determineTreasureLocation();
    if (treasurePos == null) {
      this.dolphin.setHasFish(false);
      return;
    }
    this.dolphin.setTreasurePos(treasurePos);

    this.dolphin.getNavigation().startMovingTo(treasurePos.getX(), treasurePos.getY(), treasurePos.getZ(), 0.7);
    world.sendEntityStatus(this.dolphin, (byte) 38);
  }

  @Override
  public void tick() {
    if (!this.diggingPhase && this.dolphin.getNavigation().isIdle()) {
      BlockPos heartPos = new BlockPos(this.dolphin.getTreasurePos().getX(), this.dolphin.getBlockY() - 1, this.dolphin.getTreasurePos().getZ());
      if (this.dolphin.getPos().isInRange(Vec3d.ofBottomCenter(heartPos).add(0, 1, 0), 8) && VALID_OCEAN_FLOORS.contains(this.dolphin.world.getBlockState(heartPos).getBlock())) {
        this.diggingPhase = true;
        this.digCounter = 0;
      } else {
        this.dolphin.setHasFish(false);
      }
    } else if (this.diggingPhase) {
      if (this.digCounter == NUM_DIGS) {
        if (this.dolphin.world.random.nextFloat() < CHANCE_TO_FIND_HEART_OF_THE_SEA) {
          ItemStack heartOfTheSea = new ItemStack(Items.HEART_OF_THE_SEA);
          if (this.dolphin.getEquippedStack(EquipmentSlot.MAINHAND).isEmpty() && this.dolphin.canPickupItem(heartOfTheSea)) {
            this.dolphin.equipStack(EquipmentSlot.MAINHAND, heartOfTheSea);
          }
        }
        this.dolphin.setHasFish(false);
        this.diggingPhase = false;
      } else {
        this.dolphin.world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, this.dolphin.getBlockPos(), Block.getRawIdFromState(this.dolphin.world.getBlockState(this.dolphin.getBlockPos().down())));
        this.digCounter++;
      }
    }
  }
}
