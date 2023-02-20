package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{


    Minim minim;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;
    
	public void settings()
	{
		size(500, 500);
	}


    int frameSize = 1024;

	public void setup() {
		colorMode(HSB);
		background(0);



        minim = new Minim(this);

        ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
        ab = ai.mix;



		smooth();
		
	}


	public void draw()
	{	
        background(0);
        stroke(255);

        float half = height/2;
        float cgap = 255 / (float)ab.size();
        float sum = 0;
    
        for(int i = 0; i < ab.size(); i++)
        {
            sum += abs(ab.get(i));
            stroke(cgap * i,255, 255);
            line(i, half, i, half + ab.get(i) * half );
        }

        float avgAmplitude = sum / (float)ab.size();
        noStroke();
        fill(255);
        ellipse(width/2, half, avgAmplitude * 500, avgAmplitude * 500);

       
    
	}
}

