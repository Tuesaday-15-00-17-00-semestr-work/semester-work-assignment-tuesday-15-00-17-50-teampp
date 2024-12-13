package com.example.demo.book;

import com.example.demo.GlobalData;

public class GlobalId {
    private static GlobalId instance;

    private int globalValue;

    private GlobalId() {
        globalValue = -1;
    }

    public static GlobalId getInstance() {
        if (instance == null) {
            instance = new GlobalId();
        }
        return instance;
    }

    // Getter and Setter for the global value
    public int getGlobalId() {
        return globalValue;
    }

    public void setGlobalId(int globalValue) {
        this.globalValue = globalValue;
    }
}
