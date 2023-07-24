package org.example.Target;

public class Target {
    public int[] getPosition() {
        return position;
    }

    public void setPosition(int position[]) {
        this.position = position;
    }

    private int position[]={0,0};

    private boolean alive;


    private int health;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level;


    public void setHealth(int health) {
        this.health = health;
    }
}
