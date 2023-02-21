package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{

    ArrayList<Star> stars = new ArrayList<Star>();

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
