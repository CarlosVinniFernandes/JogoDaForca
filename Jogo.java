import java.util.ArrayList;
import java.util.Scanner;


public class Jogo {
    private final Palavra palavra;
    private final Jogador jogador;
    
    public Jogo(Palavra palavra, Jogador jogador) {
        this.palavra = palavra;
        this.jogador = jogador;
    }

    public void iniciarJogo(){
        var numeroChutes = 6;
        var erros = 0;
        var chutes = new ArrayList<String>();
        
        this.palavra.gerarPalavraSecreta();

        var sc = new Scanner(System.in);
        System.out.println("Olá, " + this.jogador.getNome() + ". Seja bem-vindo ao Jogo da Forca!");
        System.out.println("Você tem " + numeroChutes + " chutes para adivinhar a palavra secreta.");
        System.out.println(this.palavra.getPalavraComChute() + "\n");

        while(!this.palavra.palavraCompleta() && erros < 6){
            switch (erros) {
                case 1:
                    System.out.println("+---+\n|   |\n|   O\n|\n|\n|\n=========");
                    break;
                case 2:
                    System.out.println("+---+\n|   |\n|   O\n|   |\n|\n|\n=========");
                    break;
                case 3:
                    System.out.println("+---+\n|   |\n|   O\n|  /|\n|\n|\n=========");
                    break;
                case 4:
                    System.out.println("+---+\n|   |\n|   O\n|  /|\\\n|\n|\n=========");
                    break;
                case 5:
                    System.out.println("+---+\n|   |\n|   O\n|  /|\\\n|  /\n|\n=========");
                    break;
                default:
                    System.out.println("+---+\n|   |\n|\n|\n|\n|\n=========");
                    break;
            }
    
            System.out.println("Digite seu chute: ");
            var chute = sc.nextLine();
            chute = chute.toLowerCase();




            if(chutes.contains(chute)){
                System.out.println("Você já chutou essa letra, tente novamente!");
                continue;
            }
            chutes.add(chute);

            if(!this.palavra.getPalavraSecreta().contains(chute)){
                erros++;
            }

            this.palavra.revelarLetra(chute);

            System.out.println("Palavra: " + this.palavra.getPalavraComChute());

            if(this.palavra.palavraCompleta()){
                System.out.println("Parabéns, "+ this.jogador.getNome() + " você acertou a palavra!");
            }
            else if(erros == 6){
                System.out.println("+---+\n|   |\n|   O\n|  /|\\\n|  / \\\n|\n=========");
                System.out.println("Poxa, "+ this.jogador.getNome() + " você não acertou a palavra!");
                System.out.println("A palavra secreta era: " + this.palavra.getPalavraSecreta());
            }
        }
        sc.close();
    }
}
