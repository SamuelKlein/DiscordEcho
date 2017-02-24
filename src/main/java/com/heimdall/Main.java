package com.heimdall;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.nio.file.Files;

/**
 * Created by samuel on 16/02/17.
 */
public class Main {

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException {

//        File[] files = new File("/Volumes/Dados/podcast/convertido/").listFiles();
//
//        for( File file : files ) {
//            System.out.println("convertendo " + file.getName());
//            Util.convertePcmToMP3(file);
//            System.out.println("Convertido " + file.getName());
//        }



        String secret = "MjgxMDU3MzA1ODIxMzE1MDcy.C4ZdpA.l6seLQv45e5mf1TZqhD9vw70gYA";

        JDA api = new JDABuilder(AccountType.BOT)
                .setToken(secret)
                .addListener(new EventListener())
                .buildBlocking();

    }

}
