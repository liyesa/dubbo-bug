package me.liye;


import java.io.Serializable;

/**
 * @author ye.ly@shopastro-inc.com
 */


public class Foo implements Serializable {

    boolean success = true;

    boolean success1 = true;
    boolean success2;

    boolean success3;
    String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess1() {
        return success1;
    }

    public void setSuccess1(boolean success1) {
        this.success1 = success1;
    }

    public boolean isSuccess2() {
        return success2;
    }

    public void setSuccess2(boolean success2) {
        this.success2 = success2;
    }

    public boolean isSuccess3() {
        return success3;
    }

    public void setSuccess3(boolean success3) {
        this.success3 = success3;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}