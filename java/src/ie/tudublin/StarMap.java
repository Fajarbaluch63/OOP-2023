package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{

    ArrayList<Star> stars = new ArrayList<Star>();
    Star firstStar = null;

	public void settings()
	{
		size(800, 800);
	}

	public void setup() {
		colorMode(RGB);
		background(0);

        

	   loadStars();
       printStars();

		smooth();
		
	}

    void printStars()
    {
        for(int i=0; i < stars.size(); i++)
        {
            println(stars.get(i));
        }
    }
    

    public void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header");
 		for(TableRow r:table.rows())
 		{
 			Star s = new Star(r);
 			stars.add(s);
 		}
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

    public void mousePressed()
{
    for (Star s : stars)
    {
        float border = width * 0.1f;
        float x = map(s.getxG(), -5, 5, border, width - border);
        float y = map(s.getyG(), -5, 5, border, height - border);
        float d = dist(mouseX, mouseY, x, y);

        if (d < s.getAbsMag())
        {
            if (firstStar == null)
            {
                firstStar = s;
            }
            else
            {
                stroke(255, 255, 0);
                line(x, y, map(firstStar.getxG(), -5, 5, border, width - border), map(firstStar.getyG(), -5, 5, border, height - border));
                float distance = dist(firstStar.getxG(), firstStar.getyG(), s.getxG(), s.getyG());
                println("Distance from " + firstStar.getDisplayName() + " to " + s.getDisplayName() + " is " + distance + " parsecs");
                firstStar = null;
            }
            break;
        }
    }
}



	public void draw()
	{	
		strokeWeight(1);
		drawGrid();
        displayStars();
        mousePressed();

	}

   
    public void displayStars()
    {
        for(int i =0; i < stars.size(); i++) 
        {
            stars.get(i).render(this);
        }
    }
}
