package exercicio01;
import java.util.Scanner;

public class somarNumeros {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//variaveis
		int num1, num2, soma;
		
		//entrada
		System.out.print("Digite um número: ");
		num1 = sc.nextInt();
		System.out.print("Digite outro número: ");
		num2 = sc.nextInt();
		
		//soma
		soma = num1 + num2;
		
		//saída
		System.out.println("Soma: " + soma);
	}
	
}
