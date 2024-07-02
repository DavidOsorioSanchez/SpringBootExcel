package com.riwi.localstorage.controller;

import com.riwi.localstorage.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@AllArgsConstructor
@RestController
public class ReportRestController {
    //conexion with the service file
    @Autowired
    private final ReportService reportService;

    //new important endpoint for generate the excel file
    @GetMapping(path = "/excel")
    public void  generateExcelResport(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String hearderKey = "content-Disposition";
        String headerValue = "attachment; filename=LocalstorageReporte.xlsx";
        response.setHeader(headerValue,hearderKey);
        reportService.generateExcel(response);
    }
}
