package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.MessageDTO;
import dbteam4.booksale.dto.MessageUserDTO;
import dbteam4.booksale.service.MessageService;
import dbteam4.booksale.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final MessageService messageService;
    private final UserService userService;
    @GetMapping()
    public String chat(@SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser, Model model){
        List<MessageUserDTO> lastMessageList = messageService.findLastMessageList(loginUser.getId());



        model.addAttribute("lastMessageList", lastMessageList);

        return "chat";
    }

    @GetMapping("/each/{otherUserId}")
    public String eachChat(@PathVariable Long otherUserId, Model model,
                           @SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser){
        if ( otherUserId == loginUser.getId()) {return "redirect:/chat";}

        List<MessageDTO> messages = messageService.findByTwoId(loginUser.getId(), otherUserId);

        String otheUserName = userService.findById(otherUserId).getUserName();

        model.addAttribute("otherUserId", otherUserId);
        model.addAttribute("otherUserName", otheUserName);
        model.addAttribute("messages", messages);

        return "chatEach";
    }
}
