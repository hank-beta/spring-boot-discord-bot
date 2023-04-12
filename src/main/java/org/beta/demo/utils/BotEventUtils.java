package org.beta.demo.utils;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class BotEventUtils {
    public static boolean isBot(MessageReceivedEvent event) {
        return event.getAuthor().isBot();
    }

    public static String extractRawMessage(MessageReceivedEvent event) {
        return event.getMessage().getContentRaw();
    }

    public static void sendMessage(MessageChannel channel, String message) {
        channel.sendMessage(message).queue();
    }
}
