package chat.service;

import chat.service.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {

    private MessageRepository messageRepository;

    @Autowired
    public ChannelService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public long createChannel() {
        return this.messageRepository.createChannel();
    }

}
