package com.example.resttemplate.resttemplateexample.service;

import com.example.resttemplate.resttemplateexample.exception.AlreadyExistsException;
import com.example.resttemplate.resttemplateexample.exception.BaseExceptionEnum;
import com.example.resttemplate.resttemplateexample.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TestExceptionService {

    private boolean flag;

    public void findData(){

        if (flag){
            System.out.println("get data..");
        }else {
            throw new DataNotFoundException(BaseExceptionEnum.DATA_NOTFOUND_EXCEPTION);
        }

    }

    public Long saveData(Long id){
        if (id==1L){
            throw new AlreadyExistsException(BaseExceptionEnum.ALREADYEXISTS_EXCEPTION);
        }

        return id;
    }
}
