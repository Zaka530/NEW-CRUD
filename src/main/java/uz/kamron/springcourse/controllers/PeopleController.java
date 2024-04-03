package uz.kamron.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.kamron.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

private final PersonDAO personDAO;

@Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model){

    model.addAttribute("people",personDAO.index());
        //получим всех людей из DAO и передадим на обображение в представление
        return "people/index";}
    @GetMapping("/{id}")
public String show(@PathVariable("id")int id,Model model){
        //Получим одного человека по id из DAO и передадим на отображение в представление
        model.addAttribute("person",personDAO.show(id));
return "people/show";
}


}
