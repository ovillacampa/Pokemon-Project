public class Pokedex implements PokedexInterface{
        private int numberOfPokemon;
        private int pokemonNumber;
        private static Pokemon[] myPokemonArray;


    Pokedex(int amountOfPokemon){
        numberOfPokemon = amountOfPokemon;
        myPokemonArray = new Pokemon[amountOfPokemon];
        pokemonNumber = 0;
    }

    /*
     * Return all the names of the Pokemon species in the
     * Pokedex.
     */
    public String[] listPokemon(){
        int i;
        String[] pokemonNames = new String[pokemonNumber];
        if(pokemonNumber == 0){
            System.out.println("Empty");
            System.out.println("");
            pokemonNames = null;
        }
        else {
            for (i = 0; i < pokemonNumber; i++) {
                pokemonNames[i] = this.myPokemonArray[i].getSpecies();
            }
        }
        return pokemonNames;

    }



    /*
     * Add a Pokemon to the Pokedex and return true if it was
     * successful. If not, return false.
     */
    public boolean addPokemon(String species) {
        boolean success = false;
        if((pokemonNumber + 1) > numberOfPokemon){
            System.out.println("Max");
            success = false;
        }
        else if (pokemonSearch(species)){
            System.out.println("Duplicate");
            success = false;
        }
        else {
            this.myPokemonArray[this.pokemonNumber] = new Pokemon(species);
            pokemonNumber++;
            success = true;
        }
        return success;
    }
    /*
     * Return the stats of a certain Pokemon that you are
     * searching for. The stats will be attack, defense, then speed
     * in that order within the array that will be returned.
     */
    public int[] checkStats(String species){
        int i;
        int[] pokemonStats = new int[3];
        if (pokemonSearch(species)){
            for(i=0; i < pokemonNumber; i++){
                if (this.myPokemonArray[i].getSpecies().equals(species)) {
                    pokemonStats[0] = this.myPokemonArray[i].getAttack();
                    pokemonStats[1] = this.myPokemonArray[i].getDefense();
                    pokemonStats[2] = this.myPokemonArray[i].getSpeed();
                }
            }
        }
        else {
            pokemonStats = null;
        }
       return pokemonStats;
    }
    /*
     * Sort Pokedex in lexical order according to the species names.
     */
    public void sortPokedex(){
        int result;
        int i;
        boolean swap = true;
        while (swap) {
            swap = false;
            for (i = 0; i < pokemonNumber - 1; i++) {
                Pokemon tempSwap = this.myPokemonArray[i];
                result = this.myPokemonArray[i].getSpecies().toLowerCase().compareTo(this.myPokemonArray[i + 1].getSpecies().toLowerCase());
                if (result > 0) {
                    this.myPokemonArray[i] = this.myPokemonArray[i + 1];
                    this.myPokemonArray[i + 1] = tempSwap;
                    swap = true;
                }
            }
        }
    }
    /*
     * Evolve a certain Pokemon by tripling the speed stat,
     * doubling the attack stat, and quadrupling the defense stat.
     * Return true if the evolve was successful.
     * If not, return false.
     */
    public boolean evolvePokemon(String species) {
        //search for pokemon species if not found return false
        //get pokemon speed with getSpeed
        //set pokemon speed with setSpeed = 3 * getSpeed
        //get pokemon attack with getAttack
        //set pokemon attack with setAttack = 2 * getAttack
        //get pokemon defense with getDefense
        //set pokemon defense with setDefense = 4 * getDefense
        int i;
        boolean done = false;
        for (i = 0; i < pokemonNumber; i++) {
            if (this.myPokemonArray[i].getSpecies().equals(species)) {
                this.myPokemonArray[i].setAttack(this.myPokemonArray[i].getAttack() * 2);
                this.myPokemonArray[i].setDefense(this.myPokemonArray[i].getDefense() * 4);
                this.myPokemonArray[i].setSpeed(this.myPokemonArray[i].getSpeed() * 3);
            done = true;

            }
            else {
                done = false;
            }
        }
        return done;
    }

    private boolean pokemonSearch(String species){
        boolean found = false;
        int i;
        for(i=0; i < pokemonNumber; i++){
            if (this.myPokemonArray[i].getSpecies().equalsIgnoreCase(species)){
                found = true;
            }
    }
        return found;
    }
}


