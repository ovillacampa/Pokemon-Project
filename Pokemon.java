public class Pokemon {
    private int attack;
    private int defense;
    private int speed;
    private String species;

    Pokemon(String pokeName){
        species = pokeName;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    public String getSpecies(){
        return species;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpecies(String newSpecies){
        species = newSpecies;
    }
    public void setAttack(int newAttack) {
        attack = newAttack;
    }
    public void setDefense(int newDefense){
        defense = newDefense;
    }
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
}
