package com.project.ecommerce.model.entity.enums;

public enum OrderTypes {
    COMPLETED(1,"COMPLETE"),PENDING(2,"PEND"),CANCELED(3,"CANCEL");

    private int code;
    private String desc;

    OrderTypes(int code, String desc) {
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
