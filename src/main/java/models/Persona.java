package models;

/**
 * Formación - Logback
 * 
 * Clase Persona
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public class Persona {

	// ~~ PROPIEDADES
	private String nombre;
	private String apellidos;
	private String dni;
	private double sueldo;
	private CuentaCorriente cuenta;

	// ~~ CONSTRUCTOR
	
	/**
	 * Construye una Persona nueva
	 * @param nombre Nombre de la persona
	 * @param apellidos Apellidos de la persona
	 * @param dni DNI de la persona
	 * @param sueldo Sueldo de la persona
	 * @param cc Cuenta Corriente asignada a la persona
	 */
	public Persona(String nombre, String apellidos, String dni, double sueldo, CuentaCorriente cc) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuenta = cc;
	}

	// ~~ GETTERS & SETTERS
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

	// ~~ MÉTODOS
	
	/**
	 * Suma en la cuenta bancaria, el sueldo actual de la persona
	 */
	public void cobrarSueldo() {
		cuenta.sumarCantidad(sueldo);
	}

	/**
	 * Resta en la cuenta bancaria, la cantidad indicada por parametro
	 * @param cantidad Cantidad a restar
	 */
	public void sacarDinero(double cantidad) {
		cuenta.restarCantidad(cantidad);
	}

	/**
	 * Actualiza el sueldo de la persona
	 * @param nuevoSueldo El nuevo sueldo
	 */
	public void actualizarSueldo(double nuevoSueldo) {
		setSueldo(nuevoSueldo);
	}

	/**
	 * Imprime por consola la información general de la persona
	 */
	public void verInfo() {
		System.out.print("  »» User Info [Nombre: " + nombre + " | Apellido: " + apellidos + " | DNI: " + dni
				+ " | Sueldo: " + sueldo + " | Saldo: " + cuenta.getSaldo() + "]\n");
	}

	// ~~ toString
	@Override
	public String toString() {
		return " [Nombre = " + nombre + " | DNI = " + dni + "]";
	}

}
