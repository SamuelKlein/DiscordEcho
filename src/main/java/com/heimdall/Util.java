package com.heimdall;

import net.sourceforge.lame.lowlevel.LameEncoder;
import net.sourceforge.lame.mp3.Lame;
import net.sourceforge.lame.mp3.MPEGMode;

import javax.sound.sampled.AudioFormat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/**
 * Created by samuel on 17/02/17.
 */
public class Util {


    public static void convertePcmToMP3(File pcmFile){
        try{
            byte[] array = encodePcmToMp3(Files.readAllBytes(pcmFile.toPath()));
            Files.write(new File(pcmFile.getPath() + ".mp3").toPath(), array);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static byte[] encodePcmToMp3(byte[] pcm) {
        LameEncoder encoder = new LameEncoder(new AudioFormat(48000.0f, 16, 2, true, true), 128, MPEGMode.STEREO, Lame.QUALITY_HIGHEST, false);
        ByteArrayOutputStream mp3 = new ByteArrayOutputStream();
        byte[] buffer = new byte[encoder.getPCMBufferSize()];

        int bytesToTransfer = Math.min(buffer.length, pcm.length);
        int bytesWritten;
        int currentPcmPosition = 0;
        while (0 < (bytesWritten = encoder.encodeBuffer(pcm, currentPcmPosition, bytesToTransfer, buffer))) {
            currentPcmPosition += bytesToTransfer;
            bytesToTransfer = Math.min(buffer.length, pcm.length - currentPcmPosition);
            mp3.write(buffer, 0, bytesWritten);
        }

        encoder.close();

        return mp3.toByteArray();
    }

}
