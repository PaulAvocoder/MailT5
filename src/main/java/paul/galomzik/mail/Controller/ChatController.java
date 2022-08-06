package java.paul.galomzik.mailt5.Controller;

import java.paul.galomzik.mailt5.Model.Message;
import java.paul.galomzik.mailt5.Repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageRepo messageRepo;


    @MessageMapping("/message")
    @SendTo("/messenger/public")
    public Message receiveMessage(@Payload Message message){
        messageRepo.save(message);
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message){
        messageRepo.save(message);
        messageRepo.findAll();
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        return message;
    }
}
