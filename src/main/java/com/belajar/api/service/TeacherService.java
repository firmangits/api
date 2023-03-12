package com.belajar.api.service;

import com.alibaba.fastjson.JSONObject;
import com.belajar.api.entity.Teacher;
import com.belajar.api.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    MediaType jsonType = MediaType.APPLICATION_JSON;

    public ResponseEntity<?> save(Teacher teacher) {
        if (teacher.getName().isEmpty())
            return ResponseEntity.badRequest().contentType(jsonType).body(responseMsg("Name can't be empty"));
        if (teacher.getAge() < 1)
            return ResponseEntity.badRequest().contentType(jsonType).body(responseMsg("Age can't be zero"));
        return ResponseEntity.ok().contentType(jsonType).body(teacherRepository.save(teacher));
    }

    public ResponseEntity<?> getAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty())
            return ResponseEntity.ok().contentType(jsonType).body(responseMsg("Data is empty"));
        return ResponseEntity.ok().contentType(jsonType).body(teacherRepository.findAll());
    }

    public ResponseEntity<?> getById(long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (!teacher.isPresent())
            return ResponseEntity.badRequest().contentType(jsonType).body(responseMsg("Data not found for ID : " + id));
        return ResponseEntity.ok().contentType(jsonType).body(teacherRepository.findById(id));
    }

    public ResponseEntity<?> update(Teacher teacher) {
        if (teacher.getName().isEmpty())
            return ResponseEntity.badRequest().contentType(jsonType).body(responseMsg("Name can't be empty"));
        if (teacher.getAge() < 1)
            return ResponseEntity.badRequest().contentType(jsonType).body(responseMsg("Age can't be zero"));
        Optional<Teacher> teacherFindId = teacherRepository.findById(teacher.getId());
        if (!teacherFindId.isPresent())
            return ResponseEntity.badRequest().contentType(jsonType).body(responseMsg("Data not found for ID : " + teacher.getId()));
        return ResponseEntity.ok().contentType(jsonType).body(teacherRepository.save(teacher));
    }

    public ResponseEntity<?> delete(long id) {
        Optional<Teacher> teacherFindId = teacherRepository.findById(id);
        if (!teacherFindId.isPresent())
            return ResponseEntity.badRequest().contentType(jsonType).body(responseMsg("Data not found for ID : " + id));
        teacherRepository.deleteById(id);
        return ResponseEntity.ok().contentType(jsonType).body(responseMsg("Deleted Successfully"));
    }

    private JSONObject responseMsg(String message) {
        JSONObject body = new JSONObject(true);
        body.put("message", message);
        return body;
    }
}
