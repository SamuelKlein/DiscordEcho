package com.DiscordEcho.Commands.Audio;

import com.DiscordEcho.Commands.Command;
import com.DiscordEcho.DiscordEcho;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;


public class ClipCommand implements Command {

    @Override
    public Boolean called(String[] args, GuildMessageReceivedEvent e){
        return true;
    }

    @Override
    public void action(String[] args, GuildMessageReceivedEvent e) {
        if (args.length != 1 && args.length != 2) {
            DiscordEcho.sendMessage(e.getChannel(), DiscordEcho.serverSettings.get(e.getGuild().getId()).prefix + usage());
            return;
        }

        if(e.getGuild().getAudioManager().getConnectedChannel() == null) {
            DiscordEcho.sendMessage(e.getChannel(), "I wasn't recording!");
            return;
        }

        if (args.length == 2 && e.getGuild().getTextChannelsByName(args[1], true).size() == 0) {
            DiscordEcho.sendMessage(e.getChannel(), "Cannot find specified voice channel");
            return;
        }

        int time;
        try {
            time = Integer.parseInt(args[0]);
        } catch (Exception ex) {
            DiscordEcho.sendMessage(e.getChannel(), DiscordEcho.serverSettings.get(e.getGuild().getId()).prefix + usage());
            return;
        }

        if (time <= 0) {
            DiscordEcho.sendMessage(e.getChannel(), "Time must be greater than 0");
            return;
        }

        if (args.length == 2)
            DiscordEcho.writeToFile(e.getGuild(), time, e.getGuild().getTextChannelsByName(args[1], true).get(0));
        else
            DiscordEcho.writeToFile(e.getGuild(), time, e.getChannel());

    }

    @Override
    public String usage() {
        return "clip [seconds] | clip [seconds] [text channel output]";
    }

    @Override
    public String descripition() {
        return "Saves a clip of the specified length and outputs it in the current or specified text channel (max 120 seconds)";
    }

    @Override
    public void executed(boolean success, GuildMessageReceivedEvent e){
        return;
    }
}
