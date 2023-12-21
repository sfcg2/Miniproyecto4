import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        try (Scanner scanner = new Scanner(System.in)) {

            
            int opc;
            do{
                System.out.println("Menu");
                System.out.println("1. Ingresar Cliente");
                System.out.println("2. Atender Cliente");
                System.out.println("0. Salir");
                System.out.print("Opcion: ");
                opc = scanner.nextInt();
                Cola cola = new Cola();

                switch (opc) {
                    case 1:
                        System.out.println("REGISTRO DE CLIENTES");
                        cola.enqueue();
                        break;
                    case 2:
                        cola.atenderCliente();
                        System.out.println("gogogo");
                        break;
                    case 3:
                        System.out.println("bibibi");
                        break;
                    default:
                        break;
                }
            }while(opc!= 0);
        }
    }
}
