package resources;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundTypeWritter {

    private int sufix_file;

    public static void ReproducirSonidox(int sufix_file) {

        String sound_file = "./src/resources/sound" + sufix_file + ".wav";

        try {

            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(new File(sound_file).getAbsoluteFile());

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {

            System.out.println("Error al reproducir el sonido.");
        }
    }

}
