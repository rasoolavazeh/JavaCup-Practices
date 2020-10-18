package ir.javacup.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	SavingAccount savingAccount;
	CheckingAccount checkingAccount;

	@Before
	public void runBeforeTests() {
		savingAccount = new SavingAccount("1234567890", "0987654321", 100_000.0, 0.2);
		checkingAccount = new CheckingAccount("9999999999", "8888888888", 200_000.0, 30.0);
	}

	@Test
	public void testSavingAccountInitialization() {
		assertEquals("1234567890", savingAccount.getCustomerNationalId());
		assertEquals("0987654321", savingAccount.getAccountNumber());
		assertEquals(0.2, savingAccount.getInterestAmount(), 1e-15);
		assertEquals(100_000.0, savingAccount.getBalance(), 1e-15);
	}

	@Test
	public void testCheckingAccountInitialization() {
		assertEquals("9999999999", checkingAccount.getCustomerNationalId());
		assertEquals("8888888888", checkingAccount.getAccountNumber());
		assertEquals(30.0, checkingAccount.getOverdraftAmount(), 1e-15);
		assertEquals(200_000.0, checkingAccount.getBalance(), 1e-15);
	}

	@Test
	public void testNegativeWithdraw() {
		BankAccount ba = new BankAccount("111", "222", 400.0);
		try {
			ba.withdraw(-200.0);
			fail("An error expected.");
		} catch (IllegalArgumentException e) {
			assertEquals("Sorry, you can not withdraw a negative amount", e.getMessage());
		}
	}

	@Test
	public void testExtraWithdraw() {
		BankAccount ba = new BankAccount("111", "222", 400.0);
		try {
			ba.withdraw(500.0);
			fail("An error expected.");
		} catch (RuntimeException e) {
			assertEquals("Your balance is not enough", e.getMessage());
		}
	}

	@Test
	public void testWithdraw() {
		BankAccount ba = new BankAccount("111", "222", 400.0);
		ba.withdraw(300.0);
		assertEquals(100.0, ba.getBalance(), 1e-15);
	}

	@Test
	public void testDeposit() {
		BankAccount ba = new BankAccount("111", "222", 400.0);
		ba.deposit(100.0);
		assertEquals(500.0, ba.getBalance(), 1e-15);
	}

	@Test
	public void testEqualityOfAccounts() {
		BankAccount sa = new SavingAccount("111", "222", 200.0, 0.2);
		BankAccount ca = new CheckingAccount("111", "222", 400.0, 100.0);
		assertFalse(sa.equals(ca));
		BankAccount ba1 = new BankAccount("111", "222", 200.0);
		BankAccount ba2 = new BankAccount("111", "222", 400.0);
		assertTrue(ba1.equals(ba2));
		ba1 = new BankAccount("111", "222", 200.0);
		ba2 = new BankAccount("111", "333", 300.0);
		assertFalse(ba1.equals(ba2));
		ba1 = new BankAccount("111", "222", 200.0);
		ba2 = new BankAccount("222", "222", 300.0);
		assertFalse(ba1.equals(ba2));
	}

	@Test
	public void testAddInterest() {
		SavingAccount ba = new SavingAccount("111", "111", 100.0, 0.2);
		ba.addInterest();
		assertEquals(120.0, ba.getBalance(), 1e-15);
		ba.addInterest();
		assertEquals(144.0, ba.getBalance(), 1e-15);
	}

}
