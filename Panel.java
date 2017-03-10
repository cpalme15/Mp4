import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Panel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1085549162291721622L;
	private JButton btn = null;
	public JTextField tf_Answer = null;
	private JTextArea ta=null;
	private Font quesFont=null;
	private Trivia t1=null;
	private Trivia t2=null;
	private Trivia t3=null;
	private Trivia t4=null;
	private Trivia t5=null;
	private JLabel j1=null;
	private JLabel j2=null;
	private JLabel j3=null;
	private JLabel j4=null;
	private JLabel j5=null;
	private JPanel north=null;
	private int count=0;
	protected Trivia [] tset=new Trivia[5];
	protected boolean btnclicked=false;
    JPanel cards; //a panel that uses CardLayout
	public Panel(){
		super();
		
        //Create the "cards".
		cards=new JPanel();
		tf_Answer=new JTextField(20);
		north=new JPanel();
		north.setLayout(new BorderLayout());
		t1=new Trivia("Who is the first president of the USA?","george washington",1);
		t2=new Trivia("What is the capital of Morocco?","rabat",3);
		t3=new Trivia("Diana Prince is the public persona of which fictional superhero?","wonder woman",5);
		t4=new Trivia("Who is Bruce Wayne's butler?","alfred pennyworth",3);
		t5=new Trivia("What is the name of Mickey Mouse's Dog?","pluto",4);
		j1=new JLabel(t1.getQuestion());
		j2=new JLabel(t2.getQuestion());
		j3=new JLabel(t3.getQuestion());
		j4=new JLabel(t4.getQuestion());
		j5=new JLabel(t5.getQuestion());
		Font quesFont = j1.getFont().deriveFont(Font.PLAIN, 30f);
	
		
		cards.setLayout(new CardLayout());
        JPanel card1 = new JPanel();
        card1.add(j1);
        JPanel card2 = new JPanel();
        card2.add(j2);
        JPanel card3 = new JPanel();
        card3.add(j3);
        JPanel card4 = new JPanel();
        card4.add(j4);
        JPanel card5 = new JPanel();
        card5.add(j5);
		this.setBackground(Color.darkGray);
		btn = new JButton("Submit Answer");
		btn.setFont(quesFont);
		btn.addActionListener(this); // If the button is clicked, the action performed is in this panel.
		tf_Answer.setFont(quesFont);
		this.addMouseListener(new myHelper());
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		this.add(btn, BorderLayout.SOUTH);
		this.add(tf_Answer, BorderLayout.CENTER);
		this.add(cards,BorderLayout.NORTH);
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		cards.add(card5);
		
	}

	public String getText()
	{
		String x=tf_Answer.getText();
		return x;
	}
	public  void setcount()
	{
		 count++;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Default")){
			String x=e.getActionCommand();
			switch(x)
			{
			case "Submit Answer": getText(); btnclicked=true ;t1.Checkanswer(); break;
			}
		}
		
	}

	private class myHelper extends MouseAdapter{ // useful if you only want one method from mouse listener, can extend
		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}
		
		public void mouseClicked(MouseEvent e){

		}
	}
}