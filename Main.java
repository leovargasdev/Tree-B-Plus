import java.util.Collections;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main{

	public static void main(String [] agrs){

		Arvore Arvore = new Arvore();
		int op = 0;
		Scanner leitor = new Scanner(System.in);
		do {
			System.out.print("Numero : ");
			Integer num = leitor.nextInt();
			if (num != 100) Arvore.Adiciona(Arvore.Raiz,num);
			else op++;
		}while(op != 1);
		Arvore.Imprimir(Arvore.Raiz);

	}
}
