package StepDef;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Hooks {

    @BeforeAll
    public static void setUp(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("After All");
    }

    @Before
    public static void beforeTest(){
        System.out.println("Before Test");
    }

    @After
    public static void afterTest(){
        System.out.println("After Test");
    }
}
