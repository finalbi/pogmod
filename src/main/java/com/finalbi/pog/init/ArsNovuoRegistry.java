package com.finalbi.pog.init;

import com.finalbi.pog.Main;
import com.finalbi.pog.common.glyphs.PogEffect;
import com.hollingsworth.arsnouveau.api.ArsNouveauAPI;
import com.hollingsworth.arsnouveau.api.spell.AbstractSpellPart;

import java.util.ArrayList;
import java.util.List;

public class ArsNovuoRegistry {
    public static List<AbstractSpellPart> registeredSpells = new ArrayList<>();

    public static void registerGlyphs() {
        register(PogEffect.INSTANCE);
    }
    public static void register(AbstractSpellPart spellPart) {
        // anti-derp assertion
        if (!Main.MODID.equals(spellPart.getRegistryName().getNamespace())) {
            Main.LOGGER.atFatal().log("Unintended unsafe glyph namespace '{}' found in glyph '{}'.",
                    spellPart.getRegistryName().getNamespace(),
                    spellPart.getRegistryName().getPath());
            throw new AssertionError();
        }
        if (!"glyph_".equals(spellPart.getRegistryName().getPath().substring(0, 6))) {
            Main.LOGGER.atFatal().log("Unintended unsafe glyph name '{}' does not begin with 'glyph_'.",
                    spellPart.getRegistryName().getPath());
            throw new AssertionError();
        }
        ArsNouveauAPI.getInstance().registerSpell(spellPart);
        registeredSpells.add(spellPart);
    }
}
