package com.example.ipldashboard.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class NFTMetadata {
	@Id
	private long id;
	@Column(nullable = false, length = 300, name = "name", unique = true)
	private String name;
	@Column(nullable = false, length = 1000, name = "description")
	private String description;

	@Column(nullable = false, length = 1000, name = "externalLink")
	private String externalLink;

	@Column(nullable = false, length = 100, name = "image")
	private String image;
	@Transient
	private Map<String, Object> attributes = new HashMap<>();
	@Column(nullable = false, length = 5000, name = "attributes", unique = true)
	private String attributesStr;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "NFTMetadata [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", attributes=" + attributesStr + "]";
	}

	public String getAttributesStr() {
		return attributesStr;
	}

	public void setAttributesStr(String attributesStr) {
		this.attributesStr = attributesStr;
	}

	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}

}
