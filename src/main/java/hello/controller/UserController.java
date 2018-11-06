package hello.controller;
import javax.validation.Valid;

import hello.model.Tournament;
import hello.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hello.model.User;
import hello.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TournamentService tournamentService;

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("user/login");
        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");

        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "Taki użytkownik już istnieje!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "Rejestracja powiodła się!");
            model.addObject("user", new User());
            model.setViewName("user/signup");
        }

        return model;
    }

    @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        model.addObject("userName", user.getFirstname() + " " + user.getLastname());
        model.setViewName("home/home");
        return model;
    }

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }
    @RequestMapping(value = {"/home/example"})
    public ModelAndView example()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<User> myusers= userService.findAllUsers();
List<Tournament> tournaments=tournamentService.findAllTournaments();
        ModelAndView model =new ModelAndView();
        model.addObject("users",myusers);
        model.addObject("tournaments",tournaments);
            model.setViewName("/home/example");
            return model;

    }
}