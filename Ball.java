import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Ball extends GameObject
{   
    int size, direction, speed;
    
    public Ball(int size)
    {
        this.size = size;
        this.direction = Greenfoot.getRandomNumber(360);
        
        this.speed = 10;
        
        redraw();
    }
    
    public void act()
    {
        setRotation(direction);
        move(speed);
        collide();
    }
    
    public void collide()
    {
        while(direction < 0)
        {
            direction += 360;
        }
        while(direction > 360)
        {
            direction -= 360;
        }
        
        Paddle hit = (Paddle) getOneIntersectingObject(Paddle.class);
        
        if(hit != null)
        {
            direction = hit.hitBall();
            // particles?!?!
            speed += 1;
        }
        if(isAtEdge() && (getX() < size/2 || getX() > getWorld().getWidth() - size/2))
        {
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
            Level thisLevel = (Level) getWorld();
            if(getX() < size/2)
            {
                thisLevel.p2Score++;
            }
            else
            {
                thisLevel.p1Score++; // KNOWS WHICH SCORE TO INCREMEBT!
            }
        }
        else if(isAtEdge() && getY() > getWorld().getHeight() - size/2)
        {
            direction = direction + ((180 - direction) * 2);
        }
        else if(isAtEdge() && getY() < size/2)
        {
            direction = direction + ((180 - direction) * 2);
        }
    }
    
    public void redraw()
    {
        image = new GreenfootImage(size, size);
        image.fillOval(0, 0, size, size);
        setImage(image);
    }
}
