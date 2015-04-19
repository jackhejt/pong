import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends Game
{
    int menuPos, numMenuPos;
    
    static boolean upD, downD;
    
    public Menu()
    {
        menuPos = 0;
    }
    
    public Menu(boolean load)
    {
        super(load);
        menuPos = 0;
    }
    
    public void act()
    {
        behavior();
        for(int x = 0; x < colorChangeRate; x++)
        {
            colorShift();
        }
        keyboardControl();
        mouseControl();
        redraw();
    }
    
    public void behavior() {}
    
    public void keyboardControl()
    {
        if(Greenfoot.isKeyDown("up") && !upD)
        {
            menuPos--;
            upD = true;
        }
        else if(!Greenfoot.isKeyDown("up"))
        {
            upD = false;
        }
        if(Greenfoot.isKeyDown("down") && !downD)
        {
            menuPos++;
            downD = true;
        }
        else if(!Greenfoot.isKeyDown("down"))
        {
            downD = false;
        }
    }
    
    public void mouseControl()
    {
        
    }
}
