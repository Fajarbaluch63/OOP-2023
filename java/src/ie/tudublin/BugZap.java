package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX;
	float playerY=9;
	float playerWidth=5;
	int score=0;
	float bugX, bugY, bugWidth;
	float halfPlayer, halfBug;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();

		playerY= height - 100;
	    playerX= width * 0.5f;
		playerWidth=50;
		halfPlayer=playerWidth *0.5f;	
	}

	public void resetBug()
	{
		bugY=50;
		bugWidth=50;
		halfBug= bugWidth *0.2f;
		bugX=random(halfBug, width-halfBug);
	}

	
	public void draw()
	{	
		drawPlayer(playerX, playerY, playerWidth);
	
	}

	void drawPlayer(float x, float y, float w)
	{
		//float h =w/2;
		stroke(255);
		noFill();
		//line(x,y, x+w, y+h);
		rectMode(CENTER);
		rect(x,y, w,w);
		line(x,y - halfPlayer, x, y - halfPlayer * 2);

	}

	
	public void keyPressed()
    {
    background(0);
    if (keyCode == LEFT)
    {
    if (playerX > 0)
    playerX -= 10;
    System.out.println("Left arrow pressed");
    }
    if (keyCode == RIGHT)
    {
    if (playerX + playerWidth < width)
    playerX += 10;
    System.out.println("Right arrow pressed");
    }
    if (key == ' ')
    {
    System.out.println("SPACE key pressed");
    line(playerX , playerY - halfPlayer, playerX , 0);
    }
    } 
}
