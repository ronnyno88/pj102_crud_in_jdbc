package connection;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionDB {
    //variaveis para acesso ao banco de dados
    private static final String NAME_DATABASE = "root";
    private static final String PATH_DATABASE = "jdbc:mysql://localhost:3306/java";
    private static final String PASSWORD= "1234";
    private static Connection connect = null;
    public ConnectionDB() {
    }

    public static void verificationStatus(Connection connection){
        if (connection == null){
            System.out.println("No connected");
        }
        System.out.println("Sucess connected");
    }

    public static Connection createConnection() throws Exception {
        //carregar drive
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(PATH_DATABASE, NAME_DATABASE, PASSWORD);
            verificationStatus(connect);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //retornar a conexão
        return connect;
    }

    public static void main(String[] args) throws Exception {
        try {
            connect = createConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
