package ru.itis.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        Boolean isAuthenticated = false;
        Boolean sessionExist = session != null;
        Boolean isLoginPage = request.getRequestURI().equals("/signIn");

        if (sessionExist) {
            isAuthenticated = (Boolean) session.getAttribute("authenticated");
            if (isAuthenticated == null) {
                isAuthenticated = false;
            }
        }

        if (isAuthenticated && !isLoginPage || !isAuthenticated && isLoginPage) {
            filterChain.doFilter(request,  response);
        } else if (isAuthenticated && isLoginPage){
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/signIn");
        }
    }

    @Override
    public void destroy() {

    }
}
