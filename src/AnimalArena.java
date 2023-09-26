import java.util.Random;

public class AnimalArena {
    /* This will be the code that pits animals against each other, and eventually is arrested by PETA and co. */
    public static Random rand = new Random();
    public static final int MAXSTRENGTH = 10; //constant value
    public static final int MAXHEALTH = 20; //constant value


    public static void main(String[] args) {
        /*
        //Examples of invalid calls
        Animal testAnimal = new Animal();
        testAnimal.type = "This is invalid because type is private";
        testAnimal.stength = 1000000; //Again, this is invalid because strength is private
        */
        Animal tiger = createAnimalWithDefaultConstructor("Tiger");

        Animal trex = createAnimalWithParameterizedConstructor("TRex");

        System.out.println(tiger);
        System.out.println(trex);

        fight(tiger, trex);

    }
    public static void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * this method creates an animal and demonstrates the use of setters
     * @return
     */
    public static Animal createAnimalWithDefaultConstructor(String animalName){
        Animal a = new Animal(); //Default constructor
        a.setType(animalName);
        int health = rand.nextInt(MAXHEALTH/2) + 11; //will give us a random number between 1 and max health
        int strength = rand.nextInt(MAXSTRENGTH) + 1;
        a.setHealth(health);
        a.setStrength(strength);
        return a;
    }

    public static Animal createAnimalWithParameterizedConstructor(String animalName){
        int health = rand.nextInt(MAXHEALTH/2) + 11; //will give us a random number between 1 and max health
        int strength = rand.nextInt(MAXSTRENGTH) + 1;
        return new Animal(animalName, strength, health);
    }

    public static void animalAttack(Animal attacker, Animal defender){
        int attack = rand.nextInt(attacker.getStrength());
        System.out.println(attacker.getType() + " attacks " + defender.getType() + " delivering " + attack + " damage");
        defender.setHealth(defender.getHealth() - attack);
        System.out.println(defender.getType() + " has " + defender.getHealth() + " health remaining");
    }

    public static void fight(Animal a1, Animal a2){
        while(!a1.isDead() && !a2.isDead()){
            animalAttack(a1, a2);
            if(!a2.isDead()){
                animalAttack(a2, a1);
            }
        }
        if(a1.isDead()){
            System.out.println(a2.getType() + " won!");
        }else{
            System.out.println(a1.getType() + " won!");
        }
    }
}
