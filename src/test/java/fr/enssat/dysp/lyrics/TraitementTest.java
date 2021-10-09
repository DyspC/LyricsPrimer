package fr.enssat.dysp.lyrics;

import fr.enssat.dysp.lyrics.logic.Traitement;
import org.junit.BeforeClass;
import org.junit.Test;

import static fr.enssat.dysp.lyrics.utils.TestFileUtils.extractFromResource;
import static org.junit.Assert.assertEquals;

public class TraitementTest {

    @BeforeClass
    public static void setUp() {
        Traitement.init();
    }

    @Test
    public void testTraiter_EvangelionSplitFullKanji() {

        String inputContent = extractFromResource("in/EvangelionOPFullKanji.sample");
        String expectedContent = extractFromResource("out/EvangelionOPFullKanji.split.sample");

        String actual = Traitement.traiter(inputContent);

        assertEquals(actual, expectedContent);

    }

    @Test
    public void testTraiter_EvangelionSplitFullRomaji() {

        String inputContent = extractFromResource("in/EvangelionOPFullRomaji.sample");
        String expectedContent = extractFromResource("out/EvangelionOPFullRomaji.split.sample");

        String actual = Traitement.traiter(inputContent);

        assertEquals(actual, expectedContent);
    }

    @Test
    public void testTraiter_WhenBlankInput_ReturnEmptyString() {
        assertEquals("", Traitement.traiter(null));
    }

    @Test
    public void testTraiter_EvangelionRomajiSplitOptimizeAndSplitThatShit() {

        String inputContent = extractFromResource("in/EvangelionOPFullRomaji.sample");

        String trait = Traitement.traiter(inputContent);

        String expectedContent = extractFromResource("out/EvangelionOPFullRomaji.split.optimize.sample");
        String expectedSplitThatShit = extractFromResource("out/EvangelionOPFullRomaji.split.optimize.chorus.sample");

        String actualOptimize = Traitement.optimize(trait);

        assertEquals(actualOptimize, expectedContent);

        String splitThatShitActual = Traitement.splitThatShit(actualOptimize);

        assertEquals(splitThatShitActual, expectedSplitThatShit);

    }


}
