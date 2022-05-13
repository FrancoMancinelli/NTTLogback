package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.CuentaCorriente;
import models.Persona;

public class MainApp {

	private static final Logger LOG = LoggerFactory.getLogger(MainApp.class);
	
	public static void main(String[] args) {
		LOG.info("INICIA LA APLICACION");
		
		List<Persona> arrayPersonas = new ArrayList<Persona>(); //Creo mi array de personas
		
		System.out.println("       >>>>            BIENVENID@ AL BANCO PICASSO           <<<<");
		String resMenuIn;
		
		int contador = 0; //Contador de cuentas
		
		do {
			System.out.println("\n       >>>>>>>>>>>>>>>>>>>>>>> MEN� INICIAL <<<<<<<<<<<<<<<<<<<<<");
			System.out.println("       >>>>    Elija una opci�n del panel a continuaci�n:    <<<<");
			System.out.println("       >>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");

			System.out.println("A �� Registrarse\nB �� Iniciar Sesi�n\nC �� Eliminar Cuenta\nD �� Salir\n");
			System.out.print("� �� Respuesta: ");
			
			LOG.info("IMPRIME MENU INICIAL");
			
			Scanner sc = new Scanner (System.in);
			resMenuIn = sc.next().toUpperCase();
			
			LOG.debug("RESPUESTA EN MENU INICIAL: {}", resMenuIn);
			switch (resMenuIn) {
			
			//Registrar nuevo usuario
			case "A":
				LOG.info("EL USUARIO DECIDE REGISTRARSE");
				System.out.println("\n       >>>>>>>>>>>>>>>>>>> ARE� DE REGISTRO <<<<<<<<<<<<<<<<<<<<<\n");
				System.out.println("       >>>>    Responda y rellene los campos que se iran     <<<<");
				System.out.println("       >>>>             mostrando por pantalla               <<<<");
				System.out.println("       >>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
				
				String nom, apell, dni;
				double sueldo;
				
				LOG.info("IMPRIME AREA DE REGISTRO");
				
				//Pedir� los datos necesarios al usuario
				System.out.print("� �� Nombre: ");
				nom = String.valueOf(sc.next());
				LOG.debug("NOMBRE INDICADO: {}", nom);
				
				System.out.print("� �� Primer Apellido: ");
				apell = String.valueOf(sc.next());
				LOG.debug("APELLIDO INDICADO: {}", apell);

				System.out.print("� �� DNI: ");
				dni = String.valueOf(sc.next());
				LOG.debug("DNI INDICADO: {}", dni);

				System.out.print("� �� Sueldo: ");
				sueldo = Double.parseDouble(sc.next());
				LOG.debug("SUELDO INDICADO: {}", sueldo);

				
				CuentaCorriente c = new CuentaCorriente(contador++, null); //Creara una cuenta corriente base que sera igual para todos
				arrayPersonas.add(new Persona(nom, apell, dni, sueldo, c)); //Creo mi persona con los datos introducidos, le asigno la cuenta y la a�ado a mi array				
				System.out.println("\n       >>>>   Tu cuenta bancar�a ha sido creada con �xito    <<<<");
				LOG.info("SE CREA LA CUENTA CORRIENTE DEL USUARIO CORRECTAMENTE");
				break;
			
			//Iniciar sesi�n
			case "B":
				LOG.info("EL USUARIO DECIDE INICIAR SESION");
				int respAux = 0;
				
				do {
				if(!arrayPersonas.isEmpty()) { //Si el array NO esta vacio
					System.out.println("\n       >>>>>>>>>>>>>>>>>>>> INICIO DE SESI�N <<<<<<<<<<<<<<<<<<<<");
					System.out.println("       >>>>        Seleccione el n�mero de la cuenta         <<<<");
					System.out.println("       >>>>            a la que quiere ingresar              <<<<");
					System.out.println("       >>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
					LOG.info("IMPRIME MENU DEL INICIO DE SESION");

					int resp = 0;
					int i = 1;
					
					for(Persona aux : arrayPersonas) {
						System.out.println(i+" �� " + aux); //Recorre mi array de personas y las imprime en orden
						i++;
					}
					
						System.out.print("\n� �� Respuesta: "); //Solicito al usuario que indique una cuenta
						resp = Integer.parseInt(sc.next());
						respAux = resp;
						LOG.debug("RESPUESTA DEL USUARIO AL INDICAR UNA CUENTA LISTADA: {}", resp);
						
						if(resp >= 1 && resp <= arrayPersonas.size()) { //Si el valor es una opcion de la lista
						Persona seleccionada = arrayPersonas.get(resp - 1);
						LOG.info("EL USUARIO SELECCIONO LA CUENTA: {}", seleccionada.toString());

						System.out.println("\n       >>>>           Has seleccionado la cuenta n�"+resp+"         <<<<");
						String resp2;
							
							do {
								System.out.println("\n       >>>>>>>>>>>>>>>>>> MEN� DE INTERACCI�N <<<<<<<<<<<<<<<<<<<");
								System.out.println("       >>>>    Elija una opci�n del panel a continuaci�n:    <<<<");
								System.out.println("       >>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
			
								System.out.println("1 �� Cobrar Sueldo\n2 �� Sacar Pasta\n3 �� Modificar Sueldo\n4 �� Ver Info\n5 �� Salir\n");
								LOG.info("IMPRIME MENU DE INTERACCION");

								System.out.print("� �� Respuesta: ");
								resp2 = String.valueOf(sc.next());
								LOG.debug("RESPUESTA DEL USUARIO AL MENU DE INTERACCION: {}", resp2);

								switch (resp2) {
							
								case "1": //Cobrar sueldo
									System.out.println("\n       >>>>       Tu sueldo ha sido cobrado con �xito        <<<<");
									LOG.info("EL USUARIO COBRA SU SUELDO");
									LOG.debug("EL USUARIO ANTES DE COBRAR TENIA {} Y COBRO {}$", seleccionada.getCuenta().getSaldo(), seleccionada.getSueldo());
									seleccionada.cobrarSueldo();
									break;
									
								case "2": //Sacar pasta
									System.out.print("� �� Cantidad a retirar: ");
									double cantidad = Double.parseDouble(sc.next());
									seleccionada.sacarDinero(cantidad);
									LOG.info("EL USUARIO RETIRA SU DINERO");
									LOG.debug("EL USUARIO RETIRO {}$", cantidad);
									break;
									
								case "3": //Modificar Sueldo
									System.out.print("� �� Nuevo sueldo: ");
									double sueldoNuevo = Double.parseDouble(sc.next());
									System.out.println("\n       >>>>      Tu sueldo ha sido modificado con �xito      <<<<");
									LOG.info("EL USUARIO ACTUALIZA SU SUELDO");
									LOG.debug("EL SUELDO ANTERIOR ERA {}$ Y EL NUEVO ES {}$", seleccionada.getSueldo(), sueldoNuevo);
									seleccionada.subirSueldo(sueldoNuevo);
									break;
									
								case "4": //Ver Info
									seleccionada.verInfo();
									LOG.info("EL USUARIO VE SU INFORMACION");
									break;
									
								case "5": //Volver atr�s
									System.out.println("\n       >>>>          Procediendo a cerrar la sesi�n          <<<<");
									System.out.println("       >>>>         Has salido de la cuenta con �xito        <<<<");
									LOG.info("EL USUARIO DECIDE VOLVER ATRAS DEL PANEL DE INTERACCION");
									break;
									
								default:
									System.out.println("\n       >>>>        Su respuesta no se encuentra dentro       <<<<       ");
									System.out.println("ERR0R! >>>>         de las posibles opciones (1 - 5)         <<<< ERR0R!");
									System.out.println("       >>>>               Vuelve a intentarlo                <<<<\n");
									LOG.error("EL USUARIO HA INDICADO UNA OPCION INVALIDA DEL MENU DE INTERACCION");

								}
								
							}while (!resp2.equals("5")); //Si el usuario no sale, repetir� el men� para poder hacer otra acci�n
							
						}else { //Si el valor no es una opcion de la lista
							System.out.println("\n       >>>>        Su respuesta no se encuentra dentro       <<<<       ");
							System.out.println("ERR0R! >>>>         de las posibles opciones (1 - "+arrayPersonas.size() +")         <<<< ERR0R!");
							System.out.println("       >>>>               Vuelve a intentarlo                <<<<");
							LOG.error("EL USUARIO HA INDICADO UNA OPCI�N INVALIDA DEL MENU DE INICIO DE SESION");
						}
					
					
				} else { //Si el array de personas esta vacio...
					System.out.println("\n       >>>>            No hay cuentas registradas            <<<<       ");
					System.out.println("ERR0R! >>>>       Primero registra una cuenta y luego        <<<< ERR0R!");
					System.out.println("       >>>>               vuelve a intentarlo                <<<<");
					LOG.error("SE HA INTENTADO INICIAR SESION A UNA CUENTA, CUANDO AUN NO HAY NINGUNA REGISTRADA");
				}

				}while(!(respAux >= 1 && respAux <= arrayPersonas.size())); //Repite el menu inicial hasta que el usuairo introduzca una cuenta de las opciones
				break;
				
			//Borrar una cuenta
			case "C":
				LOG.info("EL USUARIO DECIDE BORRAR UNA CUENTA");
				int respY = 0;
				String sn = "";
				
				do {
				if(!arrayPersonas.isEmpty()) {
					System.out.println("\n       >>>>>>>>>>>>>>>>> ELIMINACI�N DE CUENTAS <<<<<<<<<<<<<<<<<");
					System.out.println("       >>>>        Seleccione el n�mero de la cuenta         <<<<");
					System.out.println("       >>>>            a la que quiere eliminar              <<<<");
					System.out.println("       >>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
					LOG.info("IMPRIME EL MENU DE ELIMINACION DE CUENTAS");

					int i = 1;
					
					for(Persona aux : arrayPersonas) {
						System.out.println(i+" �� " + aux); //Recorre mi array de personas y las imprime en orden
						i++;
						}
						LOG.info("SE IMPRIMEN LAS PERSONAS POR PANTALLA");
					
						System.out.print("\n� �� Respuesta: "); //Solicito al usuario que indique una cuenta
						int respue = Integer.parseInt(sc.next());
						LOG.debug("EL USUARIO HA RESPONDIDO {} EN EL PANEL DE ELIMINACION", respue);
						
						if(respue >= 1 && respue <= arrayPersonas.size()) { //Si el valor es una opcion de la lista
							do {
								System.out.println("\n       >>>>           Has seleccionado la cuenta n�"+respue+"         <<<<");
								System.out.println("       >>>>   �Esta seguro que desea eliminar esta cuenta?   <<<<");
								System.out.println("       >>>>          La acci�n no podr� ser desecha          <<<<");
								LOG.info("SE IMPRIMEN UN PANEL DE CONFIRMACION PREVIO A ELIMINAR UNA CUENTA");

								System.out.print("\n� �� Respuesta (S/N): ");
								sn = String.valueOf(sc.next().toUpperCase());
								LOG.debug("LA RESPUESTA SOBRE SI BORRAR HA SIDO: {}", sn);
								
								if(sn.equals("S")) { //Si el usuario decide SI borrar la cuenta
									System.out.println("\n       >>>>          La operaci�n: borrado de cuenta         <<<<");
									System.out.println("       >>>>             se ha realizado con �xito            <<<<");
									arrayPersonas.remove(respue - 1);
									LOG.warn("SE HA ELIMINADO UNA CUENTA");
								} else {
									if(sn.equals("N")) {//Si el usuario decide NO borrar la cuenta
										System.out.println("\n       >>>>          La operaci�n: borrado de cuenta         <<<<");
										System.out.println("       >>>>            ha sido cancelada con �xito           <<<<");
										LOG.warn("NO SE HA ELIMINADO UNA CUENTA");
									} else { //Si el usuario introduce algo invalido...
										System.out.println("\n       >>>>           Su respuesta no se encuentra           <<<<       ");
										System.out.println("ERR0R! >>>>    dentro de los parametros solicitados (S/N)    <<<< ERR0R!");
										System.out.println("       >>>>              Vuelve a intentarlo                 <<<<\n");
										LOG.error("RESPUESTA INVALIDA A LA CONFIRMACI�N DE BORRADO DE CUENTAS");
									}
								}
							}while(!sn.equals("S") && !sn.equals("N"));
						
						}else { //Si el valor no es una opcion de la lista
							System.out.println("\n       >>>>        Su respuesta no se encuentra dentro       <<<<       ");
							System.out.println("ERR0R! >>>>         de las posibles opciones (1 - "+arrayPersonas.size() +")         <<<< ERR0R!");
							System.out.println("       >>>>               Vuelve a intentarlo                <<<<");
							LOG.error("EL USUARIO HA INDICADO UNA OPCI�N INVALIDA DEL MENU BORRADO DE CUENTAS");
						}
							
				} else { //Si el array de personas esta vacio...
					System.out.println("\n       >>>>            No hay cuentas registradas            <<<<       ");
					System.out.println("ERR0R! >>>>       Primero registra una cuenta y luego        <<<< ERR0R!");
					System.out.println("       >>>>               vuelve a intentarlo                <<<<");
					LOG.error("SE IMPRIME Y NOTIFICA QUE NO EXISTEN CUENTAS REGISTRADAS AUN");
					break;
				}
				
				//Repite el menu inicial hasta que el usuairo introduzca una numero de cuenta de las opciones
				//Adem�s si el usuario responde que SI o que NO a la confirmaci�n de eliminar la cuenta
				//tambi�n volvera al men� inicial
				}while(!(respY >= 1 && respY <= arrayPersonas.size()) && !sn.equals("N") && !sn.equals("S")); 
				break;
				
			//Salir del sistema
			case "D":
					System.out.print("\n  �� Has salido de la aplicaci�n\n");
					System.out.print("  �� Que tenga bonito d�a, vuelva pronto :)\n");
					LOG.info("EL USUARIO HA DECIDIDO TERMINAR EL PROGRAMA");
				break;
			
			default:
				System.out.println("\n       >>>>        Su respuesta no se encuentra dentro       <<<<       ");
				System.out.println("ERR0R! >>>>       de las posibles opciones (A, B, C, D)      <<<< ERR0R!");
				System.out.println("       >>>>               Vuelve a intentarlo                <<<<\n");
				LOG.error("EL USUARIO NO HA INDICADO UNA RESPUESTA CORRECTA EN EL MENU DE INICIO");
			 			
			}

		} while (!"d".equals(resMenuIn) && !"D".equals(resMenuIn)); //Mientras la respuesta del usuario no sea D (SALIR)

	}

}
