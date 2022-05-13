package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuentaCorriente {
	
	private static final Logger LOG = LoggerFactory.getLogger(CuentaCorriente.class);

	// Propiedades
	private int numCuenta;
	private double saldo;
	private Persona persona;

	// Getters y Setters
	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona p) {
		this.persona = p;
	}

	// Constructores
	public CuentaCorriente(int numCuenta, Persona persona) {
		super();
		this.numCuenta = numCuenta;
		this.saldo = 0.0;
		this.persona = persona;
	}

	// Metodos
	public void sumarCantidad(double cantidad) {
		this.saldo += cantidad;
	}

	public void restarCantidad(double cantidad) {
		if (this.saldo >= cantidad) {
			this.saldo -= cantidad;
			System.out.println("\n       >>>>    Has retirado dinero de la cuenta con éxito    <<<<");
			LOG.debug("EL USUARIO SI CUENTA CON LA CANTIDAD INDICADA DE DINERO PARA RETIRAR");
		} else {
			System.out.println("\n       >>>>     No tienes suficiente dinero para retirar     <<<<");
			LOG.debug("EL USUARIO NO CUENTA CON LA CANTIDAD INDICADA DE DINERO PARA RETIRAR");
		}
	}

	// toString
	@Override
	public String toString() {
		return "CuentaCorriente [NumCuenta = " + numCuenta + " | Saldo=" + saldo + " | Persona = " + persona + "]";
	}

}
