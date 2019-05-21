package com.pupsikan.chart;


import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class Controller {


    @SneakyThrows
    private String readData() {
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("GenderProbability.json").toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;


    }



    @GetMapping(value="/data", produces = MediaType.APPLICATION_JSON_VALUE)
    String allData() {
        return readData();
    }
}
