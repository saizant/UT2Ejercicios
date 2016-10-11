import java.awt.List;
import java.util.Scanner;

public class CalcPrimeNumbersThread extends Thread {
	// COMPLETAR AQUÃ� EL EJERCICIO
	private int num1;
	private int num2;
	
	public CalcPrimeNumbersThread(String[] numeros) {
		super("CalcPrimeNumbersThread");
		num1 = Integer.parseInt(numeros[0]);
		num2 = Integer.parseInt(numeros[1]);
	}
	
	
	public void run(){		
				
		List<Integer> primos = PrimeNumbers.primesInRange(num1, num2);
		
		for (Integer primo : primos) {
			System.out.println(primo);
		}
		
	}
	
}
