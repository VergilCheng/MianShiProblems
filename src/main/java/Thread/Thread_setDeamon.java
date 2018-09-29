package Thread;
/**
 * 守护线程
 * 当一个进程结束时，守护线程会强制退出。
 * 当一个进程中所有前台线程都结束时，进程
 * 就会结束。
 * @author adminitartor
 *
 * main方法是一个前台线程，当main方法的所有代码执行完毕后，main方法的线程就结束了
 * 而rose和jack这时候还在线程中执行。程序并没有退出，所以main方法不可能是后台线程。
 *
 */
public class Thread_setDeamon {
	public static void main(String[] args) {
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("rose:啊啊啊啊啊AAAAAAaaaaaaa...");
				System.out.println("音效:噗通!");
			}
		};
		
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println("jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		rose.start();
		
		//后台线程要单独设定，并在start前调用
		jack.setDaemon(true);
		jack.start();


	}
}







