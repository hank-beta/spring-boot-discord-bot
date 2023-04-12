package org.beta.demo.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

public class CommandMessageDirector {
    public static MessageEmbed sendEmbeds(String description, String url) {
        EmbedBuilder builder = new EmbedBuilder();
        return builder
                .setDescription(description)
                .setColor(Color.PINK)
                .setImage(url)
                .build();
    }

    public static MessageEmbed sendEmbedsAll(String title, String description, String url) {
        EmbedBuilder builder = new EmbedBuilder();
        return builder.setTitle(title)
                .setDescription(description)
                .setColor(Color.PINK)
                .setImage(url)
                .build();
    }
}
