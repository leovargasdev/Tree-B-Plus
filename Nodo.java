import java.util.*;
import java.util.Collections;

class Nodo{

	public Nodo filho[];

	public Nodo pai;

	public int limite;

	public List lista;

	public Nodo(){

		this.lista = new LinkedList();

		this.limite = 6;

		this.filho = new Nodo[this.limite];

	}

	public void NovoElemento(Object chave){

		this.lista.add(chave);

		Collections.sort(this.lista);

	}

}
