import DAO.PersonDAO;
import model.Person;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PersonDAO dao = new PersonDAO();
        dao.deletePerson(3);
        dao.readPersons();
    }
}