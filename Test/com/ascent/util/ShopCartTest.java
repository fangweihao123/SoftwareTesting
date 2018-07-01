package com.ascent.util;

import com.ascent.bean.Product;

import junit.framework.TestCase;

public class ShopCartTest extends TestCase {
	
	private ShopCart sCart = new ShopCart();

	private void init() {
		Product p1 = new Product("001", "��ҩ", "Lixing", "2008-11-28", "23007.gif", 
				"ss", "������", "23007.gif", "45", "45", "100", "45", "null", 
				"��ҩ", "",1, "","", "", "" );
		p1.setPid(1);
		sCart.addProduct("001", p1);
		
		Product p2 = new Product("004", "����ҩ", "lixin", "2007-2-1", "23007.gif", 
				"ee", "������", "23007.gif", "24", "78", "100", "75", "������", 
				"����ҩ", "",1, "","", "", "" );
		p1.setPid(4);
		sCart.addProduct("004", p2);
	}
	
	public void testCheckHashMapid() {
		init();
		boolean b = sCart.CheckHashMapid("001");
		assertEquals(b, true);
	}
	
	public void testCheckHashMapid1() {
		init();
		boolean b = sCart.CheckHashMapid("004");
		assertEquals(b, true);
	}
	
	public void testCheckHashMapid2() {
		init();
		boolean b = sCart.CheckHashMapid("008");
		assertEquals(b, false);
	}
	
	public void testCheckHashMapid3() {
		init();
		boolean b = sCart.CheckHashMapid("abc");
		assertEquals(b, false);
	}
	
	public void testCheckHashMapid4() {
		init();
		boolean b = sCart.CheckHashMapid("ab01");
		assertEquals(b, false);
	}
	
	

	public void testAddProduct() {
		//ShopCart sC = new ShopCart();
		init();
		Product p1 = new Product("001", "��ҩ", "Lixing", "2008-11-28", "23007.gif", 
				"ss", "������", "23007.gif", "45", "45", "100", "45", "null", 
				"��ҩ", "",1, "","", "", "" );
		p1.setPid(1);
		sCart.addProduct("001", p1);
		
		Product p2 = new Product("008", "ά����", "LiangLInxin", "2006-5-8", "23007.gif", 
				"dd", "������", "23007.gif", "97", "101", "520", "120", "", 
				"ά����", "",1, "","", "", "" );
		p2.setPid(7);
		sCart.addProduct("008", p2);
		assertEquals(sCart.getHashmap().size(), 3);
//		fail("Not yet implemented");
	}

}
