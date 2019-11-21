package Lab3.Multi.user.chat;

import javax.swing.*;
import java.awt.event.*;

public class Chat {
    private JTextField textFild;
    private JPanel panel1;
    private JTextArea textArea1;
    private JTextPane textPane1;

    public Chat() {

        textFild.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {
                String input = inputMethodEvent.paramString();

            }

            @Override
            public void caretPositionChanged(InputMethodEvent inputMethodEvent) {

            }
        });
        textPane1.addComponentListener(new ComponentAdapter() {
        });
    }
}
