package com.example.resttemplate.resttemplateexample.exception;

public enum BaseExceptionEnum {

    ALREADYEXISTS_EXCEPTION("1000","Data already exist!"),
    DATA_NOTFOUND_EXCEPTION("1001","Data not found!");

    private String code;
    private String value;

    BaseExceptionEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
