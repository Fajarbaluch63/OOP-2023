package ie.tudublin;

import processing.core.PApplet;

public class Life {
    
    public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB);
	}

   
    
    public class Life extends PApplet {
        public void settings() {
            size(1000, 1000);
        }
    
        public void setup() {
            reset();
        }
    
        float playerX, playerY;
        float playerSpeed = 5;
        float playerWidth = 40;
        float halfPlayerWidth = playerWidth / 2;
    
        float bugX, bugY, bugWidth = 100;
        float halfBugWidth = bugWidth / 2;
    
        int score = 0;
    
        void reset() {
            resetBug();
            playerX = width / 2;
            playerY = height - 50;
        }
    
        void resetBug() {
            bugX = random(halfBugWidth, width - halfBugWidth);
            bugY = 50;
        }
    
        void drawBug(float x, float y) {
            // Draw the bug
            stroke(255);
            float saucerHeight = bugWidth * 0.7f;
            line(x, y - saucerHeight, x - halfBugWidth, y);
            line(x, y - saucerHeight, x + halfBugWidth, y);
            // line(x - halfBugWidth, y, x - halfBugWidth, y);
            line(x - halfBugWidth, y, x + halfBugWidth, y);
            float feet = bugWidth * 0.1f;
            line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
            line(x + feet, y, x + halfBugWidth, y + halfBugWidth);
    
            feet = bugWidth * 0.3f;
            line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
            line(x + feet, y, x + halfBugWidth, y + halfBugWidth);
    
            float eyes = bugWidth * 0.1f;
            line(x - eyes, y - eyes, x - eyes, y - eyes * 2f);
            line(x + eyes, y - eyes, x + eyes, y - eyes * 2f);
    
        }
    
       
    
        void moveBug() {
            if ((frameCount % 30) == 0) {
                bugX += random(-5, 5);
                if (bugX < halfBugWidth) {
                    bugX = halfBugWidth;
                }
                if (bugX > width - halfBugWidth) {
                    bugX = width - halfBugWidth;
                }
                bugY += 2;
            }
        }
    
        int gameMode = 0;
    
        public void draw() {
            background(0);
            fill(255);
            
    }
    
	public void draw() {
		background(0);
		fill(255);
		noStroke();
    }
}
