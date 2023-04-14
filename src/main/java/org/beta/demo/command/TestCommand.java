package org.beta.demo.command;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import org.beta.demo.command.CommandType;
import org.beta.demo.command.Commandable;
import org.beta.demo.thirdparty.google.youtube.YoutubeRequestClient;
import org.springframework.stereotype.Component;

import static org.beta.demo.command.CommandMessageDirector.sendEmbeds;

@RequiredArgsConstructor
@Component
public class TestCommand implements Commandable {
    private final YoutubeRequestClient client;

    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        if (userMessage.equals("테스트")) {
            client.searchByVideoId("dd");
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.TEST;
    }
}
