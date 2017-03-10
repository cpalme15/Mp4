import javax.swing.JFrame;

public class Frame extends JFrame{

	public Frame(){
		super("Trivia");
		this.getContentPane().add(new Panel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.setVisible(true);
	}
}