package com.techelevator.reader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditFile {

    File auditReport = new File("audit.txt");
String dateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("mm/dd/yyyy h:mm:ss "));

    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(auditReport, true))) {
            writer.println(dateAndTime + " "+" ");


        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
    }

