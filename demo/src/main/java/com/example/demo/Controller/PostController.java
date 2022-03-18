package com.example.demo.Controller;

import com.example.demo.Model.Post;
import com.example.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping("/")
    public String viewIndexPage(Model model) {
        List<Post> postList = service.listAll();
        model.addAttribute("getAllPost", postList);
        return "index";
    }

    @RequestMapping("/new_add")
    public String viewNewPostForm(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "insert";
    }

    @RequestMapping(value = "/save_post", method = RequestMethod.POST)
    public String addNewPost(@ModelAttribute("post") Post post) {
        service.create(post);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView viewEditPostForm(@PathVariable(name = "id") long id){

        ModelAndView mav = new ModelAndView("update");
        Post post = service.updateById(id);
        mav.addObject("post", post);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePost(@PathVariable(name = "id") long id){

        service.delete(id);
        return "redirect:/";
    }


}
