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
public class ChromeBot1 extends Thread implements Runnable{
    Node node ;
    public int thresh;
    public int thresh_;
    public Robot robot;
    public Rectangle rect;
    public boolean isDino;
    public boolean isTranslated = false;
    public static int KEYSPACE = keyEvent.VK_SPACE ;
    public static int KEYDOWN = KeyEvent.VK_DOWN ; 
    public static int KEYUP = KeyEvent.VK_UP ;
    public static int MOUSELEFTCLICK = InputEvent.BUTTON1_DOWN_MASK ;	
    public static int MOUSERIGHTCLICK = InputEvent.BUTTON2_DOWN_MASK ;
    //Unparametized Constructor
    public ChromeBot1(){
        this(0,0,0,0);
        System.out.println("ChromeBot created");
    }

    public ChromeBot1(int x1,int y1,int width1,int height1){
        try{
            robot=new Robot();

        } catch (AWTException e){
            e.printStackTrace();
        }
        Node node1 = new Node(x1,y1,height1,width1,1) ;
        rect=node1.rectangle ;
	this.node = node1 ;
    }
    public ChromeBot1(Node node1){
	try{
	robot = new Robot() ;
		}
		catch(AWTException exp){
		e.printStackTrace
		}
	this.node = node1; 
	this.rect  = new Rectangle(node1.rectangle)  ;
		}
    public boolean jump() throws AWTException{
        int sum=0;
        int width2;
        int height2;
        Color c;
        robot.keyPress(ChromeBot1.KEYDOWN);
        robot.mouseWheel(-6);
        BufferedImage image=robot.createScreenCapture(rect);
        width2 = image.getWidth();
        height2 = image.getHeight();
        for(int i=0;i<width2;i+=1){
            for(int j=0;j<height2;j+=1){
                c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
                }
            }
        //System.out.println(this.toString() + sum);
        if(sum<=thresh&&isDino==true ){
        robot.delay(100);
        robot.keyRelease(ChromeBot1.KEYDOWN);
        robot.keyPress(ChromeBot1.KEYSPACE);
        robot.delay(200);
        robot.keyRelease(ChromeBot1.KEYSPACE);
        robot.keyPress(ChromeBot1.KEYDOWN);
        }//"Sum of the pixel color components is exceedingly beyond the threshold"
        if( sum>=2000000){throw new AWTException("Sum of the pixel color components is exceedingly beyond the threshold"); 
        }  
        if(isDino==false){
            if(sum>=thresh){
                return true;
            }else{     
            return false;
            }
        }
        else{
            return false;
        }
    }         
    public int  scale() throws AWTException{
        int width;    
        int height;  
        int sum= 0;  
        Color c;
        robot.keyPress(ChromeBot1.KEYDOWN);
        robot.mouseWheel(-6);
        BufferedImage image=robot.createScreenCapture(rect);
        width=image.getWidth();
         height=image.getHeight();
        for(int i=0;i<width;i+=1){
            for(int j=0;j<height;j+=1){
                c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
            }
        }
        //System.out.println(this.toString() + sum);
        if(sum>=thresh_){
            robot.delay(80);
            robot.keyRelease(ChromeBot1.KEYDOWN);
            robot.keyPress(ChromeBot1.KEYSPACE);
            robot.delay(200);
            robot.keyRelease(ChromeBot1.KEYSPACE);
            robot.keyPress(ChromeBot1.KEYDOWN);
        }
        if( sum>=2000000) {throw new AWTException("Sum of the pixel color components is exceedingly beyond the threshold"); 
        }
        return sum;
    }
    public int restart(boolean state) throws AWTException{
        int width2;
        int height2;
        int sum2=0;
        Color c;
        BufferedImage image=robot.createScreenCapture(rect);
        width2 =  image.getWidth();
        height2 = image.getHeight();
        for(int i=0;i<width2;i+=1){
            for(int j=0;j<height2;j+=1){
                c=new Color(image.getRGB(i,j));
                sum2+=c.getRed();
                sum2+=c.getBlue();
                sum2+=c.getGreen();
                }
        }
        //System.out.println(this.toString() + sum2);
        if((state==true&&sum2<=thresh)||(state==false&&sum2>=thresh_)){
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.mouseMove(x,y);
            robot.mousePress(ChromeBot1.MOUSECLICKLEFT);
            robot.delay(200);
            robot.mouseRelease(ChromeBot1.MOUSECLICKLEFT);
            robot.mouseMove(x+80,y+80);
        }
        if(sum2>=2000000){throw new AWTException("Sum of the pixel color components is exceedingly beyond the threshold"); 
                }
        return sum2;
    }//Button postion initialisation method();
    public void init(){
        robot.mouseMove(x+width/2,y+height/2);
        robot.mousePress(ChromeBot1.MOUSECLICKLEFT);
        robot.mouseRelease(ChromeBot1.MOUSECLICKLEFT);
        robot.keyPress(ChromeBot1.KEYSPACE);
        robot.delay(50);
        robot.keyRelease(ChromeBot1.KEYSPACE);
        robot.mouseMove(x+80,y+80);

    }
    //public test method(non-static);
    public int test() throws AWTException{
        int width;
        int height;
        int sum=0;
        Color c;
        BufferedImage image=robot.createScreenCapture(rect);
        width =  image.getWidth();
        height = image.getHeight();
        for(int i=0;i<width;i+=1){
            for(int j=0;j<height;j+=1){
                c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
                }
        }
        //System.out.println(this.toString() + sum2);
        if(sum>=2000000){throw new AWTException("Sum of the pixel color components is exceedingly beyond the threshold"); 
                }
        System.out.println(sum);
        return sum;
    } 
    //ChromeBot position translation method(non-static);
    public void translate(int a,int b){
        if(this.isTranslated==false){
        this.x=this.x+a;
        this.y=this.y+b;
        this.isTranslated = true;
        }
    }
}                                                                