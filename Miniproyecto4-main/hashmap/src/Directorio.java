import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Directorio {
    private Map<String, String> directorio;
    private Scanner scanner;

    public Directorio() {
        this.directorio = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void agregar(String nombre, String telefono) {
        if (!directorio.containsKey(nombre)) {
            directorio.put(nombre, telefono);
            System.out.println("Contacto " + nombre + " agregado con éxito.");
        } else {
            System.out.println("El contacto " + nombre + " ya existe en el directorio.");
        }
    }

    public void Informacion(int cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Ingrese la información del contacto " + i + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            agregar(nombre, telefono);
        }
    }

    public String Telefono(String nombre) {
        return directorio.getOrDefault(nombre, "No se encontró el contacto " + nombre + " en el directorio.");
    }

    public void buscarContacto() {
        System.out.print("Ingrese el nombre del contacto que desea buscar: ");
        String nombreBuscado = scanner.nextLine();

        String resultadoBusqueda = Telefono(nombreBuscado);
        System.out.println(resultadoBusqueda);
    }

    public void mostrarDirec() {
        System.out.println("Directorio Telefónico:");
        for (Map.Entry<String, String> entry : directorio.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Directorio directorio = new Directorio();
        System.out.print("Ingrese la cantidad de contactos que desea agregar: ");
        int cantidadContactos = directorio.scanner.nextInt();
        directorio.scanner.nextLine();  

      
        directorio.Informacion(cantidadContactos);

  
        directorio.buscarContacto();

     
        directorio.agregar("merly", "123456");

     
        System.out.println(directorio.Telefono("merly"));

        directorio.mostrarDirec();
    }
}

