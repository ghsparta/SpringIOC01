package com.pojo;



public enum State {
    ACTIVE("active"), INACTIVE("inactive"), CLOSED("closed");
    private String state;

    State(String state) {
        this.state = state;
    }
}
//Enum.valueof(State,"ACTIVE") ==> State.ACTIVE
