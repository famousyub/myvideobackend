package com.example.polls.model;


import java.io.Serializable;

import javax.persistence.*;


import org.springframework.data.annotation.Transient;

/**
 * A Imagedata.
 */
@Table(name="imagedata")
@Entity
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Imagedata implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="imagename")
    private String imagename;

    @Column(name="description")
    private String description;

    @Column(name="imagepath")
    private byte[] imagepath;

    @Column(name="imagepath_content_type")
    private String imagepathContentType;

    @Column(name="dislik")
    private Integer dislik;

    @Column(name="activate")
    private Boolean activate;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Imagedata id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagename() {
        return this.imagename;
    }

    public Imagedata imagename(String imagename) {
        this.setImagename(imagename);
        return this;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getDescription() {
        return this.description;
    }

    public Imagedata description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImagepath() {
        return this.imagepath;
    }

    public Imagedata imagepath(byte[] imagepath) {
        this.setImagepath(imagepath);
        return this;
    }

    public void setImagepath(byte[] imagepath) {
        this.imagepath = imagepath;
    }

    public String getImagepathContentType() {
        return this.imagepathContentType;
    }

    public Imagedata imagepathContentType(String imagepathContentType) {
        this.imagepathContentType = imagepathContentType;
        return this;
    }

    public void setImagepathContentType(String imagepathContentType) {
        this.imagepathContentType = imagepathContentType;
    }

    public Integer getLiked() {
        return this.dislik;
    }

    public Imagedata liked(Integer liked) {
        this.setLiked(liked);
        return this;
    }

    public void setLiked(Integer liked) {
        this.dislik = liked;
    }

    public Boolean getActivate() {
        return this.activate;
    }

    public Imagedata activate(Boolean activate) {
        this.setActivate(activate);
        return this;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Imagedata)) {
            return false;
        }
        return id != null && id.equals(((Imagedata) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Imagedata{" +
            "id=" + getId() +
            ", imagename='" + getImagename() + "'" +
            ", description='" + getDescription() + "'" +
            ", imagepath='" + getImagepath() + "'" +
            ", imagepathContentType='" + getImagepathContentType() + "'" +
            ", liked=" + getLiked() +
            ", activate='" + getActivate() + "'" +
            "}";
    }
}

