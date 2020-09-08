package com.scottkillen.mod.dendrology.world.gen.biomes;

import com.scottkillen.mod.dendrology.world.gen.biomes.WorldGenTrees.KiparisBigTreeWorldGen;
import com.scottkillen.mod.dendrology.world.gen.biomes.WorldGenTrees.KiparisWorldGen;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class KiparisGroove extends BiomeGenHills {

    public KiparisGroove() {
        super(20, true);
        this.worldGeneratorTrees = new KiparisWorldGen(false);
        this.worldGeneratorBigTree = new KiparisBigTreeWorldGen(false);
    }

    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return (p_150567_1_.nextInt(10) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees);
    }

}