package fis.java.topic13.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import fis.java.topic13.entity.Account;
import fis.java.topic13.service.impl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
	
	@Mock
	private AccountServiceImpl accountService;
	
	@Test
	void testFindAll_whenChecksSize_thenCorrect() {
		List<Account> list = accountService.findAll();
		assertThat(list, hasSize(3));
	}

//	@Test
//	void testSave() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindByAccountNumber() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteById() {
//		fail("Not yet implemented");
//	}

}
