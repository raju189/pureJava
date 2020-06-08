package threadlocal;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GlobalShareObject {

	public static void main(String[] args) {
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		//this is not thread safe due to multiple threads are access same object
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i< 1000; i++) {
			int userId = i;
			fixedThreadPool.submit(() -> {
				System.out.println(birthDate(userId, simpleDateFormat));
			});
		}
	}

	private static String birthDate(int userId, SimpleDateFormat simpleDateFormat) {
		LocalDate date = birthDateFromDB(userId);
		return simpleDateFormat.format(date);
	}

	private static LocalDate birthDateFromDB(int userId) {
		return LocalDate.now();
	}

}
