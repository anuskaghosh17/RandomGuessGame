import java.util.Random;

public class RandomNumberGenerator {
    private int numberToGuess;

    public void generateNumber() {
        Random rand = new Random();
        numberToGuess = rand.nextInt(100) + 1;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }
}
