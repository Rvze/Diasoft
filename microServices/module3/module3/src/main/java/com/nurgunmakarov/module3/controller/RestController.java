package com.nurgunmakarov.module3.controller;

import com.nurgunmakarov.module3.dto.SomeDTO;
import com.nurgunmakarov.module3.exception.NotFoundException;
import com.nurgunmakarov.module3.service.SomeClass;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("some")
@AllArgsConstructor
public class RestController {
    private final SomeClass someClass = new SomeClass();

    @GetMapping
    public Map<Long, SomeDTO> list() {
        return someClass.getSomeInfo();
    }

    @GetMapping("{id}")
    public SomeDTO getOne(@PathVariable long id) {
        return someClass.get(id);
    }

    @PostMapping()
    public SomeDTO create(@RequestBody SomeDTO someDTO) {
        return someClass.put(someDTO);
    }

    @PutMapping("{id}")
    public SomeDTO update(@RequestBody SomeDTO someDTO) {
        if (someClass.replace(someDTO))
            return someDTO;
        else
            throw new NotFoundException();

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        someClass.delete(id);
    }
}
