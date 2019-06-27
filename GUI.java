import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
	public int a;
	public int b;
	
	private JButton button = new JButton("Press");
	private JTextField input1 = new JTextField("", 5);
	private JTextField input2 = new JTextField("", 5);
	private JLabel label1 = new JLabel("in:");
	private JLabel label2 = new JLabel("out:");
	
	public int geta() {
		return a;
	     
	  }

	  public int getb() {
	     return b;
	  }

	public GUI() {
		super("Pocket");
		this.setBounds(200, 200, 250, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container1 = this.getContentPane();
		container1.setLayout(new GridLayout(5, 2, 2, 2));
		container1.add(label1);
		container1.add(input1);

		Container container2 = this.getContentPane();
		container2.setLayout(new GridLayout(5, 5, 2, 2));
		container2.add(label2);
		container2.add(input2);

		button.addActionListener(new ButtonEventListener());
		container1.add(button);
		container2.add(button);
		
	}

	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int z = 0;
			String x = input1.getText();
			String y = input2.getText();
			if (x.equals("")) {
				a = 0;
			} else {
				a = Integer.parseInt(input1.getText());
			}
			if (y.equals("")) {
				b = 0;
			} else {
				b = Integer.parseInt(input2.getText());
			}
			z = a - b;
			String message = "";
			//message += "in is " + input1.getText() + "\n";
			//message += "out is " + input2.getText() + "\n";
			message += "you have " + z;

			JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
