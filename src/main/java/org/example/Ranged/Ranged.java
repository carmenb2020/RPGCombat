package org.example.Ranged;

import org.example.Character.Character;
import org.example.Target.Target;

public class Ranged  extends Character {
    private int range;
    public Ranged(){
        super();
        this.range = 20;
    }

    public int getRange() {
        return this.range;
    }

    public String rangeDamage(Target target){
        int x;
        x = Math.abs(target.getPosition()[0]-this.getPosition()[0]);
        int y;
        y= Math.abs(target.getPosition()[1]-this.getPosition()[1]);
        double distance = Math.sqrt(x * x + y * y);

        if (this.getRange() >= distance) return "in_range_to_deal_damage_to_a_target";
        else return "out_range_to_deal_damage_to_a_target";
    }

}
