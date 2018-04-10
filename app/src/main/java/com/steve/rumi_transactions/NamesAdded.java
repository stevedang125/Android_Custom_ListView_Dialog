package com.steve.rumi_transactions;

import java.util.ArrayList;

/**
 * Created by Steve on 4/9/2018.
 */

// Object class to store all the names that will pay for the bill

public class NamesAdded {
    private String name;

    public NamesAdded(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}