import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the world our hero lives in
 * 
 * @author gabriel
 * @version nov 2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        //Create the elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //Create a label
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        createBanana();
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }

    /**
     * create a new banana at random location
     */
    public void createBanana()
    {
        Banana banana = new Banana();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(banana, x, y );
    }
}


    

