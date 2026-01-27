package heranca.exerciciosHeranca.exercicio3;

public class Triangulo extends Figura2D{
    
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public double calculoArea(){
        Figura2D figura2d = new Figura2D();
        double altura = figura2d.getAltura();
        double base = figura2d.getBase();

        double area = (base * altura) / 2;
        return area;
    }
}
