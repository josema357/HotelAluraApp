package com.josema.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.josema.controlador.ReservaController;
import com.josema.modelo.Reserva;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class EditarReserva extends JFrame {

	public static JTextField txtValor;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<String> txtFormaPago;
	
	private double valorReservaGlobal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarReserva frame = new EditarReserva(new Reserva());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;

	private JLabel labelAtras;

	/**
	 * Create the frame.
	 */
	public EditarReserva(Reserva reserva) {
		super("Editar Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarReserva.class.getResource("/com/josema/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);

		// Código que crea los elementos de la interfáz gráfica

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);

		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);

		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 289, 24);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);

		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 289, 24);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);

		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 289, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);

		JLabel lblTitulo = new JLabel("EDITAR RESERVA");
		lblTitulo.setBounds(68, 60, 289, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(EditarReserva.class.getResource("/com/josema/imagenes/Ha-100px.png")));

		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 500, 409);
		panel_1.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(EditarReserva.class.getResource("/com/josema/imagenes/reservas-img-3.png")));

		JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 285, 24);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 363, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);

		// Componentes para dejar la interfaz con estilo Material Design
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda=new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(12, 138, 199));
				labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		panel.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda=new Busqueda();
				busqueda.setVisible(true);
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
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));

		JLabel lblGuardar = new JLabel("GUARDAR");
		lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardar.setForeground(Color.WHITE);
		lblGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblGuardar.setBounds(0, 0, 122, 35);

		// Campos que guardaremos en la base de datos
		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(new Color(30, 144, 255));
		txtFechaEntrada.getCalendarButton()
				.setIcon(new ImageIcon(EditarReserva.class.getResource("/com/josema/imagenes/icon-reservas.png")));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaEntrada.setBounds(68, 161, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaEntrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(txtFechaEntrada);

		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton()
				.setIcon(new ImageIcon(EditarReserva.class.getResource("/com/josema/imagenes/icon-reservas.png")));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(68, 246, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(new Color(30, 144, 255));
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		txtFechaSalida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(txtFechaSalida);

		txtValor = new JTextField("");
		txtValor.setEditable(false);
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.LEFT);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(68, 330, 289, 33);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);
		txtValor.setColumns(10);

		txtFormaPago = new JComboBox<>();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel<>(	new String[] { "Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo" }));
		panel.add(txtFormaPago);

		JPanel btnGuardar = new JPanel();
		btnGuardar.setLayout(null);
		btnGuardar.setBackground(SystemColor.textHighlight);
		btnGuardar.setBounds(238, 493, 122, 35);
		panel.add(btnGuardar);
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnGuardar.add(lblGuardar);
		
		JPanel btnCancelar = new JPanel();
		btnCancelar.setLayout(null);
		btnCancelar.setBackground(new Color(247, 101, 111));
		btnCancelar.setBounds(68, 493, 122, 35);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnCancelar);
		
		JLabel lblCancelar = new JLabel("CANCELAR");
		lblCancelar.setBackground(new Color(0, 0, 0));
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setForeground(Color.WHITE);
		lblCancelar.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblCancelar.setBounds(0, 0, 122, 35);
		btnCancelar.add(lblCancelar);
		
		llenarFormulario(reserva);
		
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarReserva(reserva);
			}
		});
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda=new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				calcularValor(txtFechaEntrada, txtFechaSalida);				
			}
		});
		
		txtFechaEntrada.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				calcularValor(txtFechaEntrada, txtFechaSalida);
			}
		});
	}
	//Calcular valor de la reserva
	private void calcularValor(JDateChooser entrada, JDateChooser salida) {
		 if(entrada.getDate()!=null && salida.getDate() != null) {
			 Calendar inicio = entrada.getCalendar();
			 Calendar fin = salida.getCalendar();
			 
			 int dias = -1; //Para que cuenta a partir del dia siguiente
			 int costoDiario = 50;
			 
			 while(inicio.before(fin)||inicio.equals(fin)) {
				 dias++;
				 inicio.add(Calendar.DATE, 1);
			 }
			 valorReservaGlobal = dias * costoDiario;
			 txtValor.setText("$ "+ Double.toString(valorReservaGlobal));
		 }
	 }
	// Código que permite mover la ventana por la pantalla según la posición de "x"y "y"
	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}
	
	//LLenar los datos de la reserva en el formulario
	private void llenarFormulario(Reserva reserva) {
		txtFechaEntrada.setDate(reserva.getFechaEntrada());
		txtFechaSalida.setDate(reserva.getFechaSalida());
		txtFormaPago.setSelectedItem(reserva.getFormaPago());
	}
	//Actualizar los datos en la BD
	private void actualizarReserva(Reserva reserva) {
		String fechaEntrada=((JTextField)txtFechaEntrada.getDateEditor().getUiComponent()).getText();
		String fechaSalida=((JTextField)txtFechaSalida.getDateEditor().getUiComponent()).getText();
		String valor=Double.toString(valorReservaGlobal);
		
		if( fechaEntrada.isBlank() ||  fechaSalida.isBlank() || valor.isBlank()) {
			JOptionPane.showMessageDialog(contentPane,"Verifica que las fechas sean las correctas");
			return;
		}
		
		Date dateEntrada=Date.valueOf(fechaEntrada);
		Date dateSalida=Date.valueOf(fechaSalida);
		
		if(dateEntrada.compareTo(dateSalida)>=0) {
			JOptionPane.showMessageDialog(contentPane,"La fecha de entrada no puede ser mayor a la de salida");
			return;
		}
		reserva.setFechaEntrada(dateEntrada);
		reserva.setFechaSalida(dateSalida);
		reserva.setValor(Double.parseDouble(valor));
		reserva.setFormaPago(txtFormaPago.getSelectedItem().toString());
			
		ReservaController controller=new ReservaController();
		controller.update(reserva);
		
		JOptionPane.showMessageDialog(contentPane,"Reserva actualizada con éxito");
		
		Busqueda busqueda=new Busqueda();
		busqueda.setVisible(true);
		dispose();
	}
}
