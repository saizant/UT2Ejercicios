import java.awt.List;

public class CalcPrimeNumbersRunnable implements Runnable {
	private int id;
	private int from;
	private int to;
	private Thread previous;
	private static List<Integer> primos;

	// Nos guardamos el id, inicio, fin, y referencia al Runnablethread anterior
	public CalcPrimeNumbersRunnable(int id, int from, int to, Thread previous) {
		this.id = id;
		this.from = from;
		this.to= to;
		this.previous = previous;
    }
	
	@Override
	public void run() {
		// COMPLETAR AQUÃ� EL EJERCICIO
		try {
			primos = PrimeNumbers.primesInRange(from, to);
		} catch (InterruptedException ex) {
			System.out.println("ID del thread: " + id);
			for (Integer primo : primos) {
				System.out.print(primo);
				System.out.print(",");
			}
			
			
		} finally {
			while (previous.isAlive()) {
				//
			}
			
			System.out.println("ID del thread: " + id);
			for (Integer primo : primos) {
				System.out.print(primo);
				System.out.print(",");
			}
			
		}
			
		
		
		
		
	}

}
