import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            int opc;
            do{
                System.out.println("Menu");
                System.out.println("1. Ingresar Cliente");
                System.out.println("2. Atender Cliente");
                System.out.println("0. Salir");
                System.out.print("Opcion: ");
                opc = scanner.nextInt();
                limpiarPantalla();
                esperarSegundos(300);
                Cola cola = new Cola();

                switch (opc) {
                    case 1:
                        System.out.println("REGISTRO DE CLIENTES\n");
                        cola.enqueue();
                        limpiarPantalla();
                        esperarSegundos(300);
                        break;
                    case 2:
                        cola.atenderCliente();
                        
                        
                        break;
                    default:
                        break;
                }
            }while(opc!= 0);
        }
    }
    
    
    
    
    
    
    public static void limpiarPantalla() {
        try{ new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    
        }catch (Exception e){

            e.printStackTrace();
        }
    }
    public static void esperarSegundos(int sg) {
        try {
            Thread.sleep(sg); // Convierte segundos a milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
