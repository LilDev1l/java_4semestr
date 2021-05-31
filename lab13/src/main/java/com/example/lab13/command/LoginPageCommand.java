package com.example.lab13.command;

import com.example.lab13.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageCommand implements Command{

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("LOGIN PAGE");
        return new CommandResult(Page.LOGIN_PAGE.getPage(),false);
    }
}
