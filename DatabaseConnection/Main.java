import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/store_java";
        String username = "root";
        String password = "";

        try {
            // Manual class Registering
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                    // 1- Connect to Database
                    Connection connection = DriverManager.getConnection(url, username, password);
                    // 2- Prepare the query
                    Statement statement = connection.createStatement();
            ) {
                String sqlQuery = "INSERT INTO categories (name, description) VALUES " +
                        "('C# category', 'Some text goes here.');";

                // 3- Execute the query
                int numberOfAffectedRows = statement.executeUpdate(sqlQuery);

                // 4- Fetch the result
                if(numberOfAffectedRows == 0){
                    System.out.println("No rows have been affected!");
                }else {
                    System.out.println(numberOfAffectedRows + " row(s) affected!");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            // 5- Close the connection on the end of try-with-resources

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
