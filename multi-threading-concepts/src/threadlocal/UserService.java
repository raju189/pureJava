package threadlocal;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class UserService {

	public static void main(String[] args) {
		new Thread(() -> {
			String birthDate = new UserService().birthDate(100);
			System.out.println(birthDate);
		});
	}

	private String birthDate(int userId) {
		LocalDate date = birthDateFromDB(userId);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	private LocalDate birthDateFromDB(int userId) {
		return LocalDate.now();
	}

}
