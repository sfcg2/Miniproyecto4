import java.util.Scanner;

public class Clientes {
    
    Scanner scanner = new Scanner(System.in);
    private String nombre;
    private String plato;
    private String bebida;

    public Clientes(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        System.out.print("Nombre: ");
        nombre = scanner.nextLine();
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato() {
        System.out.print("Plato: ");
        plato = scanner.nextLine();
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida() {
        System.out.print("Bebida: ");
        bebida = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Clientes \nnombre: " + nombre + ", plato: " + plato + ", bebida: " + bebida;
    }

    


}
