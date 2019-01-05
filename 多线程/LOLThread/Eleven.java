package eleven;

class Hero {
    public String name;
    public float hp;
 
    public int damage;
 
    public synchronized void recover() {
    	//�߳̽���
    	if (hp >= 1000) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
        hp = hp + 1;
        System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
        // ֪ͨ��Щ�ȴ���this�����ϵ��̣߳������ѹ����ˣ����20�У��ȴ��ŵļ�Ѫ�̣߳����ѹ���
        this.notify();
    }
 
    public synchronized void hurt() {
        if (hp <= 1) {
            try {
                // ��ռ��this�ļ�Ѫ�̣߳���ʱ�ͷŶ�this��ռ�У����ȴ�
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
 
        hp = hp - 1;
        System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
        
        this.notify();
    }
 
    public void attackHero(Hero h) {
        h.hp -= damage;
        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead())
            System.out.println(h.name + "���ˣ�");
    }
 
    public boolean isDead() {
        return 0 >= hp ? true : false;
    }
 
}

public class Eleven {
    public String name;
    public float hp;
  
    public int damage;
  
    public synchronized void recover() {
        //��Ѫ�����ڻ��ߵ���1000��ʱ��
        //this.wait() ��ռ�����������̵߳ȴ�������ʱ�ͷ���
        if(hp>=1000){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
         
        hp = hp + 1;
        System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
        this.notify();
    }
  
    public synchronized void hurt() {
        if (hp == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
  
        hp = hp - 1;
        System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
        //��Ѫ֮�󣬻��ѵȴ����߳�
        this.notify();
    }
  
    public void attackHero(Hero h) {
        h.hp -= damage;
        System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
        if (h.isDead())
            System.out.println(h.name + "���ˣ�");
    }
  
    public boolean isDead() {
        return 0 >= hp ? true : false;
    }
  
}