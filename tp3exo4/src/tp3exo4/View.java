package tp3exo4;

import java.awt.*;
import javax.swing.*;

public class View extends JFrame {

    JLabel label;
    JButton[] botona;
    boolean player1;
    JTextField textField;
    JPanel titre, botonaPanel, bottomPanel;
    JButton replayButton;

    public View() {
        setTitle("Tic Tac Toe");
        setSize(600, 650);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        titre = new JPanel(new BorderLayout());
        titre.setPreferredSize(new Dimension(600, 80));

        textField = new JTextField("X turn");
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("SansSerif", Font.BOLD, 22));
        titre.add(textField, BorderLayout.CENTER);

        
        botona = new JButton[9];
        botonaPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            botona[i] = new JButton();
            botona[i].setFont(new Font("SansSerif", Font.BOLD, 40));
            botona[i].setFocusable(false);
            botonaPanel.add(botona[i]);
        }

        
        bottomPanel = new JPanel();
        replayButton = new JButton("Replay");
        replayButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        replayButton.setFocusable(false);
        bottomPanel.add(replayButton);

        
        add(titre, BorderLayout.NORTH);
        add(botonaPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
