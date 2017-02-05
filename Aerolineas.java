import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Aerolineas extends JFrame {

	private JPanel contentPane;
	private JList lAeroOr;
	private JList lAeroDest;
	private JLabel lblAeropuertoOrigen;
	private JLabel lblAeropuertoDestino;
	private JButton bGuardarVuelo;
	private JButton bCargarAero;
	private JCheckBox escala;
	private JLabel lblMxNDe;
	private JSpinner maxPasajeros;
	private JLabel lblPasajerosDelVuelo;
	private JButton cargarPasajeros;
	private JScrollPane scrollPane_2;
	private JLabel lblVuelosCreados;
	private JScrollPane scrollPane_3;
	private JLabel lResultado;
	private JFileChooser fc = new JFileChooser();
	private FileReader fr;
	private Aeropuerto aero;
	private Pasajero pasaj;
	private Vuelo vuelo;
	private JList lPasajeros;
	private JList lVuelos;
	private int contador = 1;
	private ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
	private ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aerolineas frame = new Aerolineas();
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
	public Aerolineas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 495);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnReserva = new JMenu("Reserva");
		menuBar.add(mnReserva);
		
		JMenuItem mGuardarRe = new JMenuItem("Guardar reserva");
		mGuardarRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarReserva();
			}
		});
		mnReserva.add(mGuardarRe);
		
		JMenuItem mCargarRe = new JMenuItem("Cargar reserva");
		mCargarRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarReserva();
			}
		});
		mnReserva.add(mCargarRe);
		
		JMenuItem mSalir = new JMenuItem("Salir");
		mSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnReserva.add(mSalir);
		
		JMenu mnVuelo = new JMenu("Vuelo");
		menuBar.add(mnVuelo);
		
		JMenuItem mcargarAero = new JMenuItem("Cargar aeropuertos");
		mcargarAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarAeropuertos();
			}
		});
		mnVuelo.add(mcargarAero);
		
		JMenuItem mCargarPasaj = new JMenuItem("Cargar pasajeros");
		mCargarPasaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarPasajeros();
			}
		});
		mnVuelo.add(mCargarPasaj);
		
		JMenuItem mGuardarVuelo = new JMenuItem("Guardar vuelo");
		mnVuelo.add(mGuardarVuelo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAeropuertoOrigen = new JLabel("Aeropuerto ORIGEN");
		lblAeropuertoOrigen.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAeropuertoOrigen.setBounds(37, 40, 110, 14);
		contentPane.add(lblAeropuertoOrigen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 74, 174, 79);
		contentPane.add(scrollPane);
		
		lAeroOr = new JList();
		scrollPane.setViewportView(lAeroOr);
		
		lblAeropuertoDestino = new JLabel("Aeropuerto DESTINO");
		lblAeropuertoDestino.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAeropuertoDestino.setBounds(243, 40, 110, 14);
		contentPane.add(lblAeropuertoDestino);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(240, 74, 174, 79);
		contentPane.add(scrollPane_1);
		
		lAeroDest = new JList();
		scrollPane_1.setViewportView(lAeroDest);
		
		bGuardarVuelo = new JButton("GUARDAR VUELO");
		bGuardarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarVuelo();
				inicializar();
			}
		});
		bGuardarVuelo.setFont(new Font("Tahoma", Font.BOLD, 10));
		bGuardarVuelo.setBounds(474, 72, 132, 23);
		contentPane.add(bGuardarVuelo);
		
		bCargarAero = new JButton("Cargar aeropuertos");
		bCargarAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarAeropuertos();
			}
		});
		bCargarAero.setFont(new Font("Tahoma", Font.BOLD, 10));
		bCargarAero.setBounds(37, 178, 149, 23);
		contentPane.add(bCargarAero);
		
		escala = new JCheckBox("Con escala");
		escala.setFont(new Font("Tahoma", Font.BOLD, 10));
		escala.setBounds(240, 178, 97, 23);
		contentPane.add(escala);
		
		lblMxNDe = new JLabel("M\u00E1x. n\u00BA de pasageros");
		lblMxNDe.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMxNDe.setBounds(243, 220, 124, 14);
		contentPane.add(lblMxNDe);
		
		maxPasajeros = new JSpinner();
		maxPasajeros.setModel(new SpinnerNumberModel(1, 1, 200, 1));
		maxPasajeros.setBounds(364, 217, 50, 20);
		contentPane.add(maxPasajeros);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(37, 324, 264, 79);
		contentPane.add(scrollPane_2);
		
		lPasajeros = new JList();
		scrollPane_2.setViewportView(lPasajeros);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(353, 324, 265, 79);
		contentPane.add(scrollPane_3);
		
		lVuelos = new JList();
		scrollPane_3.setViewportView(lVuelos);
		
		lblPasajerosDelVuelo = new JLabel("Pasajeros del vuelo");
		lblPasajerosDelVuelo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPasajerosDelVuelo.setBounds(37, 300, 110, 14);
		contentPane.add(lblPasajerosDelVuelo);
		
		cargarPasajeros = new JButton("Cargar pasajeros");
		cargarPasajeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarPasajeros();
			}
		});
		cargarPasajeros.setFont(new Font("Tahoma", Font.BOLD, 10));
		cargarPasajeros.setBounds(163, 290, 124, 23);
		contentPane.add(cargarPasajeros);
		
		lblVuelosCreados = new JLabel("VUELOS CREADOS");
		lblVuelosCreados.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblVuelosCreados.setBounds(364, 300, 97, 14);
		contentPane.add(lblVuelosCreados);
		
		lResultado = new JLabel("");
		lResultado.setBounds(427, 260, 209, 14);
		contentPane.add(lResultado);
	}
	/*public Aeropuerto difAeropuerto(String abr) {
		if()
	}*/
	public void cargarAeropuertos() {
		try {
			int returnVal = fc.showOpenDialog(contentPane);
			if(returnVal == fc.APPROVE_OPTION) {
				fr = new FileReader(fc.getSelectedFile());
				BufferedReader br = new BufferedReader(fr);
				String linea = null;
				String result[] = null;
				while((linea = br.readLine()) != null) {
					result = linea.split("#");
					aero = new Aeropuerto(result[0],result[1],result[2]);
					aeropuertos.add(aero);
				}
				lAeroOr.setListData(aeropuertos.toArray());
				lAeroDest.setListData(aeropuertos.toArray());
				br.close();
				lResultado.setText("Aeropuertos cargados");
			} else if(returnVal == fc.CANCEL_OPTION) {
				lResultado.setText("Operación cancelada");
			}
		} catch(IOException ex) {
			lResultado.setText("Error en la operación");
		}
	}
	public void cargarPasajeros() {
		try {
			int returnVal = fc.showOpenDialog(contentPane);
			if(returnVal == fc.APPROVE_OPTION) {
				fr = new FileReader(fc.getSelectedFile());
				BufferedReader br = new BufferedReader(fr);
				String linea = null;
				String result[] = null;
				while((linea = br.readLine()) != null) {
					result = linea.split("#");
					int edad = Integer.parseInt(result[2]);
					pasaj = new Pasajero(result[0],result[1],edad);
					pasajeros.add(pasaj);
				}
				lPasajeros.setListData(pasajeros.toArray());
				br.close();
				lResultado.setText("Pasajeros cargados");
			} else if(returnVal == fc.CANCEL_OPTION) {
				lResultado.setText("Operación cancelada");
			}
		} catch(IOException ex) {
			lResultado.setText("Error en la operación");
		}
	}
	public void guardarVuelo() {
		try {
			if(lAeroOr.isSelectedIndex(-1)) {
				lResultado.setText("Tienes que elegir un origen");
			} else if(lAeroDest.isSelectedIndex(-1)) {
				lResultado.setText("Tienes que elegir un destino");
			} else {
				Aeropuerto origen = aeropuertos.get(lAeroOr.getSelectedIndex());
				Aeropuerto destino = aeropuertos.get(lAeroDest.getSelectedIndex());
				int numPasajeros = (int) maxPasajeros.getValue();
				boolean esc = escala.isSelected();
				vuelo = new Vuelo(contador,origen,destino,numPasajeros,pasajeros,esc);
				vuelos.add(vuelo);
				lVuelos.setListData(vuelos.toArray());
				lResultado.setText("");
			}
		} catch(ArrayIndexOutOfBoundsException ex) {
			lResultado.setText("Selecciona origen y destino");
		}
	}
	public void guardarReserva() {
		try {
			FileOutputStream fo = new FileOutputStream("fichero.txt");
			ObjectOutputStream os = new ObjectOutputStream(fo);
			os.writeObject(vuelos);
			os.close();
			lResultado.setText("Reserva guardada");
		} catch(Exception ex) {
			lResultado.setText("Error en la operación");
		}
	}
	public void cargarReserva() {
		try {
			FileInputStream fs = new FileInputStream("fichero.txt");
			ObjectInputStream os = new ObjectInputStream(fs);
			Object uno = os.readObject();
			vuelos = (ArrayList<Vuelo>) uno;
			lVuelos.setListData(vuelos.toArray());
			lResultado.setText("Reserva cargada");
		} catch(Exception ex) {
			lResultado.setText("Error en la operación");
		}
	}
	public void inicializar() {
		lAeroOr.clearSelection();
		lAeroDest.clearSelection();
		maxPasajeros.setMinimumSize(getMinimumSize());
	}
}
