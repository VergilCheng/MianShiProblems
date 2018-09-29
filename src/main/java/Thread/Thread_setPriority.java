package Thread;
/**
 * 线程优先级
 * 线程有10个优先级，分别用数字1-10表示
 * 其中1为最低优先级，5为默认优先级，
 * 10为最高优先级
 * 理论上优先级越高的线程获取CPU时间片的次数
 * 就越多。
 * 也就是说优先级越高的，越先执行完，优先级越低越后执行完，理论上这样，不保证百分百这样。
 *
 * @author adminitartor
 *
 */
public class Thread_setPriority {
	static int maxnum = 0;
	static int minnum = 0;
	static int nornum = 0;
	public static void main(String[] args) {




		Thread max = new Thread(){
			public void run(){

				for(int i=0;i<10000;i++){
					System.out.println("max");
					maxnum++;
				}
			}
		};
		Thread nor = new Thread(){
			public void run(){

				for(int i=0;i<10000;i++){
					System.out.println("nor");
					nornum++;
				}
			}
		};
		Thread min = new Thread(){
			public void run(){

				for(int i=0;i<10000;i++){
					System.out.println("min");
					minnum++;
				}

			}
		};
		//Thread.MIN_PRIORITY
		min.setPriority(Thread.MIN_PRIORITY);		
		max.setPriority(Thread.MAX_PRIORITY);
		min.start();
		nor.start();
		max.start();//一般是max先输完成，最后是min输出完。
		Thread thread = Thread.currentThread();
		try {
			thread.sleep(2000);//让main方法线程sleep等待剩下的三个线程执行完成
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(maxnum+","+nornum+","+minnum);
	}
}








