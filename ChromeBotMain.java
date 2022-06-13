import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.geom.*;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.util.function.Function ;
public class ChromeBotMain extends Thread Implements Runnable{   
 //Overriding the run() method() of the Thread class;
    //The run() method() is also encapsulated in the Runnable interface;
public static void main(String[] args){
        ChromeBot1 Dinosaur=new ChromeBot1(185,282,50,50);
        ChromeBot1 Button=new ChromeBot1(318,264,50,50);
        ChromeBot1 Modulator=new ChromeBot1(153,240,50,50);
        Dinosaur.thresh = 1800000;
        Dinosaur.thresh_=100000;  
        Modulator.thresh=50000;
        Button.thresh=1600000; 
        Button.thresh_=300000;
        Dinosaur.isDino=true;
        Modulator.isDino=false;
        Button.init();  
        while(true){       
            try{   
                boolean state = Modulator.jump();
                Button.restart(state);
                if(state==true){
                    Dinosaur.jump();
                }  
                if(state==false){
                    Dinosaur.scale();
                }
            } 
            catch(AWTException e||ChromeBotException exp1){
            e.printStackTrace();
	    exp1.setStackTrace() ; 
	    exp1.printStackTrace() ;
        }     
        }
    }
        
    //public static void main() function;
    @Override 
    public void run(){
        ChromeBot1 Dinosaur=new ChromeBot1(300,308,50,50);
        ChromeBot1 Button=new ChromeBot1(321,257,50,50);
        ChromeBot1 Modulator=new ChromeBot1(227,175,50,50);
        /*while(true){
            try{
        ChromeBot1 Button=new ChromeBot1(135,380,50,50);
        Button.jump();
            }catch(AWTException E){
            System.err.println(E.toString());}
        }*/
        Dinosaur.thresh=1860000;
        Dinosaur.thresh_=100000;
        Modulator.thresh=50000;
        Button.thresh=1400000; 
        Dinosaur.isDino=true;
        Modulator.isDino=false;
        Button.init();    
        while(true){            
            try{
                boolean state = Modulator.jump();
                Button.restart(state);
                if(state==true){
                    Dinosaur.jump();
                }
                if(state ==false){
                    Dinosaur.scale();
                }
            }   
            catch(AWTException e||ChromeBotException exp1){
            System.err.println(e.toString());
		exp1.setStackTrace() ;
		exp1.printStackTrace() ;
            }    
        }
    }
}