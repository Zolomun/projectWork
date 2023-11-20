package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;


    //Jelzem, hogy JUnit5-tal akarok futtatni
    @Suite
//Jelzem,hogy cucumber tesztet akarok futtatni
    @IncludeEngines("cucumber")
//Jelzem, hogy melyik mappa tesztjeit akarom futtatni
    @SelectClasspathResource("featurefiles")
//Jelzem,hogy melyik fájlt akarom futtatni
//@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/featurefiles/budapestgo.feature")
//Szűröm a teszteket tag alapján
//    @IncludeTags("demo")
//Milyen riportot szeretnék látni
    @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:reports/result.html")
    public class TestRunner {
    }

