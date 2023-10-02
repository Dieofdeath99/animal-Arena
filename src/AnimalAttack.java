public class AnimalAttack {
    private String attackType;
    private int damage;

    public AnimalAttack(String attackType, int damage){
        this.attackType = attackType;
        this.damage = Math.max(1, damage); //same as if damage <= 0 damage = 1

    }

    public String getAttackType() {
        return attackType;
    }

    public int getDamage() {
        return damage;
    }
}