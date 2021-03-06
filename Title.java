import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

public class Title extends Menu
{
    GreenfootImage background;
    
    MouseInfo mouse;
    
    public Title()
    {
        setup();
    }
    
    public Title(boolean load)
    {
        super(load);
        setup();
    }
    
    public void setup()
    {
        numMenuPos = 4;
        
        background = new GreenfootImage(getBackground());
        
        r = Greenfoot.getRandomNumber(256);
        g = Greenfoot.getRandomNumber(256);
        b = Greenfoot.getRandomNumber(256);
        
        rDirection = true;
        gDirection = true;
        bDirection = true;
        
        redraw();
    }
    
    public void behavior()
    {
        addObject(new Pixel(), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(100) + 25);
    }
    
    public void mouseControl()
    {
        if(Greenfoot.mouseClicked(null))
        {
            mouse = Greenfoot.getMouseInfo();
            
            if(mouse != null)
            {
                addObject(new NoPoints(), mouse.getX(), mouse.getY());
                if(getObjects(NoPoints.class).size() > 10)
                {
                    removeObject((Actor) getObjects(NoPoints.class).get(0));
                }
            }
        }
    }
    
    public void redraw()
    {
        colorUpdate();
        
        // Fill background
        background.setColor(mainColor);
        background.fill();
        
        // Draw cursor
        background.setColor(inverse(inverse2Color));
        background.fillRect(650, 100 + (menuPos * 100), 600, 100);
        
        // Draw menu options
        background.setColor(inverse2Color);
        background.setFont(Game.fthinFont.deriveFont(80f));
        background.drawString("PLAY!", 780, 160);
        background.drawString("CONTROLS", 670, 260);
        background.drawString("SETTINGS", 670, 360);
        background.drawString("CREDITS", 690, 460);
        
        // Draw title
        background.setColor(inverseColor);
        background.setFont(Game.cube1Font.deriveFont(300f));
        background.drawString("pong", 0, 160);
        
        setBackground(background);
    }
}
