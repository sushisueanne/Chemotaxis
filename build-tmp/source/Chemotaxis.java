import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 int hiveX;
 int hiveY;
 Bacteria [] francine= new Bacteria [100];
 boolean mouseclicked = false;

 public void setup()   
 {     
 	size(500,500);
 	for (int i=0; i<francine.length; i++){
 	francine [i]= new Bacteria();
 	}
 }   
 public void draw()   
 {    
 	background(255,127,80);
 	for (int y=50; y<500; y=y+50){
 		stroke(255);
 		line(0,y,500,y);
 	}
 	if (mouseclicked==true){
 	francine[49].mouseappear();
 	}
	for (int i=0; i< francine.length; i++){
	 	francine[i].walk();
	 	francine[i].show();
	 	francine[i].moveTowards();
	}

 }  

 class Bacteria    
 {    
 	int myX;
 	int myY;
 	int myColour;

 	Bacteria(){

 		myX=250;
 		myY=250;

 	} 
 	public void walk(){

 		if (myX<500&&myY<500){

	 		myX=myX+(int)(Math.random()*5)-2;
	 		myY=myY+(int)(Math.random()*5)-2;

	 	}else {

 			myX=(int)(Math.random()*151)+100;
 			myY=(int)(Math.random()*151)+100;

		}

 	}
 	public void show(){
 		stroke(50);
 		fill(255,215,0);
 		ellipse(myX,myY,8,4);
 	}

 	public void mouseappear(){
 		stroke(50);
 		if (mouseclicked==true){
	 		fill(251,239,68);
	 		ellipse(hiveX,hiveY,60,20);
	 		ellipse(hiveX,hiveY+10,70,20);
	 		ellipse(hiveX,hiveY+20,80,20);
	 		ellipse(hiveX,hiveY+30,70,20);
	 		ellipse(hiveX,hiveY+40,60,20);
 		}

 	}

 	public void moveTowards(){
 	
	 	if (mouseclicked==true){

		 	if (myX-hiveX>40){
		 		myX=myX-(int)(Math.random()*3);
		 	}

		 	if (hiveX-myX>40){
		 		myX=myX+(int)(Math.random()*3);
		 	}

		 	if (myY-hiveY>40){
		 		myY=myY-(int)(Math.random()*3);
		 	}

		 	if (hiveY-myY>40){
		 		myY=myY+(int)(Math.random()*3);
		 	}
		}

 	}   
 }

 public void mouseClicked(){
 	hiveY=mouseY;
 	hiveX=mouseX;
 	mouseclicked=true;
 }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
