import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen
 * 
 * @Gabriel chu 
 * @version Dec 2023
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, 200);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        //start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,471,87);
        elephant.setLocation(274,216);
        elephant.setLocation(325,195);
        Label label = new Label("click <space> to start", 40);
        addObject(label,297,267);
        label.setLocation(315,260);
        elephant.setLocation(331,180);
        label.setLocation(315,258);
        elephant.setLocation(332,177);
        Label label2 = new Label("press arrow keys to move side to side", 30);
        addObject(label2,297,306);
        label2.setLocation(304,299);
        elephant.setLocation(288,179);
        elephant.setLocation(309,92);
    }
}
