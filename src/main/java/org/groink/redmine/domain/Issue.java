package org.groink.redmine.domain;


import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
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
    DateTime startDate;

    @XmlElement(name = "custom_fields")
    public CustomFieldCollection getCustomFieldCollection() {
        return customFieldCollection;
    }

    public void setCustomFieldCollection(CustomFieldCollection customFieldCollection) {
        this.customFieldCollection = customFieldCollection;
    }

    DateTime dueDate;
    int doneRatio;
    double estimatedHours;

    CustomFieldCollection customFieldCollection;

    DateTime createdOn;
    DateTime updatedOn;

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

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate) {
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

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }

    public DateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(DateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setProject(int id, String name) {
        this.project.id = id;
        this.project.name = name;
    }

    public void setTracker(int id, String name) {
        this.tracker.id = id;
        this.tracker.name = name;
    }

    public void setStatus(int id, String name) {
        this.status.id = id;
        this.status.name = name;
    }

    public void setPriority(int id, String name) {
        this.priority.id = id;
        this.priority.name = name;
    }

    public void setAuthor(int id, String name) {
        this.author.id = id;
        this.author.name = name;
    }

    public void setCategory(int id, String name) {
        this.category.id = id;
        this.category.name = name;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", project=" + project +
                ", tracker=" + tracker +
                ", status=" + status +
                ", priority=" + priority +
                ", author=" + author +
                ", category=" + category +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", doneRatio=" + doneRatio +
                ", estimatedHours=" + estimatedHours +
                ", customFieldCollection=" + customFieldCollection +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
