import java.sql.*;
import java.util.Scanner;

public class productcrud {

    private static Scanner scan;

    public static void adiciona(produto produto) throws SQLException {

        connectFAC cf =  new connectFAC();
        Connection connect = cf.ConnectDbMysql();
        connect.setAutoCommit(false);
        String sql = "INSERT INTO produto(description, forn_cod) VALUES(?, ?)";

        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite a descrição: ");
            String desc = scan.next();
            System.out.println("Código do Fornecedor: ");
            int forn = scan.nextInt();
            stmt.setString(1, desc);
            stmt.setInt(2, forn);
            stmt.execute();
            connect.commit();
            System.out.println(stmt.getUpdateCount()+" Registro(s) inserido(s)");
            scan.close();

        } catch (SQLException u) {
            connect.rollback();
            throw new RuntimeException(u);
        }
    }

    public static void remove(produto produto) throws SQLException {

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

    public static void atualiza(produto produto) throws SQLException {
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

    public static void consulta(produto produto) throws SQLException {

        connectFAC cf =  new connectFAC();
        Connection connect = cf.ConnectDbMysql();
        String sql = "SELECT produto.cod, produto.description, forn.forn_desc, produto.data_cadastro FROM produto INNER JOIN forn ON produto.forn_cod=forn.forn_cod WHERE produto.forn_cod LIKE ?";
        //"SELECT * from produto where forn_cod = ?"

        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Codigo do Fornecedor: ");
            int codigo = scan.nextInt();
            stmt.setInt(1, codigo);
            stmt.execute();
            ResultSet produtos = stmt.getResultSet();
            scan.close();

            while (produtos.next()) {
                int cod = produtos.getInt("cod");
                String description = produtos.getString("description");
                int forn_cod = produtos.getInt("forn_cod");
                String forn_desc = produtos.getString("forn_desc");
                Timestamp data_cadastro = produtos.getTimestamp("data_cadastro");

                System.out.println("Produto [Código=" + cod + ", Descrição=" + description +", Cód Fornecedor=" + forn_cod +", Nome Fornecedor=" + forn_desc +", Data do cadastro=" + data_cadastro + "]");
            }

        } catch (SQLException u) {
            System.out.println("Erro de conexão");
            throw new RuntimeException(u);
        }
    }

}
