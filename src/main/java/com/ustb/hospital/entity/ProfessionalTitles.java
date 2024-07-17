package com.ustb.hospital.entity;

public class ProfessionalTitles {
    private Integer id;
    private String titleName;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProfessionalTitles{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
