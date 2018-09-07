package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import bean.Cliente;
import bean.Producto;
import bean.ProductoComp;
import bean.ProductoSimple;
import interfaz.TDAManejoDatos;

public class AltaVentaView extends JFrame {

	private JPanel contentPane;

	private static final long serialVersionUID = 537605013701405665L;
	private JTextField nombreCliente;
	private JTextField diasPublicacion;
	private JLabel lblFecha;
	private JLabel lblfecha;
	private JLabel lblDniCliente;
	private JLabel lblNombreCliente;
	private JLabel lblAviso;
	private JLabel lblLineasAviso;
	private JLabel lblCantidadDeDias;
	private JButton btnCancelar;
	private JButton btnAceptar;
	//	private Administrador sistema;
	private int dniElegido;
	private int codProductoElegido;
	private DefaultListModel listModel;

	private List<Producto> productos;
	private List<Cliente> clientes;

	private JComboBox comboProductos;
	private JComboBox comboClientes;
	private JEditorPane lineaAviso;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					AltaVentaView2 frame = new AltaVentaView2();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public AltaVentaView(TDAManejoDatos manejoDatos) throws RemoteException {




		List<ProductoSimple> ps = manejoDatos.getProductosSimple().getProductosSimple();
		List<ProductoComp> pc = manejoDatos.getProductosComp().getProductosComp();
		productos = new ArrayList<Producto>();
		productos.addAll(ps);
		productos.addAll(pc);

		clientes = new ArrayList<Cliente>();
		clientes = manejoDatos.getClientes();

		setTitle("Crear Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblFecha = new JLabel("Fecha Venta:");
		lblFecha.setBounds(-13, 11, 121, 15);
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);

		lblDniCliente = new JLabel("DNI Cliente:");
		lblDniCliente.setBounds(10, 34, 121, 15);
		lblDniCliente.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreCliente.setBounds(29, 59, 121, 15);

		comboClientes = new JComboBox();
		comboClientes.setBounds(170, 32, 250, 19);
		comboClientes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				int i = comboClientes.getSelectedIndex() - 1;
				dniElegido = i;
			}
		});
		listModel = new DefaultListModel();

		//		Poblar combo clientes
		comboClientes.setModel(new DefaultComboBoxModel(clientes.toArray()));
		comboClientes.insertItemAt("Seleccione un cliente", 0);
		contentPane.setLayout(null);
		comboClientes.setSelectedIndex(0);
		contentPane.add(comboClientes);

		//		lblAviso = new JLabel("Aviso:");
		//		lblAviso.setHorizontalAlignment(SwingConstants.RIGHT);
		//		lblAviso.setBounds(29, 84, 121, 15);

		lblLineasAviso = new JLabel("Lineas Items:");
		lblLineasAviso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLineasAviso.setBounds(29, 107, 121, 15);

		//		lblCantidadDeDias = new JLabel("Dias de publicacion:");
		//		lblCantidadDeDias.setHorizontalAlignment(SwingConstants.RIGHT);
		//		lblCantidadDeDias.setBounds(10, 225, 140, 15);

		// Para la fecha:
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		lblfecha = new JLabel(dtf.format(localDate));
		lblfecha.setBounds(123, 11, 72, 15);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(170, 247, 114, 25);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					manejoDatos.crearVenta(String.valueOf(dniElegido));
					JOptionPane.showMessageDialog(null,
							"La Venta fue creada correctamente!");
					limpiarPantalla();
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Por favor verifique los datos ingresados");
				}

			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(306, 247, 114, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(lblFecha);
		contentPane.add(lblfecha);
		contentPane.add(lblDniCliente);
		//		contentPane.add(lblCantidadDeDias);
		//		contentPane.add(diasPublicacion);
		contentPane.add(btnCancelar);
		contentPane.add(btnAceptar);

		comboProductos = new JComboBox();
		comboProductos.setBounds(123, 78, 250, 24);
		comboProductos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				int i = comboProductos.getSelectedIndex() - 1;
				codProductoElegido = i;
			}
		});
		listModel = new DefaultListModel();

		//		Poblar combo productos
		comboProductos.setModel(new DefaultComboBoxModel(productos.toArray()));
		comboProductos.insertItemAt("Seleccione un producto", 0);
		comboProductos.setSelectedIndex(0);
		contentPane.add(comboProductos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 150, 250, 76);
		contentPane.add(scrollPane);
		
				lineaAviso = new JEditorPane();
				scrollPane.setViewportView(lineaAviso);
		
		JLabel lblItemsVenta = new JLabel("Items Venta");
		lblItemsVenta.setBounds(-13, 141, 121, 15);
		lblItemsVenta.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblItemsVenta);
		
		JButton btnAgregarItemventa = new JButton("Agregar ItemVenta");
		btnAgregarItemventa.setBounds(-7, 76, 115, 29);
		contentPane.add(btnAgregarItemventa);
	}





	private void limpiarPantalla() {
		dniElegido = 0;
		nombreCliente.setText("");
		comboProductos.setSelectedIndex(0);
		comboClientes.setSelectedIndex(0);

	}
}
