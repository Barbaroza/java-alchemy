package com.pmb.creating.singleton;

public enum Singleton6Enum {
    SINGLETON5;
    private Singleton5 singleton5;

    Singleton6Enum() {
        singleton5 = Singleton5.getInstance();
    }

    public Singleton5 getInstance() {
        return singleton5;
    }


}
