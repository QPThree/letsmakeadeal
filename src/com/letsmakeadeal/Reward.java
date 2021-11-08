package com.letsmakeadeal;

public enum Reward {
    VACATION_TO_HAWAII("7 days Vacation to Hawaii",false),
    JEEP_WRANGLER("4X4 Off Road Jeep Wangler",false),
    DETROIT_LIONS_NFL_TICKETS("DETROIT Lions home game NFL Tickets for 2",false),
    SEVEN_DAY_TRIP_TO_ITALY("7 days luxury trip to Italy",false),
    TWO_WEEK_TRIP_TO_DISNEY_WORLD("2 week trip to Disney World",false),
    CASH_ONE_PRIZES("$1,000",false),
    CASH_TWO_PRIZES("$3,000",false),
    LIFE_TIME_SUPPLY_OF_PENCILS("Life Time Supply of Colorful Pencils",true),
    RUBBER_CHICKEN("Yellow Rubber Screaming Chicken",true),
    CASH_THREE_PRIZES("$1",true),
    CASH_FOUR_PRIZES(".50 cents",true),
    RAISINS("Raisins",true);


    // ---- FIELDS ----
    private String name;
    private boolean zonk;


    // ---- CONSTRUCTORS ----
    Reward(String name,boolean zonk){
        this.name = name;
        this.zonk=zonk;

    }

    // ---- GETTERS SETTERS ----
    public String getName(){
        return this.name;
    }

    public boolean isZonk() {
        return zonk;
    }

    public void setZonk(boolean zonk) {
        this.zonk = zonk;
    }
}
