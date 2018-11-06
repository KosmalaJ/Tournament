package hello.controller;

import hello.model.Tournament;
import hello.model.User;
import hello.service.TournamentService;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;



@Controller
@RequestMapping(value= {"/tournaments"})
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;
    @Autowired
    private UserService userService;

@RequestMapping(value = {"/exbracket"})
public ModelAndView example() {
        ModelAndView model = new ModelAndView();

        model.setViewName("tournaments/examplebracket");
        return model;
    }
    @RequestMapping(value= {"/addtournament"}, method=RequestMethod.GET)
    public ModelAndView addtournament() {
        ModelAndView model = new ModelAndView();
        Tournament tournament =new Tournament();
        model.addObject("tournament", tournament);
        model.setViewName("tournaments/addtournament");

        return model;
    }
    @RequestMapping(value= {"/addtournament"}, method=RequestMethod.POST)
    public String createUser(@Valid Tournament tournament, BindingResult bindingResult) {
        //ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        tournamentService.saveTournament(tournament,user);
        //String msg= "Dodałeś turniej o nazwie: "+tournament.getName();
        //model.addObject("msg", msg);
        //model.setViewName("/tournaments/"+tournament.getId());
        String rt ="redirect:/tournaments/"+tournament.getId();
        return rt ;

    }
    @RequestMapping(value = "/{id}", method =RequestMethod.GET)
    public ModelAndView getTournament(
            @PathVariable("id") int id) {
        ModelAndView model =new ModelAndView();
        Tournament tournament= tournamentService.findTournamentById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User owner = userService.findUserByEmail(auth.getName());
        if(tournament.getStatus()==0 && tournament.getOwner().getId()==owner.getId())
        {model.setViewName("/tournaments/edit");
        }
        else if(tournament.getStatus()==0)
        {
            model.setViewName("tournaments/show");
        }
        //tutaj poustawiać inne nazwy view
        else model.setViewName("/home/home");
        model.addObject("tournament",tournament);

        return model;
    }

}


