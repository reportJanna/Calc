package gui;
import javax.swing.*;

import src.Calc;
import src.Parser;

import java.awt.GridLayout;
import java.awt.event.*;

/**
 * builds the User Interface 
 */
public class GUI implements ActionListener{
    private JButton clearButton;
    private JButton plusSign, minusSign, multiplySign, divideSign, solveSign
    , moduloSign, openBracket, closeBracket;
    private JButton num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, dot;
    private JLabel display;
    private JTextField inputs;
    private JFrame frame;
    private JPanel buttonPanel, outputPanel, mainPanel;

    private Parser parser;
    private Calc calc;

    private String displayString;


    /**
     * creates the default version of the GUI and instantiates it
     */
    public GUI(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel(new GridLayout(2,1));
    
        parser = new Parser();
        calc = new Calc();
        
        outputPanel = new JPanel(new GridLayout(2,1));
        displayString = "0";
        display = new JLabel(displayString);
        inputs = new JTextField("");
        inputs.addActionListener(new SolveActionListener());
        outputPanel.add(inputs);
        outputPanel.add(display);
        mainPanel.add(outputPanel);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,4));

        addButton(buttonPanel, clearButton = new JButton("CE"));
        addButton(buttonPanel, openBracket = new JButton("("));
        addButton(buttonPanel, closeBracket = new JButton(")"));
        addButton(buttonPanel, moduloSign = new JButton("%"));

        addButton(buttonPanel, num7 = new JButton("7"));
        addButton(buttonPanel, num8 = new JButton("8"));
        addButton(buttonPanel, num9 = new JButton("9"));
        addButton(buttonPanel, divideSign = new JButton("DIV"));
        
        addButton(buttonPanel, num4 = new JButton("4"));
        addButton(buttonPanel, num5 = new JButton("5"));
        addButton(buttonPanel, num6 = new JButton("6"));
        addButton(buttonPanel, multiplySign = new JButton("MUL"));

        addButton(buttonPanel, num1 = new JButton("1"));
        addButton(buttonPanel, num2 = new JButton("2"));
        addButton(buttonPanel, num3 = new JButton("3"));
        addButton(buttonPanel, minusSign = new JButton("MIN"));
        
        addButton(buttonPanel, dot = new JButton("DOT"));
        addButton(buttonPanel, num0 = new JButton("0"));
        solveSign = new JButton("=");
        solveSign.addActionListener(new SolveActionListener());
        buttonPanel.add(solveSign);
        addButton(buttonPanel, plusSign = new JButton("PLUS"));

        mainPanel.add(buttonPanel);

        frame.add(mainPanel);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * quick function to add a button to a panel
     * @param panel the panel to add to
     * @param button the button that will be added
     */
    private void addButton(JPanel panel, JButton button){
        button.addActionListener(this);
        panel.add(button);
    }

    /**
     * action events for the buttons, also updates the inputs display on each input
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == num0){
            inputs.setText(inputs.getText() + "0");
        }
        if (e.getSource() == num1){
            inputs.setText(inputs.getText() + "1");
        }
        if (e.getSource() == num2){
            inputs.setText(inputs.getText() + "2");
        }
        if (e.getSource() == num3){
            inputs.setText(inputs.getText() + "3");
        }
        if (e.getSource() == num4){
            inputs.setText(inputs.getText() + "4");
        }
        if (e.getSource() == num5){
            inputs.setText(inputs.getText() + "5");
        }
        if (e.getSource() == num6){
            inputs.setText(inputs.getText() + "6");
        }
        if (e.getSource() == num7){
            inputs.setText(inputs.getText() + "7");
        }
        if (e.getSource() == num8){
            inputs.setText(inputs.getText() + "8");
        }
        if (e.getSource() == num9){
            inputs.setText(inputs.getText() + "9");
        }
        if (e.getSource() == dot){
            inputs.setText(inputs.getText() + ".");
        }
        if (e.getSource() == multiplySign){
            inputs.setText(inputs.getText() + "*");
        }
        if (e.getSource() == divideSign){
            inputs.setText(inputs.getText() + "/");
        }
        if (e.getSource() == plusSign){
            inputs.setText(inputs.getText() + "+");
        }
        if (e.getSource() == minusSign){
            inputs.setText(inputs.getText() + "-");
        }
        if (e.getSource() == moduloSign){
            inputs.setText(inputs.getText() + "%");
        }
        if (e.getSource() == openBracket){
            inputs.setText(inputs.getText() + "(");
        }
        if (e.getSource() == closeBracket){
            inputs.setText(inputs.getText() + ")");
        }
        // clears inputString
        if (e.getSource() == clearButton){
            inputs.setText("");
        }
    }
    /**
     * class that handles the ActionEvent when a calc.calculate call has to be done
     */
    private class SolveActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            double res = calc.calculate(parser.createTokenList(inputs.getText()));
            display.setText(res + "");
        }
        
    }
}
