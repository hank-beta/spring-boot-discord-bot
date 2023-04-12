package org.beta.demo.command.mylove;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public interface MyLove {
    // 상대가 채팅을 친다.
    // 내가 선택지를 고른다
    // 출력이 나온다.
    boolean unCompleteFirstStep();

    boolean completeFirstStep();

    boolean completeSecondStep();

    boolean completeFinalStep();

    void printPreDefinedText(MessageChannel channel, User user, Integer choice);

    void choose(MessageChannel channel, User user, Integer choice);

    void printPostDefinedText(MessageChannel channel, User user, Integer choice);

    default void runScenario(MessageChannel channel, User user, Integer choice) {
        if (unCompleteFirstStep()) {
            printPreDefinedText(channel, user, choice);
        }

        if (completeFirstStep() && choice != null) {
            choose(channel, user, choice);
        }
        if (completeSecondStep()) {
            printPostDefinedText(channel, user, choice);
        }
    }
}
