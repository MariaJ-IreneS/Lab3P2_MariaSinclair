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

    
    public void setAtrapado(boolean atrapado, Pokeball pokebola) {
        if (!this.atrapado) {
            this.atrapado = atrapado;
            if (atrapado) {
                this.pokebola = pokebola; // Asigna la Pokebola solo si el Pokemon esta atrapado
            } else {
                this.pokebola = null; // Si no esta atrapado, asigna la Pokebola como null
            }
        } else {
            System.out.println("No hay ningun pokemos atrapado.");
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

    public void setPokebola(Pokeball pokebola) {
        this.pokebola = pokebola;
    }

    public Pokeball getPokebola() {
        return pokebola;
    }
    

    @Override
    public String toString() {
        return "Pokemon: \n" + "\nNombre: " + nombre + "\nEntrada: " + entrada + "\nCadena:" + cadena + "\nAtrapado: " + atrapado + "\nPokeBall=" + pokebola;
    }
}
