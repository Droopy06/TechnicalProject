import org.junit.Before;
import org.testng.annotations.Test;
import templates.carpooling.DataValidator;
import templates.carpooling.impl.DataValidatorImpl;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by LAMOOT Alexandre on 15/04/2016.
 */
public class DataValidatorTest {
    private DataValidator dataValidator;
    @Before
    public void setUp() {
        dataValidator = new DataValidatorImpl();
    }
    @Test
    public void testDateIsNull() {
        setUp();
        assertFalse(dataValidator.dateValidate(null, "dd/MM/yyyy"));
    }
    @Test
    public void testDayIsInvalid() {
        setUp();
        assertFalse(dataValidator.dateValidate("32/02/2012", "dd/MM/yyyy"));
    }
    @Test
    public void testMonthIsInvalid() {
        setUp();
        assertFalse(dataValidator.dateValidate("31/20/2012", "dd/MM/yyyy"));
    }
    @Test
    public void testYearIsInvalid() {
        setUp();
        assertFalse(dataValidator.dateValidate("31/20/19991", "dd/MM/yyyy"));
    }
    @Test
    public void testDateFormatIsInvalid() {
        setUp();
        assertFalse(dataValidator.dateValidate("2012/02/20", "dd/MM/yyyy"));
    }
    @Test
    public void testDateIsValid() {
        setUp();
        assertTrue(dataValidator.dateValidate("31/01/2012", "dd/MM/yyyy"));
    }
}
