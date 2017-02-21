package com.heimdall;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.File;

/**
 * Created by samuel on 16/02/17.
 */
public class Main {

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException {

//        Util.convertePcmToMP3(new File("/tmp/Samuelklein_1487368130017.opus"));


        String secret = "MjgxMDU3MzA1ODIxMzE1MDcy.C4ZdpA.l6seLQv45e5mf1TZqhD9vw70gYA";

        JDA api = new JDABuilder(AccountType.BOT)
                .setToken(secret)
                .addListener(new EventListener())
                .buildBlocking();





    }

}
