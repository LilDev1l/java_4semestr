package com.example.lab13.grouppresons;

import com.example.lab13.command.Command;
import com.example.lab13.command.CommandResult;
import com.example.lab13.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
/*        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }*/
        return new CommandResult(Page.WELCOME_PAGE.getPage());
    }
}
