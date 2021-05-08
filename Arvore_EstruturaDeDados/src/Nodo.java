
public class Nodo {
	public int codigo;
	public String cidade;
	public int quantidade_funcionarios;
	public Nodo filhoEsq;
	public Nodo filhoMeio;
	public Nodo filhoDir;
	
	Nodo(int cod, String cid, int qtde) {
		this.codigo = cod;
		this.cidade = cid;
		this.quantidade_funcionarios = qtde;
		this.filhoEsq = null;
		this.filhoDir = null;
		this.filhoMeio = null;
	}
}
