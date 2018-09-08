package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.ItemVenta;
import bean.Venta;
import interfaz.TDAManejoDatos;

import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class ListarItemsVentaView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 * @throws RemoteException 
	 */
	public ListarItemsVentaView(TDAManejoDatos manejoDatos, int codigoVenta) throws RemoteException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(298, 199, 115, 29);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnVolver);
		
		List list = new List();
		list.setBounds(10, 37, 403, 156);
		for(ItemVenta iv: manejoDatos.getItemsVenta(codigoVenta)){
			
			list.add(iv.toString());
		}
		contentPane.add(list);
				
		textField = new JTextField();
		textField.setText(String.valueOf(codigoVenta));
		textField.setEditable(false);
		textField.setBounds(104, 5, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCdVenta = new JLabel("C\u00F3d. Venta: ");
		lblCdVenta.setBounds(10, 8, 89, 20);
		contentPane.add(lblCdVenta);
	}
}
