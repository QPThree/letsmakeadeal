package com.letsmakeadeal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {

    Display display;

    @Before
    public void setUp() {
        display = new Display();
    }

    // ---- Constructor() ----

    @Test
    public void display_shouldInstantiateArrayOfRewards_onConstruction() {
        assertEquals(Reward.values().length, display.rewardsArray.size());
    }

    // ---- getRewardsArray() ----
    @Test
    public void getRewardsArray_shouldReturnArray_EqualToRewardsArray(){
        assertEquals(display.getRewardsArray(), display.rewardsArray);
    }

    // ---- getRandomReward() ----

    @Test
    public void getRandomReward_shouldReturnTypeReward_whenCalled() {
        assertTrue(display.getRandomReward() instanceof Reward);
    }

    @Test
    public void getRandomReward_shouldDecreaseRewardArrayLength_whenRewardReturned(){
        int size = display.getRewardsArray().size();
        display.getRandomReward();

        assertEquals(size -1, display.getRewardsArray().size());
    }

    @Test
    public void getRandomReward_shouldRemoveRewardFromArray_whenRewardIsReturned(){
        Reward reward = display.getRandomReward();

        assertTrue(!display.getRewardsArray().contains(reward));
    }


}