package DesktopRunnable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class App extends JPanel {
    private JButton create_new;
    private JPanel panel1;
    private JTextField folderNameTextField;
    private JButton clearFieldsButton;
    private JTextField EmailTextField;

    public App() {
        //This action listener is for the create button
        //Needs to set the path to the correct path and then name it the right name
        //If the name is taken throw an error
        //If the name field or the email field is empty throw an error
        //If the path doesn't exist throw an error
        //If the email doesn't exist throw an error
        //Create a system that checks for correct email type ie @...com/net/ect
        create_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //need to add something to check if the email is valid or not. If its not don't create the folder and throw an error message at the user
                if(!EmailTextField.getText().isEmpty()&&!folderNameTextField.getText().isEmpty()/*&& email doesn't exist in the database*/){
                    FolderCreation directory = new FolderCreation();
                    directory.setName(folderNameTextField.getText());
                    directory.setPath(directory.getName());
                    boolean created = directory.newDirect();
                if (created) {

                    JOptionPane.showMessageDialog(null, "A new Secure Folder has been created!");
                } else {
                    JOptionPane.showMessageDialog(null, "Error no path exists");
                }

            }
                else
                    JOptionPane.showMessageDialog(null, "                  Invalid Input \n You cannot leave the fields blank");
        }});
        //Action listener for the clear fields button
        //clears the text and directory location of all the input boxes
        clearFieldsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                folderNameTextField.setText("");
                EmailTextField.setText("");
            }
        });
    }
    //The gradient in the background
    //light blue to a darker blue
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.decode("#6EE2F5");
        Color color2 = Color.decode("#6454F0");
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

    //main method
    //creates jframe and adds everything to it
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new JFrame();
            frame.setResizable(false);
            App panel = new App();
            panel.add(new App().panel1);
            frame.add(panel).setSize(500,500);

            frame.setSize(400, 300);;
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    });
}


}
