package com.example.club.crud;

import com.example.club.common.Api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class CRUDAbstractApiController<DTO, ENTITY> implements CRUDInterface<DTO> {
    @Autowired(required = false)
    private CRUDAbstracService<DTO, ENTITY> crudAbstracService;

    @PostMapping("")
    @Override
    public DTO creat(@RequestBody DTO dto) {
        return crudAbstracService.creat(dto);
    }

    @GetMapping("/id/{id}")
    @Override
    public Optional<DTO> read(@PathVariable Long id) {
        return crudAbstracService.read(id);
    }

    @PutMapping("")
    @Override
    public DTO update(@Valid @RequestBody DTO dto) {
        return crudAbstracService.update(dto);
    }

    @DeleteMapping("")
    @Override
    public void delete(@PathVariable Long id) {
        crudAbstracService.delete(id);
    }

    @GetMapping("/all")
    @Override
    public Api<List<DTO>> list(@PageableDefault Pageable pageable) {
        return crudAbstracService.list(pageable);
    }

}
