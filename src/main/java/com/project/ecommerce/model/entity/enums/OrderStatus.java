package com.project.ecommerce.model.entity.enums;

public enum OrderStatus {
    COMPLETED(1,"COMPLETEED"),PENDING(2,"PENDING"),CANCELED(3,"CANCELED");

    private int code;
    private String desc;

    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static OrderStatus fromCode(int code) {
        for (OrderStatus type : OrderStatus.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid code for OrderTypes: " + code);
    }
}
