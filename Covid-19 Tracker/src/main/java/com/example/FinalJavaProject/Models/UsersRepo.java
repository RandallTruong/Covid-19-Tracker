package com.example.FinalJavaProject.Models;

import org.springframework.data.repository.CrudRepository;


public interface UsersRepo extends CrudRepository<User, String> {
}
