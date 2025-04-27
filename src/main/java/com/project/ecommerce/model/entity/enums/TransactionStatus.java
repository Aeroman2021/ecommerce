package com.project.ecommerce.model.entity.enums;

public enum TransactionStatus {
    SUCCESSFUL(1,"SUCCESSFUL"),
    UNSUCCESSFUL(2,"SUCCESSFUL"),
    PENDING(3,"PENDING");


    private int code;
    private String desc;

    TransactionStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static TransactionStatus fromCode(int code) {
        for (TransactionStatus status : TransactionStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code for OrderTypes: " + code);
    }
}
