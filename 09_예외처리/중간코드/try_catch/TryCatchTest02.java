package try_catch;

public class TryCatchTest02 {
	public static void main(String[] args) {
		// 발생할 수 있는 예외가 여러개라면?
		int[] nums = { 10 };

		try {
			System.out.println("정상 수행 코드1");
			Class.forName(null);
			System.out.println(10 / 0);
			System.out.println(nums[10]); // 예외가 발생할 수도 있는 코드!
			System.out.println("정상 수행 코드2");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 에러 발생!");
		} catch (ArithmeticException e) {
			System.out.println("수학적인 이슈 발생!");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 이슈 발생");
		}
		System.out.println("프로그램 종료");
		/////////////////////////////////////////////////////////
		try {
			System.out.println("정상 수행 코드1");
			Class.forName(null);
			System.out.println(10 / 0);
			System.out.println(nums[10]); // 예외가 발생할 수도 있는 코드!
			System.out.println("정상 수행 코드2");
		} catch (ArrayIndexOutOfBoundsException | ArithmeticException | ClassNotFoundException e) {
			if(e instanceof ArithmeticException) {
				System.out.println("수학적인 이슈 발생!");
			}
			System.out.println("인덱스 에러 발생!");
			System.out.println("클래스 이슈 발생");
		}
		System.out.println("프로그램 종료");
	}
}
