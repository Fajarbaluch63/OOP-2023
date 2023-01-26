package ie.tudublin;

public class cat {
    private int numLives;
    private String name;

    public cat(String name) {
        this.name = name;
        this.numLives = 9;
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    public void kill() {
        if (numLives > 0) {
            numLives--;
            System.out.println("Ouch!");
        } else {
            System.out.println("Dead");
        }
    }
}

class Main {
    public static void main(String[] args) {
        cat ginger = new cat("Ginger");
        while (ginger.getNumLives() > 0) {
            ginger.kill();
        }
    }
}