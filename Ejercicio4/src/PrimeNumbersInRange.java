import java.util.ArrayList;
import java.util.Scanner;

// Queremos calcular los nÃºmeros primos entre 2 nÃºmeros y imprimirlos por pantalla.
//
//  lee de la entrada estÃ¡ndar 2 nÃºmeros separados por espacio en la primera linea. (Ej: "1 100")
//  lee de la segunda linea de la entrada estÃ¡ndar el nÃºmero de threads en los que se tiene que dividir el trabajo.
//  lee de la 3a linea de la entrada estÃ¡ndar el nÃºmero de segundos mÃ¡ximo para realizar la tarea.

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

// ADEMAS:
// El thread principal debe poder cancelar el trabajo de los threads si se sobrepasa
// el lÃ­mite de tiempo.
// para ello debes utilizar el mÃ©todo interrupt() sobre todos los threads que todavÃ­a estÃ©n
// vivos (con el mÃ©todo isAlive(), por ejemplo)
// Los threads deben intentar acabar imprimiendo los resultados parciales que han obtenido.

public class PrimeNumbersInRange {
	// Ayuda: utiliza esta lista para guardarte la referencia a los threads que crees
	private static ArrayList<Thread> threads; 

	public static void main(String[] args) {
		// COMPLETA AQUÃ� EL EJERCICIO
		threads = new ArrayList<>();
		
		System.out.println("Introduzca 2 números separados por espacio: ");
		String[] numeros = new Scanner(System.in).nextLine().split(" ");
		
		System.out.println("Introduzca el número de threads: ");
		String n_hilos = new Scanner(System.in).nextLine();
		
		System.out.println("Introduzca el tope de segundos de los threads: ");
		String segs = new Scanner(System.in).nextLine(); 
		
		int from = Integer.parseInt(numeros[0]);
		int to = Integer.parseInt(numeros[1]);
		
		int hilos = Integer.parseInt(n_hilos);
		int segundos = Integer.parseInt(segs);
		int prop = (to - from) / hilos;
		
		Runnable r;
		Thread t = null;
		
		for (int i = 0; i < hilos; i++) {
			r = new CalcPrimeNumbersRunnable(i+1, from+(i*prop), from+((i+1)*prop), t);
			t = new Thread(r);
			t.start();
			threads.add(t);
		}
		
		try {
			Thread.sleep(segundos*1000);
		} catch (InterruptedException ex) {
			//
		}
		
		for (int i = 0; i < threads.size(); i++) {
			if (threads.get(i).isAlive()) {
				threads.get(i).interrupt();
			}
		}
		
		while (t.isAlive()) {
			//
		}
		
		System.out.println("Thread acabado. ");

	}

}
