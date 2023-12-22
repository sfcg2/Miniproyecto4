import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

class Persona {
    private String cedula;
    private String nombre;
    private int edad;

    public Persona(String cedula, String nombre, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Cédula: " + cedula + ", Nombre: " + nombre + ", Edad: " + edad;
    }
}

class PersonaDAO {
    private List<Persona> personas;

    public PersonaDAO() {
        personas = new LinkedList<>();
    }

    public void crearPersona(String cedula, String nombre, int edad) {
        Persona persona = new Persona(cedula, nombre, edad);
        personas.add(persona);
    }

    public List<Persona> getPersonas() {
        return new LinkedList<>(personas);
    }

    public void actualizarPersona(String cedula, String nuevoNombre, int nuevaEdad) {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (persona.getCedula().equals(cedula)) {
                Persona personaActualizada = new Persona(cedula, nuevoNombre, nuevaEdad);
                personas.set(i, personaActualizada);
                return;
            }
        }
    }

    public void eliminarPersona(String cedula) {
        personas.removeIf(persona -> persona.getCedula().equals(cedula));
    }

    public Persona buscarPersona(String cedula) {
        for (Persona persona : personas) {
            if (persona.getCedula().equals(cedula)) {
                return persona;
            }
        }
        return null;
    }
}

public class CRUD extends JFrame {

    private PersonaDAO personaDAO;

    public CRUD() {
        super("CRUD de Personas");

        personaDAO = new PersonaDAO();

        JButton btnLeer = new JButton("Leer Personas");
        JButton btnCrear = new JButton("Crear Persona");
        JButton btnActualizar = new JButton("Actualizar Persona");
        JButton btnEliminar = new JButton("Eliminar Persona");
        JButton btnBuscar = new JButton("Buscar Persona");

        // Asignar un color rosado pastel al fondo del panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 182, 193)); // Código de color para el rosado pastel

        // Ajustes visuales
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        btnLeer.setFont(buttonFont);
        btnCrear.setFont(buttonFont);
        btnActualizar.setFont(buttonFont);
        btnEliminar.setFont(buttonFont);
        btnBuscar.setFont(buttonFont);

        // Agregar acciones a los botones
        btnLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaPersonas();
            }
        });

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPersona();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPersona();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPersona();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPersona();
            }
        });

        // Agregar componentes al panel
        panel.add(btnLeer);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);

        // Agregar el panel al JFrame
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarListaPersonas() {
        JFrame frame = new JFrame("Lista de Personas");
        JTextArea textArea = new JTextArea(15, 40);
        textArea.setEditable(false);

        List<Persona> personas = personaDAO.getPersonas();
        if (!personas.isEmpty()) {
            for (Persona persona : personas) {
                textArea.append(persona + "\n");
            }
        } else {
            textArea.append("No hay personas registradas.\n");
        }

        // Asignar un color rosado pastel al fondo del panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 182, 193)); // Código de color para el rosado pastel

        // Ajustes visuales
        Font textAreaFont = new Font("Arial", Font.PLAIN, 14);
        textArea.setFont(textAreaFont);

        // Agregar el área de texto al panel
        panel.add(new JScrollPane(textArea));

        // Agregar el panel al JFrame
        frame.add(panel);

        frame.setSize(500, 300);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
    }

    private void crearPersona() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula de la persona:");
        if (cedula != null && !cedula.isEmpty()) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la persona:"));
            personaDAO.crearPersona(cedula, nombre, edad);
        }
    }

    private void actualizarPersona() {
        String cedulaActualizar = JOptionPane.showInputDialog("Ingrese la cédula de la persona a actualizar:");
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
        int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad:"));
        personaDAO.actualizarPersona(cedulaActualizar, nuevoNombre, nuevaEdad);
    }

    private void eliminarPersona() {
        String cedulaEliminar = JOptionPane.showInputDialog("Ingrese la cédula de la persona a eliminar:");
        personaDAO.eliminarPersona(cedulaEliminar);
    }

    private void buscarPersona() {
        String cedulaBuscar = JOptionPane.showInputDialog("Ingrese la cédula de la persona a buscar:");
        Persona persona = personaDAO.buscarPersona(cedulaBuscar);
        if (persona != null) {
            JOptionPane.showMessageDialog(this, persona.toString(), "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Persona no encontrada", "Resultado de la búsqueda", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CRUD();
            }
        });
    }
}