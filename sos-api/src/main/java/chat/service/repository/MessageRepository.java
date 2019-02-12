package chat.service.repository;

import chat.service.model.Message;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageRepository {

    private AtomicLong channelAI = new AtomicLong();
    private AtomicLong messageAI = new AtomicLong();
    private Map<Long, Set<Message>> messages = new HashMap<>();

    public long createChannel() {
        long channelId = this.channelAI.incrementAndGet();
        this.messages.put(channelId, new TreeSet<>(Comparator.comparingLong(Message::getId)));
        return channelId;
    }

    public Message add(long channel, Message message) {
        if(this.messages.containsKey(channel)) {
            message.setId(this.messageAI.incrementAndGet());
            message.setTime(new Date().getTime());
            this.messages.get(channel).add(message);
            return message;
        } else {
            throw new IllegalArgumentException("Channel not found");
        }
    }

    public Collection<Message> getAll(long channel) {
        if(this.messages.containsKey(channel)) {
            return this.messages.get(channel);
        } else {
            throw new IllegalArgumentException("Channel not found");
        }
    }

}
