package Window;

import Generator.PasswordGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Window{

    private JFrame mainFrame = new JFrame("Generator");

    private JLabel numberOfSigns = new JLabel("Number of Characters: ");
    private JTextField passwordText = new JTextField("Password",22); //TODO: Generate password upon button press

    private JComboBox numberOfCharsInput = new JComboBox();

    private JButton generate_Button = new JButton("Generate");

    private JPanel lengthPanel = new JPanel();
    private JPanel passwordPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    private int pwlength = 10;

    /**
     * Constructor tries to create the Window, catches any Exception.
     * Done to keep the method itself and the constructor cleaner.
     */
    public Window(){
        try{
            createWindow();
        } catch(Exception windowCreationException){
            windowCreationException.printStackTrace();
        }
    }

    private void createWindow(){

        passwordText.setEditable(false);
        passwordPanel.setBorder(null);

        generate_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent generatorActionEvent) {
                generateButtonPressed();
            }
        });

        int[] lengthChoices = {10,11,12,13,14,15,16,17,18,19,20};
        for(int i=0;i<lengthChoices.length;i++){
            numberOfCharsInput.addItem(lengthChoices[i]);
        }
        numberOfCharsInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent numberOfCharActionEvent) {
                updateNumberOfChars();
            }
        });

        lengthPanel.add(numberOfCharsInput);
        lengthPanel.add(numberOfSigns);

        passwordPanel.add(passwordText);

        buttonPanel.add(generate_Button);

        mainFrame.getContentPane().add(lengthPanel);
        mainFrame.getContentPane().add(passwordPanel);
        mainFrame.getContentPane().add(buttonPanel);

        mainFrame.getContentPane().setLayout(new BoxLayout(mainFrame.getContentPane(),BoxLayout.Y_AXIS));
        mainFrame.setSize(300,300);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateNumberOfChars(){
        pwlength = (int)numberOfCharsInput.getSelectedItem();
    }
    private void generateButtonPressed(){
        generate_Button.setEnabled(false);
        String password;
        password = PasswordGenerator.generatePassword(pwlength);
        passwordText.setText(password);
        System.out.println(password);
        generate_Button.setEnabled(true);
    }

    public static void main(String[] args){
        new Window();
    }

}
