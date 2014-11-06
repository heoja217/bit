//크리티컬 섹션을 동기화 처리
// 여러 스레드가 크리티컬 섹션을 실행하더라도 문제없게 한번에 하나의 스레드만 접근하도록 함.

/* 뮤텍스Mutax
  => 한 번에 하나의 스레드만이 크리티컬 섹션에 접근하는 방식
  *semaphore : 크리티컬 섹션에 진입할 수 있는 스레드 수 지정
  *뮤텍스의 세마포어는 1!
  
  - 여러 스레드가 진입하더라도 계산에 영향을 끼치지않는 코드블록 => Thread safe
  	ㄴ변수를 공유하지 않음. 즉 로컬변수만 사용한다.
 */

package java02.test12;

public class Test05 {
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
		synchronized public long withdraw(long money) {
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
