import java.sql.*;
import java.util.Scanner;

public class forncrud {
  
  private static Scanner scan;

  public static void adiciona(forn forn) throws SQLException {

      connectFAC cf =  new connectFAC();
      Connection connect = cf.ConnectDbMysql();
      connect.setAutoCommit(false);
      String sql = "INSERT INTO forn(forn_desc) VALUES(?)";

      try (PreparedStatement stmt = connect.prepareStatement(sql)) {
          Scanner scan = new Scanner(System.in);
          System.out.println("Digite a descrição: ");
          String desc = scan.nextLine();
          stmt.setString(1, desc);
          stmt.execute();
          connect.commit();
          System.out.println(stmt.getUpdateCount()+" Registro(s) inserido(s)");
          scan.close();

      } catch (SQLException u) {
          connect.rollback();
          throw new RuntimeException(u);
      }
  }

  public static void remove(forn forn) throws SQLException {

      connectFAC cf =  new connectFAC();
      Connection connect = cf.ConnectDbMysql();
      connect.setAutoCommit(false);
      String sql = "DELETE from produto where cod like ?";

      try (PreparedStatement stmt = connect.prepareStatement(sql)) {
          Scanner scan = new Scanner(System.in);
          System.out.println("Qual o código?");
          int cod = scan.nextInt();
          stmt.setInt(1, cod);
          stmt.execute();
          connect.commit();
          System.out.println(stmt.getUpdateCount()+" Registro(s) deletado(s)");
          scan.close();

      } catch (SQLException u) {
          connect.rollback();
          throw new RuntimeException(u);
      }
  }

  public static void atualiza(forn forn) throws SQLException {
      scan = new Scanner(System.in);
      connectFAC cf =  new connectFAC();
      Connection connect = cf.ConnectDbMysql();
      connect.setAutoCommit(false);
      String sql = "update produto set description = ? where cod = ?";

      try (PreparedStatement stmt = connect.prepareStatement(sql)) {            
          System.out.println("Qual o código do produto a ser atualizado?");
          int cod = scan.nextInt();
          System.out.println("Qual será a nova descrição?");
          String desc = scan.next();
          stmt.setString(1, desc);
          stmt.setInt(2, cod);
          stmt.executeUpdate();
          connect.commit();
          System.out.println(stmt.getUpdateCount()+" Registro(s) atualizado(s)");

      } catch (SQLException u) {
          connect.rollback();
          throw new RuntimeException(u);
      }
      
  }

  public static void consulta(forn forn) throws SQLException {

      connectFAC cf =  new connectFAC();
      Connection connect = cf.ConnectDbMysql();
      String sql = "SELECT * from produto where description like ?";

      try (PreparedStatement stmt = connect.prepareStatement(sql)) {
          Scanner scan = new Scanner(System.in);
          System.out.println("Descrição: ");
          String desc = scan.nextLine();
          stmt.setString(1, desc);
          stmt.execute();
          ResultSet produtos = stmt.getResultSet();
          scan.close();

          while (produtos.next()) {
              int cod = produtos.getInt("cod");
              String description = produtos.getString("description");
              //Timestamp data_cadastro = produtos.getTimestamp("data_cadastro");

              System.out.println("Produto [Código=" + cod + ", Descrição=" + description + "]");
          }

      } catch (SQLException u) {
          System.out.println("Erro de conexão");
          throw new RuntimeException(u);
      }
  }


}
