package com.nurgunmakarov.module3.service;

import com.nurgunmakarov.module3.dto.SomeDTO;
import com.nurgunmakarov.module3.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Getter
@Setter
public class SomeClass {
    private Map<Long, SomeDTO> someInfo;
    private Long id = 4L;

    public SomeClass() {
        this.someInfo = new HashMap<Long, SomeDTO>();
        init();
    }

    public SomeDTO put(SomeDTO someDTO) {
        SomeDTO newSomeDTO = new SomeDTO(id++, someDTO.getSomeText());
        someInfo.put(id++, newSomeDTO);
        return newSomeDTO;
    }

    public SomeDTO get(Long id) {
        if (someInfo.get(id) != null) {
            return someInfo.get(id);
        } else
            throw new NotFoundException();
    }

    public boolean replace(SomeDTO someDTO) {
        if (someInfo.containsKey(someDTO.getId())) {
            someInfo.put(someDTO.getId(), someDTO);
            return true;
        } else
            return false;
    }


    public void delete(Long id) {
        if (someInfo.get(id) != null) {
            someInfo.remove(id);
        } else
            throw new NotFoundException();
    }

    public void init() {
        someInfo.put(1L, new SomeDTO(1, "bla bla"));
        someInfo.put(2L, new SomeDTO(2, "чух-чух"));
        someInfo.put(3L, new SomeDTO(3, "гав-гав"));
    }

}
