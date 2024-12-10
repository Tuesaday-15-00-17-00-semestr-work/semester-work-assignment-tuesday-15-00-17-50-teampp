package com.example.demo;

public class GlobalData {

    // Private static instance of the class
    private static GlobalData instance;

    // Your global value (can be any type)
    private String globalValue;

    // Private constructor to prevent instantiation
    private GlobalData() {
        globalValue = "Default Value"; // Set the initial value
    }

    // Public method to get the single instance of the class
    public static GlobalData getInstance() {
        if (instance == null) {
            instance = new GlobalData();
        }
        return instance;
    }

    // Getter and Setter for the global value
    public String getGlobalValue() {
        return globalValue;
    }

    public void setGlobalValue(String globalValue) {
        this.globalValue = globalValue;
    }
}

/*
public class ValueToPass {

    String value;

    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
*/

