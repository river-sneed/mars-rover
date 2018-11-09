
/**
 * Write a description of class Runner here.
 *
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main(String[] args) {
        System.out.println("*");
        System.out.println("*");
        System.out.println("New Test");
        System.out.println("*");
        System.out.println("*");
        Rover r1 = new Rover("Owen");
        Rover r2 = new Rover("Marcella", 10, -4, 2);
        Rover r3 = new Rover("Narauto");
        System.out.println(r1.toString());
        
        
        
        r1.moveTo(0,5);
        System.out.println(r1);
        r1.moveTo(5,5);
        System.out.println(r1);
        r1.moveTo(0,0);
        System.out.println(r1);
        r1.moveTo(-5,-4);
        System.out.println(r1);
        
        
        
       r1.seppuku();
        r3.doubleSeppuku();
        r1.move(1);
        r1.moveTo(2,2);
        r3.move(1);
        r3.moveTo(2,2);
        r1.takePicture();
        r3.takePicture();
        r1.attack(r2);
        r3.attack(r2);
        r1.teleport(0, 0);
        r3.teleport(20, 20);
        r1.rotate(3);
        r3.rotate(3);
        r3.rotate(-9);
        
        
        
        
        
        
        
        /*System.out.println(r1);
        System.out.println(r2);
        r1.attack(r2);
        System.out.println(r2);
        r1.attack(r2);
        System.out.println(r2);
        r1.attack(r2);
        System.out.println(r2);
        r1.attack(r2);
        System.out.println(r2);
        r1.attack(r2);
        System.out.println(r2);
        r1.attack(r2);
        System.out.println(r2);
        r1.attack(r2);
        System.out.println(r2);
        r1.attack(r2);
        System.out.println(r2);*/
        
        /*
        r1.takePicture();
        System.out.println(r1);
        r1.moveTo(1,0);
        r1.takePicture();
        System.out.println(r1);
        r1.moveTo(4,0);
        r1.takePicture();
        System.out.println(r1);
        r1.moveTo(1,0);
        r1.takePicture();
        System.out.println(r1);
        r1.takePicture();
        System.out.println(r1);
        r1.takePicture();
        System.out.println(r1);
        
        
        r1.moveTo(-5,-2);
        System.out.println(r1);
        r1.moveTo(0,0);
        System.out.println(r1);
        r1.moveTo(3,5);
        System.out.println(r1);
        r1.teleport(0, 0);
        System.out.println(r1);
        r1.teleport(20, 2);
        r1.goHome();
        */
       
       
        
        /*
        r1.move(2);
        System.out.println(r1);
        r1.rotate(2);
        System.out.println(r1);
        r1.move(2);
        System.out.println(r1);
        r1.rotate(-17);
        System.out.println(r1);
        r1.move(1);
        System.out.println(r1);
        r1.rotate(-11);
        System.out.println(r1);
        r1.move(1);
        System.out.println(r1);
        */
        
        
        /*
         * 
         *
        r1.move(2);
        System.out.println(r1);
        r1.rotate(3);
        System.out.println(r2);
        r1.move(2);
        System.out.println(r1);
        r2.rotate(-4);
        System.out.println(r2);
        r2.rotate(-2);
        System.out.println(r2);
        r1.rotate(16);
        System.out.println(r1);
        r1.move(2);
        
        r2.kill(r1);
        System.out.println(r1);
        System.out.println(r2);
        
        r1.move(2);        
        System.out.println(r1);
        */
    }
}
