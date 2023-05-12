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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.josema.controlador.HuespedController;
import com.josema.modelo.Huesped;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class EditarHuesped extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarHuesped frame = new EditarHuesped(new Huesped());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JDateChooser txtFechaN;
	private JTextField txtDni;
	private JLabel labelExit;
	private JLabel labelAtras;
	private HuespedController controller=new HuespedController();

	int xMouse, yMouse;

	/**
	 * Create the frame.
	 */
	public EditarHuesped(Huesped huesped) {
		super("Editar Huesped");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(EditarHuesped.class.getResource("/com/josema/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);

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
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

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
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(12, 138, 199));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNombre.setBounds(560, 138, 285, 33);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 285, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtApellido);

		txtFechaN = new JDateChooser();
		txtFechaN.getCalendarButton().setForeground(new Color(0, 0, 0));
		txtFechaN.setBounds(560, 278, 285, 36);
		txtFechaN.getCalendarButton()
				.setIcon(new ImageIcon(EditarHuesped.class.getResource("/com/josema/imagenes/icon-reservas.png")));
		txtFechaN.getCalendarButton().setBackground(new Color(30, 144, 255));
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		txtFechaN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(txtFechaN);

		txtDni = new JTextField();
		txtDni.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtDni.setBounds(560, 354, 285, 33);
		txtDni.setBackground(Color.WHITE);
		txtDni.setColumns(10);
		txtDni.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtDni);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(562, 111, 283, 24);
		lblNombre.setForeground(SystemColor.textInactiveText);
		lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(560, 181, 285, 24);
		lblApellido.setForeground(SystemColor.textInactiveText);
		lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblApellido);

		JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
		lblFechaN.setBounds(560, 252, 285, 24);
		lblFechaN.setForeground(SystemColor.textInactiveText);
		lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblFechaN);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(560, 326, 285, 24);
		lblDni.setForeground(SystemColor.textInactiveText);
		lblDni.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblDni);

		JLabel lblTelefono = new JLabel("TELÉFONO");
		lblTelefono.setBounds(562, 401, 283, 24);
		lblTelefono.setForeground(SystemColor.textInactiveText);
		lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);

		JLabel lblTitulo = new JLabel("EDITAR HUÉSPED");
		lblTitulo.setBounds(606, 55, 271, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblTitulo);
		

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 171, 289, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);

		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(12, 138, 199));
		separator_1_2_1.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_1);

		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 315, 289, 2);
		separator_1_2_2.setForeground(new Color(12, 138, 199));
		separator_1_2_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_2);

		JSeparator separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 387, 289, 2);
		separator_1_2_3.setForeground(new Color(12, 138, 199));
		separator_1_2_3.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_3);

		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(12, 138, 199));
		separator_1_2_4.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2_4);

		JPanel btnGuardar = new JPanel();
		btnGuardar.setBounds(723, 560, 122, 35);
		btnGuardar.setLayout(null);
		btnGuardar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnGuardar);
		btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel labelGuardar = new JLabel("GUARDAR");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnGuardar.add(labelGuardar);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(12, 138, 199));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		panel.add(imagenFondo);
		imagenFondo.setIcon(new ImageIcon(EditarHuesped.class.getResource("/com/josema/imagenes/registro.png")));

		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(EditarHuesped.class.getResource("/com/josema/imagenes/Ha-100px.png")));

		JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		//contentPane.add(btnexit);
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
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.white);
		

		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		header.add(btnexit);
		
		JPanel btnCancelar = new JPanel();
		btnCancelar.setLayout(null);
		btnCancelar.setBackground(new Color(247, 101, 111));
		btnCancelar.setBounds(560, 560, 122, 35);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnCancelar);
		
		JLabel lblCancelar = new JLabel("CANCELAR");
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setForeground(Color.WHITE);
		lblCancelar.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblCancelar.setBounds(0, 0, 122, 35);
		btnCancelar.add(lblCancelar);
		
		
		
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualizarHuesped(huesped);
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
		
		llenarFormulario(huesped);
		
	}
	
	protected void llenarFormulario(Huesped huesped) {
		txtNombre.setText(huesped.getNombre());
		txtApellido.setText(huesped.getApellido());
		txtFechaN.setDate(huesped.getFechaDeNacimiento());
		txtDni.setText(huesped.getDni());
		txtTelefono.setText(huesped.getTelefono());
	}
	

	protected void actualizarHuesped(Huesped huesped) {
		String nombre=txtNombre.getText().trim();
		String apellido=txtApellido.getText().trim();
		String fechaNacimiento=((JTextField)txtFechaN.getDateEditor().getUiComponent()).getText().trim();
		String dni=txtDni.getText().trim();
		String telefono=txtTelefono.getText().trim();
		
		if(nombre.isBlank() || apellido.isBlank() || fechaNacimiento.isBlank() || dni.isBlank() ||telefono.isBlank() ) {
			JOptionPane.showMessageDialog(contentPane, "Debes llenar todos los campos.");
			return;
		}
		
		
		huesped.setApellido(apellido);
		huesped.setNombre(nombre);
		huesped.setFechaDeNacimiento(java.sql.Date.valueOf(fechaNacimiento));
		huesped.setDni(dni);
		huesped.setTelefono(telefono);
		
		controller.update(huesped);
		JOptionPane.showMessageDialog(contentPane, "Huesped acualizado con éxito");
		
		Busqueda busqueda=new Busqueda();
		busqueda.setVisible(true);
		dispose();
	}
	
	// Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}
}
