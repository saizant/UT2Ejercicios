import java.util.ArrayList;
import java.util.Scanner;

// Queremos calcular los nÃºmeros primos entre 2 nÃºmeros y imprimirlos por pantalla.
//
//  lee de la entrada estÃ¡ndar 2 nÃºmeros separados por espacio en la primera linea. (Ej: "1 100")
//  lee de la segunda linea de la entrada estÃ¡ndar el nÃºmero de threads en los que se tiene que dividir el trabajo.
//  Cada thread debe encargarse de realizar una parte equivativa del cÃ¡lculo
//
//    thread 1 [1..50]
//    thread 2 [51..100]
//
//Cada thread debe imprimir por pantalla su id, seguido de la lista de primos en su rango.
//Los ids serÃ¡n asignados en orden incremental por el thread principal de 1 a N.
//Cada thread siempre tiene que esperar a que finalice el thread anterior antes de imprimir!
//Utiliza el mÃ©todo de implementar Runnable.
//El thread principal debe esperar a la finalizaciÃ³n del thread con mayor id (el Ãºltimo).

public class PrimeNumbersInRange {
	// Ayuda: utiliza esta lista para guardarte la referencia a los threads que crees
	private ArrayList<Thread> threads; 

	public static void main(String[] args) {
		// COMPLETA AQUÃ� EL EJERCICIO
		
		System.out.println("Introduzca 2 números separados por espacio: ");
		String[] numeros = new Scanner(System.in).nextLine().split(" ");
		
		System.out.println("Introduzca el número de threads: ");
		String n_hilos = new Scanner(System.in).nextLine();
		
		int from = Integer.parseInt(numeros[0]);
		int to = Integer.parseInt(numeros[1]);
		
		int hilos = Integer.parseInt(n_hilos);
		int prop = (to - from) / hilos;
		
		Runnable r;
		Thread t = null;
		
		for (int i = 0; i < hilos; i++) {
			r = new CalcPrimeNumbersRunnable(i + 1, from+(i*prop), from+((i + 1)*prop), t);
			t = new Thread(r);
			t.start();
		}
		
		while (t.isAlive()) {
			//
		}
		
		System.out.println("Thread acabado. ");

	}

}
