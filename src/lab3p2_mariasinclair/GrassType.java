package lab3p2_mariasinclair;

public class GrassType extends Pokemon {

    private String habitad;
    private int dominio; //validar entre 0 a 100***

    public GrassType(String nombre, int entrada, String cadena, boolean atrapado, String habitad, int dominio) {
        super(nombre, entrada, cadena, atrapado);
        this.habitad = habitad;
        setDominio(dominio);
    }

    public String getHabitad() {
        return habitad;
    }

    public int getDominio() {
        return dominio;
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

    public Pokeball getPokebola() {
        return pokebola;
    }

    public void setHabitad(String habitad) {
        this.habitad = habitad;
    }

    public void setDominio(int dominio) {
        if (dominio >= 0 && dominio <= 100) {
            this.dominio = dominio;
        } else {
            System.out.println("Tiene que estar entre 0 y 100");
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

    @Override
    public String toString() {
        return super.toString() + "\nHabitad: " + habitad + "\nDominio=" + dominio;
    }

}
