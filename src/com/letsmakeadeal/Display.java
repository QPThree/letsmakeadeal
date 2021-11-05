package com.letsmakeadeal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Display {

    public ArrayList<Reward> rewardsArray; //

    public Display(){
        this.rewardsArray = new ArrayList<Reward>(List.of(Reward.values()));
    }

    public static Reward randomRewards() {
        Reward[] prizes = Reward.values();
        int length = prizes.length;
        int randPrizes = new Random().nextInt(length);
        return prizes[randPrizes];
    }
    public ArrayList<Reward> getRewardsArray(){
        return rewardsArray;
    }

    public Reward getRandomReward(){
        Collections.shuffle(getRewardsArray());
        Reward reward = rewardsArray.remove(0);
        return reward;
    }

}
