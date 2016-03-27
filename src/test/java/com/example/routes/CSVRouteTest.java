package com.example.routes;

import com.example.DemoApplication;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class CSVRouteTest extends CamelTestSupport {

    private static String mockCSVFileName = "mockCSV.csv";
    private static String mockCSVFileNameWithPath = "files/csv/" + mockCSVFileName;
    private static String mockJSONFileNameWithPath = "files/out/" + mockCSVFileName + "_1.out.csv";
    private static String mockCSVBody = "Test11;Test12;Test13;Test14\nTest21;Test22;Test33;Test44";

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {

        File in = new File(mockCSVFileNameWithPath);
        in.deleteOnExit();

        File out = new File(mockJSONFileNameWithPath);
        out.deleteOnExit();
    }

    @Override
    public RouteBuilder createRouteBuilder() {
        return new CSVRoute();
    }

    @Test
    public void testParseFile() throws InterruptedException {

        template.sendBodyAndHeader("file:files/csv", mockCSVBody, Exchange.FILE_NAME, mockCSVFileName);

        Thread.sleep(10000);

        File target = new File(mockJSONFileNameWithPath);

        assertTrue("File does not exist", target.exists());
    }
}
