package aula01.poo.src.pooClasse;

public class Veiculo {

    String cor;
    int passageiros;
    int capCombustivel;
    int kpl;

    public Veiculo(){}

    public Veiculo(String cor, int passageiros, int capCombustivel, int kpl) {
        this.cor = cor;
        this.passageiros = passageiros;
        this.capCombustivel = capCombustivel;
        this.kpl = kpl;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(int passageiros) {
        this.passageiros = passageiros;
    }

    public int getCapCombustivel() {
        return capCombustivel;
    }

    public void setCapCombustivel(int capCombustivel) {
        this.capCombustivel = capCombustivel;
    }

    public int getKpl() {
        return kpl;
    }

    public void setKpl(int kpl) {
        this.kpl = kpl;
    }

    int autonomia(){
        return capCombustivel*kpl;
    }

    double combNecessario(int kilometro){
        return (double)kilometro / kpl;
    }
 

    
}
