package interfaces;

interface F { //인터페이스 F
	double apply(double x); //double형을 받아 dobule형을 리턴하는 apply라는 메소드를 구현해야함
}

public class IntegralTest {
	public static double integral(F f, double a, double b, int n) { //f인 함수를 a에서 b까지 n개로 쪼개서 적분하는 함수
		//인터페이스 F형 f를 파라미터로 가지며 람다식 표현에 의해 f를 사용당시에 정의할수 있음
		int i; 
		double sum = 0; 
		double dt = (b - a) / n; //쪼개진 조각의 각 밑변
		for (i = 0; i < n; i++) {
			sum += f.apply(a + (i + 0.5) * dt); 
			//apply 메소드는 아직 정해지지 않았지만 f에 대입되는 람다식에 따라 달라질 수 있다.  
			//apply 메소드는  double형 인자 한개를 가지고 double형 값을 리턴하도록 구현된다.
		}
		return sum * dt;
	}

	public static void main(String[] args) {
		F f;
		double r;
		f = (x) -> {return (Math.sin(x));}; //f 변수의 인터페이스의 apply에 람다식으로 함수를 구현하는 모습 => "f(x) = sin(x)" 로 변경하였다!
		
		//f = x ->  sin(x) ; //축약버전
		
		r = integral(f, 0, 10, 100); //apply가 구현된 f를 가지고 구분구적법으로 적분
		System.out.printf("sin(x)=x, 0, 10, 100: %.5f%n", r); //소숫점 다섯자리까지 표현  => "f(x) = sin(x)" 로 변경하였다!
	}
}