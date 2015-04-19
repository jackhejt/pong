import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class NoPoints extends Ball
{
   public NoPoints()
   {
       super(50);
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
        
        if(isAtEdge() && getX() < size/2 && getY() < size/2)
        {
            direction = 30 + Greenfoot.getRandomNumber(31);
        }
        else if(isAtEdge() && getX() > getWorld().getWidth() - size/2 && getY() < size/2)
        {
            direction = 120  + Greenfoot.getRandomNumber(31);
        }
        else if(isAtEdge() && getX() < size/2 && getY() > getWorld().getHeight() - size/2)
        {
            direction = 30 + Greenfoot.getRandomNumber(31);
        }
        else if(isAtEdge() && getX() > getWorld().getWidth() - size/2 && getY() > getWorld().getHeight() - size/2)
        {
            direction = 120  + Greenfoot.getRandomNumber(31);
        }
        else if(isAtEdge() && (getX() < size/2 || getX() > getWorld().getWidth() - size/2))
        {
            direction = direction + ((180 - direction) * 2) + 180;
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
}
