package com.app.taskey.controller;

import com.app.taskey.models.Task;
import com.app.taskey.services.TaskSevice;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Data
public class TaskController {
    private  final TaskSevice taskSevice;

    public TaskController(TaskSevice taskSevice) {
        this.taskSevice = taskSevice;
    }

    @GetMapping ("/")
    public  String getAllTask(Model model){
        List<Task> tasks = taskSevice.getAllTask();
        model.addAttribute("tasks",tasks);
        return  "tasks";
    }
    @GetMapping("/{id}/delete")
    public String deleteTaskbyid(@PathVariable("id") Long id){
        taskSevice.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskSevice.toggleTask(id);
        return "redirect:/";
    }



    @PostMapping ("/")
    public String createTask( @RequestParam String  title){
        taskSevice.createtask(title);
        return "redirect:/";

    }

}
