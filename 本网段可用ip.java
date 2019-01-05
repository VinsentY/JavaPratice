package five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Five {
	
	int[][] arr = new int[9][9];
	
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		System.out.println("Loacl IP is :" + ip);
		
		String ipRange = ip.substring(0, ip.lastIndexOf("."));
		
		
		//神奇的List
		List<String> ips = Collections.synchronizedList(new ArrayList<>());
		
		//开启线程池
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		
		AtomicInteger number = new AtomicInteger();
		
		for(int i = 1; i <= 255; i++) {
			String testIp = ipRange + "." + i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					boolean reachable = isReachable(testIp);
					if(reachable) {
						ips.add(testIp);
					}
					
					synchronized (number) {
						System.out.println("已经完成:" + number.incrementAndGet() + " 个 ip 测试");
					}
					
				}
			});
			
		}
		
		//等待所有线程结束的时候，就关闭线程池
		threadPool.shutdown();
		if(threadPool.awaitTermination(1, TimeUnit.HOURS)) {
			System.out.println("如下ip地址可以连接");
            for (String theip : ips) {
                System.out.println(theip);
            }
            System.out.println("总共有:" + ips.size() + " 个地址"); 	
		}
		
				
	}




	protected static boolean isReachable(String testIp) {
		
		
		try {
			
			boolean reachable = false;
			Process p = Runtime.getRuntime().exec("ping -n 1 " + testIp);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = br.readLine()) != null) {
				if(line.length() != 0) {
					sb.append(line + "\n");
				}
			}
			reachable = sb.toString().contains("TTL");
			br.close();
			
			return reachable;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	
	}

}
