package org.beta.demo.command;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum CommandType {
    REACTION("사랑해", "안녕", "굿모닝"),
    RPS("도박", "ㄷㅂ", "ㄷ", "rps"),
    IMAGE("코코미", "에밀TS", "ㅋㅋㅁ"),
    MYLOVE("미연시", "ㅁㅇㅅ");


    private final Set<String> commandSet = new HashSet<>();

    CommandType(String... commandSet) {
        this.commandSet.addAll(Arrays.asList(commandSet));
    }

    public static CommandType from(String command) {
        CommandType[] values = CommandType.values();
        for (CommandType value : values) {
            Set<String> commandSet = value.getCommandSet();
            for (String realCommand : commandSet) {
                if (realCommand.equals(command)) {
                    return value;
                }
            }
        }

        return REACTION;
    }

    public Set<String> getCommandSet() {
        return commandSet;
    }
}
