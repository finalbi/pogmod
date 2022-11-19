package com.finalbi.pog.datagen;

import com.finalbi.pog.common.glyphs.PogEffect;
import com.hollingsworth.arsnouveau.api.RegistryHelper;
import com.hollingsworth.arsnouveau.common.crafting.recipes.GlyphRecipe;
import com.hollingsworth.arsnouveau.setup.BlockRegistry;
import com.hollingsworth.arsnouveau.setup.ItemsRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.io.IOException;
import java.nio.file.Path;

public class GlyphRecipeProvider extends com.hollingsworth.arsnouveau.common.datagen.GlyphRecipeProvider {
    public GlyphRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public void run(HashCache cache) throws IOException {
        recipes.add(get(PogEffect.INSTANCE).withIngredient());
        Path outputBase = generator.getOutputFolder();
        for (GlyphRecipe recipe : recipes){
            DataProvider.save(GSON ,cache, recipe.asRecipe(), getScribeGlyphPath(outputBase, recipe.output.getItem()));
        }
    }
}
