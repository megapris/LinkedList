import java.util.Random;

public class Creature {

    protected int strength;
    protected int health;

    protected boolean fire;
    protected boolean freeze;
    protected boolean lightning;
    protected boolean heal;

    public Creature(int strength, int health){
        this.health = health;
        this.strength = strength;
    }


    public int getStrength(){ return strength;}
    public void setStrength(int strength){ this.strength = strength; }

    public int getHealth(){return health;}
    public void setHealth(int health){ this.health = health; }

    // TO DO: finish logic fix because the max damage they can dish out is equa to strength
    public int attack(){ 
        if(!isFrozen()){
            Random rand = new Random();
            int damage = rand.nextInt(strength);
            // strength-=damage; i dont think i need this one
            return damage;
        }
        return 0;
    }
    public void hurt(int damage){
        health-=damage;
    }
    // TO DO fix return logic
    public boolean isDead(){ 
        if(health <= 0)
            return true;
        return false;
    }
    // TO DO fix logic
    public void giveSpell(SpellType type){

    }
    // TO DO make sure that cast variable is/isnt global
    public boolean canCast(SpellType type){ 

        if(SpellType.FIRE == type && fire) return true;
        if(SpellType.FROST == type && freeze) return true;
        if(SpellType.LIGHTNING == type && lightning) return true;
        if(SpellType.HEAL == type && heal) return true;

        return false;
    }
    // TO DO fix logic
    public void freeze(Creature target){

    }
    // TO DO fix logic
    public boolean isFrozen(){ return false;}
    // TO DO fix logic
    public void decFreezeTimer(){ 

    }
    // TO DO fix logic
    public void setOnFire(Creature target){

    }
    // TO DO fix logic
    public boolean isOnFire(){ return false;}
    // TO DO fix logic
    public void decFireTimer(){}
    
    public void heal(int amount){
        health+=amount;
    }
}
