package com.mvc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mvc.entity.Actor;

public interface IActorMgmtService {
	
	public Page<Actor> showAllActors(Pageable pageable);
	
	public String registerActors(Actor actor);
	
	public Actor fetchActorById(int id) throws IllegalAccessException;
	
	public String editActor(Actor actor);
	
	public String deleteActorById(int id);
	
	default void m1() {
		System.out.println("dea");
	}
	
	default void m11() {
		System.out.println("dea");
	}
	
	
	
}
