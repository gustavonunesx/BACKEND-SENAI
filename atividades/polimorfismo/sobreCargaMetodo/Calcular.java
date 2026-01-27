package polimorfismo.sobreCargaMetodo;

public class Calcular {
    
    private double linear;
    private double area;
    private double volume;

    public Calcular() {
    }

    public Calcular(double linear) {
        this.linear = linear;
    }
    
    public Calcular(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public Calcular(double linear, double area, double volume) {
        this.linear = linear;
        this.area = area;
        this.volume = volume;
    }




    public void calcular(double comprimento){
        setLinear(comprimento);
        System.out.println("Comprimento: " + comprimento);
    }

    public void calcular(double comprimento, double largura){
        this.linear = comprimento;
        this.area = this.linear * largura;
        System.out.println("Area: " + this.area);
    }

      public void calcular(double largura, double comprimento, double altura){
        this.linear = comprimento;
        this.area = this.linear * largura;
        setVolume(this.area * altura);
        System.out.println("Area: " + this.volume);

    }

    public double getLinear() {
        return linear;
    }

    public void setLinear(double linear) {
        this.linear = linear;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    
    

}
