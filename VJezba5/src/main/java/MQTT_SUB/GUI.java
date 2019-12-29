package MQTT_SUB;

//import com.sun.tools.javac.comp.Flow;

import javax.swing.*;
import java.awt.*;

class GUI {

    void create() {

        JFrame frame = new JFrame("MQTT Subscriber");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.weightx = 0.5;

        JLabel topLabel = new JLabel("Select Topic");
        constraint.gridx = 0;
        constraint.gridy = 0;
        pane.add(topLabel, constraint);

        String[] petStrings = { "#", "Temperature", "Pressure" };
        JComboBox combox = new JComboBox(petStrings);
        combox.setEditable(true);
        constraint.gridx = 1;
        constraint.gridy = 0;
        pane.add(combox, constraint);

        JButton add = new JButton("Add");
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.insets = new Insets(5,5,0,5);
        pane.add(add, constraint);

        JButton remove = new JButton("Remove");
        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.insets = new Insets(5,5,0,5);
        pane.add(remove, constraint);

        JTextField text = new JTextField();
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 2;
        constraint.ipadx = 300;
        constraint.ipady = 300;
        constraint.insets = new Insets(5,0,0,0);
        pane.add(text, constraint);

        frame.pack();
        frame.setVisible(true);
    }
}
