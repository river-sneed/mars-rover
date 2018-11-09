

/**
 * The rovers rove, they beep, they commit seppuku and double seppuku and take pictures on mars.
 *
 * @author (River Sneed)
 * @version (v3 9/25/2018)
 */
public class Rover
{
    // instance variables
    private int x;
    private int y;
    private int dir;
    private String name;
    private boolean isAlive;
    private String compassDirection;
    private int xHome;
    private int yHome;
    private int energy;
    private int numPics = 0;
    private int health = 10;
    private boolean isZombie = false;

    /** the function creates a rover 
     * @param name  name of the rover being created
     */
    public Rover(String name)
    {
        this.x = 0;
        this.xHome = 0;
        this.y = 0;
        this.yHome = 0;
        this.dir = 0;
        this.name = name;
        this.isAlive = true;
        this.energy = 25;
        
        
    }
    
    /** the function creates a rover 
     * @param name  name of the rover being created
     * @param x  x coordinate of rover being created
     * @param y  y coordinate of rover being created
     * @param dir  direction rover being created
     */
    public Rover(String name, int x, int y, int dir)
    {
        this.x = x;
        this.xHome = x;
        this.y = y;
        this.yHome = y;
        this.dir = dir;
        this.name = name;
        this.isAlive = true;
        this.energy = 25;
    }
    
    /** function returns cardinal direction rover is facing
     * 
     */
    private String getDirectionName() {
        String[] arrayDirections = { "North", "North-East", "East", "South-East",
            "South", "South-West", "West", "North-West"};
            return arrayDirections [this.dir]; 
    }
    
    /**function returns the direction needed to travel towards a given (x, y) coordinate
     * 
     * @param x  x value of destination coordinate
     * @param y  y value of destination coordinate
     */
    public int getDirectionTo(int x,int y) {
        int directionTo;
        
        if ((this.x == x) && (this.y < y)){
            directionTo = 0;
        }
        else if ((this.x < x) && (this.y < y)){
            directionTo = 1;
        }
        else if ((this.x < x) && (this.y == y)){
            directionTo = 2;
        }
        else if ((this.x < x) && (this.y > y)){
            directionTo = 3;
        }
        else if ((this.x == x) && (this.y > y)){
            directionTo = 4;
        }
        else if ((this.x > x) && (this.y > y)){
            directionTo = 5;
        }
        else if ((this.x > x) && (this.y > y)){
            directionTo = 5;
        }
        else if ((this.x > x) && (this.y == y)){
            directionTo = 6;
        }
        else if ((this.x > x) && (this.y < y)){
            directionTo = 7;
        }
        else{
            directionTo = 0;
        }
        return (directionTo);
    }
    
    /** function moves the rover to a given (x, y) coordinate in the most efficent way possible
     * @param xMove  x coordinate the rover will move to
     * @param yMove  y coordinate the rover will move to
     */
     public void moveTo(int xMove, int yMove){
       int xDiff = Math.abs(xMove - this.x);
       int yDiff = Math.abs(yMove - this.y);
       int distDiagonal = Math.min(xDiff, yDiff);
       int xOrigin = x;
       int yOrigin = y;
       
       if (((this.x != xMove) || (this.y != yMove)) && (isAlive)) {
            if (distDiagonal > 0) {
                dir = getDirectionTo(xMove, yMove);
                move(distDiagonal);
            }
            
            int xMoveRemain = Math.abs(xMove - this.x);
            int yMoveRemain = Math.abs(yMove - this.y);
            int remainingDistance = (xMoveRemain + yMoveRemain);
            if (remainingDistance > 0) {
                dir = getDirectionTo(xMove, yMove);
                move(remainingDistance);
                System.out.println(this.name + " moved from [x=" + xOrigin + ",y=" + yOrigin + 
                                   "] to [x=" + x + ",y=" + y + "].");
            }
            else {
                System.out.println(this.name + "is already there at [x=" + x + ",y=" + y + "].");
            }
       }
       else if (!isAlive) {
           showDedErr("move");
        }
       else{
           System.out.println("River is not not not gay");
           System.out.println(this.name + " moved from [x=" + xMove + ",y=" + yMove + 
                               "] to [x=" + x + ",y=" + y + "].");
        }
              
        /**
         * previous version of the move function
         * 
         * if (isAlive) {
            while ((yMove > y) && (xMove > x)) {
                dir = 1; 
                x+= 1; y += 1;
            }
            
            while ((yMove < y) && (xMove > x)) {
                dir = 3;
                x+= 1; y -= 1;  
            }
            
            while ((yMove < y) && (xMove < x)) {
                dir = 5;
                x-= 1; y -= 1;   
            }
            
            while ((yMove > y) && (xMove < x)) {
                dir = 7;
                x-= 1; y += 1;   
            }
            
            while ((yMove > y) && (xMove == x)) {
                dir = 0;
                y += 1;  
            }
            
            while ((yMove == y) && (xMove > x)) {
                dir = 2;
                x += 1;   
            }
            
            while ((yMove < y) && (xMove == x)) {
                dir = 4;
                y -= 1;
            }
            
            while ((yMove == y) && (xMove < x)) {
                dir = 6;
                x-=1;
            }*/
       
      }

    
    
