package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Formación - Logback
 * 
 * Clase CuentaCorriente
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public class CuentaCorriente {
	
	/**
	 * Instanciamiento de un Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(CuentaCorriente.class);

	// ~~ PROPIEDADES
	private int numCuenta;
	private double saldo;
	private Persona persona;
	
	// ~~ CONSTRUCTOR
	/**
	 * Construye una cuenta corriente
	 * @param numCuenta Numero de la cuenta
	 * @param persona Persona propietaria de la cuenta
	 */
	public CuentaCorriente(int numCuenta, Persona persona) {
		super();
		this.numCuenta = numCuenta;
		this.saldo = 0.0;
		this.persona = persona;
	}

	// ~~ GETTEST & SETTERS
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

	// ~~ MÉTODOS
	/**
	 * Suma la cantidad pasada por parametro al saldo total de la cuenta
	 * @param cantidad Cantidad a ser sumada
	 */
	public void sumarCantidad(double cantidad) {
		this.saldo += cantidad;
	}

	/**
	 * Resta la cantidad pasada por parametro en caso de que el saldo
	 * actual de la cuenta sea igual o mayor a la cantidad indicada
	 * @param cantidad Cantidad a ser restada
	 */
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

	//  ~~ toString
	@Override
	public String toString() {
		return "CuentaCorriente [NumCuenta = " + numCuenta + " | Saldo=" + saldo + " | Persona = " + persona + "]";
	}

}
