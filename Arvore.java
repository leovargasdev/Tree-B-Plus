import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Arvore{

    public Nodo Raiz;
    public int limite;

    public Arvore(){

        limite = 3; // vai inserir o 4 e vai quebrar o nodo
        Raiz = null;

    }

    public void Adiciona(Nodo N, Integer k){

        Nodo novo = new Nodo();
        if (N != null){
            novo = RetornaPosicao(N,k);
        }
        caso1(novo,k);

    }

    public void caso1(Nodo N, Integer k){

        if (Raiz == null){
            N.NovoElemento(k);
            Raiz = N;
        } else {
            caso2(N,k);
        }

    }

    public void caso2(Nodo N, Integer k){

        if( N.getTamanho() < limite){
            N.NovoElemento(k);
        } else {
            caso3(N,k);
        }
    }

    public void caso3(Nodo N, Integer k){
        Nodo novo = new Nodo();
        N.NovoElemento(k);
        if( N != Raiz ){
            Nodo Pai = N.pai;
            Dividir(N,novo);
            //System.out.println("dividiu, N: "+  N.lista + ",novo: " + novo.lista);
            Pai.filho.put( novo.lista.get(0) , novo );// Raiz recebe o primeiro valor de novo e ele apontara para novo
            novo.pai = Pai;
            Pai.NovoElemento(novo.lista.get(0));// so arrumar isso, qual sera a solução ???
            //caso1(Pai,k);
        }

        if (Raiz.getTamanho() > limite){
            System.out.println("Raiz:");//"cria pai no caso3 k:" + k );
            Dividir(Raiz, novo);
            Nodo Pai = new Nodo();
            Pai.lista = CriaPai(Raiz.lista, novo.lista);
            novo.pai = Pai;
            Raiz.pai = Pai;
            Pai.filho.put( Pai.lista.get(0) , Raiz );
            Pai.filho.put( Pai.lista.get(1) , novo );
            Raiz = Pai;
        }

    }

    public Nodo RetornaPosicao(Nodo N, Integer k){
        if (!N.filho.isEmpty()){
            int a;
            for(a = 0; a < N.lista.size(); a++){
                if(N.lista.get(a) > k){
                    break;
                }
            }
            if (a != 0) a--;// caso seja o indice um;
            int NumeroElemento = N.lista.get(a);
            N = RetornaPosicao(N.filho.get(NumeroElemento),k);
        }
        return N;

    }

    public List CriaPai(List A, List B){

        List Pai = new LinkedList();
        Pai.add(A.get(0));
        Pai.add(B.get(0));
        return Pai;

    }

    public void Dividir(Nodo Antigo, Nodo Novo){

        Nodo yu = new Nodo();
        for (int k = 0; k < Antigo.getTamanho(); k++){
            int posicao = Antigo.lista.get(k);
            yu.NovoElemento(posicao);
            if (Antigo.filho.get(posicao) != null){
                yu.filho.put(posicao, Antigo.filho.get(posicao));
            }
        }
        //Imprimir(yu);
        Antigo.DeletaALL();
        Novo.DeletaALL();
        int i = 0;
        for (int k : yu.filho) {
            if(k < yu.getTamanho()/2){
                Antigo.NovoElemento(k);
                Antigo.filho.put(k, yu.filho.get(k));
                Antigo.filho.get(k).pai = Antigo;
            } else {
                Novo.NovoElemento(k);
                Novo.filho.put(k, yu.filho.get(k));
                Novo.filho.get(k).pai = Novo;
            }
            i++;
        }
        while (k < yu.getTamanho()/2){
            int posicao = yu.lista.get(k);
            Antigo.NovoElemento(posicao);
            if(!yu.filho.isEmpty()){ // tem filhos
                yu.filho.get(posicao).pai = Antigo;
                Antigo.filho.put(posicao, yu.filho.get(posicao));
            }
            k++;
        }
        k = 0;
        while (k < yu.getTamanho()){
            if(k >= yu.getTamanho()/2){
                int posicao = yu.lista.get(k);
                Novo.NovoElemento(posicao);
                if(!yu.filho.isEmpty()){ // tem filhos
                    yu.filho.get(posicao).pai = Novo;
                    Novo.filho.put(posicao, yu.filho.get(posicao));
                }
            }
            k++;
        }
        yu.DeletaALL();
        /*

        if (Antigo.filho != null){
            System.out.println("Antigo: ");
            Imprimir(Antigo);
        }
        if (yu.filho != null){
            System.out.println("yu: ");
            Imprimir(yu);
        }

        for (int k = 0; k < Antigo.getTamanho(); k++){
			if(k > (Antigo.getTamanho()/2) - 1){
                int posicao = Antigo.lista.get(k);
                Novo.NovoElemento(posicao);
				if ( Antigo.filho.get(posicao) != null ){
                    Antigo.filho.get(posicao).pai = Novo;
                    Novo.filho.put(posicao, Antigo.filho.get(posicao));
				}
			}
		}
        for (int k = 0; k < Antigo.getTamanho(); k++){
            for (int a = 0; a < Novo.getTamanho(); a++){
                if (Antigo.lista.get(k) == Novo.lista.get(a)){
                    int posicao = Antigo.lista.get(k);
                    //if(Antigo.filho.get(posicao) != null){
                        //Antigo.filho.remove(posicao);
                    //}
                    Antigo.lista.remove(k);
                }
            }
        }*/
    }

    public void Imprimir(Nodo N){

        if(!N.filho.isEmpty()){
            for (int k = 0; k < N.lista.size(); k++){
                if(N.filho.get(N.lista.get(k)) != null)
                    Imprimir(N.filho.get(N.lista.get(k)));
            }
        }

        if(N.pai == null){
            System.out.println("Lista: " + N.lista);
        } else {
            for (int a = 0; a < N.pai.lista.size(); a++){
                if (N.pai.filho.get(N.pai.lista.get(a)) == N){
                    System.out.println("P: " + N.pai.lista.get(a) + ", lista: " + N.lista);
                }
            }
        }
	}

}
