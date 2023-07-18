package org.example.Ranged;

import org.example.Character.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangedTest {

    Ranged ranged = new Ranged();
    Character character = new Character();
    @Test
    public void characters_have_an_attack_max_range_ranged_fighters_have_a_range_of_20_meters(){
        Ranged ranged = new Ranged();
        assertEquals(20,ranged.getRange());
    }
    @Test
    public void characters_must_be_in_range_to_deal_damage_to_a_target(){
        ranged.setPosition(new int[]{3, 0});
        assertEquals("in_range_to_deal_damage_to_a_target", ranged.rangeDamage(character));
    }

}