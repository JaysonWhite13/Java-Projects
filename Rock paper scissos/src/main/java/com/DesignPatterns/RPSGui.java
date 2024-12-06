package com.DesignPatterns;

//frontend
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPSGui extends JFrame implements ActionListener{

    JButton rockButton , paperButton , scissorButton;

    //will display the choices of the computer
    JLabel computerChoice;

    //will display the score of the computer and the computer
    JLabel computerScoreLabel, playerScoreLabel;

    //backend obj
    RPS rps;

    public RPSGui() {
        //invoke jframe constructor and add title to the GUI
        super("Rock, Papers, Scissors Game");

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the GUI window
        setSize(480, 580);

        //load the GUI in the center of the screen every time we run the application
        setLocationRelativeTo(null);
        //set layout to null to disable layout management, so that we can use absolute positioning for the elements
        //(i.e. setting x,y coordinates ad width and height values)
        setLayout(null);

        //initialise the backend obj
        rps = new RPS();

        //add GUI components
        addGuiComponent();
    }

    private void addGuiComponent() {
        //create computer Score label
        computerScoreLabel = new JLabel("Computer Score: 0");
        //set x,y coordinates and width/height values
        computerScoreLabel.setBounds(   0, 43, 450, 30);
        //set font style and size for the label
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));
        //place the text on the center
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //add the label to the GUI window
        add(computerScoreLabel);

        //create the computer choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 118, 81);
        computerChoice.setFont(new Font("Dialog",  Font.PLAIN,18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        //Create a black border around
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //add the label to the GUI window
        add(computerChoice);


        // create player Score label
        playerScoreLabel = new JLabel("Player Score: 0");
        //set x,y coordinates and width/height values
        playerScoreLabel.setBounds(   0, 317, 450, 30);
        //set font style and size for the label
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));
        //place the text on the center
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //add the label to the GUI window
        add(playerScoreLabel);


        //player buttons

        //rock buttons
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.BOLD,18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paper buttons
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.BOLD,18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissor buttons
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(290, 387, 105 , 81);
        scissorButton.setFont(new Font("Dialog", Font.BOLD,18));
        scissorButton.addActionListener(this);
        add(scissorButton);

    }

    //display a message dialog which will show the winner and a try again button
    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this,"Result", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        //message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.setBounds(50, 60, 127, 35);
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //reset computer choice
                computerChoice.setText("?");

                //close the dialog box
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get player choice
        String playerChoice = e.getSource().toString();

        //play rock paper scissor and  store result into string variable
        String result = rps.playRPS(playerChoice);

        //load computer's choice
        computerChoice.setText(rps.getComputerChoice());

        //update the score
        computerScoreLabel.setText("computer: " + rps.getComputerScore());
        playerScoreLabel.setText("Player: " + rps.getPlayerScore());

        //display the result
        showDialog(result);
    }
}
