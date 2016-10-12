import java.awt.List;

public class CalcPrimeNumbersRunnable implements Runnable {
	private int id;
	private int from;
	private int to;
	private Thread previous;

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
		
		List<Integer> primos = PrimeNumbers.primesInRange(from, to);
		
		if (previous != null) {
			while(previous.isAlive()){
				//
			}
		}
		
		System.out.println("ID del thread: " + id);
		for (Integer primo : primos) {
			System.out.print(primo);
			System.out.print(",");
		}
		
		
	}

}
