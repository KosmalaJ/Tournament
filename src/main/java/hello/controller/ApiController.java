package hello.controller;

import hello.model.Message;
import hello.model.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= {"/api"})
public class ApiController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getmessage", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Message getMessage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        String text="Udało Ci się zalogować! "+user.getFirstname()+" "+user.getLastname();
        return new Message(100, "Congratulations!", text);
    }

}
