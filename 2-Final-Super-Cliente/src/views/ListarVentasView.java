package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import bean.Cliente;
import bean.Venta;
import interfaz.TDAManejoDatos;

public class ListarVentasView extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public ListarVentasView(TDAManejoDatos manejoDatos) throws RemoteException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListadoDeClientes = new JLabel("Listado de Ventas");
		lblListadoDeClientes.setBounds(15, 16, 221, 20);
		contentPane.add(lblListadoDeClientes);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(298, 210, 115, 29);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnVolver);

		List list = new List();
		list.setBounds(15, 42, 398, 162);
		for(Venta v: manejoDatos.getVentas()){
			list.add(v.toString());
		}
		contentPane.add(list);

		JButton btnDetalleDeVenta = new JButton("Detalle de Venta");
		btnDetalleDeVenta.setBounds(124, 210, 153, 29);
		btnDetalleDeVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//		VentanaBajaMid.getInstancia().setLocationRelativeTo(null);
				//	VentanaBajaMid.getInstancia().setVisible(true);
				ListarItemsVentaView listarItemsVentas = null;
				try {
//					Integer.parseInt(list.getSelectedItem());
					listarItemsVentas = new ListarItemsVentaView(manejoDatos, 1);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				listarItemsVentas.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnDetalleDeVenta);
	}
}
