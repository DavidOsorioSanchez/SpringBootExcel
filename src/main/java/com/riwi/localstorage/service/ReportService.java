package com.riwi.localstorage.service;

import com.riwi.localstorage.entities.EjemploEntidad;
import com.riwi.localstorage.repository.EjemploRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {

    @Autowired
    private final EjemploRepository ejemploRepository;

    public void generateExcel(HttpServletResponse response) throws IOException {
        List<EjemploEntidad> ejemploEntidads = ejemploRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheets = workbook.createSheet("courses info");
        HSSFRow row = sheets.createRow(0);

        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("name");
        row.createCell(2).setCellValue("lastname");
        row.createCell(3).setCellValue("price");

        int dataRowIndex = 1;

        for (EjemploEntidad ejemploEntidad : ejemploEntidads){
            HSSFRow datarow = sheets.createRow(dataRowIndex);
            datarow.createCell(0).setCellValue(ejemploEntidad.getId());
            datarow.createCell(1).setCellValue(ejemploEntidad.getName());
            datarow.createCell(2).setCellValue(ejemploEntidad.getLastname());
            datarow.createCell(3).setCellValue(ejemploEntidad.getPrice());
            dataRowIndex ++;
        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }

}
