package com.mariaiva.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mariaiva.game.Ex1;
import com.mariaiva.game.sprites.Pong.Ball;
import com.mariaiva.game.sprites.Pong.InputPong;
import com.mariaiva.game.sprites.Pong.Moving;
import com.mariaiva.game.sprites.Pong.Paddle;

public class Task4 extends State {


    private BitmapFont font;
    private GlyphLayout layout;

    private Ball ball;
    private Moving leftP;
    private Moving rightP;

    private int scoreLeft;
    private int scoreRight;


    public Task4(GameStateManager gsm) {
        super(gsm);

        leftP = new Paddle("Pong/line.png", Gdx.graphics.getHeight()/6*5);
        rightP = new Paddle("Pong/line.png", Gdx.graphics.getHeight()/6);
        ball = new Ball("Pong/ball.png");

        InputPong inputProcessor = new InputPong((Paddle)leftP, (Paddle) rightP);
        Gdx.input.setInputProcessor(inputProcessor);

        font = new BitmapFont();
        layout = new GlyphLayout(font, "Null", Color.GOLD, 80, Align.left, false);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        leftP.update(dt);
        rightP.update(dt);

        if(ball.flewOut()){
            if(ball.getY() < 0)
                scoreRight++;
            else
                scoreLeft++;
            if(scoreRight == 21 || scoreLeft == 21){
                System.out.println("GameOver");
            } else {
                ball.restartPosition();
            }
        }
        if(ball.getBouncing()){
            if(colliding()==null && ball.insideWalls()){
                ball.setBouncing(false);
            }
        } else {
            if(colliding()!=null){
                ball.bounceOffThePaddle(colliding());
            }
        }

        ball.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {


        sb.begin();

        sb.draw(leftP.getObj(),leftP.getX(), leftP.getY());
        sb.draw(rightP.getObj(),rightP.getX(), rightP.getY());
        sb.draw(ball.getObj(), ball.getX(), ball.getY());

        String s = String.valueOf(scoreLeft) + " || " + String.valueOf(scoreRight);
        layout.setText(font, s);
        font.draw(sb, layout, 10, Ex1.HEIGHT - 10);

        sb.end();
    }

    @Override
    public void dispose() {
        leftP.dispose();
        rightP.dispose();
        ball.dispose();
    }

    private Moving colliding(){
        if(ball.collides(leftP.getBounds()))
            return leftP;
        else if(ball.collides(rightP.getBounds()))
            return rightP;
        else
            return null;
    }
}
