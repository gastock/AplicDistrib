package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.*;

public class VentanaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3328992046678089154L;

	//private static SistemaInscripciones sis = SistemaInscripciones.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//		sis.loadFixtures();
					VentanaInicial frame = new VentanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicial() {
		setTitle("Sistema de Supermercado");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 550, 400);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAbm = new JMenu("Alta");
		menuBar.add(mnAbm);

		// Alta Cliente
		JMenuItem menuItemCrearCliente = new JMenuItem("Crear Cliente");
		mnAbm.add(menuItemCrearCliente);
		menuItemCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaInscripcionIndividual.getInstancia().setLocationRelativeTo(null);
				//		VentanaInscripcionIndividual.getInstancia().setVisible(true);
			}
		});

		// Alta Producto Simple
		JMenuItem menuItemCrearProductoSimple = new JMenuItem("Crear Producto Simple");
		mnAbm.add(menuItemCrearProductoSimple);
		menuItemCrearProductoSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaInscripcionRegular.getInstancia().setLocationRelativeTo(null);
				//		VentanaInscripcionRegular.getInstancia().setVisible(true);
			}
		});
		
		// Alta Producto Combo
		JMenuItem menuItemCrearProductoComp = new JMenuItem("Crear Producto Combo");
		mnAbm.add(menuItemCrearProductoComp);
		menuItemCrearProductoComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaInscripcionRegular.getInstancia().setLocationRelativeTo(null);
				//		VentanaInscripcionRegular.getInstancia().setVisible(true);
			}
		});

		// Alta Venta
		JMenuItem menuItemVenta = new JMenuItem("Crear Venta");
		mnAbm.add(menuItemVenta);
		menuItemVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaInscripcionRegular.getInstancia().setLocationRelativeTo(null);
				//		VentanaInscripcionRegular.getInstancia().setVisible(true);

				AltaVentaView2 altaVenta = new AltaVentaView2();
				altaVenta.setVisible(true);
				dispose();

			}
		});


		// Menu Listar 
		JMenu mnBaja = new JMenu("Listar");
		menuBar.add(mnBaja);

		//Listar Clientes
		JMenuItem menuItemListarClientes = new JMenuItem("Listar Clientes");
		mnBaja.add(menuItemListarClientes);
		menuItemListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaBajaMid.getInstancia().setLocationRelativeTo(null);
				//	VentanaBajaMid.getInstancia().setVisible(true);
			}
		});
		
		//Listar Productos
		JMenuItem menuItemListarProductos = new JMenuItem("Listar Productos");
		mnBaja.add(menuItemListarProductos);
		menuItemListarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaBajaMid.getInstancia().setLocationRelativeTo(null);
				//	VentanaBajaMid.getInstancia().setVisible(true);
			}
		});

		JMenuItem menuItemListarVentas = new JMenuItem("Listar Ventas");
		mnBaja.add(menuItemListarVentas);
		menuItemListarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaBajaMid.getInstancia().setLocationRelativeTo(null);
				//	VentanaBajaMid.getInstancia().setVisible(true);
			}
		});


		// Salir
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		JMenuItem mntmSalirSistemaInscripciones = new JMenuItem("Salir Sistema");
		mnSalir.add(mntmSalirSistemaInscripciones);
		mntmSalirSistemaInscripciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
	}

}
