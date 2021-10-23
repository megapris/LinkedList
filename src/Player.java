import java.util.Random;

public class Player extends Creature {
    protected int XP;
    protected int maxHealth;

    public boolean playerSpell = false;
    
    public Player(int strength, int health){
        super(strength, health);
        XP = 0;
        maxHealth = health;
    }

    public void addXP(int amount){
        XP+=amount;
    }

    public int getXP(){return XP;}

    // TO DO: fix logic
    public boolean canLevelUp(){return true;}

    // Fix: not sure difference about health and max health
    public void levelUp(SpellType type){
        if(XP > 100){
            XP-=100;
            strength+=5;
            health = maxHealth; // not sure if this is right
            maxHealth+=10;

            playerSpell = true;
        }
    }
}
