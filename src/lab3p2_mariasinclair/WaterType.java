package lab3p2_mariasinclair;

public class WaterType extends Pokemon {

    private boolean vivir; // vivir en agua o no
    private int rapidez;

    public WaterType(String nombre, int entrada, String cadena, boolean atrapado, boolean vivir, int rapidez) {
        super(nombre, entrada, cadena, atrapado);
        this.vivir = false;
        this.rapidez = rapidez;
    }

    public boolean isVivir() {
        return vivir;
    }

    public int getRapidez() {
        return rapidez;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEntrada() {
        return entrada;
    }

    public String getCadena() {
        return cadena;
    }

    public boolean isAtrapado() {
        return atrapado;
    }

    public Pokeball getMostrar() {
        return pokebola;
    }

    public void setVivir(boolean vivir) {
        this.vivir = vivir;
    }

    public void setRapidez(int rapidez) {
        if (!this.vivir) {
            this.vivir = vivir;
        } else {
            System.out.println("No puede vivir.");
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public void setAtrapado(boolean atrapado) {
        this.atrapado = atrapado;
    }

    public void setMostrar(Pokeball pokebola) {
        this.pokebola = pokebola;
    }

    @Override
    public String toString() {
        return super.toString() + "\nVivir=" + vivir + "\nRapidez=" + rapidez;
    }

}
