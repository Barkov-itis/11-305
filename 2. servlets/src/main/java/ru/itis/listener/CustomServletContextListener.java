package ru.itis.listener;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.repositories.SignUpService;
import ru.itis.repositories.SignUpServiceImpl;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CustomServletContextListener implements ServletContextListener {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "gjhfqr102";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb_3";
    private static final String DB_DRIVER = "org.postgres.Driver";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        servletContext.setAttribute("usersRep", usersRepository);
        SignUpService signUpService = new SignUpServiceImpl(usersRepository);
        servletContext.setAttribute("signUpService", signUpService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
