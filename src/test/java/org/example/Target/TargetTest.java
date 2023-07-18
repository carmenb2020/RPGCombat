package org.example.Target;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetTest {
    @Test
    public void target_position(){
        Target target = new Target();
        int position = target.getPosition().length;
        assertEquals(2,position);
    }
}