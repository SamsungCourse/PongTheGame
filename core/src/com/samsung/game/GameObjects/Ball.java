package com.samsung.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.samsung.game.helperClasses.BodyCreator;
import com.samsung.game.helperClasses.ContactType;
import com.samsung.game.screens.GameScreen;

import static com.samsung.game.helperClasses.Constants.BALL_SPEED;
import static com.samsung.game.helperClasses.Constants.PPM;
import static com.samsung.game.helperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.helperClasses.Constants.SCREEN_WIDTH;

public class Ball {//класс пули

    private Body body;
    float x, y, speed, velX, velY;
    private int width, height;
    private GameScreen gameScreen;
    private Texture texture;
    int scoreNum = 1;
    public int angle;

    public Ball(GameScreen gameScreen){
        x = SCREEN_WIDTH/2;
        y = SCREEN_HEIGHT/2;
        speed = BALL_SPEED;
        angle = getRandomAngle();

        texture = new Texture("dot.png");
        this.gameScreen = gameScreen;
        width = 32;
        height = 32;
        body = BodyCreator.createBody(x, y, width, height, false, 0, gameScreen.getWorld(), ContactType.BALL);
    }

    private int getRandomAngle(){//вызывается в начале, чтобы дать рандомное направление пуле
        return (Math.random() < 0.5) ? 45 : -45;
    }

    public void randomiseAngle(){//дает рандомное изменение угла от -22 до +22, дает игре неожиданностей
        int num = (int)Math.random()*44-22;
        angle += num;
    }

    public void reverseAngleY(){//непростой математикой отражает угол в направлении Y, является упрощением от angle = angle - 2*angle + 180;
        if (angle <= 0) angle = 180 - angle;
        else angle = 180 - angle;
    }

    public void reverseAngleX(){//простой математикой отражает угол в направлении X, пользуюсь тем, что значения синуса после 180 равны тем что до 180 но со знаком -
        angle = - angle;
    }

    public void incSpeed(int incSpeed){
        speed += incSpeed;
    }

    public void update(){//здесь мы каждый раз переопределяем скорость по x и y
        velX = (float) (speed * Math.sin(Math.toRadians(angle)));//формула, благодаря которой можно найти координаты X и Y точки на окружности
        velY = (float) (speed * Math.cos(Math.toRadians(angle)));//сдвигая фигуру по этим координатам мы именно так как надо пермещаем обьект на все 360 градусов
        x =  body.getPosition().x * PPM - (width/2);//это для всех обьектов справедливые строки, они говорят, где находится обьект сейчас
        y =  body.getPosition().y * PPM - (width/2);

        if (speed < 26) {//при баге перезапускаем пулю
            reset();
        }

        body.setLinearVelocity(velX, velY);

        if (y < 0){//начисляем очки врагу и перезапускаем мяч, если мяч прошел через нашу сторону
            gameScreen.getEnemy().score(scoreNum);
            reset();
        }

        if (y > SCREEN_HEIGHT){//начисляем очки игроку и перезапускаем мяч, если мяч прошел стену врага
            gameScreen.getPlayer().score(scoreNum);
            reset();
        }
    }

    public void reset(){
        velX = getRandomAngle();
        velY = getRandomAngle();
        speed = BALL_SPEED;
        body.setTransform(SCREEN_WIDTH/2/PPM, SCREEN_HEIGHT/2/PPM, 0);
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, x, y, width, height);
    }
}
