package interfaces.viewInterfaces;

import interfaces.listeners.MenuListener;

public interface MenuView {
    public void setWonGames(int gamesWon);
    public void addListener(MenuListener listener);
}
