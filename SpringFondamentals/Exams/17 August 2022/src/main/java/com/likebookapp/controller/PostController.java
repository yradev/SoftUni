package com.likebookapp.controller;

import com.likebookapp.model.dto.PostAddDTO;
import com.likebookapp.model.entity.enums.MoodName;
import com.likebookapp.service.PostService;
import com.likebookapp.session.CurrentSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("post")
public class PostController {
    private final PostService postService;
    private final CurrentSession currentSession;

    public PostController(PostService postService, CurrentSession currentSession) {
        this.postService = postService;
        this.currentSession = currentSession;
    }

    @ModelAttribute("postAddDTO")
    public PostAddDTO postAddDTO(){
        return new PostAddDTO();
    }

    @GetMapping("add")
    public ModelAndView newPost(ModelAndView modelAndView){
        if(!currentSession.isLogged()){ //•	Users (logged in) can access Add Post page.•
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        modelAndView.setViewName("post-add");
        modelAndView.addObject("moodNames", MoodName.values());
        return modelAndView;
    }

    @PostMapping("add/processing")
    public String addProcessing(@Valid PostAddDTO postAddDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(postAddDTO.getMood()==null){
            bindingResult.addError(new FieldError("moodIsEmpty","mood","You must select mood!"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postAddDTO", postAddDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.postAddDTO", bindingResult);
            return "redirect:/post/add";
        }

        postService.addPost(postAddDTO);
        return "redirect:/post/add";
    }

    @GetMapping("remove/{id}")
    public String removePost(@PathVariable long id){
        postService.removePost(id);
        return "redirect:/";
    }

    @GetMapping("add-like/{id}")
    public String addLike(@PathVariable long id){
        postService.addLike(id);
        return "redirect:/";
    }
}
