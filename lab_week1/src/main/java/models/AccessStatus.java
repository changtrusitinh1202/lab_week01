package models;

public enum AccessStatus {
    ACTIVE(1),
    DETECTIVE(0),
    TERMINATED(-1);
    private int value;

     private AccessStatus(int value){
        this.value = value;
    }

    public int  getValue() {
        return value;
    }
}
