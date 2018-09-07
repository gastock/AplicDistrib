package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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


public class AltaVentaView2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 537605013701405665L;
	private JPanel contentPane;
	private JTextField dni;
	private JTextField nombreCliente;
	private JTextField diasPublicacion;
	private JLabel lblFecha;
	private JLabel lblfecha;
	private JLabel lblDniCliente;
	private JLabel lblNombreCliente;
	private JLabel lblAviso;
	private JLabel lblLineasAviso;
	private JLabel lblFechaPublicacion;
	private JDateChooser dateChooser;
	private JLabel lblCantidadDeDias;
	private JButton btnCancelar;
	private JButton btnAcpetar;
//	private Administrador sistema;
	private int avisoElegido;
	private DefaultListModel listModel;

	private List<ProductoView> productos;

	private JComboBox comboAviso;
	private JEditorPane lineaAviso;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public AltaVentaView2() {
//		avisos = new ArrayList<AvisoView>();
//		sistema = Administrador.getInstancia();
		setTitle("Crear Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblFecha = new JLabel("Fecha Venta:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(29, 11, 121, 15);

		lblDniCliente = new JLabel("DNI Cliente:");
		lblDniCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDniCliente.setBounds(29, 34, 121, 15);

		lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreCliente.setBounds(29, 59, 121, 15);

//		lblAviso = new JLabel("Aviso:");
//		lblAviso.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblAviso.setBounds(29, 84, 121, 15);

		lblLineasAviso = new JLabel("Lineas Items:");
		lblLineasAviso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLineasAviso.setBounds(29, 107, 121, 15);

		dni = new JTextField();
		dni.setBounds(170, 31, 250, 19);
		dni.setColumns(10);

		nombreCliente = new JTextField();
		nombreCliente.setBounds(170, 56, 250, 19);
		nombreCliente.setColumns(10);

		lblFechaPublicacion = new JLabel("Fecha publicacion:");
		lblFechaPublicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaPublicacion.setBounds(10, 199, 140, 15);

//		lblCantidadDeDias = new JLabel("Dias de publicacion:");
//		lblCantidadDeDias.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblCantidadDeDias.setBounds(10, 225, 140, 15);

		// Para la fecha:
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		lblfecha = new JLabel(dtf.format(localDate));
		lblfecha.setBounds(262, 11, 72, 15);

		btnAcpetar = new JButton("Aceptar");
		btnAcpetar.setBounds(306, 264, 114, 25);
		btnAcpetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
//					sistema.registrarPublicacion(new java.sql.Date(dateChooser
//							.getDate().getTime()), avisoElegido, lineaAviso
//							.getText(), Integer.parseInt(diasPublicacion
//							.getText()), Integer.parseInt(dni.getText()),
//							nombreCliente.getText());
//					JOptionPane.showMessageDialog(null,
//							"La publicación fue creada correctamente!");
//					limpiarPantalla();
//					dispose();
//				} catch (AvisoException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Por favor verifique los datos ingresados");
				}

			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(170, 264, 114, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		diasPublicacion = new JTextField();
		diasPublicacion.setBounds(170, 222, 250, 19);
		diasPublicacion.setColumns(10);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(170, 195, 250, 19);
		contentPane.setLayout(null);
		contentPane.add(lblFecha);
		contentPane.add(lblfecha);
		contentPane.add(lblDniCliente);
		contentPane.add(dni);
//		contentPane.add(lblNombreCliente);
//		contentPane.add(nombreCliente);
//		contentPane.add(lblAviso);
//		contentPane.add(lblLineasAviso);
		contentPane.add(lblFechaPublicacion);
		contentPane.add(dateChooser);
//		contentPane.add(lblCantidadDeDias);
//		contentPane.add(diasPublicacion);
		contentPane.add(btnCancelar);
		contentPane.add(btnAcpetar);

		comboAviso = new JComboBox();
		comboAviso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				int i = comboAviso.getSelectedIndex() - 1;
				avisoElegido = 0;
//				if (i >= 0)
//					avisoElegido = avisos.get(i).getCodigo();
			}
		});
		comboAviso.setBounds(170, 79, 250, 24);
		poblarComboAvisos();
		contentPane.add(comboAviso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 107, 250, 76);
		contentPane.add(scrollPane);
		
		lineaAviso = new JEditorPane();
		scrollPane.setViewportView(lineaAviso);
	}

	private void limpiarPantalla() {
		dni.setText("");
		nombreCliente.setText("");
		comboAviso.setSelectedIndex(0);
		lineaAviso.setText("");
		dateChooser.setDate(null);
		diasPublicacion.setText("");

	}

	private void poblarComboAvisos() {
		listModel = new DefaultListModel();
//		avisos.clear();
//		avisos = sistema.getAvisos();
		comboAviso.setModel(new DefaultComboBoxModel(productos.toArray()));
		comboAviso.insertItemAt("Seleccione un producto", 0);
		comboAviso.setSelectedIndex(0);

	}
}
