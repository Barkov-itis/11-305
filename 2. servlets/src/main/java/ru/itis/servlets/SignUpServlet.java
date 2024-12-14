package ru.itis.servlets;

import ru.itis.dto.SignUpForm;
import ru.itis.service.SignUpService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private SignUpService signUpService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        signUpService = (SignUpService) config.getServletContext().getAttribute("signUpService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/html/signUp.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        Integer age = Integer.valueOf(req.getParameter("age"));

        SignUpForm signUpForm = SignUpForm.builder()
                .firstName(name)
                .lastName(surname)
                .email(login)
                .password(pass)
                .age(age)
                .build();
        try {
            signUpService.signUp(signUpForm);
            resp.sendRedirect("/signIn");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
