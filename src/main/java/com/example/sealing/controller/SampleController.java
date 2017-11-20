package com.example.sealing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sealing.bean.PlayerCsvBean;
import com.example.sealing.service.PlayerService;
import com.example.sealing.service.SampleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@RestController
public class SampleController {
    @Autowired
    private SampleService service;
    @Autowired
    private PlayerService playerService;

    @GetMapping("/sample")
    public String sample() {
        return service.getUsername();
    }

    @GetMapping(value="/sample.csv", produces="text/csv;charset=utf-8;Content-Disposition:attachment")
    public String csv() throws JsonProcessingException {
        List<PlayerCsvBean> rows = playerService.getCsvFormatList();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(PlayerCsvBean.class).withHeader();
        mapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
        return mapper.writer(schema).writeValueAsString(rows);
    }
}
