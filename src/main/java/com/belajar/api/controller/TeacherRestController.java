package com.belajar.api.controller;

import com.belajar.api.entity.Teacher;
import com.belajar.api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherRestController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return teacherService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        return teacherService.getById(id);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody Teacher teacher) {
        return teacherService.update(teacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return teacherService.delete(id);
    }
}
