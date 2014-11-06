package java02.test12;

public class Test04 {
	static class Account {
		long balance;

		public Account(int balance) {
			this.balance = balance;
		}

		private long delay() {
			long l = 10L;
			double d = 3.14;
			d = d / l;
			d += System.currentTimeMillis();
			return (long) (d / 34.56);
		}

		// 여러 스레드가 동시접근했을 시 문제가 발생하는 코드 블록
		//	=> Critical section (critical region)
		// Test05에서 개선!
		public long withdraw(long money) {
			long temp = this.balance;
			delay();
			temp = temp - money;
			delay();
			if (temp >= 0) {
				delay();
				this.balance = temp;
				delay();
				return money;
			} else {
				delay();
				return 0;
			}
		}
	}

	static class ATM extends Thread {
		Account account;

		public ATM(String name, Account account) {
			this.setName(name);
			this.account = account;
		}

		@Override
		public void run() {
			long sum = 0;
			for (int i = 0; i < 10000; i++) {
				if (account.withdraw(100) != 0) {
					sum += 100;
				} else {
					break;
				}
			}
			System.out.println(this.getName() + ": " + sum + "원 출금했습니다");
		}
	}

	public static void main(String[] args) {
		Account account = new Account(1000000);
		
		ATM atm1 = new ATM("강님", account);
		ATM atm2 = new ATM("양재", account);
		ATM atm3 = new ATM("종로", account);
		ATM atm4 = new ATM("부산", account);
		ATM atm5 = new ATM("광주", account);
		ATM atm6 = new ATM("강릉", account);
	
		atm1.start();
		atm2.start();
		atm3.start();
		atm4.start();
		atm5.start();
		atm6.start();
	}

}
