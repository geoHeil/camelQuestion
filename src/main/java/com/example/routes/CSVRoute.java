package com.example.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CSVRoute extends RouteBuilder {

    @Value("${file.inputPath}")
    private String filePath;

    @Value("${file.outputPath}")
    private String outputFilepath;

    @Override
    public void configure() throws Exception {

        // SET DELIMITER
        CsvDataFormat csvFormat = new CsvDataFormat();
        csvFormat.setQuoteDisabled(true);
        csvFormat.setDelimiter(";");

        from("file:" + filePath + "/?noop=true\"") // FILE PATH FROM PROPERTIES
                .to("file:" + filePath);
    }
}
