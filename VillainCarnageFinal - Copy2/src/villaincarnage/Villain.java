package villaincarnage;

 

import city.cs.engine.*;

 
public class Villain extends Walker {
    private int lives =3;
    private int ballCount =0;
       private int bossHealth = 50;
    private static final Shape villainShape = new PolygonShape(
        -1.29f,2.41f, -2.01f,0.1f, -0.45f,-2.1f, 1.07f,-2.72f, 2.38f,0.22f, 1.34f,1.69f, -0.46f,2.61f);
         
    private static final BodyImage image =
        new BodyImage("data/villain.png", 6f);
    public Villain(World world) {
        super(world, villainShape);
        addImage(image);
        
        // Creates the  Walker villain object which will be used as the main character
        // for the player for control
       
    }
    
    public void setBoss(){
        
        bossHealth = bossHealth -10;
        // Decrements boss health, called each time the villain object collides with a 
        // black ball object in level 4
    }
    public int getBoss(){
         
        return bossHealth;
    }
    public void setLives(){
        lives = 3;
    }
    public void   setlavaTouched(){
         
        System.out.println("Game over! You were killed by the Lava Monster!");
        System.exit(0);
        // If villain object collides with a lava object in level 1 or 2 then the appropriate 
        // message to show game is over will be generated and game application exit.
    }
    public int getLives(){
        return lives;
    }
    public void incrementLives(){
        lives = lives + 2;
        // Increments lives by 2 each time the villain object collides with the life object in level 2
    }
    public int getBallCount(){
        return ballCount;
    }
    public void setBallCount(){
        ballCount = ballCount +1;
System.out.println("Your current ball count is:  " + ballCount);
    } 
    public void DecrementLives(){
        if (lives > 0 ){
        lives = lives -1;
        
        }else{
         System.out.println("You are out of lives! Game over!");
        System.exit(0);
            // Decrements lives, called each time the villain object collides with a spike.
            // IF lives is < 0 then game will be over and an appropriate game over message will be 
            // generated and the game will exit.
            
        }
            
         
     
    }
    public int geLives(){
        return lives;
    }
    
}