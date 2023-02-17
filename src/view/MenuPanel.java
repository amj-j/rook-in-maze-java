package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.listeners.MenuListener;
import interfaces.viewInterfaces.MenuView;
import structures.MazeSize;

public class MenuPanel extends JPanel implements MenuView {
    JLabel gamesWonLabel;
    JButton resetButton;
    JButton mazeSizeButton;

    MenuListener listener;

    public MenuPanel() {     
        setBackground(DefaultSettings.BG_COLOR);
        gamesWonLabel = new JLabel();
        gamesWonLabel.setBackground(DefaultSettings.BG_COLOR);
        gamesWonLabel.setText("Games won: 0");
        resetButton = new JButton("Reset");
        mazeSizeButton = new JButton("Difficulty");
        add(gamesWonLabel);
        add(resetButton);
        add(mazeSizeButton);
        initPopupMenu();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Font font = new Font(DefaultSettings.FONT_NAME, Font.BOLD, getHeight()/2);
                gamesWonLabel.setFont(font);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.reset();
                }
            }
        });
    }

    public void setWonGames(int gamesWon) {
        gamesWonLabel.setText("Games won: " + gamesWon);
    }

    public void addListener(MenuListener listener) {
        this.listener = listener;
    }

    public void initPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem easy = new JMenuItem("Easy");
        JMenuItem medium = new JMenuItem("Medium");
        JMenuItem hard = new JMenuItem("Hard");

        ActionListener menuItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == easy) { listener.changeMazeSize(new MazeSize(10, 10)); }
                else if (event.getSource() == medium) { listener.changeMazeSize(new MazeSize(20, 15)); }
                else if (event.getSource() == hard) { listener.changeMazeSize(new MazeSize(30, 20)); }
            }
        };

        easy.addActionListener(menuItemListener);
        medium.addActionListener(menuItemListener);
        hard.addActionListener(menuItemListener);

        popupMenu.add(easy);
        popupMenu.add(medium);
        popupMenu.add(hard);
        mazeSizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(mazeSizeButton, mazeSizeButton.getWidth(), 0);
            }
        });
    }
}
