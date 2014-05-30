public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int porta = -1;

		if(args.length<1){
			System.err.println("Expected parameters.\n-h to help");
			System.exit(1);
		}
		if (args[0].equals("-s")) {
			// verificando se foi informado 1 argumento de linha de comando
			if (args.length < 2) {
				System.err.println("Uso: java tcp.Servidor <porta>");
				System.exit(1);
			}

			try { // para garantir que somente inteiros serao atribuidos a porta

				porta = Integer.parseInt(args[1]);

			} catch (Exception e) {
				System.err.println("Erro: " + e.toString());
				System.exit(1);
			}

			if (porta < 1024) {
				System.err.println("A porta deve ser maior que 1024.");
				System.exit(1);
			}

			Servidor_Desafio s=new Servidor_Desafio(porta);
	        s.run();
		}
		if (args[0].equals("-c")) {
			if (args.length < 3) {
				System.err
						.println("Uso: java tcp.Cliente <endereco-IP> <porta>");
				System.exit(1);
			}

			 Cliente_Desafio c1=new Cliente_Desafio(args[1],args[2]);
		     c1.runCli();
		}
		if (args[0].equals("-h")){
			System.out.println("OPTIONS");
			System.out.println("	-s \n	Init chat application in mode Server."+
			"Expects as parameter the port number on which waits for connections. The number must be between 1024 and 65535\n");
			System.out.println("	-c \n	Init chat application in mode Client."+
					"Expects as parameter the server IP and port number that will connect.\n");   
		       
		}

	}

}
