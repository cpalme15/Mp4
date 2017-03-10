import java.io.*;
import java.util.*;

public class Trivia extends Panel implements Serializable
{
	private String question;
	private String answer;
	private int points;
	
	
	public Trivia()
	{
		
	question="?";
	answer="";
	points=0;
		
}

	public Trivia(String x, String y, int z)
	{
		this.question = x;
		this.answer = y;
		this.points = z;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	public int getPoints()
	{
		return points;
	}
	public void setPoints(int points) 
	{
		this.points = points;
	}

	public String toString(Trivia t) 
	{
		return "Question= " + t.getQuestion() + "\nAnswer=" + t.getAnswer() + "\nPoints=" + t.getPoints() ;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + points;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trivia other = (Trivia) obj;
		if (answer == null) 
		{
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (points != other.points)
			return false;
		if (question == null) 
		{
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	public boolean Checkanswer()
	{
		if(btnclicked==true)
		{
			if(tf_Answer.getText()==tset[0].getAnswer()||tf_Answer.getText()==tset[1].getAnswer()||
					tf_Answer.getText()==tset[2].getAnswer()||tf_Answer.getText()==tset[3].getAnswer()||
					tf_Answer.getText()==tset[4].getAnswer())
			{
				System.out.println(true);
				setcount();
				return true;
				
			}
			else return false;
			
		}
	
		else return false;
	}

	public int calcPoints()
	{
		int total = 0;

		return total;
	}

}