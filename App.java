public class App {
    public static void main(String[] args) throws Exception {
        var jogador = new Jogador("Carlos");
        var palavra = new Palavra();
        Jogo jogo = new Jogo(palavra, jogador);

        jogo.iniciarJogo();
    }
}
