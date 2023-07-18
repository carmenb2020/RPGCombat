package org.example.Character;

import org.example.Target.Target;

public class Character extends Target{
    private int health = 1000;
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    private int level = 1;
    public int getLevel() {
        return level;
    }
    public void setLevel(int i) {
        this.level = i;
    }

    private boolean alive = true;
    public boolean isAlive() {
        return alive;
    }
    private void setAlive(boolean b) {
        this.alive = b;
    }


    private int maxRange;

    private int position[] = {0,0};
    @Override
    public int[] getPosition() {
        return position;
    }
    @Override
    public void setPosition(int[] position) {
        this.position = position;
    }


    public void dealDamage(Character character, int damage){
        if (!(character.equals(this))){
            int difLevel = character.getLevel() - this.getLevel();
            if ( difLevel >= 5) damage /= 2;
            else damage *= 2;
            if (character.getHealth() <= damage){
                    character.setHealth(0);
                    character.setAlive(false);
            }
            else {
                int actHealth = character.getHealth();
                int newHealth = actHealth - damage;
                character.setHealth(newHealth);
                character.setAlive(true);
            }
        }

    }

    public void healCharacter(Character character2, int heal) {
        if (character2.equals(this)){
            if (character2.getHealth() > 0) {
                int newHealth = character2.getHealth() + heal;
                character2.setHealth(Math.min(newHealth, 1000));
            }
            else character2.setAlive(false);
        }
    }


}
