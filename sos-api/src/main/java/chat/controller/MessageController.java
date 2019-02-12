package chat.controller;

import chat.service.MessageService;
import chat.service.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/{channelId}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Message> validateBot(@PathVariable("channelId") long channelId) {
        return this.messageService.getHistory(channelId);
    }

}
