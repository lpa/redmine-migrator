package org.groink.redmine.domain;


import java.util.Date;
import java.util.List;

public class Issue {

    int id;
    Project project;
    Tracker tracker;
    Status status;
    Priority priority;
    Author author;
    Category category;
    String subject;
    String description;
    Date startDate;
    Date dueDate;
    int doneRatio;
    double estimatedHours;

    List<CustomField> customFields;

    Date createdOn;
    Date updatedOn;

    public Issue() {
        this.category = new Category();
        this.author = new Author();
        this.priority = new Priority();
        this.status = new Status();
        this.tracker = new Tracker();
        this.project = new Project();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAuthor(int id, String name){
        this.author.id = id;
        this.author.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getDoneRatio() {
        return doneRatio;
    }

    public void setDoneRatio(int doneRatio) {
        this.doneRatio = doneRatio;
    }

    public double getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }


    public class Project {
        int id;
        String name;
    }


    public class Tracker {
        int id;
        String name;
    }

    public class Status {
        int id;
        String name;
    }

    public class Priority {
        int id;
        String name;
    }

    public class Author {
        int id;
        String name;
    }

    public class Category {
        int id;
        String name;
    }

    public class CustomField {
        int id;
        String name;
        String value;
    }



}
