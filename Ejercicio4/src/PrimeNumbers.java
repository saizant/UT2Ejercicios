import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
	public static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	// TODO: Modifica el método para que sea capaz de lanzar
	// una interrupción InterruptedException en caso de que en el hilo
	// en el que se ejecuta el método (Thread.getCurrentThread()) se haya
	// recibido un flag interrupt (IsInterrupted())
	// Esta comprobación debe hacerse al menos una vez en cada iteración
	public static List<Integer> primesInRange(int from, int to) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int num=from; num<to; num++) {
			if (isPrime(num)) {
				primes.add(new Integer(num));
			}
			
			if (Thread.currentThread().isInterrupted()) {
				return primes;
			} else {
				if (isPrime(num)) {
					primes.add(new Integer(num));
				}
				
			}
			
		}
		
		return primes;
	}
}
