package org.groink.redmine.domain;


import com.google.common.base.Objects;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Issue {

    private int id;
    private Project project;
    private Tracker tracker;
    private Status status;
    private Priority priority;
    private Author author;
    private Category category;
    private String subject;
    private String description;
    private DateTime startDate;

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
        this.project.setId(id);
        this.project.setName(name);
    }

    public void setTracker(int id, String name) {
        this.tracker.setId(id);
        this.tracker.setName(name);
    }

    public void setStatus(int id, String name) {
        this.status.setId(id);
        this.status.setName(name);
    }

    public void setPriority(int id, String name) {
        this.priority.setId(id);
        this.priority.setName(name);
    }

    public void setAuthor(int id, String name) {
        this.author.setId(id);
        this.author.setName(name);
    }

    public void setCategory(int id, String name) {
        this.category.setId(id);
        this.category.setName(name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, project, tracker, status, priority, author, category, subject, description, startDate, dueDate, doneRatio, estimatedHours, customFieldCollection, createdOn, updatedOn);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Issue other = (Issue) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.project, other.project) && Objects.equal(this.tracker, other.tracker) && Objects.equal(this.status, other.status) && Objects.equal(this.priority, other.priority) && Objects.equal(this.author, other.author) && Objects.equal(this.category, other.category) && Objects.equal(this.subject, other.subject) && Objects.equal(this.description, other.description) && Objects.equal(this.startDate, other.startDate) && Objects.equal(this.dueDate, other.dueDate) && Objects.equal(this.doneRatio, other.doneRatio) && Objects.equal(this.estimatedHours, other.estimatedHours) && Objects.equal(this.customFieldCollection, other.customFieldCollection) && Objects.equal(this.createdOn, other.createdOn) && Objects.equal(this.updatedOn, other.updatedOn);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("project", project)
                .add("tracker", tracker)
                .add("status", status)
                .add("priority", priority)
                .add("author", author)
                .add("category", category)
                .add("subject", subject)
                .add("description", description)
                .add("startDate", startDate)
                .add("dueDate", dueDate)
                .add("doneRatio", doneRatio)
                .add("estimatedHours", estimatedHours)
                .add("customFieldCollection", customFieldCollection)
                .add("createdOn", createdOn)
                .add("updatedOn", updatedOn)
                .toString();
    }
}
