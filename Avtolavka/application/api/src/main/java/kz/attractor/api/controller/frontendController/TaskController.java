package kz.attractor.api.controller.frontendController;

import kz.attractor.api.dto.ClientDtoAdd;
import kz.attractor.api.dto.TaskDto;
import kz.attractor.api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/tasks")
    public String showTasksPage(Model model,
                                @PageableDefault(sort = {"status"}, direction = Sort.Direction.DESC, size = 10) Pageable pageable) {
        Page<TaskDto> tasks = service.findAll(pageable);
        model.addAttribute("page", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String showTask(@PathVariable long id, Model model) {
        TaskDto task = service.findById(id);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("/tasks/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        TaskDto task = service.findById(id);
        model.addAttribute("task", task);
        return "client-edit";
    }

    @PostMapping("task-edit")
    public String edit(@Valid TaskDto taskDto,
                       BindingResult validationResult,
                       RedirectAttributes attributes) {
        attributes.addFlashAttribute("task", taskDto);
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/tasks/" + taskDto.getId() + "/edit";
        }
        service.update(taskDto);
        return "redirect:/tasks/" + taskDto.getId();
    }

    @GetMapping("/tasks/add")
    public String add() {
        return "tasks-add";
    }

    @PostMapping("tasks-add")
    public String add(@Valid TaskDto form,
                      BindingResult validationResult,
                      RedirectAttributes attributes) {
        attributes.addFlashAttribute("form", form);
        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/tasks/add";
        }
        service.add(form);
        return "redirect:/tasks";
    }

}
