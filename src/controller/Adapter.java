package controller;

import model.CharacterGame;
import model.MonsterGame;
import view.Canvas;
import view.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Adapter implements ActionListener {

    private MonsterGame monsterGame;
    private CharacterGame characterGame;

    public Adapter(MonsterGame monsterGame, CharacterGame characterGame) {
        this.monsterGame = monsterGame;
        this.characterGame = characterGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!monsterGame.getCanvas())
            MonsterGame.getInstance();
        if(!characterGame.getCanvas())
            CharacterGame.getInstance();
    }
}
