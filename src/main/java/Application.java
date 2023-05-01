import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
//        BookDAO bookDAO = new BookDAOImpl();
//        List<Book> books = bookDAO.getAllBooks();
//
//        for (Book book : books) {
//            System.out.println("Book ID: " +book.getId());
//            System.out.println("Tittle: " +book.getTittle());
//            System.out.println("Author_id: " +book.getAuthorId());
//            System.out.println("Amount: " +book.getAmount());
//        }

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.getAllEmployee();

    }
}
