package io.quarkus.devtools.codestarts.quarkus;

import static io.quarkus.devtools.codestarts.quarkus.FakeExtensionCatalog.FAKE_EXTENSION_CATALOG;
import static io.quarkus.devtools.codestarts.quarkus.FakeExtensionCatalog.FAKE_QUARKUS_CODESTART_CATALOG;
import static io.quarkus.devtools.codestarts.quarkus.QuarkusCodestartCatalog.Language.JAVA;
import static io.quarkus.devtools.codestarts.quarkus.QuarkusCodestartCatalog.Language.KOTLIN;
import static io.quarkus.devtools.codestarts.quarkus.QuarkusCodestartCatalog.Language.SCALA;

import io.quarkus.devtools.testing.codestarts.QuarkusCodestartTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

class RESTEasyCodestartTest {

    @RegisterExtension
    public static QuarkusCodestartTest codestartTest = QuarkusCodestartTest.builder()
            .quarkusCodestartCatalog(FAKE_QUARKUS_CODESTART_CATALOG)
            .extensionCatalog(FAKE_EXTENSION_CATALOG)
            .codestarts("resteasy")
            .languages(JAVA, KOTLIN, SCALA)
            .build();

    @Test
    void testContent() throws Throwable {
        codestartTest.checkGeneratedSource("org.acme.GreetingResource");
        codestartTest.checkGeneratedTestSource("org.acme.GreetingResourceTest");
        codestartTest.checkGeneratedTestSource("org.acme.NativeGreetingResourceIT");
    }

}
