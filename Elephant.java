import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant, our hero
 * 
 * @author Gabriel
 * @version nov 2023
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    //direction elephant facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor - The code that gets run one time is created 
     */
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        
        //initianl elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elepghant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Act - do whatever the elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        {
            // Add your action code here.
            if(Greenfoot.isKeyDown("left"))
            {
                move(-3);
                facing = "left";
            }
            else if(Greenfoot.isKeyDown("right"))
            {
                move(3);
                facing = "right";
            }
        
        // Remove banana if elephant eats it
        eat();
        // amimate elephant
        animateElephant();
        }
    }
    /**
     * Eat the banana and spawn new banana if banana is eaten
     */
    public void eat()
    {
        if(isTouching(Banana.class))
        {
            removeTouching(Banana.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBanana();
            world.increaseScore();
            elephantSound.play();
        }
        removeTouching(Banana.class);
    }
}
