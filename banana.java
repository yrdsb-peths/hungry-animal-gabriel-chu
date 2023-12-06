import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Falling banana
 * 
 * @author Gabriel
 * @version nov 2023
 */
public class Banana extends Actor
{
    private int speed = 1;
    /**
     * Act - do whatever the banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // banana falls downwards
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
    
        
        // Remove banana and draw game over when banana gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
