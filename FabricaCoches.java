
import java.awt.EventQueue;



import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class FabricaCoches extends JFrame {

	private JPanel contentPane;
	private JButton bMatAleatoria;
	private JComboBox comboMarca;
	private JComboBox comboModelo;
	private JComboBox comboColor;
	private JButton bFabricaCoche;
	private JLabel lMatricula;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblNewLabel;
	private JLabel lMaxCoches;
	private JTextField txtMatricula;
	private Coche car;
	private ArrayList<Coche> listaCoches;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FabricaCoches frame = new FabricaCoches();
					frame.setTitle("Fábrica de Coches P8.11");
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
	public FabricaCoches() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listaCoches = new ArrayList<Coche>();
		
		lMatricula = new JLabel("Matricula");
		lMatricula.setBounds(27, 53, 46, 14);
		contentPane.add(lMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtMatricula.setBounds(87, 50, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(27, 89, 46, 14);
		contentPane.add(lblMarca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(27, 127, 46, 14);
		contentPane.add(lblModelo);
		
		lblNewLabel = new JLabel("Color");
		lblNewLabel.setBounds(27, 162, 46, 14);
		contentPane.add(lblNewLabel);
		
		comboMarca = new JComboBox();
		comboMarca.setModel(new DefaultComboBoxModel(new String[] {"Seat", "Opel", "Fiat", "Toyota", "Ford"}));
		comboMarca.setBounds(87, 86, 86, 20);
		contentPane.add(comboMarca);
		comboMarca.setSelectedIndex(-1);
		
		comboModelo = new JComboBox();
		comboModelo.setModel(new DefaultComboBoxModel(new String[] {"Turismo", "Deportivo", "Familiar", "Pickup"}));
		comboModelo.setBounds(87, 124, 86, 20);
		contentPane.add(comboModelo);
		comboModelo.setSelectedIndex(-1);
		
		comboColor = new JComboBox();
		comboColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Azul", "Rojo", "Verde"}));
		comboColor.setBounds(87, 159, 86, 20);
		contentPane.add(comboColor);
		comboColor.setSelectedIndex(-1);
		
		bMatAleatoria = new JButton("Aleatoria");
		bMatAleatoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMatricula.setText(matAleatoria());
			}
		});
		bMatAleatoria.setBounds(183, 49, 89, 23);
		contentPane.add(bMatAleatoria);
		
		bFabricaCoche = new JButton("Fabrica coche");
		bFabricaCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCoche();
			}
		});
		bFabricaCoche.setBounds(27, 209, 115, 23);
		contentPane.add(bFabricaCoche);
		
		lMaxCoches = new JLabel("");
		lMaxCoches.setBounds(87, 279, 308, 14);
		contentPane.add(lMaxCoches);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(307, 53, 167, 186);
		contentPane.add(scrollPane);
		
		list = new JList(listaCoches.toArray());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(arg0.getValueIsAdjusting() == false) {
					switch(list.getSelectedIndex())
					{
					case 0:
						txtMatricula.setText(listaCoches.get(list.getSelectedIndex()).getMatricula());
						comboMarca.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getMarca());
						comboModelo.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getModelo());
						comboColor.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getColor());
					case 1:
						txtMatricula.setText(listaCoches.get(list.getSelectedIndex()).getMatricula());
						comboMarca.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getMarca());
						comboModelo.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getModelo());
						comboColor.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getColor());
					case 2:
						txtMatricula.setText(listaCoches.get(list.getSelectedIndex()).getMatricula());
						comboMarca.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getMarca());
						comboModelo.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getModelo());
						comboColor.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getColor());
					case 3:
						txtMatricula.setText(listaCoches.get(list.getSelectedIndex()).getMatricula());
						comboMarca.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getMarca());
						comboModelo.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getModelo());
						comboColor.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getColor());
					case 4:
						txtMatricula.setText(listaCoches.get(list.getSelectedIndex()).getMatricula());
						comboMarca.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getMarca());
						comboModelo.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getModelo());
						comboColor.setSelectedItem(listaCoches.get(list.getSelectedIndex()).getColor());
					}
				}
			}
		});
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		JButton btnBorrarCoche = new JButton("Borrar");
		btnBorrarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarCoche();
			}
		});
		btnBorrarCoche.setBounds(157, 243, 115, 23);
		contentPane.add(btnBorrarCoche);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarCoche();
			}
		});
		btnNewButton.setBounds(27, 243, 115, 23);
		contentPane.add(btnNewButton);
	}
	public String matAleatoria() {
		String matRandom = "";
		for(int i = 0;i < 7;i++) {
			int m = (int) (Math.random() * 10);
			matRandom = matRandom + Integer.toString(m);
		}
		return matRandom;
	}
	public void crearCoche() {
		String str_m = "";
		if(Coche.getNumCoches() < Coche.MAX_COCHES) {
			if(txtMatricula.getText().isEmpty()){
				lMaxCoches.setText("Tienes que poner una matricula.");
				txtMatricula.requestFocus();
			} else if(comboMarca.getSelectedIndex() == -1) {
				lMaxCoches.setText("Tienes que poner una marca.");
				comboMarca.requestFocus();
			} else if(comboModelo.getSelectedIndex() == -1) {
				lMaxCoches.setText("Tienes que poner un modelo.");
				comboModelo.requestFocus();
			} else if(comboColor.getSelectedIndex() == -1) {
				lMaxCoches.setText("Tienes que poner un color.");
				comboColor.requestFocus();
			} else {
					str_m = txtMatricula.getText();
					String str_mc = (String) comboMarca.getSelectedItem();
					String str_md = (String) comboModelo.getSelectedItem();
					String str_c = (String) comboColor.getSelectedItem();
					car = new Coche(str_m,str_mc,str_md,str_c);
					listaCoches.add(car);
					lMaxCoches.setText("");
					list.setListData(listaCoches.toArray());
			}
		} else {
			lMaxCoches.setText("No es posible crear más coches,la fábrica está llena");
		}
	}
	public void borrarCoche() {
		try {
			listaCoches.remove(list.getSelectedIndex());
			list.setListData(listaCoches.toArray());
			int nCoches = Coche.getNumCoches();
			Coche.setNumCoches(nCoches-1);
			lMaxCoches.setText("");
		}catch(ArrayIndexOutOfBoundsException e) {
			lMaxCoches.setText("Tienes que seleccionar un coche.");
		}
	}
	public void modificarCoche() {
		try {
			if(txtMatricula.getText().isEmpty()){
				lMaxCoches.setText("Tienes que poner una matricula.");
				txtMatricula.requestFocus();
			} else {
				String str_m = txtMatricula.getText();
				String str_mc = (String) comboMarca.getSelectedItem();
				String str_md = (String) comboModelo.getSelectedItem();
				String str_c = (String) comboColor.getSelectedItem();
				listaCoches.get(list.getSelectedIndex()).setMatricula(str_m);
				listaCoches.get(list.getSelectedIndex()).setMarca(str_mc);
				listaCoches.get(list.getSelectedIndex()).setModelo(str_md);
				listaCoches.get(list.getSelectedIndex()).setColor(str_c);
				list.setListData(listaCoches.toArray());
			}
		}catch (ArrayIndexOutOfBoundsException ex) {
			lMaxCoches.setText("Tienes que seleccionar un coche.");
		}
	}
}
