package com.letsmakeadeal;

public enum Reward {
    VACATION_TO_HAWAII("7 days Vacation to Hawaii"),
    JEEP_WRANGLER("4X4 Off Road Jeep Wangler"),
    DETROIT_LIONS_NFL_TICKETS("DETROIT Lions home game NFL Tickets for 2"),
    RUBBER_CHICKEN("Yellow Rubber Screaming Chicken"),
    LIFE_TIME_SUPPLY_OF_PENCILS("Life Time Supply of Colorful Pencils"),
    SEVEN_DAY_TRIP_TO_ITALY("7 days luxury trip to Italy"),
    TWO_WEEK_TRIP_TO_DISNEY_WORLD("two week trip to Disney World"),
    CASH_ONE_PRIZES("1,000"),
    CASH_TWO_PRIZES("3,000"),
    CASH_THREE_PRIZES("1 dollar"),
    CASH_FOUR_PRIZES(".50 cents"),
    RAISINS("Raisins");


    // ---- FIELDS ----
    private String name;

    // ---- CONSTRUCTORS ----
    Reward(String name){
        this.name = name;
    }

    // ---- GETTERS SETTERS ----
    public String getName(){
        return this.name;
    }

}
