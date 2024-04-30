package com.kintong.idlanalysis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kintong.idlanalysis.entity.Eduction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author kintong
 */

public interface EducationService extends IService<Eduction> {

    public List<Eduction> getEducation();

}
