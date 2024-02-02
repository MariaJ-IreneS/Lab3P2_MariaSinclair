package lab3p2_mariasinclair;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab3p2_MariaSinclair {

    static Scanner leer = new Scanner(System.in);
    static ArrayList<Pokemon> pokemones = new ArrayList<>();
    static ArrayList<Pokeball> pokebolas = new ArrayList<>();

    public static void main(String[] args) {
        int caso = 0;

        while (caso < 7) {
            System.out.println("-------MENU-------");
            System.out.println("1. Crear Pokemon. ");
            System.out.println("2. Crear Pokebola. ");
            System.out.println("3. Listar Pokemon. ");
            System.out.println("4. Eliminar Pokemon. ");
            System.out.println("5. Capturar Pokemon. ");
            System.out.println("6. Modificar Pokemon. ");
            System.out.println("7. Salir del programa. ");
            System.out.print("Elige una opcion: ");
            caso = leer.nextInt();

            switch (caso) {
                case 1:
                    crearPokemon();
                    break;

                case 2:
                    crearPokebola(pokebolas);
                    break;

                case 3:
                    listarPokemonPorTipo();
                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                default:
                    System.out.println("El programa ha finalizado.");
                    break;
            }
        }

    }//Fin del Main.

    private static void crearPokemon() {
        System.out.println("Elija el tipo de Pokemon:");
        System.out.println("1. Fire-Type");
        System.out.println("2. Water-Type");
        System.out.println("3. Grass-Type");
        System.out.println("Opcion: ");
        int tipoElegido = leer.nextInt();

        Pokemon nuevoPokemon;

        System.out.print("Nombre del Pokemon: ");
        String nombre = leer.next();
        System.out.print("Numero de entrada en la Pokedex: ");
        int entrada = leer.nextInt();
        System.out.print("Naturaleza (Timido, Energetico, Misterioso): ");
        String cadena = leer.next();

        // Crear un nuevo Pokemon con el tipo elegido y agregarlo a la lista
        switch (tipoElegido) {
            case 1:
                System.out.print("Potencia del Fire-Type: ");
                int potencia = leer.nextInt();
                nuevoPokemon = new FireType(nombre, entrada, cadena, false, potencia);
                break;
            case 2:
                System.out.print("Puede vivir en agua (true/false): ");
                boolean vivir = leer.nextBoolean();
                System.out.print("Rapidez del Water-Type: ");
                int rapidez = leer.nextInt();
                nuevoPokemon = new WaterType(nombre, entrada, cadena, false, vivir, rapidez);
                break;
            case 3:
                System.out.print("Habitat del Grass-Type: ");
                String habitat = leer.next();
                int dominio = 0;
                boolean dominioValido = false;

                do {
                    System.out.print("Dominio sobre las plantas del Grass-Type (entre 0 y 100): ");
                    if (leer.hasNextInt()) {
                        dominio = leer.nextInt();

                        if (dominio >= 0 && dominio <= 100) {
                            dominioValido = true;
                        } else {
                            System.out.println("El dominio debe estar entre 0 y 100. Intente nuevamente.");
                        }
                    } else {
                        System.out.println("Ingrese un numero valido.");
                        leer.next();
                    }
                } while (!dominioValido);
                nuevoPokemon = new GrassType(nombre, entrada, cadena, false, habitat, dominio);
                break;

            default:
                System.out.println("Tipo de Pokemon no valido.");
                nuevoPokemon = new Pokemon(nombre, entrada, cadena, false);
                break;
        }

        pokemones.add(nuevoPokemon);
        System.out.println("Pokemon agregado con exito :) ");
    }

    public static void crearPokebola(ArrayList<Pokeball> pokebolas) {
        System.out.print("Color de la Pokebola: ");
        String color = leer.next();

        System.out.print("Numero de serie de la Pokebola: ");
        int serie = leer.nextInt();

        int eficiencia = 0;
        boolean eficienciaValida = false;

        do {
            System.out.print("Eficiencia de la Pokebola (entre 1 y 3): ");

            if (leer.hasNextInt()) {
                eficiencia = leer.nextInt();

                if (eficiencia >= 1 && eficiencia <= 3) {
                    eficienciaValida = true;
                } else {
                    System.out.println("La eficiencia debe estar entre 1 y 3. Intente nuevamente.");
                }
            } else {
                System.out.println("Ingrese un numero valido.");
                leer.next();
            }
        } while (!eficienciaValida);

        pokebolas.add(new Pokeball(color, serie, eficiencia));
    }

    private static void listarPokemonPorTipo() {
        System.out.println("Lista de Pokemon agrupados por tipo:\n");
        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon pokemon = pokemones.get(i);
            int posicion = i + 1;
            if (pokemon instanceof FireType) {
                System.out.println("\nFire-Type -> \n" + posicion + ")." + ": " + pokemon);
            } else if (pokemon instanceof WaterType) {
                System.out.println("\nWater-Type -> \n" + posicion + ")." + ": " + pokemon);
            } else if (pokemon instanceof GrassType) {
                System.out.println("\nGrass-Type -> \n" + posicion + ")." + ": " + pokemon);
            }
        }
    }
}
