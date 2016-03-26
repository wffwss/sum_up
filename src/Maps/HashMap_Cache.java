package Maps;

import java.util.HashMap;
import java.util.Map;

//Picture用来模拟图片，name是图片的名称
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

	// 三级缓存：第一：从内存中找图片，若存在，直接到内存中取出图片
	// 第二：内存不存在，则到外存中找，若外存存在，直接从外存中取出图片，同时把图片放到内存中
	// 第三：内存外存都不存在，从网络上下载图片，直接使用并把图片保存到外存中，缓存到内存中
	@Override
	public String toString() {
		return "HashMap_Cache [map=" + map + "]";
	}
	public void loadPicture(String url) {
		// 如果图片不是第一次下载，缓存中已有，则直接从缓存中获取图片，不需要再次从网络上下载图片
		if (map.containsKey(url)) {
			// 根据键值取出缓存中的图片
			System.out.println("内存中已经包含了" + url + ",不需要再次从网络下载");
			Picture p = map.get(url);// 得到键值对应的value值（即图片名）
			//map.put(url, p);
			System.out.println("if结束");
		} else {
			// 假设是第一次下载，则需要从网络上下载图片，用新建一个Picture对象来模拟
			Picture picture = new Picture(url);
			// 从网络下载图片后，需要把图片缓存到内存中:此处的键值作为图片的下载地址，value值表示真实的图片
			map.put(url, picture);
			System.out.println("第一次下载" + url + ",需要从网络下载，之后再缓存到内存中");
			System.out.println(map.toString());
		}
	}

	

	public static void main(String[] args) {
		HashMap_Cache cache = new HashMap_Cache();
		cache.loadPicture("苏州");
		cache.loadPicture("苏州");
		cache.loadPicture("苏州");
	}

}
