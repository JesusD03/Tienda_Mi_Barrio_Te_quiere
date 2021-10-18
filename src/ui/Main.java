package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.DayAndIDException;
import exceptions.Under18YearsOldException;
import model.Tienda;

public class Main {
	
	public static int count = 0;
	static int option = 0;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static Tienda tienda;
	
	public static void main(String[] args) {
		tienda = new Tienda();
		menu();
	}
	
	public static void menu() {
		do {
			System.out.println("Bienvenido a la tienda Mi Barrio Te Quiere\n"+
					"Por favor seleccione una de las siguientes opciones\n"+
					"(1) Para registrar un nuevo ingreso\n"+
					"(2) Para ver la candidad de personas que han intentado ingresar\n"+
					"(3) Para salir\n");
			
			try {
				option = Integer.parseInt(br.readLine());
				chosenOoption(option);
			} catch (IOException e) {
				System.out.println("Ingrese un valor valido, por favor\n");
			} catch (NumberFormatException e) {
				System.out.println("Ingrese un valor numerico\n");
			}
		}while(option!=3);
		try {
			br.close();
			System.out.println("Hasta la proxima\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void chosenOoption(int op) {
		switch (op) {
		case 1:
			count++;
			addNewCustomer();
			break;
		
		case 2:
			attemptsToEnter();
			break;

		default:
			break;
		}
	}

	private static void addNewCustomer() {
		System.out.println("Seleccione el tipo de documento de identidad\n"+
							"(1) Tarjeta de identidad\n"+
							"(2) Cedula de ciudadania\n"+
							"(3) Pasaporte\n"+
							"(4) Cedula de extranjeria\n");
		String idType = "";
		try {
			int t = Integer.parseInt(br.readLine());
			switch (t) {
			case 1:
				idType = "TI";
				break;
			case 2:
				idType = "CC";
				break;
			case 3:
				idType = "PP";
				break;
			case 4:
				idType = "CE";
				break;
			default:
				System.out.println("Ingrese un valor que corresponda a una de las opciones\n");
				addNewCustomer();
				break;
			}
			System.out.println("Ingrese su numero de documento\n");
			String id = br.readLine();
			try {
				tienda.addCustomer(id, idType);
				System.out.println("Ha ingresado exitosamen\n");
			} catch (Under18YearsOldException e) {
				System.out.println("No se permite el ingreso a menores de edad\n");
				menu();
			} catch (DayAndIDException e) {
				System.out.println("No cumple con el Pico y Cedula, por lo que no puede entrar a la tienda\n");
				menu();
			}
		} catch (IOException e) {
			System.out.println("Ingrese un valor valido, por favor\n");
		} catch (NumberFormatException e) {
			System.out.println("Ingrese un valor numerico\n");
		}
		
		
	}
	
	private static void attemptsToEnter() {
		
		System.out.println("La cantidad de personas que han intentado ingresar son: "+count+"\n");
		
	}
	
}
