package com.example.lab13.command.authorization;

import com.example.lab13.command.Command;
import com.example.lab13.command.CommandResult;
import com.example.lab13.db.UserDAO;
import com.example.lab13.model.User;
import com.example.lab13.util.pages.Page;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.logging.Logger;

import static com.example.lab13.command.authorization.constatns.AuthConstants.*;
import static java.util.Objects.nonNull;

public class RegisterNewUserCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(RegisterNewUserCommand.class.getName());
    private CommandResult forwardToRegisterWithError(HttpServletRequest request, String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
    private CommandResult forwardToLogin(HttpServletRequest request) {
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = request.getParameter(NAME_FOR_REGISTER);
        String password = request.getParameter(PASSWORD_FOR_REGISTER);

        if (!nonNull(login) || !nonNull(password)) {
            LOGGER.info("invalid login or password format was received:" + login + " " + password);
            return forwardToRegisterWithError(request, REGISTER_ERROR, ERROR_MESSAGE_TEXT);
        }
        String hashPassword = DigestUtils.md5Hex(password);
        User user = new User(login, hashPassword);
        UserDAO userDAO = (UserDAO) request.getServletContext().getAttribute("userDAO");
        int userCount = userDAO.insert(user);
        if (userCount != 0) {
            LOGGER.info("user was registered: login:" + login + " password:" + password);
            return forwardToLogin(request);
        } else {
            LOGGER.info("invalid login or password format was received:" + login + " " + password);
            return forwardToRegisterWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
        }
    }
}
