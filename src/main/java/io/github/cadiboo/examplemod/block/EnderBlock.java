package io.github.cadiboo.examplemod.block;

import io.github.cadiboo.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.EyeOfEnderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.server.ServerWorld;

public class EnderBlock extends Block {


	public EnderBlock(final Properties properties) {
		super(properties);
		ExampleMod.LOGGER.debug("FFFFF hello EnderBlock");
	}



	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult rayTraceResult) {
		ExampleMod.LOGGER.debug("FFFFF hello onBlockActivated");
		if (worldIn.isRemote) {
			ExampleMod.LOGGER.debug("FFFFF onBlockActivated: into !isRemote loop");
			EyeOfEnderEntity eye = new EyeOfEnderEntity(
					worldIn,
					pos.getX() + 0.5,
					pos.getY() + 1.5,
					pos.getZ() + 0.5
			);

			// 讓終界之眼緩緩升起 ,  不過目前沒有發現終界之眼出現
			//eye.setMotion(0,0.1,0);
			//eye.motionY = 0.1;
			//worldIn.spawnEntityInWorld(eye);
			worldIn.addEntity(eye);

			return ActionResultType.SUCCESS;
			//return true;
		} else {
			// 伺服器端，不做任何事
			ExampleMod.LOGGER.debug("FFFFF onBlockActivated: into isRemote loop");
			return ActionResultType.FAIL;
		}


	}
}



