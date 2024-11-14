import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class MainRepository {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "gjhfqr102";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb_3";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        UserRepository userRepository = new UsersRepositoryJdbcImpl(connection);

        List<User> users = userRepository.findAll();

        users.forEach(user -> System.out.println(user.getFirstName()));


    }



}
