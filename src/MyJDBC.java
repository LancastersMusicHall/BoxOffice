import java.sql.*;
public class MyJDBC {
    public static void main(String[] args) {
        String databaseName = "in2033t04";
        try {
            Connection connection = DriverManager.getConnection(
              "jdbc:mysql://" + databaseName,
                "username",
                    "password"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from table ()");
            while (resultSet.next()) {
                resultSet.getString("table");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
