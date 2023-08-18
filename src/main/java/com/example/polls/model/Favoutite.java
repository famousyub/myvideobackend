package com.example.polls.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Favoutite {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "formation_id")
	    private Formation formation;
	    
	    public Favoutite() {
			super();
		}

		public Favoutite(Long id, Formation formation, Long user_id) {
			super();
			this.id = id;
			this.formation = formation;
			this.user_id = user_id;
		}

		@Column(name="user_id")
	   private Long user_id;

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

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

}
