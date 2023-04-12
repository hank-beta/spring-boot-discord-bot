package org.beta.demo.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import org.springframework.stereotype.Component;

import static org.beta.demo.command.CommandMessageDirector.sendEmbeds;
import static org.beta.demo.command.CommandMessageDirector.sendEmbedsAll;

@Component
public class ReactionCommand implements Commandable {
    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        if (userMessage.equals("안녕")) {
            MessageEmbed message = sendEmbeds("오니짱, 잘 잤어?", "https://i.pinimg.com/564x/22/4a/a4/224aa46e92394a4002042a03a1e1c58e.jpg");

            channel.sendMessageEmbeds(message).queue();
        }

        if (userMessage.equals("사랑해")) {
            String name = user.getName();
            String keyword = "気持ち!!!!  ❤️\u200D❤️\u200D ".repeat(5) + "\n";
            String description = keyword.repeat(10);

            MessageEmbed message = sendEmbedsAll(name + "군!! ", description, null);

            channel.sendMessageEmbeds(message).queue();
        }

        if (userMessage.equals("굿모닝")) {
            String name = user.getName();
            sendEmbeds(name + "군도 좋은 아침입니다.", null);
//            channel.sendMessageEmbeds(message).queue();
        }
    }


    @Override
    public CommandType getCommandType() {
        return CommandType.REACTION;
    }


}
