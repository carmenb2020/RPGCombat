package org.example.Melee;

import org.example.Character.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeleeTest {
    Melee melee = new Melee();
    Character character = new Character();
    @Test
    public void characters_have_an_attack_max_range_melee_fighters_have_a_range_of_2_meters(){
        Melee melee = new Melee();
        assertEquals(2,melee.getRange());
    }

    @Test
    public void characters_must_be_in_range_to_deal_damage_to_a_target(){
        melee.setPosition(new int[]{3, 0});
        assertEquals("out_range_to_deal_damage_to_a_target", melee.rangeDamage(character));
    }

}