import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pixel extends Particle
{
    int gravity;
    
    public Pixel()
    {
        this.decay = 0;
        
        this.width = Greenfoot.getRandomNumber(21) + 20;
        this.height = Greenfoot.getRandomNumber(21) + 20;
        this.speed = 0;
        this.direction = Greenfoot.getRandomNumber(360);
        
        this.spin = 20 - Greenfoot.getRandomNumber(41);
        this.gravity = Greenfoot.getRandomNumber(5) + 1;
        
        image = new GreenfootImage(width, height);
        image.setColor(Game.inverseColor);
        image.fill();
        setImage(image);
    }
    
    public void movement()
    {
        speed += gravity;
        setLocation(getX(), getY() + speed);
        turn(spin);
    }
}
