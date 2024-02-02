package lab3p2_mariasinclair;

public class Pokemon {

    protected String nombre;
    protected int entrada;
    protected String cadena; //naturaleza: Timido, Energetico, Misterioso.
    protected boolean atrapado; //validacion y pokebola.
    protected Pokeball pokebola; //lama otra clase 

    public Pokemon(String nombre, int entrada, String cadena, boolean atrapado) {
        this.nombre = nombre;
        this.entrada = entrada;
        this.cadena = cadena;
        this.atrapado = false;
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

    @Override
    public String toString() {
        return "Pokemon: \n" + "\nNombre: " + nombre + "\nEntrada: " + entrada + "\nCadena:" + cadena + "\nAtrapado: " + atrapado + "\nPokeBall=" + pokebola;
    }
}
