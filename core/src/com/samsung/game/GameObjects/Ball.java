package com.samsung.game.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.samsung.game.Boot;
import com.samsung.game.GameObjects.Paddles.UIPaddle;
import com.samsung.game.HelperClasses.BodyCreator;
import com.samsung.game.HelperClasses.ContactType;
import com.samsung.game.HelperClasses.ScreenTypePaddle;
import com.samsung.game.Screens.GameScreen;

import static com.samsung.game.HelperClasses.Constants.BALL_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.BALL_SPEED;
import static com.samsung.game.HelperClasses.Constants.BALL_WIDTH;
import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;
import static com.samsung.game.HelperClasses.Constants.PLAYER_Y;
import static com.samsung.game.HelperClasses.Constants.SCREEN_HEIGHT;
import static com.samsung.game.HelperClasses.Constants.SCREEN_WIDTH;

public class Ball {//класс пули

    private Body body;
    public float x, y, speed, velX, velY;
    private int width, height;
    private GameScreen gameScreen;
    private Texture texture;
    public int angle;
    public static int incSpeed = 5;

    public Ball(GameScreen gameScreen) {
        x = SCREEN_WIDTH / 2f;
        y = SCREEN_HEIGHT / 2f;
        speed = BALL_SPEED;
        angle = getRandomAngle(new int[]{0, 45, -45, 135, -135});

        texture = new Texture("dot.png");
        this.gameScreen = gameScreen;
        width = BALL_WIDTH;
        height = BALL_HEIGHT;
        body = BodyCreator.createBody(x, y, width, height, false, 0, gameScreen.getWorld(), ContactType.BALL);
    }

    private int getRandomAngle(int[] arr) {//вызывается в начале, чтобы дать рандомное направление пуле
        return arr[(int) (Math.random()*(arr.length - 1))];
    }

    public void randomiseAngle(int diap){//дает рандомное изменение угла от -22 до +22, придает игре неожиданностей
        int num = (int) (Math.random()*diap) - diap/2;
        angle += num;
    }

    public void reverseAngleY(){//непростой математикой отражает угол в направлении Y, является упрощением от angle = angle - 2*angle + 180;
        angle = 180 - angle;
    }

    public void reverseAngleX(){//простой математикой отражает угол в направлении X, пользуюсь тем, что значения синуса после 180 равны тем что до 180 но со знаком -
        angle = - angle;
    }

    public void incSpeed(){
        speed += incSpeed;
    }

    public void update(){//здесь мы каждый раз переопределяем скорость по x и y
        velX = (float) (speed * Math.sin(Math.toRadians(angle)));//формула, благодаря которой можно найти координаты X и Y точки на окружности
        velY = (float) (speed * Math.cos(Math.toRadians(angle)));//сдвигая фигуру по этим координатам мы именно так как надо пермещаем обьект на все 360 градусов
        x =  body.getPosition().x * PIXELS_PER_METRE - (width/2f);//это для всех обьектов справедливые строки, они говорят, где находится обьект сейчас
        y =  body.getPosition().y * PIXELS_PER_METRE - (width/2f);

        body.setLinearVelocity(velX, velY);

        if (y < PLAYER_Y - 20){//начисляем очки врагу и перезапускаем мяч, если мяч прошел через нашу сторону
            gameScreen.getEnemy().score();
            if (Boot.volume){
                gameScreen.lvlUp.play();
            }
            reset();
            angle = getRandomAngle(new int[]{180, 157, 135, -157, -135});
        }
        if (UIPaddle.type == ScreenTypePaddle.GAME_SCREEN) {
            if (y > SCREEN_HEIGHT - PLAYER_Y + 20) {//начисляем очки игроку и перезапускаем мяч, если мяч прошел стену врага
                gameScreen.getPlayer().score();
                if (Boot.volume) {
                    gameScreen.lvlUp.play();
                }
                reset();
                angle = getRandomAngle(new int[]{0, 22, 45, -22, -45});
            }
        }

        if (angle > 360){
            System.out.println(angle);
            angle = 360 - angle;
            System.out.println(angle);
        }
        if (angle < -360){
            System.out.println(angle);
            angle = 360 + angle;
            System.out.println(angle);
        }

        if (body.getLinearVelocity().x == 0 && body.getLinearVelocity().y == 0){
            reset();
            angle = getRandomAngle(new int[]{0, 45, -45, 135, -135});
        }
    }

    public void reset(){
        speed = BALL_SPEED;
        body.setTransform(SCREEN_WIDTH/2f/PIXELS_PER_METRE, SCREEN_HEIGHT/2f/PIXELS_PER_METRE, 0);
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, x, y, width, height);
    }
}
