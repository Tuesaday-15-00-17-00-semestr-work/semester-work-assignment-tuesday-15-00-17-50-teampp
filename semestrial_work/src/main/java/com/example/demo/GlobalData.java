package com.example.demo;

public class GlobalData {

    private static GlobalData instance;

    private String globalValue;

    private GlobalData() {
        globalValue = "Default Value";
    }

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

