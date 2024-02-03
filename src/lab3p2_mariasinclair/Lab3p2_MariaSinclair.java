package lab3p2_mariasinclair;

import java.util.ArrayList;
import java.util.Random;
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
                    eliminarPorTipo();
                    break;

                case 5:
                    encuentroPokemon(pokebolas);
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

    private static void eliminarPorTipo() {
        System.out.println("Eliminar Pokemon por Tipo:");
        System.out.println("1. Fire-Type");
        System.out.println("2. Water-Type");
        System.out.println("3. Grass-Type");

        int opcionTipo;

        while (true) {
            System.out.print("Seleccione el tipo de Pokemon que desea eliminar (1-3): ");

            if (leer.hasNextInt()) {
                opcionTipo = leer.nextInt();
                leer.nextLine();

                if (opcionTipo >= 1 && opcionTipo <= 3) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese una opción valida (1-3).");
                }
            } else {
                System.out.println("Por favor, ingrese un numero entero.");
                leer.nextLine();
            }
        }

        String tipoPokemon = null;

        switch (opcionTipo) {
            case 1:
                tipoPokemon = "Fire-Type";
                break;
            case 2:
                tipoPokemon = "Water-Type";
                break;
            case 3:
                tipoPokemon = "Grass-Type";
                break;
            default:
                System.out.println("Opcion no valida.");
                return;
        }

        // Mostrar lista de Pokemon del tipo seleccionado
        System.out.println("\nLista de Pokemon " + tipoPokemon + " para eliminar:\n");

        int indice = 1;

        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon pokemon = pokemones.get(i);

            if ((opcionTipo == 1 && pokemon instanceof FireType)
                    || (opcionTipo == 2 && pokemon instanceof WaterType)
                    || (opcionTipo == 3 && pokemon instanceof GrassType)) {
                System.out.println(indice + ". " + pokemon);
                indice++;
            }
        }

        if (indice == 1) {
            System.out.println("No hay Pokemon de tipo " + tipoPokemon + " en la lista.");
            return;
        }

        int indiceEliminar;
        while (true) {
            System.out.print("Ingrese el numero del Pokemon que desea eliminar: ");

            if (leer.hasNextInt()) {
                indiceEliminar = leer.nextInt();
                leer.nextLine();

                if (indiceEliminar >= 1 && indiceEliminar < indice) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese un indice valido (1-" + (indice - 1) + ").");
                }
            } else {
                System.out.println("Por favor, ingrese un numero entero.");
                leer.nextLine();
            }
        }

        // Eliminar el Pokemon seleccionado
        int contador = 1;
        for (int i = 0; i < pokemones.size(); i++) {
            Pokemon pokemon = pokemones.get(i);

            if ((opcionTipo == 1 && pokemon instanceof FireType)
                    || (opcionTipo == 2 && pokemon instanceof WaterType)
                    || (opcionTipo == 3 && pokemon instanceof GrassType)) {
                if (contador == indiceEliminar) {
                    pokemones.remove(i);
                    System.out.println("Pokemon eliminado con exito.");
                    break;
                }
                contador++;
            }
        }
    }

    private static void encuentroPokemon(ArrayList<Pokeball> pokebolas) {
        if (pokebolas.isEmpty()) {
            System.out.println("No hay pokebolas disponibles.");
            return;
        }

        // Mostrar pokebolas disponibles
        System.out.println("Pokebolas disponibles: ");
        for (int i = 0; i < pokebolas.size(); i++) {
            System.out.println((i + 1) + ". " + pokebolas.get(i));
        }

        // Pedir al usuario que elija una pokebola
        int opcionPokebola;

        while (true) {
            System.out.print("Seleccione una pokebola para el encuentro (1-" + pokebolas.size() + "): ");

            if (leer.hasNextInt()) {
                opcionPokebola = leer.nextInt();
                leer.nextLine();

                if (opcionPokebola >= 1 && opcionPokebola <= pokebolas.size()) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese una opcion valida.");
                }
            } else {
                System.out.println("Por favor, ingrese un numero entero.");
                leer.nextLine();
            }
        }

        Pokeball pokebolaElegida = pokebolas.get(opcionPokebola - 1);

        // Seleccionar un pokemon aleatorio no atrapado
        Random random = new Random();
        Pokemon pokemonEncontrado = null;

        for (Pokemon pokemon : pokemones) {
            if (!pokemon.isAtrapado()) {
                pokemonEncontrado = pokemon;
                break;
            }
        }

        if (pokemonEncontrado == null) {
            System.out.println("Todos los pokemon ya han sido atrapados.");
            return;
        }

        System.out.println("Ha aparecido el Pokemon " + pokemonEncontrado.getNombre());
        System.out.print("Utilizar pokebola para capturar (1) o huir (2): ");

        int opcionAccion;

        while (true) {
            if (leer.hasNextInt()) {
                opcionAccion = leer.nextInt();
                leer.nextLine();

                if (opcionAccion == 1 || opcionAccion == 2) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese una opcion valida (1 o 2).");
                }
            } else {
                System.out.println("Por favor, ingrese un numero entero.");
                leer.nextLine();  // Limpiar el buffer de entrada
            }
        }

        if (opcionAccion == 2) {
            System.out.println("Has decidido huir :");
            return;
        }

        // Intento de captura
        int Atrapar = 0;

        switch (pokebolaElegida.getEficiencia()) {
            case 3:
                Atrapar = 1;
                break;
            case 2:
                Atrapar = 2 / 3;
                break;
            case 1:
                Atrapar = 1 / 3;
                break;
        }

        if (random.nextDouble() < Atrapar) {
            System.out.println("Has capturado a " + pokemonEncontrado.getNombre() + " con exito :*)");
            pokemonEncontrado.setAtrapado(true);
            pokemonEncontrado.setPokebola(pokebolaElegida);
            pokebolas.remove(pokebolaElegida);
        } else {
            System.out.println("No has logrado atrapar a " + pokemonEncontrado.getNombre() + ".");
            pokebolas.remove(pokebolaElegida);
        }
    }

}
