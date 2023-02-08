
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form extends PlayerStats{

    private static JFrame form;
    private static JTextArea ta;
    private static JPanel panel;
    private static JButton option1;
    private static JButton option2;

    static Boolean canPassOptionOne;
    static Boolean canPassOptionTwo;

//Build GUI

    public Form(NodeMap map) {

        createFrame(map);
        nodeDisplay(map);
        

    }

    private static void createFrame(NodeMap map){

        form = new JFrame("Get to your 9am on time!");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setSize(1280,720);
        form.setResizable(false); //Disable the Resize Button
        form.setLocationRelativeTo(null);

        createPanel();
        createButtons(map);
        createTextArea();

        panel.add(option1);
        panel.add(option2);

        //Adding Components to the frame.
        form.getContentPane().add(BorderLayout.SOUTH, panel);
        form.getContentPane().add(BorderLayout.CENTER, ta);
        form.setVisible(true);


    }

    private static void createPanel(){

        panel = new JPanel(); // the panel is not visible in output
        setColors(panel, Color.BLACK,Color.white);

    }

    private static void createButtons(NodeMap map){

        option1 = new JButton("Option 1");
        option1.setFont(createFont(50));
        setColors(option1,Color.darkGray, Color.white);

        option1.addActionListener((ActionEvent e) -> {

             move(map,1);
             nodeDisplay(map);

        }); 

        option2 = new JButton("Option 2");
        option2.setFont(createFont(50));
        setColors(option2,Color.darkGray, Color.white);
        option2.addActionListener((ActionEvent e) -> {

            move(map,2);
            nodeDisplay(map);
            
        });

    }


    private static void createTextArea(){

        ta = new JTextArea();
        ta.setFont(createFont(50));
        ta.setBackground(Color.darkGray);
        ta.setForeground(Color.green);

    }

    private static void move(NodeMap map, int direction){


        if (map.currentNode().getDescription().equals("-")){

            map.optionTwoPath(); 

        }

        else {

            if(canPassOptionOne == true && direction == 1){

                map.decision(direction);}

            else if(canPassOptionTwo == true && direction ==2){

                map.decision(direction);}

        }

    }

    private static void nodeDisplay(NodeMap map){

        handlePlayerStats(map);

        ta.setText(map.currentNode().getDescription() + "\n");
        ta.append("Option 1: " + map.currentNode().getOptionOneText() + "\n");
        ta.append("Option 2: " + map.currentNode().getOptionTwoText() + "\n");
        ta.append("Coolness Points: " + playerStats.getCoolnessPoints() + "\n");
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);

        canPassOptionOne = map.canPassOptionOne(map, playerStats);
        canPassOptionTwo = map.canPassOptionTwo(map, playerStats);

        if (map.currentNode().getOptionTwoText().equals("-")){

            option1.setFont(createFont(40));
            option1.setText("Press to Restart");
            option2.setVisible(false);

        }

        else {

            option2.setVisible(true);
            option1.setFont(createFont(50));
            option1.setText("Option 1");

        }

    }



//Helpers

    private static void setColors(JComponent object, Color bg, Color fg){

        object.setBackground(bg);
        object.setForeground(fg);

    }
    
    private static Font createFont(int size){

        return  new Font("Arial", Font.PLAIN,size);
    
    }

    public static PlayerStats playerStats = new PlayerStats();

    public static void handlePlayerStats(NodeMap map){

        playerStats.addCoolnessPoints(map.currentNode().getCoolnessGained());

        if (map.currentNode().getOptionTwoText().equals("-")){playerStats.resetStats();}

    }

}
