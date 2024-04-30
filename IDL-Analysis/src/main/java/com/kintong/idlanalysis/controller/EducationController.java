package com.kintong.idlanalysis.controller;

import com.kintong.idlanalysis.entity.Eduction;
import com.kintong.idlanalysis.service.EducationService;
import com.kintong.idlanalysis.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author kintong
 */
@RestController
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:5173")

public class EducationController {

    @Autowired
    EducationService educationService;

    @GetMapping
    public ApiResult<List<Eduction>> demo() {
        return ApiResult.success(educationService.getEducation());
    }

}
