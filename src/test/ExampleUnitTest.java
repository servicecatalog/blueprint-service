import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.doNothing;

/**
 * Created by PLGrubskiM on 2017-05-24.
 */
public class ExampleUnitTest {

    @Before
    public void someBeforeMethod() {
        doNothing();
    }

    @Test
    public void someUnitTest() {
        Assert.assertTrue(true);
    }
}
