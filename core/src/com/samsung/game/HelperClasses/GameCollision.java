package com.samsung.game.HelperClasses;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Paddles.PlayerPaddle;
import com.samsung.game.GameObjects.Paddles.UIPaddle;
import com.samsung.game.Screens.GameScreen;

public class GameCollision implements ContactListener {//класс который применяется в GameScreen для обработки коллизий

    private GameScreen gameScreen;
    public static int diapozoneP = 90;
    public static int diapozoneE = 45;

    public GameCollision(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture a = contact.getFixtureA();
        Fixture b = contact.getFixtureB();

        if(a == null|| b == null) return; //проверяем на наличие нарушений
        if(a.getUserData() == null || b.getUserData() == null) return;//проверяем на наличие нарушений

        if(a.getUserData() == ContactType.BALL || b.getUserData() == ContactType.BALL){//если хотя бы один из прикоснувшихся - шар, то обрабатываем столкновение
            //коллизия игрока и пули
            if (a.getUserData() == ContactType.PLAYER || b.getUserData() == ContactType.PLAYER){
                if (Boot.volume){
                    gameScreen.beat.play();
                }
                gameScreen.getBall().reverseAngleY();
                if (PlayerPaddle.paddleType == PaddleType.GREEN) {
                    gameScreen.getBall().randomiseAngle(diapozoneP);
                } else {
                    gameScreen.getBall().randomiseAngle(diapozoneE);
                }
                if (PlayerPaddle.paddleType == PaddleType.BLUE) {
                    gameScreen.getBall().incSpeed(12);
                } else {
                    gameScreen.getBall().incSpeed();
                }

            }
            //коллизия стены и пули
            if (a.getUserData() == ContactType.WALL || b.getUserData() == ContactType.WALL){
                gameScreen.getBall().reverseAngleX();
            }

            if (a.getUserData() == ContactType.ENEMY || b.getUserData() == ContactType.ENEMY){
                if (Boot.volume){
                    gameScreen.beat.play();
                }
                gameScreen.getBall().reverseAngleY();
                gameScreen.getBall().randomiseAngle(diapozoneE);
                gameScreen.getBall().incSpeed();
                if (UIPaddle.type == ScreenTypePaddle.WALL_SCREEN){
                    gameScreen.getPlayer().score();
                }
            }
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
