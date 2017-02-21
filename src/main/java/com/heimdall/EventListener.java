package com.heimdall;

import com.DiscordEcho.Commands.CommandHandler;
import com.DiscordEcho.Configuration.ServerSettings;
import com.DiscordEcho.DiscordEcho;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;


public class EventListener extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if(event.getMessage().getContent().equals("gravar")){

            VoiceChannel vc = event.getMember().getVoiceState().getChannel();
            vc.getGuild().getAudioManager().openAudioConnection(vc);
            vc.getGuild().getAudioManager().setReceivingHandler(new AudioReceiveListener());
        } else if(event.getMessage().getContent().equals("salvar")){
            AudioReceiveListener.usuariosIO.forEach((s, outputStream) -> {
//                    outputStream.close();
//                    Util.convertePcmToMP3(AudioReceiveListener.usuariosFilesIO.get(s));

            });
            AudioReceiveListener.usuariosIO = new HashMap<>();
            AudioReceiveListener.usuariosFilesIO = new HashMap<>();

        }
    }
}
