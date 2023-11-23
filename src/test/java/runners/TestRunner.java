package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite

@IncludeEngines("cucumber")

@SelectClasspathResource("featurefiles")

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:reports/result.html")
public class TestRunner {
}

