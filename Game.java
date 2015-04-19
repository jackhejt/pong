import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.awt.*;

public class Game extends World
{
    public static Font cube1Font, elabFont, fregFont, fthinFont, tinyFont;
    public static int r, g, b, colorChangeRate;
    public static boolean rDirection, gDirection, bDirection;
    public static Color mainColor, inverseColor, inverse2Color;
    
    public Game()
    {    
        super(1200, 600, 1);
        
        try
        {
            cube1Font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/cube1.ttf"));
            fregFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/freg.ttf"));
            fthinFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/fthin.ttf"));
            elabFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/elab.ttf"));
            tinyFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/tiny.ttf"));
        }
        catch(IOException e)
        {
            cube1Font = new Font(Font.SERIF, Font.PLAIN, 50);
            fregFont = new Font(Font.SERIF, Font.PLAIN, 50);
            fthinFont = new Font(Font.SERIF, Font.PLAIN, 50);
            elabFont = new Font(Font.SERIF, Font.PLAIN, 50);
            tinyFont = new Font(Font.SERIF, Font.PLAIN, 50);
            System.out.println("GAH! IT BROKE!");
        }
        catch(FontFormatException e)
        {
            cube1Font = new Font(Font.SERIF, Font.PLAIN, 50);
            fregFont = new Font(Font.SERIF, Font.PLAIN, 50);
            fthinFont = new Font(Font.SERIF, Font.PLAIN, 50);
            elabFont = new Font(Font.SERIF, Font.PLAIN, 50);
            tinyFont = new Font(Font.SERIF, Font.PLAIN, 50);
            System.out.println("GAH! IT BROKE!");
        }
        
        colorChangeRate = 1;
        
        setPaintOrder(Pixel.class);
    }
    
    public void act()
    {
        for(int x = 0; x < colorChangeRate; x++)
        {
            colorShift();
        }
        control();
        redraw();
    }
    
    public void colorShift()
    {
        switch(Greenfoot.getRandomNumber(3))
        {   
        case 0:
            if(rDirection)
            {
                r += Greenfoot.getRandomNumber(5) + 1;
            }
            else
            {
                r -= Greenfoot.getRandomNumber(5) + 1;
            }
            break;
        case 1:
            if(gDirection)
            {
                g += Greenfoot.getRandomNumber(5) + 1;
            }
            else
            {
                g -= Greenfoot.getRandomNumber(5) + 1;
            }
            break;
        case 2:
            if(bDirection)
            {
                b += Greenfoot.getRandomNumber(5) + 1;
            }
            else
            {
                b -= Greenfoot.getRandomNumber(5) + 1;
            }
            break;
        }
        
        if (r >= 255)
        {
            rDirection = false;
            r = 255;
        }
        else if(r <= 0)
        {
            rDirection = true;
            r = 0;
        }
        if (g >= 255)
        {
            gDirection = false;
            g = 255;
        }
        else if(g <= 0)
        {
            gDirection = true;
            g = 0;
        }
        if (b >= 255)
        {
            bDirection = false;
            b = 255;
        }
        else if(b <= 0)
        {
            bDirection = true;
            b = 0;
        }
    }
    
    public void redraw()
    {
        colorUpdate();
    }

    public void colorUpdate()
    {
        mainColor = new Color(r, g, b);
        inverseColor = new Color(255-r, 255-g, 255-b);
        if(r + g + b > 384)
        {
            inverse2Color = inverseColor.darker().darker();
        }
        else
        {
            inverse2Color = inverseColor.brighter().brighter();
        }
    }
    
    public void control() {}
}
