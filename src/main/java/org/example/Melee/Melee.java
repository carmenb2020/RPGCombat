package org.example.Character.Melee;

import org.example.Character.Character.Character;

public class Melee extends Character {

    @Override
    public int setMaxrange(int maxrange) {
        return super.setMaxrange(20);
    }
    public int getMaxRange() {
        return 20;
    }
}
