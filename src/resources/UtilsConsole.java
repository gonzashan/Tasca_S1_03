package resources;

import java.util.Random;

import static java.lang.Thread.sleep;

public class UtilsConsole {

    public static void screen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int velocityChoose(int e) {

        int min = 95, max = 220, result;
        int fixedVelocity = 26;

        if (e == 0) result = (int) Math.floor(Math.random() * (max - min + 1) + min);
        else result = fixedVelocity;

        return result;
    }

    public static void typeWriter(String e) {
        //int min = 95;
        int r = 1;
        int max = 220;
        int velocity;
        int[] numeros = new int[max];

        //int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        velocity = velocityChoose(r);

        int pass1 = velocityChoose(r);
        Random rd = new Random(velocityChoose(r));

        int i;

        for (i = 0; i < e.length(); i++) {
            System.out.printf("%c", e.charAt(i));
            /*sonido.ReproducirSonidox(número del la muestra de sound + variable)*/
            if (i % 2 == 0) SoundTypeWritter.ReproducirSonidox(i % 2);
            //random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            try {
                sleep(r == 0 ? rd.nextInt(velocityChoose(r)) : velocity );
                //0.5s pause between characters
            } catch (InterruptedException ex) {

                Thread.currentThread().interrupt();
            }
        }
        //System.out.println();
    }

}