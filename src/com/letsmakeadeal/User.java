package com.letsmakeadeal;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    public List<Reward> rewards = new ArrayList<>();

    User (String name,Reward reward){
       setName(name);
       addReward(reward);
    }

    User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addReward(Reward reward) {
        // if statement here is dull reward then empty the array
        if (reward.isZonk()) {
            clearRewards();
        }

        this.rewards.add(reward);
    }

    public void getRewards() {
        for (Reward reward:rewards) {
            System.out.println(reward.getName());
        }
    }

    public void clearRewards() {
        rewards.clear();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "'s Rewards: " + rewards.toString();
    }
}
