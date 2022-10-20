package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rikkei.academy.model.Song;
import rikkei.academy.model.SongForm;
import rikkei.academy.service.category.ICategoryService;
import rikkei.academy.service.song.ISongService;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class SongController {

    ISongService songService;
    ICategoryService categoryService;

    public SongController(ISongService songService, ICategoryService categoryService) {
        this.songService = songService;
        this.categoryService = categoryService;
    }

    @GetMapping({"/", "/song"})
    public String showList(Model model) {
        model.addAttribute("songs", songService.findAll());
        System.out.println(songService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("songForm", new SongForm());
        model.addAttribute("categories", categoryService.findAll());
        return "create";
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/save")
    public String save(SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getSong();

        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getSinger(), songForm.getCategory().stream().map(integer -> categoryService.findById(integer)).collect(Collectors.toList()), fileName);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Song saved successfully.");
        return "redirect:/create";
    }

    @GetMapping("/{id}/listen")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "listen";
    }
}