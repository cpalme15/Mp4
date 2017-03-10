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
	static JTextField tf_Answer = null;
	public JTextField ptcount=null;
	public JTextField questionnum=null;
	public int qnum=0;
	public int pt=0;
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
	private static int count=0;
	static Trivia [] tset=new Trivia[5];
	static boolean btnclicked=false;
	CardLayout cardLayout =null;
    JPanel cards; //a panel that uses CardLayout
	public Panel(){
		super();
        //Create the "cards".
		cards=new JPanel();
		tf_Answer=new JTextField(20);
		north=new JPanel();
		north.setLayout(new BorderLayout());
		north.setLayout(new BorderLayout());
		ptcount=new JTextField(8);
		questionnum=new JTextField(5);
		ptcount.setText("Points:"+pt);
		questionnum.setText("Q# "+qnum);
		t1=new Trivia("Who was the first president of the USA?","george washington",1);
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
		Font longquesFont=j1.getFont().deriveFont(Font.PLAIN,25f);
		Font numFont=j1.getFont().deriveFont(Font.PLAIN,23f);
		ptcount.setBackground(Color.LIGHT_GRAY);
		questionnum.setBackground(Color.lightGray);
	    ptcount.setFont(numFont);
	    questionnum.setFont(numFont);
		j1.setFont(quesFont);
		j2.setFont(quesFont);
		j3.setFont(longquesFont);
		j4.setFont(quesFont);
		j5.setFont(quesFont);
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
		tset[0]=t1;
		tset[1]=t2;
		tset[2]=t3;
		tset[3]=t4;
		tset[4]=t5;
		
		btn = new JButton("Submit Answer");
		btn.setFont(quesFont);
		btn.addActionListener(this); // If the button is clicked, the action performed is in this panel.
		tf_Answer.setFont(quesFont);
		this.addMouseListener(new myHelper());
		this.setFocusable(true);
		this.setLayout(new BorderLayout());
		this.add(btn, BorderLayout.SOUTH);
		this.add(north,BorderLayout.NORTH);
		this.add(tf_Answer, BorderLayout.CENTER);
		north.add(cards,BorderLayout.CENTER);
		north.add(ptcount,BorderLayout.WEST);
		north.add(questionnum,BorderLayout.EAST);
		cards.add(card1,"Card1");
		cards.add(card2,"Card2");
		cards.add(card3,"Card3");
		cards.add(card4,"Card4");
		cards.add(card5,"Card5");
		 cardLayout = (CardLayout) cards.getLayout();
		
	}

	public static String getText()
	{
		String x=tf_Answer.getText();
		return x;
	}
	public static void setcount()
	{
		 count++;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			String x=e.getActionCommand();
			switch(x)
			{
			case "Submit Answer": 
				getText(); 
				btnclicked=true ;
				Trivia.Checkanswer(); 
				switchques();
				break;
			}
		
		
	}
	public void switchques()
	{
		if(Trivia.rightanswer==true)
		{
			pt++;
			cardLayout.next(cards);
			qnum++;
			tf_Answer.setText("");
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