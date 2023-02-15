package controller;

import interfaces.MazeListener;
import model.Model;
import structures.TileCoords;
import view.MazeView;

public class MazeController implements MazeListener {
    Model model;
    MazeView view;

    public MazeController(Model model) {
        this.model = model;
    }

    public void mazeClicked(TileCoords coords) {
        TileCoords newPlayerPos = model.moveTo(coords);
        if (newPlayerPos != null) {
            view.setPlayerPos(newPlayerPos);
        }
        if (model.hasWon()) {
            
        }
    }
}
