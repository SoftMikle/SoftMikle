import lambdas.poetry.PoetryUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;

public class PoetryTests {
    PoetryUtil poetryUtil;
    List<String> listOfPoetry;

    @Before
    public void initializer() {
        poetryUtil = new PoetryUtil();
        listOfPoetry = asList(
                "Совсем исхудал,",
                "И волосы отросли.",
                "Долгие дожди.");
        poetryUtil.showStatistics(listOfPoetry);
    }

    @Test
    public void poetryTest() {
        Assert.assertEquals(poetryUtil.getPunctuationMarksCounter().get(), 3);
        Assert.assertEquals(poetryUtil.getVowelsCounter().get(), 17);
        Assert.assertEquals(poetryUtil.getConsonantsCounter().get(), 21);
        Assert.assertEquals(poetryUtil.getPrepositionsCounter().get(), 0);
    }
}
