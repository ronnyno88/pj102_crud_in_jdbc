package DAO;

import connection.ConnectionDB;
import model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDAO {
    private Connection connect = null;
    private PreparedStatement pstm = null;
    private ResultSet res = null;

    public void createPerson(Person person){
        String sql = "INSERT INTO person (name, age) VALUES (?,?)";
        try {
            connect = ConnectionDB.createConnection();
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, person.getName());
            pstm.setInt(2, person.getAge());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connect.close();
                pstm.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void readPerson(){
        String sql = "SELECT * FROM person";
        try {
            connect = ConnectionDB.createConnection();
            pstm = connect.prepareStatement(sql);
            res = pstm.executeQuery();
            while (res.next()){
                Integer id = res.getInt("id");
                String name = res.getString("name");
                Integer age = res.getInt("age");
                System.out.println("id- "+id+"name- "+name+"age- "+age);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connect.close();
                pstm.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void updatePerson(Person person){
        String sql = "UPDATE person SET name=?, age=? WHERE id=?";
        try {
            connect = ConnectionDB.createConnection();
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, person.getName());
            pstm.setInt(2, person.getAge());
            pstm.setInt(3, person.getId());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connect.close();
                pstm.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void deletePerson(Person person){
        String sql = "DELETE person WHERE id=?";
        try {
            connect = ConnectionDB.createConnection();
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, person.getId());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connect.close();
                pstm.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
