package com.suraj.spring.test;

import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suraj.spring.beans.HCLInfo;

public class HCLInfoTest {

	public static void main(String[] args) {
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("spring.xml");
			HCLInfo info = context.getBean("info", HCLInfo.class);
			Properties props = info.getProps();
			for (Entry<?, ?> entry : props.entrySet()) {
				System.out.println(entry.getKey()+"\t"+entry.getValue());
			}
		} catch (BeansException e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				((AbstractApplicationContext) context).close();
			}
		}
	}
}
