import java.util.Scanner;

public class App {

    static produto produto = new produto();
    static forn forn = new forn();
    static String ini;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        System.out.println("Iniciar programa? Y|N");
        ini = scan.next();
        
        if (ini.equalsIgnoreCase("y")) {
            
            System.out.println("(F) Fornecedor | (P) Produto");
            String fp = scan.next();
            if (fp.equalsIgnoreCase("p")) {
                System.out.println("(I) Incluir | (D) Deletar | (C) Consultar | (A) Atualizar");
                String desc = scan.next();
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
                
            }
            else {
                System.out.println("(I) Incluir | (D) Deletar | (C) Consultar | (A) Atualizar");
                String desc = scan.next();
                if (desc.equalsIgnoreCase("i")) {
                    forncrud.adiciona(forn);
                    System.out.println("Incluido com Sucesso!");
                } else if (desc.equalsIgnoreCase("c")) {
                    forncrud.consulta(forn);
                } else if (desc.equalsIgnoreCase("a")) {
                    forncrud.atualiza(forn);
                } else {
                    forncrud.remove(forn);
                }
                
            }
            System.out.println("\nFinalizado com sucesso!");
            // ini = scan.next();
        }
    }
}
