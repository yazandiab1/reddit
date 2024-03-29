package com.yazan.reddit.controller;

import com.yazan.reddit.domain.Comment;
import com.yazan.reddit.domain.Link;
import com.yazan.reddit.service.CommentServiceImpl;
import com.yazan.reddit.service.LinkServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class LinkController {
    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);

    private LinkServiceImpl linkService;
    private CommentServiceImpl commentService;

    public LinkController(LinkServiceImpl linkService, CommentServiceImpl commentService) {
        this.linkService = linkService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("links", linkService.getLinks());
        return "link/list";
    }

    @GetMapping("link/{id}")
    public String read(@PathVariable Long id,Model model) {

        Optional<Link> link = linkService.getLink(id);
        if (link.isPresent()) {
            Link current_link = link.get();

            Comment comment = new Comment();
            comment.setLink(current_link);

            model.addAttribute("comment", comment);
            model.addAttribute("link", current_link);
            model.addAttribute("success",model.containsAttribute("success"));
            return "link/view";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link",new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            logger.info("Validation errors were found while submitting a new link.");
            model.addAttribute("link",link);
            return "link/submit";
        } else {
            // save our link
            linkService.addLink(link);
            logger.info("New link was saved successfully");
            redirectAttributes
                    .addAttribute("id",link.getId())
                    .addFlashAttribute("success",true);
            return "redirect:/link/{id}";
        }
    }

    @Secured({"ROLE_USER"})
    @PostMapping("/link/comments")
    public String addComment(@Valid Comment comment, BindingResult bindingResult) {
        if ( bindingResult.hasErrors() ) {
            logger.info("There was a problem in add this comment");
        } else  {
            commentService.addComment(comment);
            logger.info("new comment was saved successfully");
        }

        return "redirect:/link/" + comment.getLink().getId();
    }

}
