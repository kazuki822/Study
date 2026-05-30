package com.example.demo.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    CalculatorTest calc;

    @BeforeEach
    void setUp() {
        calc = new CalculatorTest();
    }

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    private @Nullable Integer add(int i, int j) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@AfterEach
    void tearDown() {
        // 後処理（必要なら）
    }
}