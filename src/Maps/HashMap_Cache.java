package Maps;

import java.util.HashMap;
import java.util.Map;

//Picture����ģ��ͼƬ��name��ͼƬ������
class Picture {
	String name;

	public Picture(String name) {
		super();
		this.name = name;
	}
}

public class HashMap_Cache {
	Map<String, Picture> map;

	public HashMap_Cache() {
		map = new HashMap<String, Picture>();
	}

	// �������棺��һ�����ڴ�����ͼƬ�������ڣ�ֱ�ӵ��ڴ���ȡ��ͼƬ
	// �ڶ����ڴ治���ڣ���������ң��������ڣ�ֱ�Ӵ������ȡ��ͼƬ��ͬʱ��ͼƬ�ŵ��ڴ���
	// �������ڴ���涼�����ڣ�������������ͼƬ��ֱ��ʹ�ò���ͼƬ���浽����У����浽�ڴ���
	@Override
	public String toString() {
		return "HashMap_Cache [map=" + map + "]";
	}
	public void loadPicture(String url) {
		// ���ͼƬ���ǵ�һ�����أ����������У���ֱ�Ӵӻ����л�ȡͼƬ������Ҫ�ٴδ�����������ͼƬ
		if (map.containsKey(url)) {
			// ���ݼ�ֵȡ�������е�ͼƬ
			System.out.println("�ڴ����Ѿ�������" + url + ",����Ҫ�ٴδ���������");
			Picture p = map.get(url);// �õ���ֵ��Ӧ��valueֵ����ͼƬ����
			//map.put(url, p);
			System.out.println("if����");
		} else {
			// �����ǵ�һ�����أ�����Ҫ������������ͼƬ�����½�һ��Picture������ģ��
			Picture picture = new Picture(url);
			// ����������ͼƬ����Ҫ��ͼƬ���浽�ڴ���:�˴��ļ�ֵ��ΪͼƬ�����ص�ַ��valueֵ��ʾ��ʵ��ͼƬ
			map.put(url, picture);
			System.out.println("��һ������" + url + ",��Ҫ���������أ�֮���ٻ��浽�ڴ���");
			System.out.println(map.toString());
		}
	}

	

	public static void main(String[] args) {
		HashMap_Cache cache = new HashMap_Cache();
		cache.loadPicture("����");
		cache.loadPicture("����");
		cache.loadPicture("����");
	}

}
