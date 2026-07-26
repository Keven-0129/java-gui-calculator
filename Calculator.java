import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField field1;
    private JTextField field2;
    private JTextField result;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(320, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Font fieldFont = new Font("Arial", Font.PLAIN, 20);
        field1 = new JTextField();
        field1.setFont(fieldFont);
        field1.setHorizontalAlignment(SwingConstants.RIGHT);

        field2 = new JTextField();
        field2.setFont(fieldFont);
        field2.setHorizontalAlignment(SwingConstants.RIGHT);

        result = new JTextField();
        result.setFont(fieldFont);
        result.setHorizontalAlignment(SwingConstants.RIGHT);
        result.setEditable(false);

        JPanel fieldsPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        fieldsPanel.add(new JLabel("Number 1:"));
        fieldsPanel.add(field1);
        fieldsPanel.add(new JLabel("Number 2:"));
        fieldsPanel.add(field2);
        fieldsPanel.add(new JLabel("Result:"));
        fieldsPanel.add(result);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        String[] ops = {"+", "-", "*", "/"};
        for (String op : ops) {
            JButton button = new JButton(op);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout());
        add(fieldsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        double num1;
        double num2;
        try {
            num1 = Double.parseDouble(field1.getText());
            num2 = Double.parseDouble(field2.getText());
        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
            return;
        }

        double value = 0;

        switch (command) {
            case "+":
                value = num1 + num2;
                break;
            case "-":
                value = num1 - num2;
                break;
            case "*":
                value = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    result.setText("Error: Div by 0");
                    return;
                }
                value = num1 / num2;
                break;
        }

        result.setText(String.valueOf(value));
    }    

    public static void main(String[] args) {        
            Calculator calculator = new Calculator();
            calculator.setVisible(true);        
    }
}
