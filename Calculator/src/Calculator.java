
/*import java.awt.*;
import javax.swing.*;
public class Calculator extends JFrame {
   
   private JPanel panel;
   private JPanel panel1;
   private JPanel panel2;
   private JTextField tField;
   private JButton[] buttons1;
   private JButton[] buttons2;
   private String[] labels1 = {
         "", "lnv", "ln", "(", ")",
         "lnt", "sinh", "sin", "x^2", "n!",
         "dms", "cosh", "cos", "x^y", "y√x",
         "ㅠ", "tanh","tan", "x^3", "3√x",
         "F-E", "Exp", "Mod", "log", "10^x"
   };
   private String[] labels2 = {
         "MC", "MR", "MS", "M+", "M-",
         "CE", "C", "←", "±", "√",
         "7", "8", "9", "/", "%",
         "4", "5", "6", "*", "1/x",
         "1", "2", "3", "-", "=",
         "0", ".", "+"};
   
   public Calculator() {
      panel = new JPanel();
      panel1 = new JPanel();
      panel2 = new JPanel();
      tField = new JTextField(35);
      tField.setText("0.");
      tField.setEnabled(false);
      
      panel1.setLayout(new GridLayout(6, 5, 3, 3));
      buttons1 = new JButton[25];
      int index1 = 0;
      for(int rows = 0; rows < 5; rows++) {
         for (int cols= 0; cols < 5; cols++) {
            buttons1[index1] = new JButton(labels1[index1]);
            panel1.add(buttons1[index1]);
            index1++;
         }
      }
      
      panel2.setLayout(new GridLayout(6, 5, 3, 3));
      buttons2 = new JButton[28];
      for(int r = 0; r < 28; r++) {
         buttons2[r] = new JButton(labels2[r]);
         panel2.add(buttons2[r]);
      }
      //super.setLayout(new BorderLayout(0,3));
      add(tField, BorderLayout.NORTH);
      panel.setLayout(new BorderLayout(0,3));
      panel.add(panel1,BorderLayout.WEST);
      panel.add(panel2,BorderLayout.EAST);
      add(panel, BorderLayout.AFTER_LAST_LINE);
      setVisible(true);
      pack();
   }

   public static void main(String args[]) {
      Calculator s = new Calculator();
   }
}
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField tField;
	private JButton[] buttons1;
	private JButton[] buttons2;
	private String[] labels1 = { "", "lnv", "ln", "(", ")", "Int", "sinh", "sin", "x^2", "n!", "dms", "cosh", "cos",
			"x^y", "y√x", "∏", "tanh", "tan", "x^3", "3√x", "F-E", "Exp", "Mod", "log", "10^x", };

	private String[] labels2 = { "MC", "MR", "MS", "M+", "M-", "←", "CE", "C", "±", "√", "7", "8", "9", "/", "%", "4",
			"5", "6", "*", "1/x", "1", "2", "3", "-", "=", "0", ".", "+", };

	public Calculator() {
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tField = new JTextField(35);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		tField.setText("0.");
		tField.setEnabled(false);

		panel1.setLayout(new GridLayout(6, 5, 3, 3));
		panel2.setLayout(new GridLayout(0, 5, 3, 3));

		buttons1 = new JButton[25];
		buttons2 = new JButton[28];

		int index = 0;

		for (int rows = 0; rows < 5; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				buttons1[index] = new JButton(labels1[index]);
				panel1.add(buttons1[index]);
				index++;
			}
		}

		index = 0;

		for (int rows = 0; rows < 6; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				buttons2[index] = new JButton(labels2[index]);
				panel2.add(buttons2[index]);
				index++;
				
				if(index == 28) 
					break;
			}
		}
		this.setLayout(new BorderLayout(0,3));
		add(tField,BorderLayout.NORTH);
		panel3.setLayout(new GridLayout(0,2,3,0));
		panel3.add(panel1);
		panel3.add(panel2);
		add(panel3,BorderLayout.SOUTH);
		setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
	}

}*/

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
   private JPanel panel;
   private JPanel panel1;
   private JPanel panel2;
   private JTextField tField;
   private JButton[] buttons1;
   private JButton[] buttons2;
   private String[] labels1= {
         "","lnv","ln","(",")",
         "lnt","sinh","sin","x^2","n!",
         "dms","cosh","cos","x^y","y√x",
         "π","tanh","tan","x^3","3√x",
         "F-E","Exp","Mod","log","10^x",
   };
   private String[] labels2= {
         "MC","MR","MS","M+","M-",
         "←","CE","C","±","√",
         "7","8","9","/","%",
         "4","5","6","*","1/x",
         "1","2","3","-","=",
         "0",".","+",
   };
   
   public Calculator() {
      setTitle("계산기");
      tField=new JTextField(35);
      panel=new JPanel();
      panel1=new JPanel();
      panel2=new JPanel();
      tField.setText("0");
      tField.setEnabled(false);
      panel.setLayout(new GridLayout(0,2,3,3));
      panel1.setLayout(new GridLayout(6,5,3,3));
      panel2.setLayout(new GridLayout(0,5,3,3));
      buttons1=new JButton[25];
      buttons2=new JButton[28];
      int index1=0;
      for(int rows=0;rows<5;rows++) {
         for(int cols=0;cols<5;cols++) {
            buttons1[index1]=new JButton(labels1[index1]);
            panel1.add(buttons1[index1]);
            index1++;
         }
         
      }
      int index2=0;
      for(int rows=0;rows<6;rows++) {
         for(int cols=0;cols<5;cols++) {
            buttons2[index2]=new JButton(labels2[index2]);
            panel2.add(buttons2[index2]);
            index2++;
            if(index2==28)break;
         }
         
      }
      this.setLayout(new BorderLayout(0,2));
      add(tField,BorderLayout.NORTH);
      add(panel,BorderLayout.CENTER);
      panel.add(panel1);
      panel.add(panel2);

      setVisible(true);
      pack();
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Calculator s=new Calculator();
   }

}