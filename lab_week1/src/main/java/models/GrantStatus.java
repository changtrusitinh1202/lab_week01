package models;

public enum GrantStatus {
    DIASABLE(0),
    ENABLE(1);
    private int value;

    private GrantStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
