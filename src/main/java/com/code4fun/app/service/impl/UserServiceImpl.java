package com.code4fun.app.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.code4fun.app.dto.Mapper;
import com.code4fun.app.dto.UserRequest;
import com.code4fun.app.entity.User;
import com.code4fun.app.repository.UserRepository;
import com.code4fun.app.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public User create(UserRequest userRequest) {
		User createdUser = userRepository.save(Mapper.userRequestToUser(userRequest));
		return createdUser;
	}

	@Override
	public User retrieveById(Long id) {
		User retrievedUser = userRepository.findById(id).orElse(null);
		return retrievedUser;
	}

	@Override
	public Set<User> retrieveAll() {
		Set<User> retrievedUsersList = userRepository.findAll().stream().collect(Collectors.toSet());
		return retrievedUsersList;
	}

	@Override
	public User update(Long id, UserRequest userRequest) {

		User userToUpdate = retrieveById(id);

		if (userToUpdate != null && userRequest != null) {

			if (userRequest.getName() != null)
				userToUpdate.setName(userRequest.getName());

			if (userRequest.getBirthDate() != null)
				userToUpdate.setBirthDate(userRequest.getBirthDate());

			if (userRequest.getEmail() != null)
				userToUpdate.setEmail(userRequest.getEmail());

			if (userRequest.getMobile() != null)
				userToUpdate.setMobile(userRequest.getMobile());

			userRepository.save(userToUpdate);

		}

		return userToUpdate;

	}

	@Override
	public String delete(Long id) {

		User userToDelUser = retrieveById(id);

		if (userToDelUser != null) {
			userRepository.delete(userToDelUser);
			return "user deleted with id :: " + id;
		}

		return "user could not be deleted with id :: " + id;

	}

}
