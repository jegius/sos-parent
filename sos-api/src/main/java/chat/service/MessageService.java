package chat.service;

import chat.service.model.Message;
import chat.service.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message addMessage(long channel, Message message) {
        return this.messageRepository.add(channel, message);
    }

    public Collection<Message> getHistory(long channel) {
        return this.messageRepository.getAll(channel);
    }

}
