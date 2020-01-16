package MQTT_SUB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI {

    private JScrollPane messageBox;
    private JPanel scrollPanel;
    private Subscriber parent;

    GUI(Subscriber p) {
        parent = p;
    }

    void create(String[] hostList, String[] topicList) {

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

        final JComboBox hostCombo = new JComboBox(hostList);
        constraint.gridx = 1;
        pane.add(hostCombo, constraint);

        JLabel topicLabel = new JLabel("Select Topic");
        constraint.gridx = 0;
        constraint.gridy = 1;
        pane.add(topicLabel, constraint);

        //String[] updatedTopicList;
        final JComboBox topicCombo = new JComboBox(topicList);
        constraint.gridx = 1;
        pane.add(topicCombo, constraint);

        JButton conButton = new JButton("Connect");

        conButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String host = hostCombo.getSelectedItem().toString();
                String topic = topicCombo.getSelectedItem().toString();
                parent.connect(host, topic);
            }
        });

        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 2;
        constraint.insets = new Insets(5,10,0,10);
        pane.add(conButton, constraint);



        scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
        messageBox = new JScrollPane(scrollPanel);
        messageBox.setPreferredSize(new Dimension(300, 300));
        constraint.gridy = 3;
        constraint.insets = new Insets(5,0,0,0);
        pane.add(messageBox, constraint);

        frame.pack();
        frame.setVisible(true);
    }

    void addMessage(String message) {

        JTextArea text = new JTextArea(message, 3, 20);
        text.setEditable(false);
        scrollPanel.add(text);
        scrollPanel.revalidate();
    }
}
