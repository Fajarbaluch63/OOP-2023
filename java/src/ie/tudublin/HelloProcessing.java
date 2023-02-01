package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(0);

		
	}

	
	public void draw()
	{	
		background(255,0,0);
		stroke(1,0,0);
		noStroke();
		fill(241,254,0);
		circle(250,250,450);//cx,cy,d
		fill(0,244,255);
		triangle(250,5,0,410,500,410);
		fill(255,255,255);
		ellipse(250,250,250,100);//cx,cy,d
		fill(0);
		ellipse(250,250,80,80);
		

		
	}
}
