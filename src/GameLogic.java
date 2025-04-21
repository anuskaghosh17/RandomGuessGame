public class GameLogic {
    private int numberOfTries;
    private RandomNumberGenerator rng;

    public GameLogic(RandomNumberGenerator rng) {
        this.rng = rng;
        this.rng.generateNumber();
        this.numberOfTries = 0;
    }

    public String checkGuess(int guess) {
        numberOfTries++;
        int target = rng.getNumberToGuess();

        if (guess < target) {
            return "Too low! Try again.";
        } else if (guess > target) {
            return "Too high! Try again.";
        } else {
            return "Correct! Tries: " + numberOfTries;
        }
    }

    public void resetGame() {
        rng.generateNumber();
        numberOfTries = 0;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }
}

