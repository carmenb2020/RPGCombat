package org.example.Character;

import org.example.Target.Target;
import org.example.Things.Things;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void setAlive(boolean b) {
        this.alive = b;
    }

    ArrayList<String> factions = new ArrayList<String>();

    private int position[] = {0,0};
    @Override
    public int[] getPosition() {
        return position;
    }
    @Override
    public void setPosition(int[] position) {
        this.position = position;
    }


    public void dealDamage(Object object, int damage){
        if (object.getClass() == Character.class){
            if (!(object.equals(this)) && (isAllies((Character) object)==false)){
                int difLevel = ((Character) object).getLevel() - this.getLevel();
                if ( difLevel >= 5) damage /= 2;
                else damage *= 2;
                if (((Character) object).getHealth() <= damage){
                    ((Character) object).setHealth(0);
                    ((Character) object).setAlive(false);
                }
                else {
                    int actHealth = ((Character) object).getHealth();
                    int newHealth = actHealth - damage;
                    ((Character) object).setHealth(newHealth);
                    ((Character) object).setAlive(true);
                }
            }
        }
        else if(object.getClass() == Things.class){
            int newHealth = ((Things) object).getHealth() - damage;
            if (((Things) object).getHealth()>0){
                if (newHealth>0) ((Things) object).setHealth(newHealth);
                else {
                    ((Things) object).setHealth(0);
                    object = null;
                    try {
                        super.finalize();
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void healCharacter(Object object, int heal) {
        if (object.getClass() == Character.class){
            if (object.equals(this) || (isAllies((Character) object) == true)){
                if (((Character) object).getHealth() > 0) {
                    int newHealth = ((Character) object).getHealth() + heal;
                    ((Character) object).setHealth(Math.min(newHealth, 1000));
                }
                else ((Character) object).setAlive(false);
            }
        }
    }

    public void joinFaction(String faction){
        this.factions.add(faction);
    }

    public void leaveFaction(String faction){
        this.factions.remove(faction);
    }

    public Boolean isAllies(Character character){

        List<String> allies = (List<String>) this.factions.stream()
                .filter(element -> character.factions.contains(element))
                .collect(Collectors.toList());

        if (allies.size()>0){
            return true;
        }
        else return false;
    }


}
