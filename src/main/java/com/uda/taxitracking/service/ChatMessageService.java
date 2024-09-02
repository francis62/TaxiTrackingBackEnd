package com.uda.taxitracking.service;

import com.uda.taxitracking.model.ChatMessage;
import com.uda.taxitracking.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<String> getAllSenders() {
        List<ChatMessage> chatMessages = chatMessageRepository.findAll();
        return chatMessages.stream()
                .map(ChatMessage::getSender)
                .distinct()
                .filter(sender -> !sender.equals("conductor"))
                .collect(Collectors.toList());
    }


    public List<ChatMessage> getMessagesBySender(String _sender) {
        System.out.printf("getMessagesBySender: %s\n", _sender);
        List<ChatMessage> userToDriver = chatMessageRepository.findBySenderAndReceiver(_sender, "conductor");
        List<ChatMessage> driverToUser = chatMessageRepository.findBySenderAndReceiver("conductor", _sender);
        userToDriver.addAll(driverToUser);
        Collections.sort(userToDriver, Comparator.comparing(ChatMessage::getId));
        return userToDriver;
    }

}
