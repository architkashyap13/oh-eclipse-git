package com.org.oh_backend;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class App 
{
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("m123"));
	}
}
