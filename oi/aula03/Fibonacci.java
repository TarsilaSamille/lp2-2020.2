package aula03;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int n;
		System.out.printf("Informe um numero:");
		n = ler.nextInt();
		int soma=0;
		for (int i = 1; i <= n; i++) {
			int numeroAnterior = 0, total=0;
			int fibonacce = (i<=1) ? 0 : 1;
			int x=3;
			while(x <= i) {
				x++;
				total  = numeroAnterior + fibonacce;
				numeroAnterior = fibonacce;
				fibonacce = total;
			}
			soma+= fibonacce;
		}
		System.out.print("(Soma):" + soma + "\t");
	}
}
