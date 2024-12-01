package ru.itis.servlets;

import ru.itis.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private List<User> users;

    @Override
    public void init() throws ServletException {
        users = new ArrayList<>();
        User userOne = User.builder()
                .id(1L)
                .firstName("Danil")
                .lastName("Smirnov")
                .age(22)
                .build();

        User userTwo = User.builder()
                .id(2L)
                .firstName("Dima")
                .lastName("Petrov")
                .age(18)
                .build();

        User userThree = User.builder()
                .id(3L)
                .firstName("Kirill")
                .lastName("Egikov")
                .age(25)
                .build();

        users.add(userOne);
        users.add(userTwo);
        users.add(userThree);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        PrintWriter writer = resp.getWriter();


//        StringBuilder resultHtml = new StringBuilder();
//
//                resultHtml.append("<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>Users</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "<h1>Users</h1>\n" +
//                "<div>\n" +
//                "    <table>\n" +
//                "        <tr>\n" +
//                "            <th>ID</th>\n" +
//                "            <th>FIRST NAME</th>\n" +
//                "            <th>LAST NAME</th>\n" +
//                "            <th>AGE</th>\n" +
//                "        </tr>\n");
//
//                for (User user : users) {
//                    resultHtml.append("<tr>\n");
//                    resultHtml.append("<td>").append(user.getId()).append("</td>\n");
//                    resultHtml.append("<td>").append(user.getFirstName()).append("</td>\n");
//                    resultHtml.append("<td>").append(user.getLastName()).append("</td>\n");
//                    resultHtml.append("<td>").append(user.getAge()).append("</td>\n");
//                    resultHtml.append("</tr>");
//                }
//
//                resultHtml.append("    </table>\n" +
//                "</div>\n" +
//                "</body>\n" +
//                "</html>");
//
//                writer.write(resultHtml.toString());
        req.setAttribute("usersForJsp", users);
        HttpSession httpSession= req.getSession();
        System.out.println(httpSession.getAttribute("authenticated"));
        req.getRequestDispatcher("/jsp/users.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
