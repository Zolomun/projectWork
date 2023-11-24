package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite

@IncludeEngines("cucumber")

@SelectClasspathResource("featurefiles")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "java.tesco.pages,java.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:reports/cucumber-reports.json")

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:reports/result.html")
public class TestRunner {
}

