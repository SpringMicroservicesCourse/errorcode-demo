package tw.fengqing.spring.data.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import tw.fengqing.spring.data.demo.exception.CustomDuplicatedKeyException;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ErrorCodeDemoApplicationTests {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testThrowingCustomException() {
		// 這個測試方法示範了資料庫主鍵衝突的情況
		// 第一次插入 ID=1 的資料是成功的
		jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'a')");
		System.out.println("成功插入第一筆資料 ID=1");
		
		// 第二次嘗試插入相同 ID=1 的資料
		// 因為 ID 是主鍵，不能重複
		// 所以這行會拋出資料庫異常
		CustomDuplicatedKeyException exception = assertThrows(CustomDuplicatedKeyException.class, () -> {
			jdbcTemplate.execute("INSERT INTO FOO (ID, BAR) VALUES (1, 'b')");
		});
		System.out.println("預期拋出異常: " + exception.getMessage());
	}
}
