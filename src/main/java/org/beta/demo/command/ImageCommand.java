package org.beta.demo.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class ImageCommand implements Commandable {

    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        try {
            File file = ResourceUtils.getFile("classpath:cocomi.png");
            channel.sendFile(Files.readAllBytes(file.toPath()), "cocomi.png").queue();
        } catch (IOException e) {
            System.out.println("w파일을 읽을 수 없네/ 파일이 없네");
            throw new RuntimeException(e);
        }

    }

    @Override
    public CommandType getCommandType() {
        return CommandType.IMAGE;
    }
}
