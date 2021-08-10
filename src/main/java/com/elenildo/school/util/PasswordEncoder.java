package com.elenildo.school.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		System.out.print(bpe.encode("321"));

	}

}
