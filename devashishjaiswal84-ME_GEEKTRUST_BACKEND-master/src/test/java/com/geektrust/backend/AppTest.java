// package com.geektrust.backend;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// @DisplayName("App Test")
// class AppTest {

//     @Test
//     public void Application_Test() throws Exception{
//         // Arrange
//         // Act   
//         // Assert
//         Assertions.assertTrue(true);
//     }

// }

package com.geektrust.backend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@DisplayName("App Test")
class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Integration Test #1")
    void runTest1() {
        // Arrange
        //List<String> arguments= new ArrayList<>(List.of("input1.txt"));
        String argument = "sample_input/input1.txt";

        String expectedOutput = "SUB_TOTAL 13000.00\n" +
                "COUPON_DISCOUNT B4G1 2500.00\n" +
                "TOTAL_PRO_DISCOUNT 0.00\n" +
                "PRO_MEMBERSHIP_FEE 0.00\n" +
                "ENROLLMENT_FEE 0.00\n" +
                "TOTAL 10500.00";

        // Act
        App.run(argument);

        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #2")
    void runTest2() {
        // Arrange
        //List<String> arguments= new ArrayList<>(List.of("input1.txt"));
        String argument = "sample_input/input2.txt";

        String expectedOutput = "SUB_TOTAL 10000.00\n" +
                "COUPON_DISCOUNT DEAL_G20 2000.00\n" +
                "TOTAL_PRO_DISCOUNT 0.00\n" +
                "PRO_MEMBERSHIP_FEE 0.00\n" +
                "ENROLLMENT_FEE 0.00\n" +
                "TOTAL 8000.00";

        // Act
        App.run(argument);

        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #3")
    void runTest3() {
        // Arrange
        //List<String> arguments= new ArrayList<>(List.of("input1.txt"));
        String argument = "sample_input/input3.txt";

        String expectedOutput = "SUB_TOTAL 8555.00\n" +
                "COUPON_DISCOUNT DEAL_G5 427.75\n" +
                "TOTAL_PRO_DISCOUNT 145.00\n" +
                "PRO_MEMBERSHIP_FEE 200.00\n" +
                "ENROLLMENT_FEE 0.00\n" +
                "TOTAL 8127.25";

        // Act
        App.run(argument);

        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #4")
    void runTest4() {
        // Arrange
        //List<String> arguments= new ArrayList<>(List.of("input1.txt"));
        String argument = "sample_input/input4.txt";

        String expectedOutput = "SUB_TOTAL 5615.00\n" +
                "COUPON_DISCOUNT NONE 0.00\n" +
                "TOTAL_PRO_DISCOUNT 85.00\n" +
                "PRO_MEMBERSHIP_FEE 200.00\n" +
                "ENROLLMENT_FEE 500.00\n" +
                "TOTAL 6115.00";

        // Act
        App.run(argument);

        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #5")
    void runTest5() {
        // Arrange
        //List<String> arguments= new ArrayList<>(List.of("input1.txt"));
        String argument = "sample_input/input5.txt";

        String expectedOutput = "SUB_TOTAL 17790.00\n" +
                "COUPON_DISCOUNT B4G1 2475.00\n" +
                "TOTAL_PRO_DISCOUNT 410.00\n" +
                "PRO_MEMBERSHIP_FEE 200.00\n" +
                "ENROLLMENT_FEE 0.00\n" +
                "TOTAL 15315.00";

        // Act
        App.run(argument);

        // Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}