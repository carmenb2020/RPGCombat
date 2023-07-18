package org.example.Character.Character;

public class Character {
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
    private int damage;

    public void setDamage(int d) {
        this.damage = d;

    }

    private int maxrange;

    public int getMaxrange() {
        return maxrange;
    }

    public void setMaxrange(int maxrange) {
        this.maxrange = maxrange;
    }
    public void dealDamage(Character character, int damage){
        if (!(character.equals(this))){
            int difLevel = character.level - this.level;
            if ( difLevel >= 5) damage /= 2;
            else damage *= 2;
            if (character.health <= damage){
                    character.setHealth(0);
                    character.setAlive(false);
            }
            character.health -= damage;
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