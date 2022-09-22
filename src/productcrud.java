import java.sql.*;
import java.util.Scanner;

public class productcrud {

    public static void adiciona(produto produto) throws SQLException {

        java.sql.Connection conn = connectDAO.conectaBD();
        String sql = "INSERT INTO produto(description) VALUES(?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite a descrição: ");
            String desc = scan.nextLine();
            stmt.setString(1, desc);
            stmt.execute();
            conn.commit();
            scan.close();

        } catch (SQLException u) {
            conn.rollback();
            throw new RuntimeException(u);
        }
    }

    public static void remove(produto produto) throws SQLException {

        java.sql.Connection conn = connectDAO.conectaBD();
        String sql = "DELETE from produto where cod like ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            Scanner scan = new Scanner(System.in);
            System.out.println("Qual o código?");
            int cod = scan.nextInt();
            stmt.setInt(1, cod);
            stmt.execute();
            System.out.println(stmt.getUpdateCount());
            conn.commit();
            scan.close();

        } catch (SQLException u) {
            conn.rollback();
            throw new RuntimeException(u);
        }
    }

    public static void atualiza(produto produto) throws SQLException {

        java.sql.Connection conn = connectDAO.conectaBD();
        String sql = "UPDATE * from produto where cod like ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Qual o código?");
            int cod = scan.nextInt();
            stmt.setInt(1, cod);
            stmt.execute();
            scan.close();

        } catch (SQLException u) {
            System.out.println("Código não encontrado!");
            throw new RuntimeException(u);
        }
    }

    public static void consulta(produto produto) throws SQLException {

        java.sql.Connection conn = connectDAO.conectaBD();
        String sql = "SELECT * from produto where cod like ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Qual o código?");
            int cod = scan.nextInt();
            stmt.setInt(1, cod);
            stmt.execute();
            scan.close();

        } catch (SQLException u) {
            System.out.println("Código não encontrado!");
            throw new RuntimeException(u);
        }
    }

}
