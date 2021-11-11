package com.letsmakeadeal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    public User user;

    @Before
    public void setUp() {
        user = new User();
    }

    // ---- addReward() ----
    @Test
    public void addReward_shouldIncreaseArrayLength_whenRewardIsAdded() {

        user.addReward(Reward.CASH_FOUR_PRIZES);
        assertEquals(1, user.getRewards().size());

        user.addReward(Reward.JEEP_WRANGLER);
        assertEquals(2, user.getRewards().size());
    }

    @Test
    public void addReward_shouldClearRewards_whenZonkRewardIsAdded() {
        user.addReward(Reward.JEEP_WRANGLER);
        user.addReward(Reward.CASH_ONE_PRIZES);

        user.addReward(Reward.RAISINS);//zonk reward
        assertEquals(1, user.getRewards().size());
    }

    // ---- clearRewards() ----
    @Test
    public void clearRewards_shouldEmptyArrayList_whenArrayHasRewards(){
        user.addReward(Reward.JEEP_WRANGLER);
        user.addReward(Reward.CASH_TWO_PRIZES);

        user.clearRewards();
        assertEquals(0, user.getRewards().size());
    }





}