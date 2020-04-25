package io.github.cadiboo.examplemod.block;

import io.github.cadiboo.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class MyBlock extends Block {

	private ServerWorld world;

	public MyBlock(final Properties properties) {
		super(properties);
		//ExampleMod.LOGGER.debug("AAAAA myBlock");
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		//ExampleMod.LOGGER.debug("BBBBB pos=" + pos.toString());
		//ExampleMod.LOGGER.debug("BBBBB pos.DOWN=" + pos.down().toString());
		BlockState newBlockState = world.getBlockState(pos.down());  // 取得我們要複製的方塊資訊，即Y軸往下一格處的方塊
		world.setBlockState(pos, newBlockState, 8); //將我們的方塊做變化

/*
		// 增加一點閃電特效, 結果變成閃電後果  到處著火 (client 端)
		// 閃電特效只有在server端才會出現, 所以要用ServerWorld world, this.world, 並且mod 用在server上
		if (world.isRemote) {
			LightningBoltEntity lightningBolt = new LightningBoltEntity(
					(ServerWorld) world,
					pos.getX(),
					pos.getY(),
					pos.getZ(),
					true
			);
			//world.addWeatherEffect(lightningBolt);
			//world.addEntity(lightningBolt); //只有聲音
			((ServerWorld) world).addLightningBolt(lightningBolt);
		}
*/
	}
}

/*
	@Override
	public void onBlockHarvested(World world,BlockPos pos,BlockState state, PlayerEntity player){
		ExampleMod.LOGGER.debug("DDDDD pos="+pos.toString());
		ExampleMod.LOGGER.debug("DDDDD pos.DOWN="+pos.down().toString());
		BlockState newBlockState = world.getBlockState(pos.down());
		world.setBlockState(pos, newBlockState,8 );
	}
 */
	/*
	@Override
	public void onBlockAdded(BlockState state,World world,BlockPos pos, BlockState oldstate, boolean isMoving) {
		ExampleMod.LOGGER.debug("CCCCC pos="+pos.toString());
		ExampleMod.LOGGER.debug("CCCCC pos.DOWN="+pos.down().toString());
		//BlockState newBlockState = world.getBlockState(pos.down());
		//world.setBlockState(pos, newBlockState);
	}

	 */




	/*
	public void onBlockAdded(World world, BlockPos pos, BlockState state) {
	    // 取得我們要複製的方塊資訊，即Y軸往下一格處的方塊
	    //BlockState newBlockState = world.getBlockState(pos.offset(EnumFacing.DOWN));
		BlockState newBlockState = world.getBlockState(pos.down());
	    // 將我們的方塊做變化
	    world.setBlockState(pos, newBlockState);

	    // 增加一點閃電特效
	    EntityLightningBolt lightningBolt = new EntityLightningBolt(
	            world,
	            pos.getX(),
	            pos.getY(),
	            pos.getZ()
	    );
	    world.addWeatherEffect(lightningBolt);
	}
	 */


