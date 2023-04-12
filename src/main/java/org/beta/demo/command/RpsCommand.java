package org.beta.demo.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.springframework.stereotype.Component;

@Component
public class RpsCommand implements Commandable {
    @Override
    public void doCommand(MessageChannel channel, User user, String message) {
        // !도박 [가위,바위,보]
        int computer = (int) Math.round(Math.random() * 3);

        if (message.equals("가위")) {
            if (computer == 0) {
                channel.sendMessage("비겼습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("졌습니다!").queue();
            } else {
                channel.sendMessage("이겼습니다!").queue();
            }
        } else if (message.equals("바위")) {
            if (computer == 0) {
                channel.sendMessage("이겼습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("비겼습니다!").queue();
            } else {
                channel.sendMessage("졌습니다!").queue();
            }
        } else if (message.equals("보")) {
            if (computer == 0) {
                channel.sendMessage("졌습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("이겼습니다!").queue();
            } else {
                channel.sendMessage("비겼습니다!").queue();
            }
        } else {
            channel.sendMessage("가위, 바위, 보 중에 내주세요.").queue();
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.RPS;
    }
}
