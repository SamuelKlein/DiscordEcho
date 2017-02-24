package com.heimdall;

import com.DiscordEcho.DiscordEcho;
import net.dv8tion.jda.core.audio.AudioReceiveHandler;
import net.dv8tion.jda.core.audio.CombinedAudio;
import net.dv8tion.jda.core.audio.UserAudio;
import net.dv8tion.jda.core.entities.User;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AudioReceiveListener implements AudioReceiveHandler {

    public static HashMap<String, OutputStream> usuariosIO = new HashMap<>();

    public static HashMap<String, File> usuariosFilesIO = new HashMap<>();

    @Override
    public boolean canReceiveCombined() {
        return true;
    }

    @Override
    public boolean canReceiveUser() {
        return true;
    }

    @Override
    public void handleCombinedAudio(CombinedAudio combinedAudio) {

        try {
            OutputStream gravarInputStream = null;
            if (usuariosIO.containsKey("Teste")) {
                gravarInputStream = usuariosIO.get("Teste");
            } else {
                gravarInputStream = criarIn("Teste");
            }
            gravarInputStream.write(combinedAudio.getAudioData(1));
            gravarInputStream.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        Set<String> usuarios = new HashSet<>();
//        combinedAudio.getUsers().forEach(user -> {
//            usuarios.add(user.getName());
//        });
//        Set<String> set = usuariosFilesIO.keySet().stream().filter((v)-> {
//            return !usuarios.contains(v);
//        }).collect(Collectors.toSet());
//        int quantidade = combinedAudio.getAudioData(1).length;
//
//        byte[] b = new byte[quantidade];
//        for (String nome : set) {
//            OutputStream gravarInputStream = usuariosIO.get(nome);
//            try {
//                gravarInputStream.write(b);
//                gravarInputStream.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void handleUserAudio(UserAudio userAudio) {
//        String nome = userAudio.getUser().getName();
//        try {
//            OutputStream gravarInputStream = null;
//            if (usuariosIO.containsKey(nome)) {
//                gravarInputStream = usuariosIO.get(nome);
//            } else {
//                gravarInputStream = criarIn(nome);
//            }
//            byte[] b = userAudio.getAudioData(1);
//            gravarInputStream.write(b);
//            gravarInputStream.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private OutputStream criarIn(String nome) throws FileNotFoundException {
        File file = new File("/tmp/teste/teste");
        usuariosFilesIO.put(nome, file);
        FileOutputStream fos = new FileOutputStream(file);
        usuariosIO.put(nome, fos);
        return fos;
    }


}