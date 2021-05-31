package com.example.lab13.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
        CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
