package com.example.sealing.type;

public enum StatusType {
    CREATING("作成中", 0),
    REQUESTED("申請済み", 1),
    REJECTED("差戻し", 2),
    APPROVED("承認済み", 3);

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
               value == 2 ? StatusType.REJECTED :
               value == 3 ? StatusType.APPROVED : null;
    }

    // action何ていうStatusTypeが知らない概念が入ってるものをここに書くべきじゃないと思う
    public static StatusType getNextStatusTypeByAction(String action) {
        return action.equals("submit") ? StatusType.REQUESTED :
               action.equals("approve") ? StatusType.APPROVED :
               action.equals("reject") ? StatusType.REJECTED : null;
    }
}
