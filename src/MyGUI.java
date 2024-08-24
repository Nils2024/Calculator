import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MyGUI extends JFrame implements ActionListener{

    MyGUI myGUI;
    TextField calculatorDisplay;
    Double zahl1 = null;
    Character operator = null;
    Button clearButton;

    String[] buttonContent = {"1", "2", "3", "*",
            "4", "5", "6", "/",
            "7", "8", "9", "+",
            ",", "0", "=", "-"};

    ArrayList<Button> buttons = new ArrayList<>();

    public MyGUI() {

        this.setBackground(Color.darkGray);

        this.setTitle("Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setBounds(200, 200, 700, 700);

        Container myContentPane = this.getContentPane();
        myContentPane.setLayout(new BorderLayout());
        Container containerNumbers = new Container();
        containerNumbers.setLayout(new GridLayout(4, 4));

        for (String x : buttonContent) {
            buttons.add(new Button(x));
            containerNumbers.add(buttons.getLast());
            buttons.getLast().addActionListener(this);
        }

        clearButton = new Button("C");
        clearButton.setPreferredSize(new Dimension(70, 100));
        clearButton.addActionListener(this);

        calculatorDisplay = new TextField();
        calculatorDisplay.addKeyListener(this);
        //calculatorDisplay.setText("Hallo");
        myContentPane.add(calculatorDisplay, BorderLayout.NORTH);
        myContentPane.add(containerNumbers, BorderLayout.CENTER);
        myContentPane.add(clearButton, BorderLayout.EAST);

        this.setVisible(true);
    }

    void handleNumber(Character digit) {

        boolean execute = false;

        if (calculatorDisplay.getText().indexOf(',') == -1 && digit == ',' && !calculatorDisplay.getText().isEmpty()) {
            execute = true;
        }
        if (Character.isDigit(digit)) {
            execute = true;
        }
        if (execute) {
            calculatorDisplay.setText(calculatorDisplay.getText() + digit);
        }
    }

    void handleOperator(Character operator) {

        if (this.zahl1 == null) {
            zahl1 = Double.parseDouble(calculatorDisplay.getText());
            calculatorDisplay.setText("");


            if (this.operator == null) {
                this.operator = operator;
                return;
            }
        }

        if (this.operator == null) {
            this.operator = operator;
            calculatorDisplay.setText("");
            return;
        }

        switch (this.operator) {
            case '+':
                zahl1 = zahl1 + Double.parseDouble(calculatorDisplay.getText());
                calculatorDisplay.setText("");
                break;
            case '-':
                zahl1 = zahl1 - Double.parseDouble(calculatorDisplay.getText());
                calculatorDisplay.setText("");
                break;
            case '*':
                zahl1 = zahl1 * Double.parseDouble(calculatorDisplay.getText());
                calculatorDisplay.setText("");
                break;
            case '/':
                zahl1 = zahl1 / Double.parseDouble(calculatorDisplay.getText());
                calculatorDisplay.setText("");
                break;
        }

        if (operator == '=') {
            calculatorDisplay.setText(String.valueOf(zahl1));
            this.operator = null;
            return;
        }

        this.operator = operator;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Button btn : buttons) {
            if (e.getSource() == btn) {
                char tmp = btn.toChar();
                if (Character.isDigit(btn.toChar()) || tmp == ',') {
                    handleNumber(btn.toChar());
                } else {
                    handleOperator(btn.toChar());
                }
                break;
            }
        }
        if (e.getSource() == clearButton) {
            zahl1 = null;
            operator = null;
            calculatorDisplay.setText("");
        }

    }


}
