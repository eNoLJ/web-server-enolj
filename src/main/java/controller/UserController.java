package controller;

import annotation.Controller;
import annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index.html")
    public String mainPage() {
        logger.info("메인 페이지 요청");
        return "/index.html";
    }
}
