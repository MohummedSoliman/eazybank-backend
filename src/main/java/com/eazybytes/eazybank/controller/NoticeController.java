package com.eazybytes.eazybank.controller;

import com.eazybytes.eazybank.model.Notice;
import com.eazybytes.eazybank.repositry.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticeController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("notices")
    public List<Notice> getNotices(){
        return noticeRepository.findAllActiveNotices();
    }
}
