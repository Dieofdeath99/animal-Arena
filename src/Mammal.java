import java.util.Random;

public class Mammal extends Animal{ //the keyword extends means it inherits everything from Animal
    private AnimalAttack[] attacks = new AnimalAttack[4]; //Declare a 3 element array to hold attack objects
    private static Random rand = new Random();
    private AnimalAttack LastAttack;
    public Mammal(String type, int strength, int health){ //these are the same properties in Animal we will set them
        super(type, strength, health); //call the parent constructor (not required)
//set the 3 attacks:
        attacks[0] = new AnimalAttack("claws", rand.nextInt(getStrength()));
        attacks[1] = new AnimalAttack("bites", rand.nextInt(getStrength()));
        attacks[2] = new AnimalAttack("kicks", rand.nextInt(getStrength()));
        attacks[3] = new AnimalAttack("breath", rand.nextInt(getStrength()));
    }
    public int attack(){
        return detailedAttack().getDamage();
    }

    /**
     * Selects a random attack from the arrray and returns it
     * @return
     */
    public AnimalAttack detailedAttack(){
        int attackNum = rand.nextInt(attacks.length); //get us a random index from the array
        LastAttack = attacks[attackNum];
        return attacks[attackNum];
    }
}


