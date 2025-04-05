package tp3exo4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Controller implements ActionListener{
	Random rand=new Random();
	View view;
	
	
	public Controller(View view)
	{
		this.view=view;
		for(int i=0;i<9;i++)
		{
			view.botona[i].addActionListener(this);
		}
		view.replayButton.addActionListener(this);
		firstTurn();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == view.replayButton) {
		    resetGame();
		    return;
		}

		for(int i=0;i<9;i++)
		{
			if(e.getSource()==view.botona[i])
			{
				if(view.player1==true)
				{
					if(view.botona[i].getText()=="")
					{
						view.botona[i].setForeground(new Color(255,0,0));
						view.botona[i].setText("X");
						view.player1=false;
						view.textField.setText("O turn");
						checkWinner();
						
					}
				}
				
				else {
					if(view.botona[i].getText()=="")
					{
						view.botona[i].setForeground(new Color(0,0,255));
						view.botona[i].setText("O");
						view.player1=true;
						view.textField.setText("X turn");
						checkWinner();
						
					}
					
				}
			}
		}
		
	}
	
	
	
	public static void main(String [] args)
	{
		View view=new View();
		new Controller(view);
	}
	
	public void checkWinner() {
	    // X WIN
	    if (view.botona[0].getText().equals("X") && view.botona[1].getText().equals("X") && view.botona[2].getText().equals("X")) {
	        xWin(0, 1, 2);
	    }
	    if (view.botona[3].getText().equals("X") && view.botona[4].getText().equals("X") && view.botona[5].getText().equals("X")) {
	        xWin(3, 4, 5);
	    }
	    if (view.botona[6].getText().equals("X") && view.botona[7].getText().equals("X") && view.botona[8].getText().equals("X")) {
	        xWin(6, 7, 8);
	    }
	    if (view.botona[0].getText().equals("X") && view.botona[3].getText().equals("X") && view.botona[6].getText().equals("X")) {
	        xWin(0, 3, 6);
	    }
	    if (view.botona[1].getText().equals("X") && view.botona[4].getText().equals("X") && view.botona[7].getText().equals("X")) {
	        xWin(1, 4, 7);
	    }
	    if (view.botona[2].getText().equals("X") && view.botona[5].getText().equals("X") && view.botona[8].getText().equals("X")) {
	        xWin(2, 5, 8);
	    }
	    if (view.botona[0].getText().equals("X") && view.botona[4].getText().equals("X") && view.botona[8].getText().equals("X")) {
	        xWin(0, 4, 8);
	    }
	    if (view.botona[2].getText().equals("X") && view.botona[4].getText().equals("X") && view.botona[6].getText().equals("X")) {
	        xWin(2, 4, 6);
	    }

	    // O WIN
	    if (view.botona[0].getText().equals("O") && view.botona[1].getText().equals("O") && view.botona[2].getText().equals("O")) {
	        oWin(0, 1, 2);
	    }
	    if (view.botona[3].getText().equals("O") && view.botona[4].getText().equals("O") && view.botona[5].getText().equals("O")) {
	        oWin(3, 4, 5);
	    }
	    if (view.botona[6].getText().equals("O") && view.botona[7].getText().equals("O") && view.botona[8].getText().equals("O")) {
	        oWin(6, 7, 8);
	    }
	    if (view.botona[0].getText().equals("O") && view.botona[3].getText().equals("O") && view.botona[6].getText().equals("O")) {
	        oWin(0, 3, 6);
	    }
	    if (view.botona[1].getText().equals("O") && view.botona[4].getText().equals("O") && view.botona[7].getText().equals("O")) {
	        oWin(1, 4, 7);
	    }
	    if (view.botona[2].getText().equals("O") && view.botona[5].getText().equals("O") && view.botona[8].getText().equals("O")) {
	        oWin(2, 5, 8);
	    }
	    if (view.botona[0].getText().equals("O") && view.botona[4].getText().equals("O") && view.botona[8].getText().equals("O")) {
	        oWin(0, 4, 8);
	    }
	    if (view.botona[2].getText().equals("O") && view.botona[4].getText().equals("O") && view.botona[6].getText().equals("O")) {
	        oWin(2, 4, 6);
	    }
	}

	
	public void firstTurn()
	{
		if(rand.nextInt(2)==0)
		{
			view.textField.setText("X turn");
			view.player1=true;
		}
		else {
			view.textField.setText("O turn");
			view.player1=false;
		}
		
	}
	
	public void xWin(int a,int b,int c)
	{
		view.botona[a].setBackground(Color.green);
		view.botona[b].setBackground(Color.green);
		view.botona[c].setBackground(Color.green);
		for(int i=0;i<9;i++)
		{
			view.botona[i].setEnabled(false);
		}
		view.textField.setText("X win");
	}
	
	public void oWin(int a,int b,int c)
	{
		view.botona[a].setBackground(Color.green);
		view.botona[b].setBackground(Color.green);
		view.botona[c].setBackground(Color.green);
		for(int i=0;i<9;i++)
		{
			view.botona[i].setEnabled(false);
		}
		view.textField.setText("O win");
	}
	
	public void resetGame() {
	    for (int i = 0; i < 9; i++) {
	        view.botona[i].setText("");
	        view.botona[i].setEnabled(true);
	        view.botona[i].setBackground(null);
	    }
	    firstTurn();
	}

	
	
	
	

}
