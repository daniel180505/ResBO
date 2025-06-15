/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package s12.proyec.restaurantee;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Modelo.Usuario;

import java.io.FileOutputStream;
import java.util.List;

public class ExportadorExcel {

    public static void exportarUsuarios(List<Usuario> lista) {
        try (Workbook libro = new XSSFWorkbook()) {
            Sheet hoja = libro.createSheet("Usuarios");
            Row header = hoja.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Nombre");
            header.createCell(2).setCellValue("DNI");
            header.createCell(3).setCellValue("Rol");

            int fila = 1;
            for (Usuario u : lista) {
                Row row = hoja.createRow(fila++);
                row.createCell(0).setCellValue(u.getId());
                row.createCell(1).setCellValue(u.getNombre());
                row.createCell(2).setCellValue(u.getDni());
                row.createCell(3).setCellValue(u.getRol());
            }

            try (FileOutputStream out = new FileOutputStream("usuarios.xlsx")) {
                libro.write(out);
            }

            System.out.println("Exportación exitosa.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
