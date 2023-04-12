package org.beta.demo.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public interface Commandable {
    void doCommand(MessageChannel channel, User user, String userMessage);

    CommandType getCommandType();
}
