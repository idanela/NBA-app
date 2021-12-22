package com.idanElazar.nba;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NbaApplicationTests {

	 Calculator calculator = new Calculator();
	@Test
	void itShouldAddNumbers() {
		//given
		int num1= 20;
		int num2 = 30;
		//when
		int result = calculator.add(num1,num2);
		//then
		assertThat(result).isEqualTo(50);
	}

	class Calculator{
		int add(int a,int b)
		{
			return a+b;
		}
	 }

}
