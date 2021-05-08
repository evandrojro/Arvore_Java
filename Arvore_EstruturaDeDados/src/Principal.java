import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		ArvoreTernaria arvore = new ArvoreTernaria();
		int opcao;
		int input;
		String resultado;
		Boolean resposta;

		arvore.construir(arvore.getRaiz(), 'r', 0);

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("\n\t\tMENU" + "\n\n\t1.Localizar setor"
					+ "\n\t2.Quantos servidores" + "\n\t3.Maior setor por cidade" + "\n\t4.Maior setor"
					+ "\n\t5.Maior cidade" + "\n\t6.Verificar setor" + "\n\n\t9.SAIR\n\t"));
			switch (opcao) {
			case 1:
				arvore.limparResultado();

				input = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do setor"));
				resultado = arvore.localizarCidade(arvore.getRaiz(), input);

				System.out.println();
				if (resultado != null) {
					System.out.println("O setor " + input + " está localizado na cidade de " + resultado);
				} else {
					System.out.println("Setor não encontrado");
				}
				break;

			case 2:
				arvore.limparResultado();

				input = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do setor"));
				resultado = arvore.quantosFuncionarios(arvore.getRaiz(), input);

				System.out.println();
				if (resultado != null) {
					System.out.println("No setor " + input + " temos " + resultado + " funcionários");
				} else {
					System.out.println("Setor não encontrado");
				}
				break;

			case 3:
				arvore.limparResultado();

				String cidade = JOptionPane.showInputDialog("Informe o nome da cidade");
				input = arvore.setoresNaCidade(arvore.getRaiz(), cidade);

				System.out.println();
				if (input > 0) {
					System.out.println("Temos " + input + " setores alocados na cidade de " + cidade);
				} else {
					System.out.println("Cidade não encontrada");
				}
				break;
			case 4:
				arvore.limparResultado();
				input = arvore.maiorSetor(arvore.getRaiz());
				System.out.println();
				System.out.println("O MAIOR SETOR É " + input);

				break;
			case 5:
				arvore.limparResultado();
				resultado = arvore.maiorCidade(arvore.getRaiz());
				System.out.println();
				System.out.println("A CIDADE COM MAIS FUNCIONÁRIOS É " + resultado);
				break;
			case 6:
				arvore.limparResultado();
				input = Integer.parseInt(JOptionPane.showInputDialog("Informe o setor"));
				resposta = arvore.existeSetor(input, arvore.getRaiz());
				System.out.println();
				if(resposta) {
					System.out.println("Esse setor existe");
				}
				else {
					System.out.println("Setor não existe");
				}
				break;
			}
		} while (opcao != 9);

		System.out.println("Até a próxima :)");
	}

}