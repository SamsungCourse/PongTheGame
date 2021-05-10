package com.samsung.game.HelperClasses;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.samsung.game.HelperClasses.Constants.PIXELS_PER_METRE;

public class BodyCreator {//этот класс создает нашим обьектам хитбоксы, чтобы можно было регировать на них потом

    public static Body createBody(float x, float y, float width, float height, boolean isStatic, float dencity, World world, ContactType type){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = !isStatic ? BodyDef.BodyType.DynamicBody : BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x / PIXELS_PER_METRE, y / PIXELS_PER_METRE);
        bodyDef.fixedRotation = true;
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PIXELS_PER_METRE, height / 2 / PIXELS_PER_METRE);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = dencity;
        body.createFixture(fixtureDef).setUserData(type);

        shape.dispose();
        return body;
    }
}
