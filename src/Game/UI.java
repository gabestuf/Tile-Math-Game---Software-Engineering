package Game;
import javax.swing.*;
import java.awt.*;

public class UI {

    public JFrame window;

    //QUIT
    JPanel quitNamePanel;
    JPanel boardButtonPanel;
    JPanel moveButtonPanel;
    JLabel quitNameLabel;
    JButton boardButton, quitButton;
    //MAIN PANEL
    JPanel topPanel, tilePanel;
    JLabel screenLabel;
    public JButton upButton, downButton, leftButton, rightButton, button00, button01, button02, button10, button11,button12, button20, button21, button22, quitScreenButton, resetButton;
    //public JTextArea mainTextArea;
    //FONT
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public void createUI(Game.ChoiceHandler cHandler) {

        //WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        //QUIT SCREEN
        quitNamePanel = new JPanel();
        quitNamePanel.setBounds(60, 100, 700, 500);
        quitNamePanel.setBackground(Color.black);
        quitNameLabel = new JLabel("Are you sure you want to quit?");
        quitNameLabel.setForeground(Color.white);
        quitNameLabel.setFont(titleFont);
        quitNamePanel.add(quitNameLabel);

        boardButtonPanel = new JPanel();
        boardButtonPanel.setBounds(250,300,300,150);
        boardButtonPanel.setBackground(Color.black);
        boardButtonPanel.setLayout(new GridLayout(2,1));
        window.add(boardButtonPanel);

        quitButton = new JButton("QUIT");
        quitButton.setBackground(Color.black);
        quitButton.setForeground(Color.white);
        quitButton.setFont(normalFont);
        quitButton.setFocusPainted(false);
        quitButton.addActionListener(cHandler);
        quitButton.setActionCommand("quit");
        boardButtonPanel.add(quitButton);

        boardButton = new JButton("BOARD");
        boardButton.setBackground(Color.black);
        boardButton.setForeground(Color.white);
        boardButton.setFont(normalFont);
        boardButton.setFocusPainted(false);
        boardButton.addActionListener(cHandler);
        boardButton.setActionCommand("start");
        boardButtonPanel.add(boardButton);

        window.add(quitNamePanel);
        window.add(boardButtonPanel);

        //GAME SCREEN

        //tile panel
        tilePanel = new JPanel();
        tilePanel.setBounds(50,100,400,400);
        tilePanel.setBackground(Color.black);
        tilePanel.setLayout(new GridLayout(3,3));
        window.add(tilePanel);

        button00 = new JButton("7");
        button00.setBackground(Color.black);
        button00.setForeground(Color.white);
        button00.setFont(normalFont);
        button00.setFocusPainted(false);
        button00.addActionListener(cHandler);
        button00.setActionCommand("00");
        tilePanel.add(button00);

        button10 = new JButton("2");
        button10.setBackground(Color.black);
        button10.setForeground(Color.white);
        button10.setFont(normalFont);
        button10.setFocusPainted(false);
        button10.addActionListener(cHandler);
        button10.setActionCommand("10");
        tilePanel.add(button10);

        button20 = new JButton("8");
        button20.setBackground(Color.black);
        button20.setForeground(Color.white);
        button20.setFont(normalFont);
        button20.setFocusPainted(false);
        button20.addActionListener(cHandler);
        button20.setActionCommand("20");
        tilePanel.add(button20);

        button01 = new JButton("1");
        button01.setBackground(Color.black);
        button01.setForeground(Color.white);
        button01.setFont(normalFont);
        button01.setFocusPainted(false);
        button01.addActionListener(cHandler);
        button01.setActionCommand("01");
        tilePanel.add(button01);

        button11 = new JButton("4");
        button11.setBackground(Color.black);
        button11.setForeground(Color.white);
        button11.setFont(normalFont);
        button11.setFocusPainted(false);
        button11.addActionListener(cHandler);
        button11.setActionCommand("11");
        tilePanel.add(button11);

        button21 = new JButton("9");
        button21.setBackground(Color.black);
        button21.setForeground(Color.white);
        button21.setFont(normalFont);
        button21.setFocusPainted(false);
        button21.addActionListener(cHandler);
        button21.setActionCommand("21");
        tilePanel.add(button21);

        button02 = new JButton("6");
        button02.setBackground(Color.black);
        button02.setForeground(Color.white);
        button02.setFont(normalFont);
        button02.setFocusPainted(false);
        button02.addActionListener(cHandler);
        button02.setActionCommand("02");
        tilePanel.add(button02);

        button12 = new JButton("3");
        button12.setBackground(Color.black);
        button12.setForeground(Color.white);
        button12.setFont(normalFont);
        button12.setFocusPainted(false);
        button12.addActionListener(cHandler);
        button12.setActionCommand("12");
        tilePanel.add(button12);

        button22 = new JButton("5");
        button22.setBackground(Color.black);
        button22.setForeground(Color.white);
        button22.setFont(normalFont);
        button22.setFocusPainted(false);
        button22.addActionListener(cHandler);
        button22.setActionCommand("22");
        tilePanel.add(button22);

        //top panel
        topPanel = new JPanel();
        topPanel.setBounds(100, 15, 600, 50);
        topPanel.setBackground(Color.black);
        topPanel.setLayout(new GridLayout(1,3));
        window.add(topPanel);

        quitScreenButton = new JButton("QUIT");
        quitScreenButton.setBackground(Color.black);
        quitScreenButton.setForeground(Color.white);
        quitScreenButton.setFont(normalFont);
        quitScreenButton.setFocusPainted(false);
        quitScreenButton.addActionListener(cHandler);
        quitScreenButton.setActionCommand("toQuitScreen");
        topPanel.add(quitScreenButton);

        screenLabel = new JLabel("    TILE GAME");
        screenLabel.setForeground(Color.magenta);
        screenLabel.setFont(normalFont);
        topPanel.add(screenLabel);

        resetButton = new JButton("RESET");
        resetButton.setBackground(Color.black);
        resetButton.setForeground(Color.white);
        resetButton.setFont(normalFont);
        resetButton.setFocusPainted(false);
        resetButton.addActionListener(cHandler);
        resetButton.setActionCommand("reset");
        topPanel.add(resetButton);

        //move button panel

        moveButtonPanel = new JPanel();
        moveButtonPanel.setBounds(520, 200, 200, 200);
        moveButtonPanel.setBackground(Color.black);
        moveButtonPanel.setLayout(new GridLayout(2,2));
        window.add(moveButtonPanel);

        upButton = new JButton("▲");
        upButton.setBackground(Color.black);
        upButton.setForeground(Color.white);
        upButton.setFont(normalFont);
        upButton.setFocusPainted(false);
        upButton.addActionListener(cHandler);
        upButton.setActionCommand("moveUp");
        moveButtonPanel.add(upButton);

        rightButton = new JButton("►");
        rightButton.setBackground(Color.black);
        rightButton.setForeground(Color.white);
        rightButton.setFont(normalFont);
        rightButton.setFocusPainted(false);
        rightButton.addActionListener(cHandler);
        rightButton.setActionCommand("moveRight");
        moveButtonPanel.add(rightButton);

        downButton = new JButton("▼");
        downButton.setBackground(Color.black);
        downButton.setForeground(Color.white);
        downButton.setFont(normalFont);
        downButton.setFocusPainted(false);
        downButton.addActionListener(cHandler);
        downButton.setActionCommand("moveDown");
        moveButtonPanel.add(downButton);

        leftButton = new JButton("◄");
        leftButton.setBackground(Color.black);
        leftButton.setForeground(Color.white);
        leftButton.setFont(normalFont);
        leftButton.setFocusPainted(false);
        leftButton.addActionListener(cHandler);
        leftButton.setActionCommand("moveLeft");
        moveButtonPanel.add(leftButton);


        downButton.setVisible(false);
        upButton.setVisible(false);
        leftButton.setVisible(false);
        rightButton.setVisible(false);

        // WIN / LOSE

        window.setVisible(true);

    }

    public void resetUI() {
        button00.setText("7");
        button10.setText("2");
        button20.setText("8");
        button01.setText("1");
        button11.setText("4");
        button21.setText("9");
        button02.setText("6");
        button12.setText("3");
        button22.setText("5");

        button00.setVisible(true);
        button10.setVisible(true);
        button20.setVisible(true);
        button01.setVisible(true);
        button11.setVisible(true);
        button21.setVisible(true);
        button02.setVisible(true);
        button12.setVisible(true);
        button22.setVisible(true);

        button11.setBackground(Color.black);
        button11.setForeground(Color.white);
    }
}
