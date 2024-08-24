import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {

    private String text;

    public Button(String text){

    this.text = text;
    this.setText(text);
    this.setFocusable(false);
    this.setFont(new Font("Comic Sans", Font.BOLD, 30));
    this.setBackground(Color.gray);

    }

    public Character toChar(){
        return text.charAt(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
