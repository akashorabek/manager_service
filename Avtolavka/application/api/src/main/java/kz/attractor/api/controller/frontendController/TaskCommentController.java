package kz.attractor.api.controller.frontendController;

import kz.attractor.api.dto.ContactDtoAdd;
import kz.attractor.api.dto.TaskCommentDto;
import kz.attractor.api.dto.TaskCommentDtoAdd;
import kz.attractor.api.dto.TaskDto;
import kz.attractor.api.service.TaskCommentService;
import kz.attractor.datamodel.model.TaskComment;
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

@Controller
@RequiredArgsConstructor
public class TaskCommentController {

    private final TaskCommentService taskCommentService;

    @GetMapping("/task")
    public String showTaskCommentsPage(Model model,
                                @PageableDefault(sort = {"status"}, direction = Sort.Direction.DESC, size = 5) Pageable pageable) {
        Page<TaskCommentDto> taskCommentDtos = taskCommentService.findAll(pageable);
        model.addAttribute("page", taskCommentDtos);
        return "task";
    }
    @GetMapping("/tasks/{id}/comments/add")
    public String add(@PathVariable long id, Model model) {
        model.addAttribute("taskId", id);
        return "comment-add";
    }

    @PostMapping("comment-add")
    public String add(TaskCommentDtoAdd form) {
        taskCommentService.add(form);
        return "redirect:/tasks/" + form.getTaskId();
    }
}
