import java.util.Random;
public class Animal {
    private String type;
    private int strength; //max strength/damage the animal can inflict
    private int health; //the stuff that keeps the animal alive

    private static final int MINSTRENGTH = 1;
    private static final int MINHEALTH = 0;
    private static Random rand = new Random();

    /**
     * Default constructor. Called at instantiation with Animal mayAnimal = new Animal();
     */
    public Animal(){
        type = "";
        strength = 1;
        health = 10;
    }

    /**
     * Parameterized constructor for setting basic values
     * @param type
     * @param strength
     * @param health
     */
    public Animal(String type, int strength, int health){
        this.type = type;
        setStrength(strength);
        setHealth(health);

    }

    @Override
    public String toString(){
        return "Type: " + type + "; Strength: " + strength + "; Health: " + health + ";";

    }

    /**
     * Setter for type
     * @param str
     */
    public void setType(String str){
        type = str;
    }
    public void setStrength(int value){
        //put in protections to make sure value is valid
        if(value < MINSTRENGTH){
            strength = MINSTRENGTH;
        }else{
            strength = value;
        }
    }

    public void setHealth(int value){
        //put in protections to make sure value is valid
        if(value < MINHEALTH){
            health = MINHEALTH;
        }else{
            health = value;
        }
    }

    public int getHealth(){
        return health;
    }

    public String getType(){
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isDead(){
        if(health == 0){
            return true;
        } else {
            return false;
        }
    }
    public int attack(){
        return rand.nextInt(getStrength() + 1);
    }
    public AnimalAttack detailedAttack(){
        return new AnimalAttack("attacks", attack());
    }
}
