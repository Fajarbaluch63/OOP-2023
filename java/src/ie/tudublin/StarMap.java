
package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;
import java.util.ArrayList;
import processing.data.Table;

public class StarMap extends PApplet
{

    ArrayList<Star> stars = new ArrayList<Star>();

	public void settings()
	{
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

        Table table = loadTable("stars.csv", "header");
    
        for (TableRow row : table.rows()) {
            Star star = new Star(row);
            stars.add(star);
        }

        loadData("stars.csv");
        loadData("stars.csv");
        printStars();


		smooth();
	}

	
	public void draw()
	{	
		drawGrid();

	}

	public class Star {
         String DisplayName;
         boolean isHabitable;
         float distance;
         float xG;
         float yG;
         float zG;
         float absoluteMagnitude;
    
         public Star(Table table, int rowIndex) {
            DisplayName = table.getString(rowIndex, "Display Name");
            distance = table.getFloat(rowIndex, "Distance");
            absoluteMagnitude = table.getFloat(rowIndex, "AbsMag");
            xG = table.getFloat(rowIndex, "Xg");
            yG = table.getFloat(rowIndex, "Yg");
            zG = table.getFloat(rowIndex, "Zg");
        }

        public Star(TableRow row) {
            this.DisplayName = row.getString("Display Name");
            this.distance = row.getFloat("Distance");
            // Assign the other properties in a similar way
        }
        
        
    }

    public void loadData(String filename) {
        Table table = loadTable(filename, "header");
        for (TableRow row : table.rows()) {
            Star star = new Star(row);
            stars.add(star);
        }
    }

    public void printStars() {
        for (Star star : stars) {
            println(star.toString());
        }
    }

    public void drawGrid() {
        stroke(150, 0, 255);
        strokeWeight(1);
        textSize(12);
        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, 50, width - 50);
            float y = map(i, -5, 5, height - 50, 50);
            line(x, 50, x, height - 50);
            line(50, y, width - 50, y);
            textAlign(CENTER, TOP);
            fill(150, 0, 255);
            text(str(i) + " pc", x, height - 40);
            textAlign(RIGHT, CENTER);
            text(str(i) + " pc", 40, y);
        }
    }   
}

