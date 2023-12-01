package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;

import Controlador.ClienteControlador;
import DataBase.Database;
import Modelo.Cliente;

public class Vista {

    public JFrame frame;
    private JDialog pantallaCarga;
    private ClienteControlador clienteControlador;

    public Vista(ClienteControlador clienteControlador) {
        this.clienteControlador = clienteControlador;
    }
    
    /**
     * @wbp.parser.entryPoint
     */

    public void inicializarVentana() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JTextPane txtpnBienvenidoAMygymfit = new JTextPane();
        txtpnBienvenidoAMygymfit.setBackground(new Color(255, 255, 255));
        txtpnBienvenidoAMygymfit.setText("Bienvenido a MyGymFit");
        panel.add(txtpnBienvenidoAMygymfit, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));

        JButton btnInsertarCliente = new JButton("Insertar cliente");
        btnInsertarCliente.setToolTipText("Añadir un nuevo cliente");
        btnInsertarCliente.setForeground(new Color(255, 255, 255));
        btnInsertarCliente.setBackground(new Color(0, 0, 0));
        btnInsertarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertarCliente();
                ventanaInsertar();
            }
        });
        panel_1.add(btnInsertarCliente);

        JButton btnEliminarCliente = new JButton("Eliminar cliente");
        btnEliminarCliente.setToolTipText("Eliminar un cliente");
        btnEliminarCliente.setForeground(new Color(255, 255, 255));
        btnEliminarCliente.setBackground(new Color(0, 0, 0));
        btnEliminarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarCliente();
            }
        });
        panel_1.add(btnEliminarCliente);

        JButton btnVerClientes = new JButton("Ver clientes");
        btnVerClientes.setToolTipText("Ver la lista de clientes");
        btnVerClientes.setForeground(new Color(255, 255, 255));
        btnVerClientes.setBackground(new Color(0, 0, 0));
        btnVerClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verClientes();
            }
        });
        panel_1.add(btnVerClientes);

        frame.setVisible(true);
    }

    public void mostrarPantallaCarga() {
        pantallaCarga = new JDialog((JFrame) null, "Cargando...", true);
        pantallaCarga.setLayout(new BorderLayout());
        pantallaCarga.add(new JLabel("Realizando operación..."), BorderLayout.CENTER);
        pantallaCarga.setSize(200, 100);
        pantallaCarga.setLocationRelativeTo(null);

        Timer temporizador = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocultarPantallaCarga();
                inicializarVentana();
            }
        });
        temporizador.setRepeats(false);
        temporizador.start();

        pantallaCarga.setVisible(true);
    }

    private void ocultarPantallaCarga() {
        pantallaCarga.setVisible(false);
        pantallaCarga.dispose();
    }

    // Method to insert a new client
    private void insertarCliente() {
        // You need to implement the logic for inserting a new client in the controller
        clienteControlador.insertarCliente(new Cliente(/* provide necessary information */));
    }

    // Method to delete a client
    private void eliminarCliente() {
        // You need to implement the logic for deleting a client in the controller
        clienteControlador.eliminarCliente(new Cliente()/* provide necessary information */);
    }

    // Method to view clients
    private void verClientes() {
        // You need to implement the logic for viewing clients in the controller
        clienteControlador.verClientes();
    }
    
    private void ventanaInsertar() {
        JDialog dialogInsertar = new JDialog(frame, "Insertar Cliente", true);
        dialogInsertar.setSize(300, 200);
        dialogInsertar.setLayout(new BorderLayout());

        JPanel panelCampos = new JPanel(new GridLayout(4, 2));

        JTextField txtNombre = new JTextField();
        JTextField txtApellido = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtFechaAlta = new JTextField();

        panelCampos.add(new JLabel("Nombre:"));
        panelCampos.add(txtNombre);
        panelCampos.add(new JLabel("Apellido:"));
        panelCampos.add(txtApellido);
        panelCampos.add(new JLabel("Email:"));
        panelCampos.add(txtEmail);
        panelCampos.add(new JLabel("Fecha de Alta:"));
        panelCampos.add(txtFechaAlta);

        dialogInsertar.add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String email = txtEmail.getText();
                String fechaAlta = txtFechaAlta.getText();

                if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || fechaAlta.isEmpty()) {
                    JOptionPane.showMessageDialog(dialogInsertar, "Por favor, complete todos los campos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Cliente nuevoCliente = new Cliente(0, nombre, apellido, email, fechaAlta);

                    // Insert the new client into the database using the controller
                    if (clienteControlador != null) {
                        // Assuming that your ClienteControlador has a reference to the Database
                        Database database = clienteControlador.getConection();

                        // Validate that the Database object is not null
                        if (database != null) {
                            // Insert the new client into the database
                            clienteControlador.insertarCliente(nuevoCliente);

                            // Optionally, you can display a success message
                            JOptionPane.showMessageDialog(dialogInsertar, "Cliente guardado exitosamente.", "Éxito",
                                    JOptionPane.INFORMATION_MESSAGE);

                            // Close the JDialog or clear the input fields
                            dialogInsertar.dispose();
                        } else {
                            // Handle the case where the Database object is null
                        }
                    } else {
                        // Handle the case where the ClienteControlador object is null
                    }
                }
            }
        });

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogInsertar.dispose();
            }
        });

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        dialogInsertar.add(panelBotones, BorderLayout.SOUTH);

        dialogInsertar.setLocationRelativeTo(frame);
        dialogInsertar.setVisible(true);
    }
}
