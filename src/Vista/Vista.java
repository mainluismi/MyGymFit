/**
 * La clase `Vista` representa la interfaz gráfica de usuario para la aplicación MyGymFit.
 * Proporciona métodos para inicializar la ventana principal y mostrar diálogos para insertar y eliminar clientes.
 *
 * @author Luismi
 * @version 1.8
 * @since 20/12/23
 */
package Vista;

import java.awt.BorderLayout;
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
import javax.swing.SwingUtilities;

import Controlador.ClienteControlador;
import Estilo.Look;
import Modelo.Cliente;

public class Vista {

    /**
     * El marco principal de la aplicación.
     */
    public JFrame frameLuismi;

    /**
     * Diálogo para la pantalla de carga.
     */
    private JDialog pantallaCargaLuismi;

    /**
     * El controlador del cliente asociado a esta vista.
     */
    private ClienteControlador clienteControladorLuismi;

    /**
     * Constructor de la clase `Vista`.
     *
     * @param clienteControladorLuismi El controlador del cliente asociado a esta vista.
     */
    public Vista(ClienteControlador clienteControladorLuismi) {
        this.clienteControladorLuismi = clienteControladorLuismi;
        Look.setUIFontLuismi();
    }

    /**
     * Inicializa la ventana principal de la aplicación.
     */
    public void inicializarVentanaLuismi() {
        frameLuismi = new JFrame();
        frameLuismi.setBounds(100, 100, 450, 300);
        frameLuismi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelLuismi = new JPanel();
        frameLuismi.getContentPane().add(panelLuismi, BorderLayout.CENTER);
        panelLuismi.setLayout(new BorderLayout(0, 0));

        JTextPane txtpnBienvenidoAMygymfitLuismi = new JTextPane();
        txtpnBienvenidoAMygymfitLuismi.setEditable(false);
        txtpnBienvenidoAMygymfitLuismi.setText("Bienvenido a MyGymFit");
        panelLuismi.add(txtpnBienvenidoAMygymfitLuismi, BorderLayout.NORTH);

        JPanel panel_1Luismi = new JPanel();
        panelLuismi.add(panel_1Luismi, BorderLayout.CENTER);
        panel_1Luismi.setLayout(new GridLayout(1, 0, 0, 0));

        JButton btnInsertarClienteLuismi = new JButton("Insertar cliente");
        btnInsertarClienteLuismi.setToolTipText("Añadir un nuevo cliente");
        btnInsertarClienteLuismi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoInsertarClienteLuismi();
            }
        });
        panel_1Luismi.add(btnInsertarClienteLuismi);

        JButton btnEliminarClienteLuismi = new JButton("Eliminar cliente");
        btnEliminarClienteLuismi.setToolTipText("Eliminar un cliente");
        btnEliminarClienteLuismi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoEliminarClienteLuismi();
            }
        });
        panel_1Luismi.add(btnEliminarClienteLuismi);

        JButton btnVerClientesLuismi = new JButton("Ver clientes");
        btnVerClientesLuismi.setToolTipText("Ver la lista de clientes");
        panel_1Luismi.add(btnVerClientesLuismi);

        Look.setButtonStylesLuismi(btnInsertarClienteLuismi, btnEliminarClienteLuismi, btnVerClientesLuismi);
        Look.setButtonTextToWhite(btnInsertarClienteLuismi, btnEliminarClienteLuismi, btnVerClientesLuismi);

        frameLuismi.setVisible(true);
    }

    /**
     * Muestra la pantalla de carga mientras se realiza una operación.
     */
    public void MostrarPantallaCargaLuismi() {
        pantallaCargaLuismi = new JDialog((JFrame) null, "Cargando...", true);
        pantallaCargaLuismi.setLayout(new BorderLayout());
        pantallaCargaLuismi.add(new JLabel("Realizando operación..."), BorderLayout.CENTER);
        pantallaCargaLuismi.setSize(200, 100);
        pantallaCargaLuismi.setLocationRelativeTo(null);

        javax.swing.Timer temporizadorLuismi = new javax.swing.Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    ocultarPantallaCargaLuismi();
                    inicializarVentanaLuismi();
                });
            }
        });
        temporizadorLuismi.setRepeats(false);
        temporizadorLuismi.start();

        pantallaCargaLuismi.setVisible(true);
    }

    /**
     * Oculta la pantalla de carga.
     */
    private void ocultarPantallaCargaLuismi() {
        pantallaCargaLuismi.setVisible(false);
        pantallaCargaLuismi.dispose();
    }

    /**
     * Muestra un diálogo para eliminar un cliente.
     */
    private void mostrarDialogoEliminarClienteLuismi() {
        JDialog dialogEliminarLuismi = new JDialog(frameLuismi, "Eliminar Cliente", true);
        dialogEliminarLuismi.setSize(300, 200);
        dialogEliminarLuismi.setLayout(new BorderLayout());

        JPanel panelCamposLuismi = new JPanel(new GridLayout(1, 2));

        JTextField txtIdLuismi = new JTextField();

        panelCamposLuismi.add(new JLabel("Dime el id:"));
        panelCamposLuismi.add(txtIdLuismi);

        dialogEliminarLuismi.add(panelCamposLuismi, BorderLayout.CENTER);

        JPanel panelBotonesLuismi = new JPanel();

        JButton btnGuardarLuismi = new JButton("Aceptar");
        btnGuardarLuismi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idLuismi = txtIdLuismi.getText();
                int idConvertidoLuismi = Integer.parseInt(idLuismi);

                if (idLuismi.isEmpty()) {
                    JOptionPane.showMessageDialog(dialogEliminarLuismi, "Por favor, complete todos los campos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Cliente nuevoClienteLuismi = new Cliente(idConvertidoLuismi);
                    clienteControladorLuismi.eliminarClienteLuismi(nuevoClienteLuismi);

                    dialogEliminarLuismi.dispose();
                }
            }
        });

        JButton btnCancelarLuismi = new JButton("Cancelar");
        btnCancelarLuismi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogEliminarLuismi.dispose();
            }
        });

        Look.setButtonStylesLuismi(btnGuardarLuismi, btnCancelarLuismi);
        Look.setButtonTextToWhite(btnGuardarLuismi, btnCancelarLuismi);

        panelBotonesLuismi.add(btnGuardarLuismi);
        panelBotonesLuismi.add(btnCancelarLuismi);

        dialogEliminarLuismi.add(panelBotonesLuismi, BorderLayout.SOUTH);

        dialogEliminarLuismi.setLocationRelativeTo(frameLuismi);
        dialogEliminarLuismi.setVisible(true);
    }

    /**
     * Muestra un diálogo para insertar un nuevo cliente.
     */
    private void mostrarDialogoInsertarClienteLuismi() {
        JDialog dialogInsertarLuismi = new JDialog(frameLuismi, "Insertar Cliente", true);
        dialogInsertarLuismi.setSize(300, 200);
        dialogInsertarLuismi.setLayout(new BorderLayout());

        JPanel panelCamposLuismi = new JPanel(new GridLayout(4, 2));

        JTextField txtNombreLuismi = new JTextField();
        JTextField txtApellidoLuismi = new JTextField();
        JTextField txtEmailLuismi = new JTextField();
        JTextField txtFechaAltaLuismi = new JTextField();

        panelCamposLuismi.add(new JLabel("Nombre:"));
        panelCamposLuismi.add(txtNombreLuismi);
        panelCamposLuismi.add(new JLabel("Apellido:"));
        panelCamposLuismi.add(txtApellidoLuismi);
        panelCamposLuismi.add(new JLabel("Email:"));
        panelCamposLuismi.add(txtEmailLuismi);
        panelCamposLuismi.add(new JLabel("Fecha de Alta:"));
        panelCamposLuismi.add(txtFechaAltaLuismi);

        dialogInsertarLuismi.add(panelCamposLuismi, BorderLayout.CENTER);

        JPanel panelBotonesLuismi = new JPanel();

        JButton btnGuardarLuismi = new JButton("Guardar");
        btnGuardarLuismi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreLuismi = txtNombreLuismi.getText();
                String apellidoLuismi = txtApellidoLuismi.getText();
                String emailLuismi = txtEmailLuismi.getText();
                String fechaAltaLuismi = txtFechaAltaLuismi.getText();

                if (nombreLuismi.isEmpty() || apellidoLuismi.isEmpty() || emailLuismi.isEmpty() || fechaAltaLuismi.isEmpty()) {
                    JOptionPane.showMessageDialog(dialogInsertarLuismi, "Por favor, complete todos los campos.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Cliente nuevoClienteLuismi = new Cliente(0, nombreLuismi, apellidoLuismi, emailLuismi, fechaAltaLuismi);

                    if (clienteControladorLuismi != null) {
                        clienteControladorLuismi.insertarClienteLuismi(nuevoClienteLuismi);
                        JOptionPane.showMessageDialog(dialogInsertarLuismi, "Cliente guardado exitosamente.", "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                        dialogInsertarLuismi.dispose();
                    } else {
                        JOptionPane.showMessageDialog(dialogInsertarLuismi, "Error: Controlador no inicializado.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton btnCancelarLuismi = new JButton("Cancelar");
        btnCancelarLuismi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogInsertarLuismi.dispose();
            }
        });

        Look.setButtonStylesLuismi(btnGuardarLuismi, btnCancelarLuismi);
        Look.setButtonTextToWhite(btnGuardarLuismi, btnCancelarLuismi);

        panelBotonesLuismi.add(btnGuardarLuismi);
        panelBotonesLuismi.add(btnCancelarLuismi);

        dialogInsertarLuismi.add(panelBotonesLuismi, BorderLayout.SOUTH);

        dialogInsertarLuismi.setLocationRelativeTo(frameLuismi);
        dialogInsertarLuismi.setVisible(true);
    }
}
