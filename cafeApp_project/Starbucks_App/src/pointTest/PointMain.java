package pointTest;

public class PointMain {
	
	public static void main(String[] args) {
		
		
		
		Point point = new Point();

		System.out.println(point.readPoint("park1234")); // 포인트 확인하기
		
		
		point.savePoint("park1234", 4000);
		System.out.println(point.readPoint("park1234")); // 포인트 확인하기
		
		
		point.usePoint("park1234", 3000); //포인트 사용하기
		System.out.println(point.readPoint("park1234")); // 포인트 확인하기
	}
	
	
	

}
