package chapter3.exercise2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Exercise2Test {
    Exercise2 exercise2;

    @BeforeAll
    public void BeforeAll(){
        exercise2 = new Exercise2();
    }
}