import java.util.Random;
import java.util.Scanner;



public class Arena {

    private int turnCount = 0;
    private Scanner sc;
    private boolean firstTurn = true;
    
    Queue<Creature> north = new Queue<Creature>();
    Queue<Creature> south = new Queue<Creature>();
    Queue<Creature> west = new Queue<Creature>();
    Queue<Creature> east = new Queue<Creature>();

    Player player = new Player(100,100);

    void gameLoop(){
        
        do{
           createMonster();
           playersTurn();
           monstersTurn();
           turnCount++;
           firstTurn = false;
        }while(!isGameOver());
        sc.close();
    }

    public boolean isGameOver() {
        if(player.isDead() || (north.isEmpty() && south.isEmpty() && east.isEmpty() && west.isEmpty()))
            return true;
        return false;
    }

    public  void createMonster(){
        Random rand = new Random();
        int monsterChance = rand.nextInt(4);
        int randomQueue = rand.nextInt(4)+1;
        Creature monster = new Creature(rand.nextInt(49),rand.nextInt(99));
        
        if(firstTurn){
            switch(randomQueue){
                case 1: north.add(monster);
                    break;
                case 2: south.add(monster);
                    break;
                case 3: east.add(monster);
                    break;
                case 4: west.add(monster);
                    break;
            }
        }

        if((monsterChance == 3 || monsterChance == 1 || monsterChance == 2) && !firstTurn){
            
            switch(randomQueue){
                case 1: north.add(monster);
                    break;
                case 2: south.add(monster);
                    break;
                case 3: east.add(monster);
                    break;
                case 4: west.add(monster);
                    break;
            }

        // System.out.println(north.size());
        // System.out.println(south.size());
        // System.out.println(east.size());
        // System.out.println(west.size());
        }
    }

    public void playersTurn(){
         sc= new Scanner(System.in);
        if(!north.isEmpty() || !south.isEmpty() || !east.isEmpty() || !west.isEmpty()){
            // what if there are no monsters, automatically wins turn
            // mostrar poder y vida del jugador
            System.out.println("You have " + player.health + " health, and " + player.strength + " strength");
            System.out.println("----------------------------------------------------------------------------");

            if(!north.isEmpty())
                System.out.println("North has " + north.size() + " monster(s)");
            if(!south.isEmpty())
                System.out.println("South has " + south.size() + " monster(s)");
            if(!west.isEmpty())
                System.out.println("West has " + west.size() + " monster(s)");
            if(!east.isEmpty())
                System.out.println("East has " + east.size() + " monster(s)");
            System.out.println("Choose where you want to attack: N- North, S- South, E-East, W-West");

            // TO DO error checking for user input
            String attackDir = "";
            boolean rightAnswer = false;
      
            do{
                
                    attackDir = sc.nextLine();
                attackDir = attackDir.toUpperCase();
                
                if(attackDir.equals("N") && !north.isEmpty())
                    rightAnswer = true;
                if(attackDir.equals("S") && !south.isEmpty())
                    rightAnswer = true;
                if(attackDir.equals("E") && !east.isEmpty())
                    rightAnswer = true;
                if(attackDir.equals("W") && !west.isEmpty())
                    rightAnswer = true;
                //System.out.println("There are no monsters in that direction");
            }while(!rightAnswer);

            
            boolean spellCasted = false;
            if(player.canCast(SpellType.FIRE) || player.canCast(SpellType.FROST) || player.canCast(SpellType.LIGHTNING) || player.canCast(SpellType.HEAL)){
                System.out.println("You can cast a spell or attack");
                
                String playerAction = sc.nextLine();

                if(playerAction.equals("Spell")){
                    
                    spellCasted = true;
                }

            }
            if(!spellCasted){
                //attack
                Creature temp = new Creature(0,0);
                switch(attackDir){
                    case "N": temp = north.peek();
                        break;
                    case "W": temp = west.peek();
                        break;
                    case "E": temp = east.peek();
                        break;
                    case "S": temp = south.peek();
                        break;
                }
                int playerDamage = player.attack();
                temp.hurt(playerDamage);
                System.out.println("You have attached the monster with " + playerDamage + " power");
                if(temp.isDead()){
                    System.out.println("You have killed the monster");
                  
                        switch(attackDir){
                            case "N": 
                                if(north.size() > 1)
                                    temp = north.dequeue();
                                if(north.size() == 1)
                                    north.clear();
                                break;
                            case "W": 
                                if(west.size() > 1)
                                    temp = west.dequeue();
                                if(north.size() == 1)
                                    west.clear();
                                break;
                            case "E": 
                                if(east.size() > 1)
                                    temp = east.dequeue();
                                if(east.size() == 1)
                                    east.clear();
                                break;
                            case "S": 
                                if(south.size() > 1)
                                    temp = south.dequeue();
                                if(south.size() == 1)
                                    south.clear();
                                break;
                        }
                    
                    


                }
                if(!temp.isDead())
                System.out.println("The monster has " + temp.getHealth() + " remaining health");
                // atacaste con 10 de poder a tantos tantos
                // estado del monstruo
                attackDir = "";
            }
       
            
        

        }

    }

    public void monstersTurn() {
        Creature temp = new Creature(0,0);
        int monsterAttack;

        if(!north.isEmpty()){
            temp = north.peek();
            monsterAttack = temp.attack();
            player.hurt(monsterAttack);

            if(!player.isDead())
                System.out.println("A monster from the North just attcked you!. Health is: " + player.health);
            else System.out.println("You have died");
        }
        if(!south.isEmpty()){
            temp = south.peek();
            monsterAttack = temp.attack();
            player.hurt(monsterAttack);
            if(!player.isDead())
                System.out.println("A monster from the South just attcked you!. Health is: " + player.health);
            else System.out.println("You have died");
        }
        if(!east.isEmpty()){
            temp = east.peek();
            monsterAttack = temp.attack();
            player.hurt(monsterAttack);

            if(!player.isDead())
                System.out.println("A monster from the East just attcked you!. Health is: " + player.health);
            else System.out.println("You have died");
        }
        if(!west.isEmpty()){
            temp = west.peek();
            monsterAttack = temp.attack();
            player.hurt(monsterAttack);

            if(!player.isDead())
                System.out.println("A monster from the West just attcked you!. Health is: " + player.health);
            else System.out.println("You have died");
        }
    }


    public static void main(String[] args){
        Arena game = new Arena();

        game.gameLoop();
        System.out.println("you have survived "+ game.turnCount + " rounds");
     
    }


}
