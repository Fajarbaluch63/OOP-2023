package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{

	public void settings()
	{
		size(800, 800);
	}

	public void setup() {
		colorMode(RGB);
		background(0);

        

	

		smooth();
		
	}

    public void drawGrid()
    {
        stroke(0,255,255);
        float border = width * 0.1f;

        
        for(int i = -5; i <= 5; i++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);

            textAlign(CENTER, CENTER);
            text(i, border * 0.5f, x);
            text(i, x, border * 0.5f);

        }

        
    }


	public void draw()
	{	
		strokeWeight(1);
		drawGrid();
	}

    public void drawStars()
    {
        //for(Star s:stars()
       // {
          //  s.render(this);
       // }
    }
}
