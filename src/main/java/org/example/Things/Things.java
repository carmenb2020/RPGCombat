package org.example.Things;

import org.example.Target.Target;

public class Things  extends Target {

    private Integer health;
    public void setHealth(int health) {
        this.health = health;
    }
    public Integer getHealth() {
        return health;
    }

    private int position[] = {0,0};
    @Override
    public int[] getPosition() {
        return position;
    }
    @Override
    public void setPosition(int[] position) {
        this.position = position;
    }

}