    /** the function takes the rover to its home coordinates using the moveTo(xHome, yHome) function
     * then it outputs the rover's new coordinates
     */
    public void goHome() {
       if (isAlive) {
            moveTo(xHome, yHome);
            System.out.println(name + " went home and is now at: [x=" + x + ",y=" + y + "]");
       }
        else {
            showDedErr("go home");
        }
    }
    
    /** the function teleports the rover to the given coordinates (xMove, yMove) and plays a cool sound
     *  @param xMove  x coordinate the rover will teleport to
     *  @param yMove  y coordinate the rover will teleport to
     */
    public void teleport(int xMove, int yMove) {        
       if (isAlive) {
        int xDifference = Math.abs(x - xMove);
        int yDifference = Math.abs(y - yMove);
        double teleDistance = Math.hypot(xDifference, yDifference);
        Math.round(teleDistance);
        teleDistance *= 5;
        
        int sleep = 150;
        
        x = xMove;
        y = yMove;
        System.out.println(name + " teleported to: [x=" + x + ",y=" + y + "]");
        
        if(teleDistance > 0){
            for(int i = 0; i < teleDistance; i++){
                 java.awt.Toolkit.getDefaultToolkit().beep();
                try{
                    Thread.sleep(sleep);
                    if (sleep > 50) {
                        sleep -= 3;
                    }
                    else {
                        sleep = 50;
                    } 
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
      }
      else {
            showDedErr("teleport");
        }
    }
    
    /** the function rotates the rover (rotateAmount)
     * @ param rotateAmount  the amount that the rover will rotate in the 8 (0-7) direction system
     */
    public void rotate(int rotateAmount)
    {
        if (isAlive) {
            dir = dir + rotateAmount;
            
            if (dir >= 8) {
                dir = dir % 8;
            }
        else if (dir <= -1) {
            int dirCheck = Math.abs(dir);
            dirCheck = dirCheck % 8;
            
            dir =  (8 - dirCheck);  
        }
        System.out.println(this.name + " turnt " + rotateAmount + " units and is now facing " 
                           + getDirectionName() + ".");
      }
      else {
            showDedErr("turn");
      }
    }
   
   
   /** the function moves the rover a certain distance specified by moveDistance if the rover is alive
    * @param moveDistance  the distance the rover will move in a given direction 
    */ 
    public void move(int moveDistance) 
    {
        if (isAlive) {
            if (dir == 0) {
                y = y + moveDistance;
            }
            else if (dir == 1) {
                x = x + moveDistance;
                y = y + moveDistance;
            }
            else if (dir == 2) {
                x = x + moveDistance;
            }
            else if (dir == 3) {
                x = x + moveDistance;
                y = y - moveDistance;
            }
            else if (dir == 4) {
                y = y - moveDistance;
            }
            else if (dir == 5) {
                x = x - moveDistance;
                y = y - moveDistance;
            }
            else if (dir == 6) {
                x = x - moveDistance;
            }
            else if (dir == 7) {
                x = x - moveDistance;
                y = y + moveDistance;
            }
            
            System.out.println(this.name + " moved forward " + moveDistance +
                               " units to the " + getDirectionName() + ".");
        }
        else {
            showDedErr("move");
        }
    }
     
   /** the function takes a picture at the rover's location so long as the memory is not full
     * 
     */
   public void takePicture() {
        if (isAlive) {
            if (numPics < 5) {
                numPics += 1;
                System.out.println(this.name + " took a picture at [x=" + x + ",y=" + y + "] facing "
                + getDirectionName() + " .");
            }
            else {
                System.out.println(this.name + "could not take a picture because its memory is full.");
            }
        }
        else {
            showDedErr("take Picture");
        }
    }
    
    /** the function transmits the number of pictures taken and then wipes the rovers onboard memory
     * by setting numPics to 0
     */
    public void transmitPictures() {
        System.out.println(this.name + " has sent " + numPics + " picture(s) back to earth.");
        numPics = 0;
    }
    
    /** the function is used when a rover dies to change isAlive to false and health to 0
     * 
     */
    public void die() {
        isAlive = false;
        health = 0;
    }
    
    /** the function turns a rover into a zombie with 0 health, isZombie and isAlive to true
     * 
     */
    public void zombify() {
        health = 0;
        isZombie = true;
        isAlive = true;
    }
    
    /** the function lets rover kill another rover
     * @param other  the rover that will be killed
     */
    public void kill(Rover other) {
        deathScript(1, (other.name));
        other.die();
    }
    
    /** the function allows a rover to commit seppuku; a form of japanese ritualistic suicide with its own lazer
     * this turns the rover into a zombie if it is alive
     */
    public void seppuku() {
        die();
        deathScript(2, "none");
    }
    
    /** the function allows a rover to commit seppuku; a form of japanese ritualistic suicide with its own lazer
     * 
     */
    public void doubleSeppuku() {
        if (this.isAlive == true) {
        this.zombify();
        deathScript(3, "none");
       }
       else {
        System.out.println(this.name + " cannot commit double seppuku because it is already dead");
        }
    }
    
    /**the function takes in a scriptNum(ber) and a name of another rover (type "none" if not appliciable) and 
     * outputs a script based on the inputs
     * 
     * @param scriptNum  the number of script
     * @param otherName  name of the other rover (if it is involved in the script)
     */
    public void deathScript(int scriptNum, String otherName) {
        if (scriptNum == 0) {
            System.out.println(otherName + " goes 'beep beep aaaaaaakkkkkk!' and dies");
        }
        else if (scriptNum == 1) {
            System.out.println(this.name + " decides to play god and shoots " + otherName + " with space lasers.");
        }
        else if (scriptNum == 2) {
            System.out.println(this.name + " has commited seppuku with its own mining lazer and ");
            System.out.println("silently dies with only the sound of its oil dripping onto the ground...");
        }
        else if (scriptNum == 3) {
            System.out.println(this.name + " has commited double seppuku by frying its motherboard with its own mining lazer and ");
            System.out.println("silently dies with only the sound of its oil dripping onto the ground...");
            System.out.println(this.name + " is now a zombie samuari warrior ");
        }
        else if (scriptNum == 4) {
            System.out.println(otherName + " was mauled by zombie " + this.name + " and now " + otherName + " is a zombie too.");
        }
        else if (scriptNum == 5) {
            System.out.println(otherName + " was dead but now ... " + otherName + " is an undead zombie!!!!");
        }
        else if (scriptNum == 6) {
            System.out.println(this.name + " decided to mess with " + otherName + "'s undead reamains... now " + this.name + " is a zombie!!!");   
        }
    }
    
    /** the function creates a generalized error message for when the rover can't preform actions because it is dead
     * 
     * @param blank  the thing the 
     */
    public void showDedErr(String blank) {
        System.out.println(this.name + " can't " + blank + ". It's ded.");
    }
    
    /** the function allows a rover to attack another rover for a random amount of integer damage between 0 and 4
     * if the rover kills the other rover, the other rover dies
     * if the other rover is already dead at the time of the attack the attacking rover is also made into a zombie rover
     * zombie rovers can maul non zombie rovers and zombify them
     * 
     * @param other  the rover that is being attacked
     */
    public void attack(Rover other) {
        int damage = ((int)(5*Math.random()));
        
        if ((other.health >= 1) && (this.isZombie == false)) {   
            System.out.println("attack will do " + damage + " damage to " + other.name);
            other.health -= damage;
            if (other.health <= 0) {
                other.die();
                deathScript(0, (other.name));
            }
            else {
                System.out.println(other.name + " now has " + other.health + " health.");
            }
        }
        else if ((other.health >= 1) && (this.isZombie == true)) {
            other.zombify();
            deathScript(4, (other.name));
        }
        else if ((other.health <= 0) && (other.isZombie == false)) {
            other.zombify();
            deathScript(5, (other.name));
        }
        else {
            other.health = 0;
            zombify();
            deathScript(6, (other.name));            
        }
    }
    
    /** makes the tostring 
     * 
     */
    public String toString() {
        return "Rover[name=" + name + ",x=" + x + ",y=" + y + 
               ",dir=" + dir + ",numPics=" + numPics + ",isAlive=" + isAlive + "]";
    }
}
