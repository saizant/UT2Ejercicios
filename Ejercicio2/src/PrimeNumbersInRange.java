import java.util.Scanner;

// Queremos calcular los nÃºmeros primos entre 2 nÃºmeros y imprimirlos por pantalla.
//
//Requisitos:
//
//    lee de la entrada estÃ¡ndar 2 nÃºmeros separados por espacio en la primera linea. (Ej: "2 100")
//    Utiliza un thread que realice el trabajo y se encargue de imprimir por pantalla la lista resultante.
//    Utiliza el mÃ©todo de implementar Runnable.
//    El thread principal debe esperar a la finalizaciÃ³n del thread trabajador o "worker".


public class PrimeNumbersInRange {

	public static void main(String[] args) {
		// COMPLETA AQUÃ� EL EJERCICIO
		System.out.println("Introduzca 2 números separados por espacio: ");
		String[] numeros = new Scanner(System.in).nextLine().split(" ");
		
		int from = Integer.parseInt(numeros[0]);
		int to = Integer.parseInt(numeros[1]);
		
		Runnable r = new CalcPrimeNumbersRunnable(from, to);
		
		new Thread(r).start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex ) {
			ex.printStackTrace();
		}

	}

}
