package com.example.lab13.command.authorization;

import com.example.lab13.command.Command;
import com.example.lab13.command.CommandResult;
import com.example.lab13.session.SessionAttribute;
import com.example.lab13.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

public class SignOutCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(SignOutCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute(SessionAttribute.NAME);
        LOGGER.info("user was above: name:" + username);
        session.removeAttribute(SessionAttribute.NAME);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);

    }
}
