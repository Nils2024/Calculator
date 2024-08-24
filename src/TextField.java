import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {

    private String calculatorDisplay;
    private final int textField_HEIGHT = 100;

    public TextField(){

        this.setFont(new Font("Comic Sans", Font.BOLD, 40));
        this.setBackground(Color.black);
        this.setForeground(Color.green);
        this.setPreferredSize(new Dimension(100, textField_HEIGHT));
    }

    public String getCalculatorDisplay() {
        return calculatorDisplay;
    }


    public void setCalculatorDisplay(String text) {
        this.calculatorDisplay = text;
        this.setText(text);
    }




}

