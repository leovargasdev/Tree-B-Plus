import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Nodo{

	public Nodo pai;
	public List<Integer> lista;
	public Map<Integer,Nodo> filho;


	public Nodo(){

		this.lista = new ArrayList<Integer>();
		this.filho = new HashMap<Integer,Nodo>();

	}

	public Integer getTamanho(){
		return this.lista.size();
	}

	public void NovoElemento(Integer chave){

		this.lista.add(chave);
		Collections.sort(this.lista);

	}

	public void DeletaALL(){

		this.lista.clear();
		this.filho.clear();

	}

	public boolean VereficaPai(){
		if(this.pai == null) return false;
		return true; // tem pai;
	}

}
