package lab3p2_mariasinclair;

public class Pokeball {
    
   protected String color;    
   protected int serie;
   protected int eficiencia; //numero entre 1 y 3

    public Pokeball(String color, int serie, int eficiencia) {
        this.color = color;
        this.serie = serie;
        this.eficiencia = eficiencia;
    }

    public String getColor() {
        return color;
    }

    public int getSerie() {
        return serie;
    }

    public int getEficiencia() {
        return eficiencia;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public void setEficiencia(int eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public String toString() {
        return "Pokeball: \n" + "\nColor:" + color + "\nSerie: " + serie + "\nEficiencia: " + eficiencia;
    }
   
   
}
