package com.code4fun.app.dto;

import com.code4fun.app.entity.User;

public class Mapper {

	public static User userRequestToUser(UserRequest userRequest) {

		User user =
					
					User.builder()
					.name(userRequest.getName())
					.birthDate(userRequest.getBirthDate())
					.email(userRequest.getEmail())
					.mobile(userRequest.getMobile())
					.status(userRequest.getStatus())
					.build();

			return user;

		}

		public static UserRequest userToUserRequest(User user) {

			UserRequest userRequest =
					
					UserRequest.builder()
					.name(user.getName())
					.birthDate(user.getBirthDate())
					.email(user.getEmail())
					.mobile(user.getMobile())
					.status(user.getStatus())
					.build();
			
			return userRequest;

		}

	}
