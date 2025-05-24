package com.mvc.service;

import com.mvc.entity.Actor;

public interface IActorMgmtService {
	
	public Iterable<Actor> showAllActors();
	
	public String registerActors(Actor actor);
	
	public Actor fetchActorById(int id) throws IllegalAccessException;
	
	public String editActor(Actor actor);
	
	public String deleteActorById(int id);
}
