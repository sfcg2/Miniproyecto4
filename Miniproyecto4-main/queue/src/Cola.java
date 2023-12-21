import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cola{
    Clientes cliente = new Clientes();
    Scanner scanner = new Scanner(System.in);
    static Queue <Clientes> ListaClientes = new LinkedList<Clientes>();

    public void enqueue(){

        cliente.setNombre();
        
        cliente.setPlato();

        cliente.setBebida();

        ListaClientes.add(cliente);
        
        System.out.println(ListaClientes.toString());
        
    }
    
    public void atenderCliente(){
        
        if(ListaClientes.isEmpty()){

            System.out.println("La cola esta vacia, no hay clientes para atender");
            
        }if(!ListaClientes.isEmpty()){

            for(int i=0; i<ListaClientes.size();i++){

                System.out.println("Cliente Atendido");
                System.out.println(ListaClientes.peek());
                System.out.println(ListaClientes.remove());

            }System.out.println(ListaClientes.toString());
        }
    }
}
