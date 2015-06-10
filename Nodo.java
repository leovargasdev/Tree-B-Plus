import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Nodo{

	//public Nodo filho[];

	public Nodo pai;

	public int limite;

	public List<Integer> lista;

	public Map<Integer,Nodo> filho;


	public Nodo(){

		this.lista = new ArrayList<Integer>();

		this.limite = 6;

		this.filho = new HashMap<Integer,Nodo>();

		//this.filho = new Nodo[this.limite];

	}

	public void NovoElemento(Integer chave){

		this.lista.add(chave);

		Collections.sort(this.lista);

	}

}
