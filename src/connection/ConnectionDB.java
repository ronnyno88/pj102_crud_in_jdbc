package connection;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    //variaveis para acesso ao banco de dados
    private static final String NAME_DATABASE = "";
    private static final String PATH_DATABASE = "";
    private static final String PASSWORD= "";
    private static String status = "No connected";
    private static Connection connect = null;
    public ConnectionDB() {
    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        //carregar drive
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //receber parametros de conexão
        try {
            connect = DriverManager.getConnection(PATH_DATABASE, NAME_DATABASE, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //retornar a conexão
        return connect;
    }

    public static void main(String[] args) throws SQLException {
        try {
            Connection connect = createConnection();
        } catch (Exception e){
            System.out.println(status);
            e.printStackTrace();
        }
        try {
            if (connect != null) {
                System.out.println(status = "Connected Sucess");
                connect.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
