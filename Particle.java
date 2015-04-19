import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Particle extends GameObject
{
    int decay, timer;
    
    int width, height, speed, direction, spin;
    
    public Particle()
    {
        this.decay = 0;
        
        this.width = Greenfoot.getRandomNumber(5) + 1;
        this.height = Greenfoot.getRandomNumber(5) + 1;
        this.speed = Greenfoot.getRandomNumber(20) + 5;
        this.direction = Greenfoot.getRandomNumber(360);
        
        image = new GreenfootImage(width, height);
        image.fill();
        setImage(image);
    }
    
    public Particle(int direction, int speed)
    {
        this.decay = Greenfoot.getRandomNumber(5) + 3;
        
        this.width = Greenfoot.getRandomNumber(5) + 1;
        this.height = Greenfoot.getRandomNumber(5) + 1;
        this.speed = Greenfoot.getRandomNumber(10) + speed;
        this.direction = direction;
        
        image = new GreenfootImage(width, height);
        image.fill();
        setImage(image);
    }
    
    public void act() 
    {
        timer++;
        movement();
        die();
    }
    
    public void movement()
    {
        setRotation(direction);
        move(speed);
    }
    
    public void die()
    {
        if(timer > decay && decay != 0)
        {
            getWorld().removeObject(this);
        }
        else if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
