package Postfix_Calculator;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.security.DigestException;
import java.util.*;

public class CalcuGUI extends JFrame {
  /**
  	 *
  	 */
  private static final long serialVersionUID = -8318925639232821017L;
  private GridBagConstraints constraints;
  private JButton button[];
  private JTextField area;
  private String STRarea;
  private String str, pa;
  private int length;

  public void setAreaText(String f) {
    area.setText(f);
  }

  public CalcuGUI() {
    setIconImage(new ImageIcon("Postfix_Calculator/images/icon.png").getImage());
    setSize(350, 375);
    setTitle("Postfix Calculator");

    ImageIcon buttonGRAY = new ImageIcon("Postfix_Calculator/images/gray.png");
    ImageIcon buttonRED = new ImageIcon("Postfix_Calculator/images/red.png");
    ImageIcon buttonBLACK = new ImageIcon("Postfix_Calculator/images/black.png");
    ImageIcon buttonSPACE = new ImageIcon("Postfix_Calculator/images/black1.png");
    Font font = new Font("Arial", Font.BOLD, 20);
    Font font1 = new Font("Arial", Font.BOLD, 25);

    constraints = new GridBagConstraints();
    button = new JButton[20];
    area = new JTextField(15);
    area.setFont(font1);
    area.setEditable(false);
    area.setForeground(Color.black);
    area.setBackground(Color.white);
    area.setText("");

    button[0] = new JButton("7");
    button[1] = new JButton("8");
    button[2] = new JButton("9");
    button[3] = new JButton("4");
    button[4] = new JButton("5");
    button[5] = new JButton("6");
    button[6] = new JButton("1");
    button[7] = new JButton("2");
    button[8] = new JButton("3");
    button[9] = new JButton("0");
    button[11] = new JButton("SPACE");
    button[12] = new JButton("AC");
    button[13] = new JButton("DEL");
    button[14] = new JButton("+");
    button[15] = new JButton("-");
    button[16] = new JButton("x");
    button[17] = new JButton("/");
    button[18] = new JButton("=");

    Container ner = getContentPane();
    ner.setLayout(new FlowLayout());

    JPanel panel = new JPanel();
    BorderLayout bord = new BorderLayout();
    panel.setLayout(bord);
    ner.add(panel);
    panel.setBorder(new MatteBorder(27, 10, 10, 10, Color.CYAN));

    CalcuHandler handler = new CalcuHandler();

    JPanel panel1 = new JPanel();
    FlowLayout flow = new FlowLayout();
    panel1.setLayout(flow);
    panel.add(panel1, "North");
    panel1.add(area);

    JPanel panel2 = new JPanel();
    BorderLayout bord1 = new BorderLayout();
    panel2.setLayout(bord1);
    panel2.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.add(panel2, "Center");

    JPanel panel4 = new JPanel();
    GridBagLayout grid = new GridBagLayout();
    panel4.setLayout(grid);
    panel2.add(panel4, "Center");

    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        constraints.gridy = i;
        constraints.gridx = j;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        grid.setConstraints(button[count], constraints);
        button[count].setFont(font);
        button[count].setVerticalTextPosition(SwingConstants.CENTER);
        button[count].setHorizontalTextPosition(SwingConstants.CENTER);
        button[count].setPreferredSize(new Dimension(45, 35));
        button[count].setIcon(buttonBLACK);
        button[count].setForeground(Color.white);
        panel4.add(button[count]);
        button[count].addActionListener(handler);
        count++;
      }
    }

    JPanel Spanel = new JPanel();
    Spanel.setLayout(new BorderLayout());
    panel2.add(Spanel, "South");

    JPanel Spanel1 = new JPanel();
    GridBagLayout grid1 = new GridBagLayout();
    Spanel1.setLayout(grid1);
    Spanel.add(Spanel1, "North");

    constraints.gridy = 0;
    constraints.gridx = 0;
    constraints.gridheight = 1;
    constraints.insets = new Insets(5, 5, 5, 5);
    grid1.setConstraints(button[9], constraints);
    button[9].setFont(font);
    button[9].setVerticalTextPosition(SwingConstants.CENTER);
    button[9].setHorizontalTextPosition(SwingConstants.CENTER);
    button[9].setPreferredSize(new Dimension(158, 35));
    button[9].setIcon(buttonSPACE);
    button[9].setForeground(Color.white);
    Spanel1.add(button[9]);
    button[9].addActionListener(handler);

    constraints.gridy = 0;
    constraints.gridx = 2;
    constraints.gridheight = 1;
    constraints.insets = new Insets(5, 5, 5, 5);
    grid1.setConstraints(button[16], constraints);
    button[16].setFont(font);
    button[16].setVerticalTextPosition(SwingConstants.CENTER);
    button[16].setHorizontalTextPosition(SwingConstants.CENTER);
    button[16].setPreferredSize(new Dimension(50, 35));
    button[16].setIcon(buttonGRAY);
    button[16].setForeground(Color.white);
    Spanel1.add(button[16]);
    button[16].addActionListener(handler);

    constraints.gridy = 0;
    constraints.gridx = 3;
    constraints.gridheight = 1;
    constraints.insets = new Insets(5, 5, 5, 5);
    grid1.setConstraints(button[17], constraints);
    button[17].setFont(font);
    button[17].setVerticalTextPosition(SwingConstants.CENTER);
    button[17].setHorizontalTextPosition(SwingConstants.CENTER);
    button[17].setPreferredSize(new Dimension(50, 35));
    button[17].setIcon(buttonGRAY);
    button[17].setForeground(Color.white);
    Spanel1.add(button[17]);
    button[17].addActionListener(handler);

    JPanel Spanel2 = new JPanel();
    GridBagLayout grid2 = new GridBagLayout();
    Spanel2.setLayout(grid2);
    Spanel.add(Spanel2, "Center");

    constraints.gridy = 0;
    constraints.gridx = 0;
    constraints.gridheight = 1;
    constraints.insets = new Insets(5, 5, 5, 5);
    grid2.setConstraints(button[11], constraints);
    button[11].setFont(font);
    button[11].setVerticalTextPosition(SwingConstants.CENTER);
    button[11].setHorizontalTextPosition(SwingConstants.CENTER);
    button[11].setPreferredSize(new Dimension(158, 35));
    button[11].setIcon(buttonSPACE);
    button[11].setForeground(Color.white);
    Spanel2.add(button[11]);
    button[11].addActionListener(handler);

    constraints.gridy = 0;
    constraints.gridx = 1;
    constraints.gridheight = 1;
    constraints.insets = new Insets(5, 5, 5, 5);
    grid2.setConstraints(button[18], constraints);
    button[18].setFont(font);
    button[18].setVerticalTextPosition(SwingConstants.CENTER);
    button[18].setHorizontalTextPosition(SwingConstants.CENTER);
    button[18].setPreferredSize(new Dimension(111, 35));
    button[18].setIcon(buttonGRAY);
    button[18].setForeground(Color.white);
    Spanel2.add(button[18]);
    button[18].addActionListener(handler);

    JPanel Epanel = new JPanel();
    Epanel.setLayout(new BorderLayout());
    panel2.add(Epanel, "East");

    JPanel Epanel1 = new JPanel();
    GridBagLayout grid3 = new GridBagLayout();
    Epanel1.setLayout(grid3);
    Epanel.add(Epanel1, "North");

    int count1 = 12;
    for (int i = 0; i < 2; i++) {
      constraints.gridy = i;
      constraints.gridx = 3;
      constraints.gridheight = 1;
      constraints.insets = new Insets(5, 5, 5, 5);
      grid3.setConstraints(button[count1], constraints);
      button[count1].setFont(font);
      button[count1].setVerticalTextPosition(SwingConstants.CENTER);
      button[count1].setHorizontalTextPosition(SwingConstants.CENTER);
      button[count1].setPreferredSize(new Dimension(112, 35));
      button[count1].setIcon(buttonRED);
      button[count1].setForeground(Color.white);
      Epanel1.add(button[count1]);
      button[count1].addActionListener(handler);
      count1++;
    }

    JPanel Epanel2 = new JPanel();
    GridBagLayout grid4 = new GridBagLayout();
    Epanel2.setLayout(grid4);
    Epanel.add(Epanel2, "Center");

    int count2 = 14;
    for (int i = 0; i < 1; i++) {
      for (int j = 0; j < 2; j++) {
        constraints.gridy = i;
        constraints.gridx = j;
        constraints.gridheight = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        grid4.setConstraints(button[count2], constraints);
        button[count2].setFont(font);
        button[count2].setVerticalTextPosition(SwingConstants.CENTER);
        button[count2].setHorizontalTextPosition(SwingConstants.CENTER);
        button[count2].setPreferredSize(new Dimension(50, 35));
        button[count2].setIcon(buttonGRAY);
        button[count2].setForeground(Color.white);
        Epanel2.add(button[count2]);
        button[count2].addActionListener(handler);
        count2++;
      }
    }

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  class CalcuHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {

      String action = e.getActionCommand();

      if (action == "1") {
        str = area.getText();
        area.setText(str + "1");
      } else if (action == "2") {
        str = area.getText();
        area.setText(str + "2");
      } else if (action == "3") {
        str = area.getText();
        area.setText(str + "3");
      } else if (action == "4") {
        str = area.getText();
        area.setText(str + "4");
      } else if (action == "5") {
        str = area.getText();
        area.setText(str + "5");
      } else if (action == "6") {
        str = area.getText();
        area.setText(str + "6");
      } else if (action == "7") {
        str = area.getText();
        area.setText(str + "7");
      } else if (action == "8") {
        str = area.getText();
        area.setText(str + "8");
      } else if (action == "9") {
        str = area.getText();
        area.setText(str + "9");
      } else if (action == "0") {
        str = area.getText();
        area.setText(str + "0");
      } else if (action == "AC") {
        area.setText("");
      } else if (action == "SPACE") {
        str = area.getText();
        area.setText(str + " ");
      } else if (action == "DEL") {
        str = area.getText().substring(0, area.getText().length() - 1);
        area.setText(str);
      } else if (action == "+") {
        str = area.getText();
        area.setText(str + "+");
      } else if (action == "-") {
        str = area.getText();
        area.setText(str + "-");
      } else if (action == "x") {
        str = area.getText();
        area.setText(str + "*");
      } else if (action == "/") {
        str = area.getText();
        area.setText(str + "/");
      } else if (action == ".") {
        str = area.getText();
        area.setText(str + ".");
      } else if (action == "=") {
        String toEval = area.getText().toString();
        length = toEval.length();

        try {
          pa = Integer.toString(toEvaluate(toEval));

        } catch (Exception pi) {
          area.setText("  S Y N T A X   E R R O R");
          pa = area.getText().toString();
          length = 0;
        }
        area.setText(pa);
      }
    }

    public int toEvaluate(String tata) throws IOException, DigestException {
String tok;
int opr;
CalcuSTACK calstck = new CalcuSTACK(100);
StringTokenizer tokenizer = new StringTokenizer(tata);
char curr; 

while (tokenizer.hasMoreTokens()) {
tok = tokenizer.nextToken();

if (tok.length() > 1) {
try{
opr = Integer.parseInt(tok);
calstck.push(new Integer(opr));
}catch (NumberFormatException nfe){
throw new IOException();
}
}
else { 
curr = tok.charAt(0);
if (Character.isDigit(curr)){
calstck.push(new Integer(Character.digit(curr, 10)));
}
else { 
try{
Object rick = calstck.pop();
Object rick1 = calstck.pop();
int qwe = getValue(rick);
int qwo = getValue(rick1);

switch (curr){
	
case '+':
calstck.push(new Integer(qwo + qwe));
break;

case '-':
calstck.push(new Integer(qwo - qwe));
break;

case '*':
calstck.push(new Integer(qwo * qwe));
break;

case '/':
if (qwe == 0) {throw new DigestException();
}
calstck.push(new Integer(qwo / qwe));
break;
default:
throw new IOException();
}
            
}catch (EmptyStackException ese){
throw new IOException();
}
}
           
}
}

int result;
if (!calstck.isEmpty()) {
result = getValue(calstck.pop());
}
else { 
result = 0;
}
if (!calstck.isEmpty()) {
throw new IOException();
}
else {
return result;
}
  }
}

private int getValue(Object temp){
    return((Integer)temp).intValue();
}

public static void main(String[]args){
	
CalcuGUI fred=new CalcuGUI();
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
int w = fred.getSize().width;
int h = fred.getSize().height;
int x = (dim.width-w)/2;
int y = (dim.height-h)/2;
fred.setBounds(x, y, w, h ); 
fred.setResizable(false);
fred.setVisible(true);
}
}