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

	/*for (int k = 0; k < AVO.lista.size(); k++){
		if(k > (AVO.lista.size()/2) - 1){
			//System.out.println(AVO.lista.get(k));
			copia.NovoElemento(AVO.lista.get(k));
			if ( AVO.filho.get(AVO.lista.get(k)) != null ){
				//System.out.println(AVO.filho.get(AVO.lista.get(k)).lista);
				copia.filho.put(AVO.lista.get(k), AVO.filho.get(AVO.lista.get(k)));
				AVO.filho.remove(AVO.lista.get(k));
			}
			AVO.lista.remove(k);
			k--;
		}
	}*/  //Separa duas lista e salva os hashmaps

}
