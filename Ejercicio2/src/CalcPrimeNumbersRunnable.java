import java.awt.List;

public class CalcPrimeNumbersRunnable implements Runnable {
	private int from;
	private int to;

	public CalcPrimeNumbersRunnable(int from2, int to2) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to= to;
	}
//	public void CalcPrimeNumbersRunnable(int from, int to) {
//		this.from = from;
//		this.to= to;
//    }
	@Override
	public void run() {
		// COMPLETAR AQUÃ� EL EJERCICIO
		List<Integer> primos = PrimeNumbers.primesInRange(from, to);
		
		for (Integer primo : primos) {
			System.out.println(primo);
		}
	}

}
