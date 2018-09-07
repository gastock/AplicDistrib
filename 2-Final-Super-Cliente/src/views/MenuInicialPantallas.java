package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaz.TDAManejoDatos;

public class MenuInicialPantallas extends JFrame {
	private static final long serialVersionUID = 3328992046678089154L;

	//private static SistemaInscripciones sis = SistemaInscripciones.getInstancia();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					//		sis.loadFixtures();
//					VentanaInicial frame = new VentanaInicial(manejoDatos);
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
	public MenuInicialPantallas(TDAManejoDatos manejoDatos) {
		
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
				AltaClienteView altaCliente = null;
				altaCliente = new AltaClienteView(manejoDatos);
				altaCliente.setVisible(true);
				dispose();
			}
		});

		// Alta Producto Simple
		JMenuItem menuItemCrearProductoSimple = new JMenuItem("Crear Producto Simple");
		mnAbm.add(menuItemCrearProductoSimple);
		menuItemCrearProductoSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaProductoSimpleView altaProductoSimple = null;
				altaProductoSimple = new AltaProductoSimpleView(manejoDatos);
				altaProductoSimple.setVisible(true);
				dispose();
			}
		});
		
		// Alta Producto Combo
		JMenuItem menuItemCrearProductoComp = new JMenuItem("Crear Producto Combo");
		mnAbm.add(menuItemCrearProductoComp);
		menuItemCrearProductoComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaInscripcionRegular.getInstancia().setLocationRelativeTo(null);
				//		VentanaInscripcionRegular.getInstancia().setVisible(true);
				AltaProductoCompView altaProductoComp = null;
				altaProductoComp = new AltaProductoCompView(manejoDatos);
				altaProductoComp.setVisible(true);
				dispose();
			}
		});

		// Alta Venta
		JMenuItem menuItemVenta = new JMenuItem("Crear Venta");
		mnAbm.add(menuItemVenta);
		menuItemVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaInscripcionRegular.getInstancia().setLocationRelativeTo(null);
				//		VentanaInscripcionRegular.getInstancia().setVisible(true);

				AltaVentaView altaVenta = null;
				try {
					altaVenta = new AltaVentaView(manejoDatos);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				ListarClientesView listarClientes = null;
				try {
					listarClientes = new ListarClientesView(manejoDatos);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				listarClientes.setVisible(true);
				dispose();
			}
		});
		
		//Listar Productos
		JMenuItem menuItemListarProductos = new JMenuItem("Listar Productos");
		mnBaja.add(menuItemListarProductos);
		menuItemListarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaBajaMid.getInstancia().setLocationRelativeTo(null);
				//	VentanaBajaMid.getInstancia().setVisible(true);
				ListarProductosView listarProductos = null;
				try {
					listarProductos = new ListarProductosView(manejoDatos);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				listarProductos.setVisible(true);
				dispose();
			}
		});

		JMenuItem menuItemListarVentas = new JMenuItem("Listar Ventas");
		mnBaja.add(menuItemListarVentas);
		menuItemListarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaBajaMid.getInstancia().setLocationRelativeTo(null);
				//	VentanaBajaMid.getInstancia().setVisible(true);
				ListarVentasView listarVentas = null;
				try {
					listarVentas = new ListarVentasView(manejoDatos);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				listarVentas.setVisible(true);
				dispose();
			}
		});


		// Salir
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		JMenuItem mntmSalirSistemaInscripciones = new JMenuItem("Salir Sistema");
		mnSalir.add(mntmSalirSistemaInscripciones);
		getContentPane().setLayout(null);
		mntmSalirSistemaInscripciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
	}


}
