import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalBrawl {
    public static ArrayList<Animal> animals; //Note: We have declared the list here, but it will still need instructions
    public static Scanner input = new Scanner(System.in);
    public static final int MILLIDELAY = 500;

    public static void main(String[] args) {
        animals = new ArrayList<>(); //instantiate the list. it is currently empty.
        addAnimals();
        //make sure we have enough animals to brawl by checking size of the list
        if(animals.size() >= 2) {
            //we can brawl
            printRoster();
            //have the animals brawl until only one remains - remove the animals from the list as they die
            brawl();
            System.out.println("All but one animal has been defeated");
            //new// access element in list with listname.get(#)
            System.out.println(animals.get(0) + " is the winner!");
        }else{
            System.out.println("Not enough animals to brawl");
        }
    }

    /** selects random animals to attack other animals
     * removes animals from the list as they die
     * until only one animal remains in the list
     */
    public static void brawl(){
        do{
            int attackerIndex = ThreadLocalRandom.current().nextInt(animals.size());//random number from 0 to size of arraylist
            int defenderIndex;
            do{
                defenderIndex = ThreadLocalRandom.current().nextInt(animals.size());
            }while(attackerIndex == defenderIndex);
            animalAttack(animals.get(attackerIndex), animals.get(defenderIndex));
            if(animals.get(defenderIndex).getHealth() <= 0){
                System.out.println(ConsoleColors.BLUE + animals.get(defenderIndex).getType() + " has been defeated." + ConsoleColors.RESET);
                //new// remove an element from the list with .remove(index)
                animals.remove(defenderIndex);
            }
        }while(animals.size() > 1); //new// get arraylist size with list.size()
    }
    public static void animalAttack(Animal attacker, Animal defender){
        int attack;
        if(attacker instanceof Mammal) {//Note: INSTANCEOF!!!!!! Even though we know it's an animal it could be a mammal
            AnimalAttack a = attacker.detailedAttack();
            attack = a.getDamage();
            System.out.println(ConsoleColors.RED + attacker.getType() + " attacks with " + a.getAttackType() + ConsoleColors.RESET);
        }else{
            attack = attacker.attack();
        }
        System.out.println(attacker.getType() + " attacks " + defender.getType() + " delivering " + attack + " damage");
        defender.setHealth(defender.getHealth() - attack);
        System.out.println(defender.getType() + " has " + defender.getHealth() + " health remaining");
    }
    public static void printRoster(){
        //new// For Each
        //a is what we'll call each element. animals is the collection we are iterating through
        for (Animal a:animals) {
            System.out.println(a);
        }
    }

    /**
     * Have the user respond to prompts until they are done adding animals
     */
    public static void addAnimals(){
        String userIn;
        //use a do-while loop
        do{
            System.out.print("Enter A to add an animal, M to add a Mammal and B when it's time to Brawl! -> ");
            userIn = input.nextLine().trim().toUpperCase();
            //new//
            if(userIn.equals("A")) {
                addAnimal();
            }else if(userIn.equals("M")){
                addMammal();
            }
        }while(!userIn.equals("B"));
    }
    public static void addAnimal(){
        System.out.println("Creating Animal: ");
        addAnimal(false);
    }
    public static void addMammal(){
        System.out.println("Creating Mammal: ");
        addAnimal(true);
    }
    public static void addAnimal(boolean isMammal){
        String userIn, type;
        int strength, health;
        System.out.print("Please enter the type: ");
        type = input.nextLine();
        System.out.print("Please enter the strength (invalid values will be treated as 1): ");
        userIn = input.nextLine();
        //new//
        strength = Utilities.parseInt(userIn, 1);
        System.out.print("Please enter the health (invalid values will be treated as 1): ");
        userIn = input.nextLine();
        health = Utilities.parseInt(userIn, 1);
        if(isMammal) {
            animals.add(new Mammal(type, strength, health));
        }else{
            animals.add(new Animal(type, strength, health));
        }
    }
}
/*
Static methods (in utilities class. We don't need an instance of an object to call these.
ForEach loops: (iterates through each element in a collection such as list)
syntax is For(datatype item : collection){ do something with the item }

ArrayLists - dynamic in size - must be instantiated (eg. list = new ArrayList<>()) before used.
When declaring arraylists specify its datatype in the <>
eg. public static ArrayList<Animal> animals; //here the datatype for the list is animal.
Access elements in an array list with list.get(index)
Remove elements in an array list with list.remove(index)
Add elements to an array list with list.add(element)
Get number of elements in the list with list.size()
String comparisons should not be done with == or != ---these compare memory addresses, not characters.
You should use stringVar.equals(thing you're comparing) : this method returns true or false.
Try/Catch can be used to handle exceptions and prevent the program from crashing
try{
return Integer.parseInt(s);
}catch (NumberFormatException e){
return ifInvalid;
}
Note: you should be specific in what exception type you are trying to catch.

*/