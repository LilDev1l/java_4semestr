package math;


import junit.framework.TestCase;
import org.junit.*;

public class MyMathTest {
    @BeforeClass
    public static void setUpAll() {
        System.out.println("@BeforeClass");
    }
    @Before
    public void setUp() {
        System.out.println("@Before");
    }

    @Test(timeout = 200)
    public void sum() {
        int result = new MyMath().sum(3,2);
        TestCase.assertEquals(5, result);
    }

    @Ignore("ignored")
    @Test
    public void test() {
    }

    @After
    public void tearDown() {
        System.out.println("@After");
    }
    @AfterClass
    public static void tearDownAll() {
        System.out.println("@AfterClass");
    }
}