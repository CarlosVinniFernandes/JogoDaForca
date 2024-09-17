import java.util.Arrays;
import java.util.List;

public class Palavra {
    private List<String> palavras = Arrays.asList("Faca", "Colher", "Pote", "Tigela", "Panela", "Garfo", "Prato");

    private String palavraSecreta;
    private String palavraComChute;
    
    public void gerarPalavraSecreta(){
        var range = this.palavras.size() - 1;
        var index = (int) (Math.random() * range);

        this.palavraSecreta = this.palavras.get(index);
        this.palavraSecreta = palavraSecreta.toLowerCase();
        this.palavraComChute = "-".repeat(this.palavraSecreta.length());
    }

    public void revelarLetra(String letra){
        for (int i = 0; i < this.palavraSecreta.length(); i++) {
            if(this.palavraSecreta.charAt(i) == letra.charAt(0)){
                this.palavraComChute = this.palavraComChute.substring(0,i) + 
                letra + this.palavraComChute.substring(i + 1);
            }
        }
    }

    public boolean palavraCompleta(){
        return !this.palavraComChute.contains("-");
    }

    public List<String> getPalavras() {
        return palavras;
    }
    public void setPalavras(List<String> palavras) {
        this.palavras = palavras;
    }
    public String getPalavraSecreta() {
        return palavraSecreta;
    }

    public String getPalavraComChute() {
        return palavraComChute;
    }
    public void setPalavraComChute(String palavraComChute) {
        this.palavraComChute = palavraComChute;
    }

    

}
