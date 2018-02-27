    /**
     * original minecraft glazed.terracotta
     */
package net.minecraft.block;

import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

    /**
     * theese two import was not found in glazed terracotta or mcreator java source - but necessary!
     */

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.BlockHorizontal;

    /**
     * mcreator stuff
     */
     
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;


import java.util.Random;

public class mcreator_yellowPaintedAsphalt3 {

     public mcreator_yellowPaintedAsphalt3() {
     }

     public static BlockYellowPaintedAsphalt3 block;

     public static Item item;

     public static Object instance;

     public int addFuel(ItemStack fuel) {
          return 0;
     }

     public void serverLoad(FMLServerStartingEvent event) {
     }

     public void preInit(FMLPreInitializationEvent event) {
          block.setRegistryName("yellowPaintedAsphalt3");
          ForgeRegistries.BLOCKS.register(block);
          item = new ItemBlock(block).setRegistryName(block.getRegistryName());
          ForgeRegistries.ITEMS.register(item);
     }

     public void registerRenderers() {
     }

     public void load(FMLInitializationEvent event) {
          if (event.getSide() == Side.CLIENT) {
               Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                         .register(item, 0, new ModelResourceLocation("testenvironmentmod:yellowPaintedAsphalt3", "inventory"));
          }
     }

     static {

          block = (BlockYellowPaintedAsphalt3) (new BlockYellowPaintedAsphalt3().setHardness(2.0F).setResistance(10.0F).setLightLevel(0.0F)
                    .setUnlocalizedName("yellowPaintedAsphalt3").setLightOpacity(0).setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
          block.setHarvestLevel("pickaxe", 4);
     }

     public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
     }

     public void generateNether(World world, Random random, int chunkX, int chunkZ) {
     }

static class BlockYellowPaintedAsphalt3 extends BlockHorizontal
{   
    boolean red = false;
    
    protected BlockYellowPaintedAsphalt3()
    {


        super(Material.ROCK);
        this.setSoundType(SoundType.STONE);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
        return i;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    public EnumPushReaction getMobilityFlag(IBlockState state)
    {
        return EnumPushReaction.PUSH_ONLY;
    }

          @Override
          public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
               int i = pos.getX();
               int j = pos.getY();
               int k = pos.getZ();
               world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));

          }

          @Override
          public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
               return red ? 15 : 0;
          }

          @Override
          public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
               return red ? 15 : 0;
          }

          @SideOnly(Side.CLIENT)
          @Override
          public BlockRenderLayer getBlockLayer() {
               return BlockRenderLayer.SOLID;
          }

          @Override
          public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
               return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
          }

          @Override
          public int tickRate(World world) {
               return 10;
          }

          @Override
          public int quantityDropped(Random par1Random) {
               return 1;
          }

     }
     
}
