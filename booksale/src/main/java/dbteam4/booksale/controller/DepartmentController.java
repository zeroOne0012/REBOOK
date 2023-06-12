
package dbteam4.booksale.controller;

import dbteam4.booksale.service.SchoolService;
import org.springframework.stereotype.Controller;
import dbteam4.booksale.dto.SchoolDTO;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final SchoolService schoolService;

    @GetMapping
    public String department() {return "department";}

    @PostMapping("/save")
    public String save(@ModelAttribute SchoolDTO schoolDTO){
        log.info("schoolDTO ={}", schoolDTO.toString());
        schoolService.save(schoolDTO);
        return "redirect:/";
    }
}
