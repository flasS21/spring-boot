package com.code4fun.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	private Long id;
	private String name;
	private LocalDate birthDate;
	private String email;
	private String mobile;
	private Boolean status;

}
