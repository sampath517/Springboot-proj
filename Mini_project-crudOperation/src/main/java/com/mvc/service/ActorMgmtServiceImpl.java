package com.mvc.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.entity.Actor;
import com.mvc.repository.IActorRepository;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService{
	
	@Autowired
	private IActorRepository actorRepo;
	@Override
	public Iterable<Actor> showAllActors() {
		
		return actorRepo.findAll();
	}
	@Override
	public String registerActors(Actor actor) {
		
		//set windows username as created by username
		actor.setCreatedBy(System.getProperty("user.name"));
		
		int id=actorRepo.save(actor).getAid();
		return "Actor is saved with id value "+id;
	}
	@Override
	public Actor fetchActorById(int id) throws IllegalAccessException {
		// TODO Auto-generated method stub
		return actorRepo.findById(id).orElseThrow(() -> new IllegalAccessException("invalid id") );
	}
	@Override
	public String editActor(Actor actor) {
		Optional<Actor>opt=actorRepo.findById(actor.getAid());
		if(opt.isPresent()) {
			
		Actor	actor1=opt.get();
		actor.setUpdateCount(actor1.getUpdateCount());
			actor1.setUpdateBy(System.getProperty("user.name"));
			actorRepo.save(actor);
			
			return actor1.getAid()+"Actor data is modified";
		}
		return actor.getAid()+"Actor is not found";
	}
	
	
	@Override
	public String deleteActorById(int id) {
		// TODO Auto-generated method stub
		Optional<Actor>opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			actorRepo.deleteById(id);
			
			return id+" Actor is removed";
		}
		return id+" Actor is not found deletion";
	}
	
}
