package Lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JPanel implements ActionListener {

	Stack<Double> operand;
	Stack<String> operator;
	JLabel operandLabel, operatorLabel;
	JTextField operandTextField, operatorTextField, screen;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bAdd, bSub, bMul, bDiv, bRP, bLP, bC, bSR, bPoint;
	int digit = 0;

	public Calculator() {

		operand = new Stack<Double>();
		operator = new Stack<String>();

		setLayout(null);
		screen = new JTextField();
		screen.setEnabled(false);
		screen.setSize(460, 30);
		screen.setLocation(20, 20);
		add(screen);

		operandLabel = new JLabel("Operand stack");
		operandLabel.setSize(120, 20);
		operandLabel.setLocation(20, 100);
		add(operandLabel);

		operandTextField = new JTextField();
		operandTextField.setEnabled(false);
		operandTextField.setSize(300, 25);
		operandTextField.setLocation(150, 100);
		add(operandTextField);

		operatorLabel = new JLabel("Operator stack");
		operatorLabel.setSize(120, 20);
		operatorLabel.setLocation(20, 130);
		add(operatorLabel);

		operatorTextField = new JTextField();
		operatorTextField.setEnabled(false);
		operatorTextField.setSize(300, 25);
		operatorTextField.setLocation(150, 130);
		add(operatorTextField);

		b1 = new JButton("1");
		b1.setSize(30, 20);
		b1.setLocation(100, 200);
		add(b1);
		b1.addActionListener(this);

		b2 = new JButton("2");
		b2.setSize(30, 20);
		b2.setLocation(140, 200);
		add(b2);
		b2.addActionListener(this);

		b3 = new JButton("3");
		b3.setSize(30, 20);
		b3.setLocation(180, 200);
		add(b3);
		b3.addActionListener(this);

		b4 = new JButton("4");
		b4.setSize(30, 20);
		b4.setLocation(100, 250);
		add(b4);
		b4.addActionListener(this);

		b5 = new JButton("5");
		b5.setSize(30, 20);
		b5.setLocation(140, 250);
		add(b5);
		b5.addActionListener(this);

		b6 = new JButton("6");
		b6.setSize(30, 20);
		b6.setLocation(180, 250);
		add(b6);
		b6.addActionListener(this);

		b7 = new JButton("7");
		b7.setSize(30, 20);
		b7.setLocation(100, 300);
		add(b7);
		b7.addActionListener(this);

		b8 = new JButton("8");
		b8.setSize(30, 20);
		b8.setLocation(140, 300);
		add(b8);
		b8.addActionListener(this);

		b9 = new JButton("9");
		b9.setSize(30, 20);
		b9.setLocation(180, 300);
		add(b9);
		b9.addActionListener(this);

		bPoint = new JButton(".");
		bPoint.setSize(30, 20);
		bPoint.setLocation(180, 350);
		add(bPoint);
		bPoint.addActionListener(this);

		b0 = new JButton("0");
		b0.setSize(30, 20);
		b0.setLocation(140, 350);
		add(b0);
		b0.addActionListener(this);

		bLP = new JButton("(");
		bLP.setSize(30, 20);
		bLP.setLocation(230, 350);
		add(bLP);
		bLP.addActionListener(this);

		bRP = new JButton(")");
		bRP.setSize(30, 20);
		bRP.setLocation(270, 350);
		add(bRP);
		bRP.addActionListener(this);

		bAdd = new JButton("+");
		bAdd.setSize(30, 20);
		bAdd.setLocation(230, 200);
		add(bAdd);
		bAdd.addActionListener(this);

		bSub = new JButton("-");
		bSub.setSize(30, 20);
		bSub.setLocation(270, 200);
		add(bSub);
		bSub.addActionListener(this);

		bMul = new JButton("*");
		bMul.setSize(30, 20);
		bMul.setLocation(230, 250);
		add(bMul);
		bMul.addActionListener(this);

		bDiv = new JButton("/");
		bDiv.setSize(30, 20);
		bDiv.setLocation(270, 250);
		add(bDiv);
		bDiv.addActionListener(this);

		bSR = new JButton("sqrt");
		bSR.setSize(30, 20);
		bSR.setLocation(270, 300);
		add(bSR);
		bSR.addActionListener(this);

		bC = new JButton("C");
		bC.setSize(30, 20);
		bC.setLocation(100, 350);
		add(bC);
		bC.addActionListener(this);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Calculator panel = new Calculator();
		frame.getContentPane().add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void calculate() {
		String operatorChar = operator.pop();
		double operand1 = operand.pop();
		double result = 0;
		if (operatorChar == "+")
			result = operand1 + operand.pop();
		if (operatorChar == "-")
			result = operand.pop() - operand1;
		if (operatorChar == "*")
			result = operand1 * operand.pop();
		if (operatorChar == "/")
			result = operand.pop() / operand1;
		if (operatorChar == "sqrt") {
			result = Math.sqrt(operand1);
		}
		operand.push(result);
		operandTextField.setText(operand.toString());
		operatorTextField.setText(operator.toString());

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(b0) || e.getSource().equals(b1) || e.getSource().equals(b2) || e.getSource().equals(b3)
				|| e.getSource().equals(b4) || e.getSource().equals(b5) || e.getSource().equals(b6)
				|| e.getSource().equals(b7) || e.getSource().equals(b8) || e.getSource().equals(b9)
				|| e.getSource().equals(bPoint)) {
			operandTextField.setText(operandTextField.getText() + ((JButton) e.getSource()).getText());
			digit++;
		} else if (e.getSource().equals(bAdd) || e.getSource().equals(bSub) || e.getSource().equals(bMul)
				|| e.getSource().equals(bDiv) || e.getSource().equals(bSR)) {
			if (digit != 0) {
				operandTextField.setText(operandTextField.getText() + " ");
				operand.push(Double.parseDouble(operandTextField.getText().substring(
						operandTextField.getText().length() - digit - 1, operandTextField.getText().length() - 1)));

				digit = 0;

			}
			operatorTextField.setText(operatorTextField.getText() + " " + ((JButton) e.getSource()).getText());
			operator.push(((JButton) e.getSource()).getText());

		} else if (e.getSource().equals(bRP)) {
			if(operand.isEmpty() || operator.isEmpty()){
				return;
			}
			if (digit != 0) {
				operandTextField.setText(operandTextField.getText() + " ");
				operand.push(Double.parseDouble(operandTextField.getText().substring(
						operandTextField.getText().length() - digit - 1, operandTextField.getText().length() - 1)));

				digit = 0;

			}
			calculate();

		} else if (e.getSource().equals(bLP)) {
			digit = 0;

		} else if (e.getSource().equals(bC)) {
			operandTextField.setText("");
			operatorTextField.setText("");
			operand = new Stack<>();
			operator = new Stack<>();
			digit = 0;
			screen.setText("");
			return;
		}

		screen.setText(screen.getText() + ((JButton) e.getSource()).getText());

	}

}
