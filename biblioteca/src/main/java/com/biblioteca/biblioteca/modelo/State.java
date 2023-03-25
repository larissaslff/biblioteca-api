package com.biblioteca.biblioteca.modelo;

public enum State {
    MA, PI, CE, SP, RJ, TO, PR, PA;

    public static State stringToEnum(String state){
        if(state == null) {
            return null;
        }
        State.valueOf(state.toUpperCase());
        return State.valueOf(state.toUpperCase());
    }
}
