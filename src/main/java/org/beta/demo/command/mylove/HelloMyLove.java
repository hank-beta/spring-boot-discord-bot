package org.beta.demo.command.mylove;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;

import static org.beta.demo.command.CommandMessageDirector.sendEmbedsAll;


public class HelloMyLove implements MyLove {
    private int choice = 0;
    private int scenarioStep = 0;


    @Override
    public boolean unCompleteFirstStep() {
        return scenarioStep == 0;
    }

    @Override
    public boolean completeFirstStep() {
        return scenarioStep == 1;
    }

    @Override
    public boolean completeSecondStep() {
        return scenarioStep == 2;
    }

    @Override
    public boolean completeFinalStep() {
        return scenarioStep == 3;
    }

    @Override
    public void printPreDefinedText(MessageChannel channel, User user, Integer choice) {
        MessageEmbed message = sendEmbedsAll("우당탕탕 베타양 꼬시기 대작전", "내 사랑 베타가 나타났다. 어떻게 꼬시지?\n\n" + "[1] 안녕 자기\n[2] 사랑해", "https://i.pinimg.com/564x/07/0e/90/070e90ba99adf33722b4866db3292c74.jpg");
        channel.sendMessageEmbeds(message).queue();
        scenarioStep++;
    }

    @Override
    public void choose(MessageChannel channel, User user, Integer choice) {
        switch (choice) {
            case 1:
                this.choice = 1;
                break;
            case 2:
                this.choice = 2;
                break;
        }
        scenarioStep++;
    }

    @Override
    public void printPostDefinedText(MessageChannel channel, User user, Integer choice) {
        MessageEmbed message = null;

        switch (this.choice) {
            case 1:
                message = sendEmbedsAll("베타 양", "머야 이새키, 귀엽노", "https://i.pinimg.com/736x/b7/1b/90/b71b9063505143ee37708c4805353ffd.jpg");
                break;
            case 2:
                message = sendEmbedsAll("베타 양", "경멸의 눈빛을 보낸다.\n '이상한 새키'", "https://i.pinimg.com/564x/c2/00/b1/c200b1bc77fa22aa43b62ad0232f1b75.jpg");
                break;
        }

        channel.sendMessageEmbeds(message).queue();
        scenarioStep++;
    }
}
