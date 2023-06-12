package dbteam4.booksale.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MembertierController {
    @GetMapping("/membertier")
    public String alarm(){return "membertier";}
}
