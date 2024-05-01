package com.bookstore.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/bookstore/step_defs",
        plugin = {
                "html:target/default-html-reports.html"
        },
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner extends AbstractTestNGCucumberTests {
}
