package com.scottkillen.mod.dendrology.world.gen.biomes.WorldGenTrees;

import com.scottkillen.mod.dendrology.content.overworld.OverworldTreeSpecies;
import com.scottkillen.mod.dendrology.world.gen.feature.KiparisTree;
import com.scottkillen.mod.koresample.tree.DefinesTree;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class KiparisWorldGen extends WorldGenTrees {

    KiparisTree kiparisTree;

    public KiparisWorldGen(boolean p_i2027_1_) {
        super(p_i2027_1_);
        this.kiparisTree = new KiparisTree(p_i2027_1_);
        this.kiparisTree.setTree(OverworldTreeSpecies.KIPARIS);
    }

    @Override
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
        return kiparisTree.generate(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_);
    }

    public void setTree(DefinesTree tree) {
        kiparisTree.setTree(tree);
    }

    @Override
    public String toString() {
        return kiparisTree.toString();
    }

    @Override
    public void func_150524_b(World p_150524_1_, Random p_150524_2_, int p_150524_3_, int p_150524_4_, int p_150524_5_) {
        kiparisTree.func_150524_b(p_150524_1_, p_150524_2_, p_150524_3_, p_150524_4_, p_150524_5_);
    }

    @Override
    public void setScale(double p_76487_1_, double p_76487_3_, double p_76487_5_) {
        kiparisTree.setScale(p_76487_1_, p_76487_3_, p_76487_5_);
    }
}
