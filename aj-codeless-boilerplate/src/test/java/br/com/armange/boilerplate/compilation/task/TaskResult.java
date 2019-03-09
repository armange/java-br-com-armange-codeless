package br.com.armange.boilerplate.compilation.task;

import java.util.Set;

public class TaskResult {

    private final boolean result;
    private final Set<String> messages;
    
    public TaskResult(final boolean result, final Set<String> messages) {
        this.result = result;
        this.messages = messages;
    }

    public boolean isFailed() {
        return result == false;
    }

    public Set<String> getMessages() {
        return messages;
    }
}
