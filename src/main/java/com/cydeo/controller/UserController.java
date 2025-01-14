package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final RoleService roleService;
    private final UserService userService;
    private final ProjectService projectService;

    public UserController(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user",new UserDTO());

        model.addAttribute("roles",roleService.findAll());

        model.addAttribute("users",userService.findAll());

        return "/user/create";
    }




    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user){

        userService.save(user);

        return "redirect:/user/create";

    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username")String username , Model model){

        //what i need to do here?  user,user,roles

        //user object ${user)
        model.addAttribute("user", userService.findById(username));

        //roles ${roles}
        model.addAttribute("roles",roleService.findAll());

        //users ${users}
        model.addAttribute("users",userService.findAll());


        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO user){

        //update that user
        userService.update(user);

        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username")String username , Model model){



        userService.deleteById(username);


        return "redirect:/user/create";
    }





}
