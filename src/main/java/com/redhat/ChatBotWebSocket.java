package com.redhat;

import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;
import io.smallrye.mutiny.Multi;

@WebSocket(path = "/chatbot")
public class ChatBotWebSocket {

    private final Bot bot;

    public ChatBotWebSocket(Bot bot) {
        this.bot = bot;
    }

    @OnOpen
    public String onOpen() {
        return "Welcome to the IBM TechXchange 2024 Chatbot powered by OpenShift AI! How can I help you today?";
    }

    @OnTextMessage
    public Multi<String> onTextMessage(String message) {
        return bot.chat(message);
    }
}