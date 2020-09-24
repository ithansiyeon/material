package com.test.dummy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class RoundInfoDummy {
	public static void main(String[] args) {
		//2시간 반 
		//한시간 반 쉬고 회차 3개 씩 
		
		Calendar c = Calendar.getInstance();
		int month = 6;
		int day = 1;
		String sql = null;
		boolean loop = true;
		File file = new File("D:\\프로젝트3\\회차더미.txt");
		File file1 = new File("D:\\프로젝트3\\회차날짜.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			BufferedWriter writer1 = new BufferedWriter(new FileWriter(file1));
			for (int i = 0; i < 100; i++) {
				c.set(2020, month, day, 9, 0,0);
				loop = true;
				while (loop) {
//					for (int j = 0; j < 3; j++) {
					
						String date = String.format("%tF %tT", c,c);
						sql = String.format(
								"insert into tblRoundInfo values(roundInfoSeq.nextVal,to_date('%s','yyyy-mm-dd hh24:mi:ss'),to_date('2020-07-01','yyyy-mm-dd'),to_date('2020-09-30','yyyy-mm-dd'),%d,default);",
								date,i + 1);
						writer.write(sql);
						writer1.write(date);
						writer1.newLine();
						writer.newLine();
						c.add(Calendar.HOUR, 2);
						c.add(Calendar.MINUTE, 30);
						c.add(Calendar.HOUR, 1);
						c.add(Calendar.MINUTE, 30);
//					}
					c.add(Calendar.DATE, 3);
					c.set(Calendar.HOUR_OF_DAY, 9);
					c.set(Calendar.MINUTE,0);
					c.set(Calendar.SECOND,0);
//					System.out.println(day);
//					if (c.get(Calendar.DAY_OF_MONTH) == 7 || c.get(Calendar.DAY_OF_MONTH) == 8 ) {
//						day = 1;
//					}
					if (c.get(Calendar.MONTH) == 9) {
//						System.out.println(1);
						month = 6;
						day = 1;
						loop = false;
					}
				}
			}
			writer.close();
			writer1.close();
		} catch (Exception e) {
			System.out.println("RoundInfoDummy.main()");
			e.printStackTrace();
		}
		System.out.println("완료");
	}

}