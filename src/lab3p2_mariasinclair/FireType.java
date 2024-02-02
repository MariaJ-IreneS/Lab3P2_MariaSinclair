package lab3p2_mariasinclair;

public class FireType extends Pokemon{
   
    private int potencia; 

    public FireType(String nombre, int entrada, String cadena, boolean atrapado, int potencia) {
        super(nombre, entrada, cadena, atrapado);
        this.potencia=potencia; 
    }
    
   

    public int getPotencia() {
        return potencia;
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

    
    public void setPotencia(int potencia) {
        this.potencia = potencia;
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
        return "FireType:\n" + "\nPotencia=" + potencia;
    }

    
    
    
}
