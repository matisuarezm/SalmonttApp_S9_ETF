package cl.salmontt.ui;

import cl.salmontt.data.GestorEntidades;
import cl.salmontt.model.Empleado;
import cl.salmontt.model.Proveedor;
import cl.salmontt.model.Registrable;
import cl.salmontt.util.ValidaRutException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalmonttAppFrame extends JFrame{

    private JTextField txtNombre, txtRut, txtDireccion, txtComuna, txtTelefono, txtMail;
    private JTextField txtGiro, txtFechaIngreso, txtCargo, txtDepartamento, txtSueldo, txtTipoEntidad;
    private JComboBox<String> cbTipo;
    private JTextArea txtAreaLog;
    private JButton btnIngresar;

    private GestorEntidades gestor;

    public SalmonttAppFrame(){
        gestor = new GestorEntidades();
        setTitle("INGRESO DE ENTIDADES SALMONTAPP");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel lblNombre = new JLabel("Nombre / Razón Social:");
        lblNombre.setBounds(15,20,160,25);
        add(lblNombre);

        JLabel lblRut = new JLabel("Rut:");
        lblRut.setBounds(15,50,80,25);
        add(lblRut);

        JLabel lblGiro = new JLabel("Giro:");
        lblGiro.setBounds(250,50,80,25);
        add(lblGiro);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(15,80,80,25);
        add(lblDireccion);

        JLabel lblComuna = new JLabel("Comuna:");
        lblComuna.setBounds(250,80,80,25);
        add(lblComuna);

        JLabel lblRegion = new JLabel("Región:");
        lblRegion.setBounds(450,800,80,25);
        add(lblRegion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(15,110,160,25);
        add(lblTelefono);

        JLabel lblMail = new JLabel("Mail:");
        lblMail.setBounds(250,110,80,25);
        add(lblMail);

        JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:");
        lblFechaIngreso.setBounds(15,150,160,25);
        add(lblFechaIngreso);

        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(15,180,80,25);
        add(lblCargo);

        JLabel lblDepto = new JLabel("Departamento:");
        lblDepto.setBounds(15,210,160,25);
        add(lblDepto);

        JLabel lblSueldo = new JLabel("Sueldo:");
        lblSueldo.setBounds(15,240,80,25);
        add(lblSueldo);

        txtNombre = new JTextField();
        txtNombre.setBounds(160,20,300,25);
        add(txtNombre);

        txtRut = new JTextField();
        txtRut.setBounds(45,50,190,25);
        add(txtRut);

        txtGiro = new JTextField();
        txtGiro.setBounds(285,50,175,25);
        add(txtGiro);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(80,80,155,25);
        add(txtDireccion);

        txtComuna = new JTextField();
        txtComuna.setBounds(310,80,150,25);
        add(txtComuna);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(80,110,155,25);
        add(txtTelefono);

        txtMail = new JTextField();
        txtMail.setBounds(285,110,175,25);
        add(txtMail);

        txtFechaIngreso = new JTextField();
        txtFechaIngreso.setBounds(110,150,125,25);
        add(txtFechaIngreso);

        txtCargo = new JTextField();
        txtCargo.setBounds(60,180,175,25);
        add(txtCargo);

        txtDepartamento = new JTextField();
        txtDepartamento.setBounds(110,210,125,25);
        add(txtDepartamento);

        txtSueldo = new JTextField();
        txtSueldo.setBounds(65,240,170,25);
        add(txtSueldo);

        //ComboBox
        JLabel lblTipoEntidad = new JLabel("Tipo:");
        lblTipoEntidad.setBounds(250,150,80,25);
        add(lblTipoEntidad);

        String[] tipoEntidad = {"","Empleado","Proveedor"};
        cbTipo = new JComboBox<>(tipoEntidad);
        cbTipo.setBounds(285,150,175,25);
        add(cbTipo);

        //Boton
        btnIngresar = new JButton("Ingresar Cliente / Proveedor");
        btnIngresar.setBounds(250,210,210,50);
        add(btnIngresar);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEntidades();
            }
        });

        //TextArea
        txtAreaLog = new JTextArea();
        txtAreaLog.setEnabled(false);
        JScrollPane scroll = new JScrollPane(txtAreaLog);
        scroll.setBounds(15, 270, 450,180);
        add(scroll);

    }

    public void guardarEntidades(){

        Registrable nuevaEntidad;

        String nombre = txtNombre.getText();
        String rut = txtRut.getText();
        String direccion = txtDireccion.getText();
        String comuna = txtComuna.getText();
        String telefono = txtTelefono.getText();
        String mail = txtMail.getText();
        String tipoEntidad = (String) cbTipo.getSelectedItem();

        try {
            if (tipoEntidad.equals("Proveedor")) {
                String giro = txtGiro.getText();
                nuevaEntidad = new Proveedor(nombre, rut, direccion, comuna, null, telefono, mail, giro);

            } else if (tipoEntidad.equals("Empleado")) {
                String fechaIngreso = txtFechaIngreso.getText();
                String cargo = txtCargo.getText();
                String departamento = txtDepartamento.getText();

                double sueldo = 0;
                try {
                    sueldo =  Double.parseDouble(txtSueldo.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Valida el sueldo ingresado");
                    return;
                }

                try{
                    nuevaEntidad = new Empleado(nombre, rut, direccion, comuna, null, telefono, mail, fechaIngreso, cargo, departamento, sueldo);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    return;
                }

            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un tipo para realizar el registro.");
                return;
            }

            gestor.agregarRegistro(nuevaEntidad);

            actualizarLog();

            txtNombre.setText("");
            txtRut.setText("");
            txtDireccion.setText("");
            txtComuna.setText("");
            txtTelefono.setText("");
            txtMail.setText("");
            txtGiro.setText("");
            txtFechaIngreso.setText("");
            txtCargo.setText("");
            txtDepartamento.setText("");
            txtSueldo.setText("");

            JOptionPane.showMessageDialog(this, "Registro realizado correctamente");
        } catch (ValidaRutException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valida el sueldo ingresado");
        }

    }

    private void actualizarLog(){
        String listaRegistros = gestor.listarTodos();

        txtAreaLog.setText("--- Lista de entidades SalmonttApp ---\n");
        txtAreaLog.append(listaRegistros);
    }

}
