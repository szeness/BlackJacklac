package game;

import gui.CarAndOthers;
import gui.CardFramez;
import gui.Gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler extends Gui implements KeyListener {


    public KeyHandler() {}


    @Override
    public void keyTyped(KeyEvent e) {

        switch(e.getKeyChar()) {
            case 'i':

                Engine.intro();

                break;
////////////////////////////////// C ////////////////////////////////
            case 'c':try {

                Engine.check();


            } catch (InterruptedException ex) {ex.printStackTrace();}
                break;

////////////////////////////////// X ////////////////////////////////
            case 'x':

                xButton();

                break;
            case 'l':

                Runnable r = new Runnable() {
                    public void run() {
                        try {
                            Clock.runIntro();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                new Thread(r).start();
                break;

////////////////////////////////// N ////////////////////////////////
            case 'n':try {


                    Engine.newGame();




            } catch (InterruptedException ex) {ex.printStackTrace();}
                break;

            case 'e':
                dot.setVisible(false);

                break;
            case 'f':


                break;
            case 'v':
                textArea1.setVisible(!textArea1.isVisible());
                break;
            case 'q':
                label.setLocation(label.getX() - 10, label.getY());
                m6.setLocation(m6.getX()-10,m6.getY());
                CarAndOthers.explo(dot);
                CarAndOthers.explo(dot2);
                break;
            case 'w':
                label.setLocation(label.getX(), label.getY() - 10);
                m6.setLocation(m6.getX(),m6.getY()-10);
                CarAndOthers.explo(dot);
                CarAndOthers.explo(dot2);
                break;

////////////////////////////////// S ////////////////////////////////
            case 's':
                Engine.splitCards();

                break;
            case 'r':
                Credit.resetCreditz();
                break;
            case 'b':
            for (JLabel jl : CardFramez.cardsPlayerArray) {
                System.out.println(jl);
            }
                break;

////////////////////////////////// D ////////////////////////////////
            case 'd':
                try {
                    Engine.doubleDown();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                break;
            case 'a':
                m6.setLocation(m6.getX()-10,m6.getY()+10);
                CarAndOthers.explo(dot);
                CarAndOthers.explo(dot2);

                break;
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        //keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
        switch (e.getKeyCode()) {
            case 37 -> label.setLocation(label.getX() - 10, label.getY());
            case 38 -> label.setLocation(label.getX(), label.getY() - 10);
            case 39 -> label.setLocation(label.getX() + 10, label.getY());
            case 40 -> label.setLocation(label.getX(), label.getY() + 10);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }


public static void xButton() {


        if (!Engine.passedDealer) {

            if (!Engine.xOffdueSplitt) {
                Gui.textArea4.setText("-  Dealers Turn  -");
                Gui.textArea5.setText("- Dealers Turn -\n");

                try {
                    Runnable r = new Runnable() {
                        public void run() {
                            try {

                                Thread.sleep(700);
                                Engine.passToDealer();

                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    };
                    new Thread(r).start();

                } catch (Exception exception) {
                    exception.printStackTrace();
                }


                try {
                    Runnable r = new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(1700);
                                Engine.dealerExtraCard();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();

                            }
                        }
                    };
                    new Thread(r).start();

                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            } else Gui.textArea4.append("\n stand both split");
        } else Gui.textArea3.append("- wait -");

    }
}
