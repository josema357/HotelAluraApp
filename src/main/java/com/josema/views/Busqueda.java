package com.josema.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.josema.controlador.HuespedController;
import com.josema.controlador.ReservaController;
import com.josema.modelo.Huesped;
import com.josema.modelo.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private JTabbedPane panel;
	int xMouse, yMouse;
	
	ReservaController controllerReserva=new ReservaController();
	HuespedController controllerHuesped=new HuespedController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					
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
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/com/josema/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(539, 127, 190, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(315, 62, 296, 42);
		contentPane.add(lblNewLabel_4);
		
		panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		
		
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/com/josema/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("DNI");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reservas");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/com/josema/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/com/josema/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(631, 507, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(247, 101, 111));
		btnEliminar.setBounds(763, 507, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		
		JPanel btnActualizar = new JPanel();
		btnActualizar.setLayout(null);
		btnActualizar.setBackground(new Color(12, 138, 199));
		btnActualizar.setBounds(482, 507, 139, 35);
		btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnActualizar);
		
		JLabel lblActualizar = new JLabel("ACTUALIZAR");
		lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizar.setForeground(Color.WHITE);
		lblActualizar.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblActualizar.setBounds(0, 0, 139, 35);
		btnActualizar.add(lblActualizar);
		setResizable(false);
		
		//Eventos de los botones
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchRecord();
			}
		});
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateRecord();
			}
		});
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteRecord();
			}
		});
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String windowName=panel.getTitleAt(panel.getSelectedIndex());
				switch (windowName) {
				case "Reservas":
					updateReservas();
					break;
				case "Huéspedes":
					updateHuespedes();
				default:
					break;
				}
			}
		});
		
		//Actualizar lista
		updateReservas();
		updateHuespedes();
		
	}
	
	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
	    xMouse = evt.getX();
	    yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	    int x = evt.getXOnScreen();
	    int y = evt.getYOnScreen();
	     this.setLocation(x - xMouse, y - yMouse);
	}
	
	//Metodos para los eventos de los botones
	private void searchRecord() {
		String windowName=panel.getTitleAt(panel.getSelectedIndex());
		String userInput=txtBuscar.getText();
		
		switch(windowName) {
			case "Reservas" :
				if(userInput.isBlank()) {
					updateReservas();
					return;
				}else if (userInput.equalsIgnoreCase("null")) {
					modelo.setRowCount(0);
					for(Reserva reser: controllerReserva.searchNull()) {
						modelo.addRow(reser.toArray());
					}
				}else {
					modelo.setRowCount(0);
					for(Reserva reser: controllerReserva.search(userInput)) {
						modelo.addRow(reser.toArray());
					}
				}
				break;
			case "Huéspedes":
				if(userInput.isBlank()) {
					updateHuespedes();
					return;
				}
				modeloHuesped.setRowCount(0);
				for(Huesped hues: controllerHuesped.search(userInput)) {
					modeloHuesped.addRow(hues.toArray());
				}
				break;
			default:
				JOptionPane.showMessageDialog(contentPane, "Ventana no identificada");
			
		}
	}
	private void updateRecord() {
		String windowNmae=panel.getTitleAt(panel.getSelectedIndex());
		int indexRow;
		switch (windowNmae) {
		case "Reservas":
			indexRow=tbReservas.getSelectedRow();
			if(indexRow==-1) {
				JOptionPane.showMessageDialog(contentPane, "Selecciona un registro");
				return;
			}
			String idReserva=(String)modelo.getValueAt(indexRow, 0);
			Reserva reservaEdit=controllerReserva.getById(Long.parseLong(idReserva));
			
			EditarReserva editarReserva=new EditarReserva(reservaEdit);
			editarReserva.setVisible(true);
			dispose();
			break;
		case "Huéspedes":
			indexRow=tbHuespedes.getSelectedRow();
			if(indexRow==-1){
				JOptionPane.showMessageDialog(contentPane, "Selecciona un registro");
				return;
			}
			String idHuesped=(String)modeloHuesped.getValueAt(indexRow, 0);
			Huesped huespedEdit=controllerHuesped.getById(Long.parseLong(idHuesped));
			
			EditarHuesped editarHuesped=new EditarHuesped(huespedEdit);
			editarHuesped.setVisible(true);
			dispose();
			break;
			
		default:
			JOptionPane.showMessageDialog(contentPane, "Ventana no identificada");
		}
	}
	private void deleteRecord() {
		String windowName=panel.getTitleAt(panel.getSelectedIndex());
		int indexRow;
		Long id;
		int option;
		
		switch (windowName) {
		case "Reservas":
			indexRow=tbReservas.getSelectedRow();
			if(indexRow==-1) {
				JOptionPane.showMessageDialog(contentPane, "Selecciona un registro");
				return;
			}
			id=Long.valueOf((String) modelo.getValueAt(indexRow, 0));
			option=JOptionPane.showConfirmDialog(contentPane, "Estas seguro que deseas eliminar la reserva");
			if(option!=JOptionPane.YES_OPTION) {
				return;
			}
			modelo.removeRow(indexRow);
			controllerReserva.deleteById(id);
			break;
		case "Huéspedes":
			indexRow=tbHuespedes.getSelectedRow();
			if(indexRow==-1) {
				JOptionPane.showMessageDialog(contentPane, "Selecciona un registro");
				return;
			}
			id=Long.valueOf((String) modeloHuesped.getValueAt(indexRow, 0));
			option=JOptionPane.showConfirmDialog(
					contentPane, 
					"Estas seguro que deseas eliminar al huesped. Se eliminaran las reservas asociadas al huesped");
			if(option!=JOptionPane.YES_OPTION) {
				return;
			}
			
			modeloHuesped.removeRow(indexRow);
			controllerHuesped.delete(id);
			updateReservas();
			break;
		default:
			JOptionPane.showMessageDialog(contentPane, "Ventana no identificada");
		}
		
	}
	private void updateReservas() {
		modelo.setRowCount(0);
		for(Reserva reser: controllerReserva.list()) {
			modelo.addRow(reser.toArray());
		}
	}
	private void updateHuespedes() {
		modeloHuesped.setRowCount(0);
		for (Huesped hues: controllerHuesped.list()) {
			modeloHuesped.addRow(hues.toArray());
		}
	}
}
