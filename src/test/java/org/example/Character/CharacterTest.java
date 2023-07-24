package org.example.Character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.example.Things.Things;

class CharacterTest{

    Character character1 = new Character();
    Character character2 = new Character();

    Things thing = new Things();

    @Test
    public void health_should_start_at_1000(){
        assertTrue(character1.getHealth()>=1000);
    }

    @Test
    public void level_should_start_at_1(){
        assertEquals(1, character1.getLevel());
    }

    @Test
    public void alive_may_be_a_true_o_false_starting_alive(){
        assertTrue(character1.isAlive());
    }

    @Test
    public void characters_can_deal_damage_to_characters_damage_is_subtracted_from_health(){
        int oldHealth = character2.getHealth();
        int damage = 200;
        int newHealth = oldHealth - (damage*2);
        character1.dealDamage(character2, damage);
        assertEquals(newHealth, character2.getHealth());
    }

    @Test
    public void when_damage_received_exceeds_current_Health_Health_becomes_0_and_the_character_dies(){
        int damage = 2100;
        character1.dealDamage(character2, damage);
        assertFalse(character2.isAlive());
    }

    @Test
    public void a_character_can_heal_a_character(){
        int heal = 1000;
        character1.healCharacter(character2,heal);
        assertTrue(character2.isAlive());
    }

    @Test
    public void a_character_dead_characters_cannot_be_healed(){
        character2.setHealth(0);
        character2.healCharacter(character2,1000);
        assertFalse(character2.isAlive());
    }

    @Test
    public void healing_cannot_raise_health_above_1000(){
        character1.healCharacter(character2, 200);
        assertTrue(character2.getHealth() <= 1000);
    }

    @Test
    public void a_character_cannot_deal_damage_to_itself(){
        character1.dealDamage(character1, 1000);
        assertEquals(1000, character1.getHealth());
    }

    @Test
    public void a_character_can_only_heal_itself(){
        character2.setHealth(500);
        character2.healCharacter(character2, 200);
        assertEquals(700, character2.getHealth());
    }

    @Test
    public void if_the_target_is_5_or_more_Levels_above_the_attacker_damage_is_reduced_by_50_per_cent(){
        character2.setLevel(8);
        character1.dealDamage(character2,200);
        assertEquals(900, character2.getHealth());
    }
    @Test
    public void if_the_target_is_5_or_more_Levels_below_the_attacker_damage_is_increased_by_50_per_cent(){
        character1.setLevel(8);
        character1.dealDamage(character2,200);
        assertEquals(600, character2.getHealth());
    }

    @Test
    public void characters_may_belong_to_one_or_more_Factions(){
       Character character1 = new Character();
       assertEquals(0,character1.factions.size());
    }

    @Test
    public void a_character_may_join_one_or_more_factions(){
        character1.joinFaction("faction1");
        assertEquals(true, character1.factions.contains("faction1"));
    }

    @Test
    public void a_character_may_leave_one_or_more_factions(){
        character1.leaveFaction("faction1");
        assertEquals(character1.factions.contains("faction1"), false);
    }

    @Test
    public void players_belonging_to_the_same_faction_are_considered_allies(){
        character1.factions.add("faction1");
        character2.factions.add("faction1");
        assertEquals(true, character1.isAllies(character2));
    }

    @Test
    public void allies_cannot_deal_damage_to_one_another(){
        character1.factions.add("faction1");
        character2.factions.add("faction1");
        character2.setHealth(250);
        character1.dealDamage(character2,250);
        assertEquals(250, character2.getHealth());
    }

    @Test
    public void allies_can_heal_one_another(){
        character1.factions.add("faction1");
        character2.factions.add("faction1");
        character2.setHealth(250);
        character1.healCharacter(character2,250);
        assertEquals(500, character2.getHealth());
    }

    @Test
    public void characters_can_damage_non_character_things_anything_that_has_health_may_be_a_target(){
        thing.setHealth(250);
        character1.dealDamage(thing, 250 );
        assertEquals(0, thing.getHealth());
    }

    @Test
    public void these_things_cannot_be_healed(){
        thing.setHealth(250);
        character1.healCharacter(thing, 500);
        assertEquals(250, thing.getHealth());
    }
}