package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.listeners.MenuListener;
import interfaces.viewInterfaces.MenuView;

public class MenuPanel extends JPanel implements MenuView {
    JLabel gamesWonLabel;
    JButton resetButton;

    MenuListener listener;

    public MenuPanel() {     
        setBackground(DefaultSettings.BG_COLOR);
        resetButton = new JButton("Reset");
        gamesWonLabel = new JLabel();
        gamesWonLabel.setBackground(DefaultSettings.BG_COLOR);
        gamesWonLabel.setText("Games won: 0");
        add(resetButton);
        add(gamesWonLabel);
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
}
