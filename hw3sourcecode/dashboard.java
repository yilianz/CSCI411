/*  Modified from Java Swing Tutorial
 *  Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.  
 *  https://docs.oracle.com/javase/tutorial/uiswing/examples/components/HtmlDemoProject/src/components/HtmlDemo.java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager;

public class dashboard extends JPanel {
    JLabel hallway;
    JTextArea office;
    JLabel messageboard;
    JLabel officeboard;

    public dashboard() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        String initialText = "";
        Color bg = new Color(237,236,253);
        Color fg = new Color(7,16,19);

        office = new JTextArea(10, 30);
        office.setText(initialText);
        office.setBackground(bg);
        office.setForeground(fg);
        
        JScrollPane scrollPane = new JScrollPane(office);

        officeboard = new JLabel("Office Notice");
        //Another Approach
        JButton finished = new JButton("Answer the question -- Done");
        finished.setMnemonic(KeyEvent.VK_C);
        finished.setAlignmentX(Component.CENTER_ALIGNMENT);
        finished.addActionListener(new ActionListener() {
            // React to the user pushing the Change button.
            public void actionPerformed(ActionEvent e) {
                hallway.setText(office.getText());
            }
        });

        String initialHallway = "<html></html>";
        hallway = new JLabel(initialHallway) {
            public Dimension getPreferredSize() {
                return new Dimension(300, 200);
            }

            public Dimension getMinimumSize() {
                return new Dimension(300, 200);
            }

            public Dimension getMaximumSize() {
                return new Dimension(300, 200);
            }
        };
        hallway.setBackground(bg);
        String initialmessage = "<html><font color=#A31621> Simulation starts </font></html>";
        messageboard = new JLabel(initialmessage) {
            public Dimension getPreferredSize() {
                return new Dimension(200, 20);
            }

            public Dimension getMinimumSize() {
                return new Dimension(200, 20);
            }

            public Dimension getMaximumSize() {
                return new Dimension(200, 20);
            }
        };
        hallway.setVerticalAlignment(SwingConstants.CENTER);
        hallway.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.setBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("TA's office - One person a time"),
                        BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        leftPanel.add(scrollPane);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        leftPanel.add(officeboard);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.setBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Hallway - Three chairs"),
                        BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        rightPanel.add(hallway);
        rightPanel.add(messageboard);

        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(leftPanel);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(rightPanel);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });

    }

    public  void postMessage(String m) {
        messageboard.setText("<html><font color=#C14953>" + m + "</font></html>");
    }

    public void officeMessage(String m) {
        officeboard.setText("<html><font color=#071013>" + m + "</font></html>");
    }

    public void enterRoom(String name) {
        office.append("Student " + name + " enter office\n");
    }
    private String removeLine(String m, String current){
        int pos = current.indexOf(m); 
        if (pos!= -1){
        current = current.substring(0, pos)+current.substring(pos+m.length());
        }
        return current;
    }

    public  void leaveRoom(String name) {
        String current = office.getText();
        // remove the student from office
        String m = "Student " + name + " enter office\n";
        office.setText(removeLine(m,current));
    }

    public synchronized void waitHallway(String name) {
        String current = hallway.getText();
        current = current.substring(0, current.length() - 7) + "<br>Student " + name + " is waiting" + "</html>";
        hallway.setText(current);
    }

    public synchronized void leaveHallway(String name) {

        String current = hallway.getText();
        // remove the student from waiting room
        String m = "<br>Student " + name + " is waiting";
        hallway.setText(removeLine(m,current));
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be invoked
     * from the event dispatch thread.
     */
    private void createAndShowGUI() {
        try {
  
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }

        // Create and set up the window.
        JFrame frame = new JFrame("Java Synchronization Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add content to the window.
        frame.add(this);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}