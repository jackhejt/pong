import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Ball extends GameObject
{   
    int size, direction, speed, initialSpeed, tick, respawnTime, launchTime, launchGo;
    
    boolean fail, spawned;
    
    public Ball(int size)
    {
        this.size = size;
        if(Greenfoot.getRandomNumber(2) == 0)
        {
            this.direction = Greenfoot.getRandomNumber(90) - 45;
        }
        else
        {
            this.direction = (Greenfoot.getRandomNumber(90) - 45) + 180;
        }
        
        this.speed = 10;
        this.initialSpeed = 10;
        
        this.fail = false;
        this.spawned = false;
        this.tick = 0;
        this.respawnTime = 80;
        
        this.launchGo = 16;
        
        redraw();
    }
    
    public void act()
    {
        if(spawned)
        {
            setRotation(direction);
            move(speed);
            particleTrail();
            collide();
        }
        else if(!spawned && !fail)
        {
            launch();
        }
        else
        {
            respawn();
        }
    }
    
    public void launch()
    {
        tick++;
        if(launchTime > launchGo)
        {
            spawned = true;
        }
        else if(tick > launchTime/2)
        {
            launchTime++;
            tick = 0;
            setRotation(direction);
            move(-2);
        }
    }
    
    public void respawn()
    {
        tick++;
        
        if(tick > respawnTime)
        {
            fail = false;
            tick = 0;
            launchTime = 1;
        }
        else if(tick > respawnTime/2)
        {
            visible = true;
            speed = initialSpeed;
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
            redraw();
        }
        else if(tick > respawnTime/4)
        {
            // LEAVE ME EMPTY
        }
        else
        {
            failParticles();
        }
    }
    
    public void failParticles()
    {
        if(getX() < size/2)
        {
            for(int x = speed * speed; x > 0; x--)
            {
                getWorld().addObject(new Particle(Greenfoot.getRandomNumber(141) - 70, speed, 0), getX(), getY() + Greenfoot.getRandomNumber(size + 1) - (size/2));
            }
        }
        else
        {
            for(int x = speed * speed; x > 0; x--)
            {
                getWorld().addObject(new Particle(Greenfoot.getRandomNumber(141) + 110, speed, 0), getX(), getY() + Greenfoot.getRandomNumber(size + 1) - (size/2));
            }
        }
    }
    
    public void particleTrail()
    {
        for(int x = speed; x > 0; x--)
        {
            getWorld().addObject(new Particle(direction + 140 + Greenfoot.getRandomNumber(81), speed), getX() + Greenfoot.getRandomNumber(size + 1) - (size/2), getY() + Greenfoot.getRandomNumber(size + 1) - (size/2));
        }
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
            for(int x = speed * speed; x > 0; x--)
            {
                getWorld().addObject(new Particle(), getX(), getY() + getImage().getHeight()/3);
            }
            speed += 1;
        }
        if(isAtEdge() && (getX() < size/2 || getX() > getWorld().getWidth() - size/2))
        {
            spawned = false;
            fail = true;
            tick = 0;
            visible = false;
            redraw();
            
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
            for(int x = speed * 3; x > 0; x--)
            {
                getWorld().addObject(new Particle(), getX(), getY() + getImage().getHeight()/3);
            }
        }
        else if(isAtEdge() && getY() < size/2)
        {
            direction = direction + ((180 - direction) * 2);
            for(int x = speed * 3; x > 0; x--)
            {
                getWorld().addObject(new Particle(), getX(), getY() + getImage().getHeight()/3);
            }
        }
    }
    
    public void redraw()
    {
        if(visible)
        {
            image = new GreenfootImage(size, size);
            image.fillOval(0, 0, size, size);
            setImage(image);
        }
        else
        {
            image = new GreenfootImage(size, size);
            setImage(image);
        }
    }
}
