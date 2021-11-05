package com.letsmakeadeal;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    public List<Reward> rewards=new ArrayList<>();

    public User (String name,Reward reward){
       setName(name);
       addReward(reward);
    }

    public User() {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void addReward(Reward reward) {
        // if statement here is dull reward then empty the array
        if (reward.isZonk()) {
            clearRewards();
            System.out.println("Rewards cleared");
        }

        this.rewards.add(reward);
        System.out.println("Reward added to the user");
    }

    public void getRewards() {
        for (Reward reward:rewards) {
            System.out.println(reward.getName());
        }
    }

    private void clearRewards() {
        rewards.clear();
    }

    public String getName() {
        return name;
    }

}
