
public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private static int numCoches;
	public static final int MAX_COCHES = 5;
	
	public Coche() {
		matricula = "";
		marca = "";
		modelo = "";
		color = "";
		numCoches++;
	}
	public Coche(String m,String mc,String md,String c) {
		this();
		setMatricula(m);
		setMarca(mc);
		setModelo(md);
		setColor(c);
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public static int getNumCoches() {
		return numCoches;
	}
	public static void setNumCoches(int numCoches) {
		Coche.numCoches = numCoches;
	}
	public String toString() {
		String cadena = getMatricula() + " " + getMarca() + " " + getModelo() + " " + getColor() + " \n";
		return cadena;
	}
}
