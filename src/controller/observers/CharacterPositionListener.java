package controller.observers;

import model.CharacterGame;

public class CharacterPositionListener implements CharacterListener {
    @Override
    public void onPositionChanged(CharacterEvent event) {
        CharacterGame.getInstance().setPos((int) event.getX(), (int) event.getY());
    }
}
