package com.project.E_Commerce.model.entity.enums;


public enum Region {

    US(1,"US"),
    UK(2,"UK"),
    UAE(3,"UAE");

    private int code;
    private String desc;

    Region(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static OrderTypes fromCode(int code) {
        for (OrderTypes type : OrderTypes.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid code for OrderTypes: " + code);
    }
}
