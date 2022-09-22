import java.util.Scanner;

public class App {

    static produto produto = new produto();

    public static void main(String[] args) throws Exception {
        System.out.println("(I) Incluir | (D) Deletar | (C) Consultar | (A) Atualizar");
        Scanner scan = new Scanner(System.in);
        String desc = scan.nextLine();
        if (desc.equalsIgnoreCase("i")) {
            productcrud.adiciona(produto);
            System.out.println("Incluido com Sucesso!");
        } else if (desc.equalsIgnoreCase("c")) {
            productcrud.consulta(produto);
        } else if (desc.equalsIgnoreCase("a")) {
            productcrud.atualiza(produto);
        } else {
            productcrud.remove(produto);
        }
        scan.close();
    }
}
