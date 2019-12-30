package MQTT_SUB;

//import com.sun.tools.javac.comp.Flow;

import javax.swing.*;
import java.awt.*;

class GUI {

    private JPanel messageBox;
//    private JScrollPane messageBox;

    void create(/*String[] hostList, String[] topicList*/) {

        JFrame frame = new JFrame("MQTT Subscriber");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.weightx = 0.5;
        constraint.insets = new Insets(5,5,0,5);

        JLabel hostLabel = new JLabel("Select Host");
        constraint.gridx = 0;
        constraint.gridy = 0;
        pane.add(hostLabel, constraint);

        String[] petStrings = { "#", "Temperature", "Pressure" };
        JComboBox hostCombo = new JComboBox(petStrings);
        constraint.gridx = 1;
        constraint.gridy = 0;
        pane.add(hostCombo, constraint);

        JLabel topicLabel = new JLabel("Select Topic");
        constraint.gridx = 0;
        constraint.gridy = 1;
        pane.add(topicLabel, constraint);

        //String[] petStrings = { "#", "Temperature", "Pressure" };
        JComboBox topicCombo = new JComboBox(petStrings);
        constraint.gridx = 1;
        constraint.gridy = 1;
        pane.add(topicCombo, constraint);

        JButton conButton = new JButton("Connect");
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 2;
        constraint.insets = new Insets(5,10,0,10);
        pane.add(conButton, constraint);

//        messageBox = new JScrollPane();
        messageBox = new JPanel();
        messageBox.setLayout(new FlowLayout());
        messageBox.setPreferredSize(new Dimension(300, 300));
        JScrollPane scrollBox = new JScrollPane();
        messageBox.add(scrollBox);
        constraint.gridy = 3;
        //constraint.ipadx = 300;
        //constraint.ipady = 300;
        constraint.insets = new Insets(5,0,0,0);
        pane.add(messageBox, constraint);

        frame.pack();
        frame.setVisible(true);
    }

    void addMessage(String message) {

        JTextArea text = new JTextArea(message, 4, 20);
        text.setPreferredSize(new Dimension(300, 20));
        text.setEditable(false);
        messageBox.add(text);
    }
}
