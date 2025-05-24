

package com.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer>{

}
