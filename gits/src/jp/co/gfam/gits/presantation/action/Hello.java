package jp.co.gfam.gits.presantation.action;

import com.opensymphony.xwork2.ActionSupport;

public class Hello extends ActionSupport {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Hello World !!";

    public String execute() throws Exception {
        setMessage(MESSAGE);
        return "success";
    }

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
