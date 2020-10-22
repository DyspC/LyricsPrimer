package fr.enssat.dysp.lyrics;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResourceBasedTest {

    private static final Path EXPECTED_FOLDER = Path.of("src/test/resources/out");

    private static final Path SAMPLE_FOLDER = Path.of("src/test/resources/in");

    public static final Map<String, Function<String, String>> PROCESSORS = Map.of(
            "split", Traitement::traiter,
            "optimize", Traitement::optimize,
            "chorus", Traitement::splitThatShit
    );
    public static final String SAMPLE_SUFFIX = ".sample";

    @BeforeClass
    public static void setUp() {
        Traitement.init();
    }

    @Test
    public void resourceBased() throws IOException {
        Assert.assertEquals("All resources should have passed execution",
                Collections.emptyList(),
                Files.list(EXPECTED_FOLDER)
                        .filter(Files::isRegularFile)
                        .filter(path -> path.toString().endsWith(SAMPLE_SUFFIX))
                        .flatMap(path -> {
                            System.out.printf("Found test resource: '%s'%n" , path);
                            try {
                                executeOnce(path);
                                return Stream.empty();
                            } catch (IOException | AssertionError e) {
                                e.printStackTrace();
                                return Stream.of(path);
                            }
                        }).collect(Collectors.toList()));
    }

    private void executeOnce(Path resource) throws IOException {
        final String resourceContent = Files.readString(resource, StandardCharsets.UTF_8);
        final String[] composite = resource.getFileName().toString().split("\\.");

        Path sourcePath = SAMPLE_FOLDER.resolve(composite[0] + SAMPLE_SUFFIX);
        String tmp = Files.readString(sourcePath, StandardCharsets.UTF_8);
        for (int i = 1; i < composite.length - 1; i++) {
            String operationKey = composite[i];
            Function<String, String> operation = PROCESSORS.get(operationKey);
            System.out.printf("Executing operation '%s'%n", operationKey);
            if(operation == null) {
                throw new UnsupportedOperationException("No lyrics operation exists for name: " + operationKey);
            } else {
                tmp = operation.apply(tmp);
            }
        }
        Assert.assertEquals(resourceContent, tmp);
    }



}
