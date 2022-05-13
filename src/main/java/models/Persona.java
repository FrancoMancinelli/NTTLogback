package models;

public class Persona {

	// Propiedades
	private String nombre;
	private String apellidos;
	private String dni;
	private double sueldo;
	private CuentaCorriente cuenta;

	// Getters y Setters
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorriente c) {
		this.cuenta = c;
	}

	// Constructores
	public Persona(String nombre, String apellidos, String dni, double sueldo, CuentaCorriente persona) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuenta = persona;
	}

	// Metodos
	public void cobrarSueldo() {
		cuenta.sumarCantidad(sueldo);
	}

	public void sacarDinero(double cantidad) {
		cuenta.restarCantidad(cantidad);
	}

	public void subirSueldo(double nuevoSueldo) {
		setSueldo(nuevoSueldo);
	}

	public void verInfo() {
		System.out.print("  »» User Info [Nombre: " + nombre + " | Apellido: " + apellidos + " | DNI: " + dni
				+ " | Sueldo: " + sueldo + " | Saldo: " + cuenta.getSaldo() + "]\n");
	}

	// toString
	@Override
	public String toString() {
		return " [Nombre = " + nombre + " | DNI = " + dni + "]";
	}

}
