package try_catch;

public class TryCatchTest01 {
	public static void main(String[] args) {
		int[] nums = {10};
		
		try {
			System.out.println("정상 수행 코드1");
			System.out.println(nums[10]); //예외가 발생할 수도 있는 코드!
			System.out.println("정상 수행 코드2");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 에러 발생!");
		}
		System.out.println("프로그램 종료");
	}
}
