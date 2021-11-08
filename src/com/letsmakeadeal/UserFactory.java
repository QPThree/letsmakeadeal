package com.letsmakeadeal;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static User createUser(String name, Reward reward) {
        return new User(name, reward);
    }

}
