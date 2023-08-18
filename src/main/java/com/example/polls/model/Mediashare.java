package com.example.polls.model;

import java.io.Serializable;

import javax.persistence.*;


import org.springframework.data.annotation.Transient;

/**
 * A Mediashare.
 */
@Table(name="mediashare")
@Entity
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Mediashare implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="mediatag")
    private String mediatag;

    @Column(name="mediadescription")
    private String mediadescription;

    @Column(name="mediatagy")
    private String mediatagy;

    
    @Lob
    @Column(name="mediavideo")
    private byte[] mediavideo;

    @Column(name="mediavideo_content_type")
    private String mediavideoContentType;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Mediashare id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediatag() {
        return this.mediatag;
    }

    public Mediashare mediatag(String mediatag) {
        this.setMediatag(mediatag);
        return this;
    }

    public void setMediatag(String mediatag) {
        this.mediatag = mediatag;
    }

    public String getMediadescription() {
        return this.mediadescription;
    }

    public Mediashare mediadescription(String mediadescription) {
        this.setMediadescription(mediadescription);
        return this;
    }

    public void setMediadescription(String mediadescription) {
        this.mediadescription = mediadescription;
    }

    public String getMediatagy() {
        return this.mediatagy;
    }

    public Mediashare mediatagy(String mediatagy) {
        this.setMediatagy(mediatagy);
        return this;
    }

    public void setMediatagy(String mediatagy) {
        this.mediatagy = mediatagy;
    }

    public byte[] getMediavideo() {
        return this.mediavideo;
    }

    public Mediashare mediavideo(byte[] mediavideo) {
        this.setMediavideo(mediavideo);
        return this;
    }

    public void setMediavideo(byte[] mediavideo) {
        this.mediavideo = mediavideo;
    }

    public String getMediavideoContentType() {
        return this.mediavideoContentType;
    }

    public Mediashare mediavideoContentType(String mediavideoContentType) {
        this.mediavideoContentType = mediavideoContentType;
        return this;
    }

    public void setMediavideoContentType(String mediavideoContentType) {
        this.mediavideoContentType = mediavideoContentType;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Mediashare)) {
            return false;
        }
        return id != null && id.equals(((Mediashare) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Mediashare{" +
            "id=" + getId() +
            ", mediatag='" + getMediatag() + "'" +
            ", mediadescription='" + getMediadescription() + "'" +
            ", mediatagy='" + getMediatagy() + "'" +
            ", mediavideo='" + getMediavideo() + "'" +
            ", mediavideoContentType='" + getMediavideoContentType() + "'" +
            "}";
    }
}
