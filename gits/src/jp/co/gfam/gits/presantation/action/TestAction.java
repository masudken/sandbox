package jp.co.gfam.gits.presantation.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport {
    private String message;

    public String getMessage() {
        return message;
    }

    public String execute() throws Exception {
        message = "てすと";

        return SUCCESS;
    }
}
