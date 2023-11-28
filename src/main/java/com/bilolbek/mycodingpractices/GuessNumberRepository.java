package com.bilolbek.mycodingpractices;

import org.springframework.data.repository.CrudRepository;

public interface GuessNumberRepository extends CrudRepository<UserGuessNumber, Integer> {
}
