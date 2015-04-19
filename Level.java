import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level extends Game
{
    Paddle p1, p2;
    int p1Score, p2Score;
    
    public Level()
    {
        p1 = new Paddle("w", "s", 0);
        p2 = new Paddle("up", "down", 180);
        addObject(p1, 50, getHeight()/2);
        addObject(p2, getWidth() - 50, getHeight()/2);
        addObject(new Ball(50), getWidth()/2, getHeight()/2);
        
        p1Score = 0;
        p2Score = 0;
    }
    
    // make public void redraw here!
}