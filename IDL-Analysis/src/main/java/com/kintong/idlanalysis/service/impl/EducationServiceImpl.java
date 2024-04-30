package com.kintong.idlanalysis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kintong.idlanalysis.entity.Eduction;
import com.kintong.idlanalysis.mapper.EducationMapper;
import com.kintong.idlanalysis.service.EducationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author kintong
 */
@Service
public class EducationServiceImpl extends ServiceImpl<EducationMapper, Eduction> implements EducationService {

    @Override
    public List<Eduction> getEducation(){
        return  this.list();
    }
}
