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
import org.junit.runners.JUnit4;
import org.junit4.assert.AssertEquals ;
import org.junit4.Test ;
import java.io.Serializable ;
public class Node{
public static class Position{
private int x ; 
private int y ; 
private int scale ;
public position(int xPos,int yPos, int scale1 ){
this.x = xPos ; 
this.y = yPos ;
this.scale =  scale1 ;
}
public position(int xPos,int yPos){
this.x = xPos ; 
this.y = yPos ;
this.scale = 1 ;
}
public void setPos(int xPos, int yPos  ){
this.x = xPos ;
this.y = yPos ; 
}
public void setPosX(int xPos ){
this.x = xPos ;
}
public void setPosY(int yPos){
this.y = yPos ; 
}
public int getPosX( ){
int x1 = this.xPos ;
return x1 ;
}
public int getPosY(){
int y1 = this.yPos ;
return y1 ;
}
}
int thresh ;
int height ; 
int width;
Position position ;
Rectangle rect ; 
public int Thresh ;
public Node(){
this(0,0)  ;
}
public Node(int x1, int y1,int scale){
this.position =  new Position(x1,y1,scale) ;
this.height  = 0 ;
this.width = 0 ; 
this.rect = new Rectangle(x1,y1,0,0);

}
public Node(int x1, int y1,int height1, int width1,int scale ){
this.position = new Position(x1,y1,scale) ;
this.height = height1 ; 
this.width1 = width ; 
this.rect = new Rectangle(x,y,height,width);
}
public Position getPosition(){
Position pos = this.position ;
return pos  ; 
}
public int getWidth(){
int width1 = this.width; 
return width1 ;
}
public int getHeight(){
int height1 = this.height; 
return height1 ;
}
public void setPostion(Position pos1){
Position pos2 = pos1 ;
this.position = pos2 ;
}
public void setHeight(int height1){
int pos2 =  height1 ;
this.height = pos2 ;
}
public void setWidth(int width1){
int pos2 =  width1 ;
this.width = pos2 ;
}
}
