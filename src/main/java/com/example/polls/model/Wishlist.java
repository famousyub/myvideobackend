package com.example.polls.model;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Wishlist implements Serializable {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "formation_id")
	    private Formation formation;
	    
	    @Column(name="user_id")
	    public Long getUser_id() {
			return user_id;
		}

		public Wishlist(Formation formation, Long user_id) {
			super();
			this.formation = formation;
			this.user_id = user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		private Long user_id;
	    

	    @Column(name = "created_date")
	    private Date createdDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Formation getFormation() {
			return formation;
		}

		public void setFormation(Formation formation) {
			this.formation = formation;
		}

		public Wishlist(Long id, Formation formation) {
			super();
			this.id = id;
			this.formation = formation;
		}

		public Wishlist() {
			super();
		}
	    
	    
	    

}
