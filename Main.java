// Osiris Villacampa Project 3 Pokedex
import java.util.Scanner;

public class Main {
    public static void main (String[]args){
        Scanner inputUser = new Scanner(System.in);
        boolean Stop = false;
        int pokemons = -1;
        System.out.println("Welcome to your new Pokedex!");
        System.out.println("How many Pokemon are in your region?:");
        while (pokemons < 0){
            while (!inputUser.hasNextInt()){
                System.out.println("That is not a valid choice. Try again.");
                System.out.println("How many Pokemon are in your region?:");
                inputUser.next();
            }
            pokemons = inputUser.nextInt();
            if(pokemons < 0){
                System.out.println("That is not a valid choice. Try again.");
                System.out.println("How many Pokemon are in your region?:");
            }
        }
        Pokedex myPokedex = new Pokedex(pokemons);
        System.out.println("");
        System.out.println("Your new Pokedex can hold " + pokemons + " Pokemon. Let's start using it!");
        System.out.println("");
        String pokemonName;
        while (Stop != true) {
            System.out.println("1. List pokemon");
            System.out.println("2. Add Pokemon");
            System.out.println("3. Check a Pokemon's stats");
            System.out.println("4. Evolve Pokemon");
            System.out.println("5. Sort Pokemon");
            System.out.println("6. Exit");
            System.out.println("");
            System.out.println("What would you like to do?");
            int selection;
            if (inputUser.hasNextInt())
            {
                selection = inputUser.nextInt();
            }
            else
            {
                selection = 0;
                inputUser.next();
            }
            switch (selection) {                        // Using a switch statement to easily make the menu options
                case 1:
                    System.out.println("");
                    String[] pokemonList = myPokedex.listPokemon();
                    int counter = 1;
                    if (pokemonList != null) {
                        // for loop through string list printing out
                        for (String s : pokemonList) {
                            System.out.println(counter + ". " + s);
                            counter++;
                            // statement that shows if list is empty print empty
                        }
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Please enter the Pokemon's Species: ");
                    pokemonName = inputUser.next();
                    myPokedex.addPokemon(pokemonName);
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Please enter the Pokemon of interest: ");
                    pokemonName = inputUser.next();
                    int[] pokemonStats = myPokedex.checkStats(pokemonName);
                    if(pokemonStats != null) {
                        System.out.println("");
                        System.out.println("The stats for " + pokemonName + " are: ");
                        System.out.println("Attack: " + pokemonStats[0]);
                        System.out.println("Defense: " + pokemonStats[1]);
                        System.out.println("Speed: " + pokemonStats[2]);
                    }
                    else {
                        System.out.println("Missing");
                    }
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Please enter the Pokemon of interest: ");
                    pokemonName = inputUser.next();
                    boolean evolvePokemon = myPokedex.evolvePokemon(pokemonName);
                    if (evolvePokemon != false){
                        System.out.println(pokemonName + " has evolved!");
                    }
                    else {
                        System.out.println("Missing");
                    }
                    System.out.println("");
                    break;
                case 5:
                    myPokedex.sortPokedex();
                    break;
                    case 6:
                    Stop = true;
                    break;
                default:
                    System.out.println("That is not a valid choice. Try again.");
                    System.out.println("");
                    break;
            }

        }

    }
}

//https://stackoverflow.com/questions/7687310/java-array-with-loop
//https://www.geeksforgeeks.org/bubble-sort/
//https://stackoverflow.com/questions/2912817/how-to-use-scanner-to-accept-only-valid-int-as-input