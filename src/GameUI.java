import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameUI extends JFrame implements ActionListener {
    private JTextField guessField;
    private JButton guessButton;
    private JLabel messageLabel;

    private GameLogic gameLogic;

    public GameUI() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        gameLogic = new GameLogic(rng);

        setTitle("Number Guessing Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100", JLabel.CENTER);
        add(instructionLabel);

        guessField = new JTextField();
        add(guessField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        add(guessButton);

        messageLabel = new JLabel("Good luck!", JLabel.CENTER);
        add(messageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(guessField.getText());
            String result = gameLogic.checkGuess(guess);
            messageLabel.setText(result);

            if (result.startsWith("Correct!")) {
                int option = JOptionPane.showConfirmDialog(this,
                        "Correct! You guessed in " + gameLogic.getNumberOfTries() + " tries.\nPlay again?",
                        "Game Over", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    gameLogic.resetGame();
                    guessField.setText("");
                    messageLabel.setText("Good luck!");
                } else {
                    System.exit(0);
                }
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number.");
        }
    }
}

