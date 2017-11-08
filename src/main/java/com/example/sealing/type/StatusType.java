package com.example.sealing.type;

public enum StatusType {
    CREATING("作成中", 0),
    REQUESTED("申請済", 1),
    APPROVED("承認済み", 2);

    private final String name;
    private final Integer value;

    StatusType(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public static StatusType getStatusTypeByValue(Integer value) {
        return value == 0 ? StatusType.CREATING :
               value == 1 ? StatusType.REQUESTED :
               value == 2 ? StatusType.APPROVED : null;
    }
}
