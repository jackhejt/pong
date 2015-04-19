import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Paddle extends GameObject
{
    int dy, topSpeed, front;
    
    String up, down;
    
    Paddle(String up, String down, int front)
    {
        this.up = up;
        this.down = down;
        
        this.dy = 0;
        this.topSpeed = 20;
        this.front = front;
        
        image = new GreenfootImage(10, 100);
        image.fill();
        setImage(image);
    }
    
    public void act() 
    {
        control();
        movement();
        // redraw()?
    }    
    
    public void control()
    {
        if(Greenfoot.isKeyDown(up))
        {
            dy--;
            for(int x = (dy * -1); x > 0; x--)
            {
                getWorld().addObject(new Particle(Greenfoot.getRandomNumber(21 + (dy * -2)) + (80 + dy), (dy * -1)), getX(), getY() + getImage().getHeight()/3);
            }
        }
        if(Greenfoot.isKeyDown(down))
        {
            dy++;
            for(int x = dy; x > 0; x--)
            {
                getWorld().addObject(new Particle(Greenfoot.getRandomNumber(21 + (dy * 2)) - (100 + dy), dy), getX(), getY() - getImage().getHeight()/3);
            }
        }
        
        // DEACCELERATION
        /*
        if(!Greenfoot.isKeyDown(up) && !Greenfoot.isKeyDown(down))
        {
            if(dy > 0)
            {
                dy--;
            }
            else if(dy < 0)
            {
                dy++;
            }
        }
        */
       
        if(dy > topSpeed)
        {
            dy = topSpeed;
        }
        else if(dy < -topSpeed)
        {
            dy = -topSpeed;
        }
    }
    
    public void movement()
    {
        setLocation(getX(), getY() + dy);
        
        if(dy > 0)
        {
            for(int x = dy; x > 0; x--)
            {
                getWorld().addObject(new Particle(Greenfoot.getRandomNumber(21 + (dy * 2)) - (100 + dy), dy), getX(), getY() - getImage().getHeight()/3);
            }
        }
        else if(dy < 0)
        {
            for(int x = (dy * -1); x > 0; x--)
            {
                getWorld().addObject(new Particle(Greenfoot.getRandomNumber(21 + (dy * -2)) + (80 + dy), (dy * -1)), getX(), getY() + getImage().getHeight()/3);
            }
        }
        
        if(getY() > getWorld().getHeight() - (getImage().getHeight()/2))
        {
            setLocation(getX(), getWorld().getHeight() - (getImage().getHeight()/2));
            for(int x = dy; x > 0; x--)
            {
                getWorld().addObject(new Particle(), getX(), getY() + getImage().getHeight()/3);
            }
            dy *= -1;
            dy /= 2;
        }
        else if(getY() < (getImage().getHeight()/2))
        {
            setLocation(getX(), (getImage().getHeight()/2));
            for(int x = (dy * -1); x > 0; x--)
            {
                getWorld().addObject(new Particle(), getX(), getY() - getImage().getHeight()/3);
            }
            dy *= -1;
            dy /= 2;
        }
    }
    
    public int hitBall()
    {
        if(front == 180)
        {
            return front - dy;
        }
        else
        {
            return front + dy;
        }
    }
}
