import javax.swing.JOptionPane;

public class ArvoreTernaria {

	public Nodo raiz;
	public String result;
	public int resultNumber; 
	public boolean aux;
	public int setorQuant;
	
	ArvoreTernaria() {
		this.raiz = null;
		this.limparResultado();
	}
	
	public Nodo getRaiz() {
		return this.raiz;
	}
	
	public void limparResultado() {
		this.result = null;
		this.resultNumber = 0;
		this.aux = false;
		this.setorQuant =  0;
		
	}
	
	public void construir(Nodo filho, char lado, int quem) {
		String entra;
		int lido;
		Nodo onde;
		
		if(lado == 'r') {
			entra = JOptionPane.showInputDialog("INFORME A RAÍZ");
		} else {
			if(lado == 'e') {
				entra = JOptionPane.showInputDialog("INFORME O FILHO ESQUERDO DE "+quem);
			} else if(lado == 'c') {
				entra = JOptionPane.showInputDialog("INFORME O FILHO DO MEIO DE "+quem);
			}else {
				entra = JOptionPane.showInputDialog("INFORME O FILHO DIREITO DE "+quem);
			}
		}
		
		lido = Integer.parseInt(entra);
		
		if(lido != 0) {
			onde = this.coloca(filho, lido, lado);
			this.construir(onde, 'e', lido);
			this.construir(onde, 'c', lido);
			this.construir(onde, 'd', lido);
		}
	}
	
	public Nodo coloca(Nodo atual, int quem, char lado) {
		Nodo alocou;
		//DESCOMENTAR AS 2 LINHAS ABAIXO QUANDO FOR ENTREGAR		
		String cid = JOptionPane.showInputDialog("INFORME A CIDADE QUE O SETOR "+quem+" ESTÁ ALOCADO");
		int qtde = Integer.parseInt(JOptionPane.showInputDialog("INFORME A QUANTIDADE DE FUNCIONÁRIOS DO SETOR "+quem));
		
		alocou = new Nodo(quem, cid, qtde);
		
		if(raiz == null) {
			raiz = alocou;
		} else {
			if(lado == 'e') {
				atual.filhoEsq = alocou;
			} else if(lado == 'c') { 
				atual.filhoMeio = alocou;
			} else {
				atual.filhoDir = alocou;
			}
		}
		
		return alocou;
	}
	
	//Método 1 - Pré ordem com preferência à esquerda Se a opção 1 for selecionada o programa pede ao usuário que informe o códido de um setor, varre a arvore em pre ordem com preferencia a esquerda
	public String localizarCidade(Nodo raiz, int procurado) {
		if(raiz != null) {
			System.out.print(raiz.codigo + " ");
			
			if(raiz.codigo == procurado) {
				this.result = raiz.cidade;
			}
			this.localizarCidade(raiz.filhoEsq, procurado);
			this.localizarCidade(raiz.filhoMeio, procurado);
			this.localizarCidade(raiz.filhoDir, procurado);
		}
		
		return this.result;
	}
	
	/*Método 2 - Pré ordem com preferência à direita Mostra a ordem de visita aos nodos e diz em qual cidade está localizado este setor.
	Se a opção 2 for selecionada o programa pede ao usuário que informe o código do setor, varre a arvore com pré ordem com preferencia a direita, */
	

	public String quantosFuncionarios(Nodo raiz, int procurado) {
		if(raiz != null) {
			System.out.print(raiz.codigo + " ");
			
			if(raiz.codigo == procurado) {
				this.result = Integer.toString(raiz.quantidade_funcionarios);
			}
			
			this.quantosFuncionarios(raiz.filhoDir, procurado);
			this.quantosFuncionarios(raiz.filhoMeio, procurado);
			this.quantosFuncionarios(raiz.filhoEsq, procurado);
		}
		
		return result;
	}
	
	/*Método 3 - Pós ordem com preferência à esquerda Se a opção 3 for selecionada o programa pede o nome de uma cidade, varre a arvore em pós ordem com pref esq, 
	mostra a ordem de sequencia de visita aos nodos e informa quantos setores existem nesta cidade.*/
	
	
	public int setoresNaCidade(Nodo raiz, String procurado) {
		if(raiz != null) {			
			if(raiz.cidade.intern() == procurado.intern()) {
				this.resultNumber++;
			}
			
			this.setoresNaCidade(raiz.filhoEsq, procurado);
			this.setoresNaCidade(raiz.filhoMeio, procurado);
			this.setoresNaCidade(raiz.filhoDir, procurado);
			System.out.print(raiz.codigo + " ");
		}
		
		return this.resultNumber;
	}
	
	/*Metodo 4 - Pós ordem com preferência à direita Se a opção 4 for selecionada o programa Varre a arvore com pos ord com pref a dir, mostra a ordem de visita aos nodos e 
	informa qual o setor tem mais funcionários lotados.*/
	
	
	public int maiorSetor(Nodo raiz) {
		if(raiz!=null) {
			if(raiz.quantidade_funcionarios > this.setorQuant) {
				this.setorQuant = raiz.quantidade_funcionarios;
				this.resultNumber = raiz.codigo;
				
			}
			maiorSetor(raiz.filhoDir);
			maiorSetor(raiz.filhoMeio);
			maiorSetor(raiz.filhoEsq);
			System.out.print(raiz.codigo + " ");
		}
		return this.resultNumber;
	}
	
	/*Metodo 5 - In ordem com preferência à esquerda Se a opção 5 for selecionada o programa varre a arvore In ordem com pref a esq, mostre a ordem de sequencia de visita aos nodos e 
	informa em qual cidade está o setor com mais funcionário lotados.*/
	
	public String maiorCidade(Nodo raiz) {
		if(raiz!= null) {
			if(raiz.quantidade_funcionarios > this.setorQuant ) {
				this.setorQuant = raiz.quantidade_funcionarios;
				this.result = raiz.cidade;
			}
			maiorCidade(raiz.filhoEsq);
			System.out.print(raiz.codigo + " ");
			maiorCidade(raiz.filhoMeio);
			maiorCidade(raiz.filhoDir);
			
		}
		return this.result;
	}
	
	
	/* Metodo 6 - In ordem com preferência à direita  Se a opção 6 for selecionada o programa pede que o usuário informe o código de um setor, varre a arvore in ord com pref a dir, informa a sequencia
	de visita aos nodos e diz se o setor existe na empresa.*/
	
	
	public Boolean existeSetor(int setor, Nodo raiz) {
		if(raiz!=null) {
			if(raiz.codigo == setor) {
				this.aux = true;
			}
			existeSetor(setor,raiz.filhoDir);
			System.out.print(raiz.codigo + " ");
			existeSetor(setor,raiz.filhoMeio);
			existeSetor(setor,raiz.filhoEsq);
			
		}
		
		return this.aux;
		
	}	
}
