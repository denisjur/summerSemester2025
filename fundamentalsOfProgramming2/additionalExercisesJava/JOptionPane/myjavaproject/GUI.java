package myjavaproject;

import javax.swing.JOptionPane;

public class GUI {

    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null, "Hello " + name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age")); //IMPORTANT normal würden wir einen String bekommen, aber dieser wird nun in einem Integer umgewandlet 
        JOptionPane.showMessageDialog(null, "You are " + age + " years old");

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height")); // Aici verwandelst du Strung input in einem data type double
        JOptionPane.showMessageDialog(null, "You are " + height + " cm tall");
    }
}


