package com.salesianostriana.tribici.controller;

import com.salesianostriana.tribici.model.Use;
import com.salesianostriana.tribici.service.UseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/use")
@RequiredArgsConstructor
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class UseController {

    private final UseService useService;

    @GetMapping("/user/{id}")
    public Page<Use> getAllUse(
            @PathVariable
            Long id,
            @PageableDefault
            Pageable pageable
    ) {
        return useService.findUseByUserId(id, pageable);
    }

}
