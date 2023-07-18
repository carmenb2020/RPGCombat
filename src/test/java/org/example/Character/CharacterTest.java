package org.example.Character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest{

    Character character1 = new Character();
    Character character2 = new Character();

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


}