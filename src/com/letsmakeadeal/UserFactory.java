package com.letsmakeadeal;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    //all static factory class
    private UserFactory(){};

    public static User createUser(String name, Reward reward) {
        return new User(name, reward);
    }

}
