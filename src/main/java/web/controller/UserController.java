package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private UserDao userDao;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping("/")
    public String update(@ModelAttribute("user") User user, @RequestParam(name = "id") long id) {
        userService.edit(user);
        return "redirect:/";
    }
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "show";
    }
@DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        userService.delete(id);
        return "redirect:/";
    }

}
