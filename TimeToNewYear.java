import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Считает время до следующего нового года
 *
 * @author Фомченков Вячеслав
 * @version 31.12.16
 */
public class TimeToNewYear implements ITimeToNewYear
{
	// Следующий новый год
	private int nextYear;
	// Время до нового года
	private LocalDateTime newYear;
	// Нынешнее время
	private LocalDateTime now;
	// Дни до нового года
	private long days;
	// Часы до нового года
	private long hours;
	// минуты для нового года
	private long minutes;
	// Секунды до нового года
	private long secondsToNewYear;

	public TimeToNewYear()
	{
		nextYear = LocalDateTime.now().getYear() + 1;
		newYear = LocalDateTime.of(nextYear, 01, 01, 00, 00, 00);
		now = LocalDateTime.now();

		secondsToNewYear = Duration.between(now, newYear).getSeconds();

		days = secondsToNewYear / 60 / 60 / 24;
		secondsToNewYear -= days * 60 * 60 * 24;

		hours = secondsToNewYear / 60 / 60;		
		secondsToNewYear -= hours * 60 * 60;

		minutes = secondsToNewYear / 60;		
		secondsToNewYear -= minutes * 60;
	}

	/**
	* @return Поздравить с текущим новым годом
	*/
	@Override
	public String congratulations()
	{
		// Год, с которым нужно поздравить
		int happyNewYear = LocalDateTime.now().getYear();
		return "Счастливого " + happyNewYear + " года!";
	}

	/**
	* @return преобразование времени до нового года в удобный строковый формат
	*/
	@Override
	public String getTimeToNewYear()
	{
		String str = "До нового " + nextYear + " года осталось:\n";
		str += days + " дней\n";
		str += hours + " часов\n";
		str += minutes + " минут\n";
		str += secondsToNewYear + " секунд\n";
		return str;
	}
}
