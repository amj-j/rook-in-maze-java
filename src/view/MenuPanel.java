package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.MenuListener;

public class MenuPanel extends JPanel {
    JLabel gamesWonLabel;
    JButton settingsButton;
    JButton resetButton;

    MenuListener listener;

    public MenuPanel() {     
        setBackground(DefaultSettings.BG_COLOR);
        settingsButton = new JButton("Settings");
        resetButton = new JButton("Reset");
        gamesWonLabel = new JLabel();
        gamesWonLabel.setBackground(DefaultSettings.BG_COLOR);
        gamesWonLabel.setText("Games won: 0");
        add(settingsButton);
        add(resetButton);
        add(gamesWonLabel);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Font font = new Font(DefaultSettings.FONT_NAME, Font.BOLD, getHeight()/2);
                gamesWonLabel.setFont(font);
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.openSettings();
                }
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
}
