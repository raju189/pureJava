package threadlocal;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeFormatter {
	public static ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}

		@Override
		public SimpleDateFormat get() {
			return super.get();
		}
	};
	
	
	//Java 8  with FactoryMethod is withIntitial
	public static ThreadLocal<SimpleDateFormat> df8 = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

		//Each Thread has it's own TheadLocal object so only 10 SimpleDateFormat object created.
		for(int i=0; i< 1000; i++) {
			int userId = i;
			fixedThreadPool.submit(() -> {
				System.out.println(birthDate(userId));
			});
		}
	}

	private static String birthDate(int userId) {
		LocalDate date = birthDateFromDB(userId);
		SimpleDateFormat simpleDateFormat = ThreadSafeFormatter.df.get();
		return simpleDateFormat.format(date);
	}

	private static LocalDate birthDateFromDB(int userId) {
		return LocalDate.now();
	}
}
