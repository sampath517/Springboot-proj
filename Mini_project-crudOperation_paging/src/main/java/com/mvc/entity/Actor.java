package com.mvc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "JPA_ACTOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Actor {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "ACTOR_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer aid;
	@Column(length = 20)
	@NonNull
	private String aname;
	@Column(length = 30)
	@NonNull
	private String addrs;
	@NonNull
	private Double fee;
	@Column(length = 20)
	@NonNull
	private String category;
	
	@CreationTimestamp()
	@Column(updatable = false)
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime updateDate;
	
	@Version
	private Integer updateCount;  //version feature
	
	@Column(length = 20,updatable = false)
	private String createdBy;
	@Column(length = 20,insertable = false)
	private String updateBy;
	
	
	
}
