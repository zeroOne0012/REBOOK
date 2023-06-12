package dbteam4.booksale.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AlarmController {
    @GetMapping("/alarm")
    public String alarm(){return "alarm";}
}
