package co.escuelaing.ieti.apirest.data;

public class Task {
    public int id;
    public String name;
    public String description; 
    public String status ; 
    public String assignedTo; 
    public String nadueDateme; 
    public String created; 


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return this.assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getNadueDateme() {
        return this.nadueDateme;
    }

    public void setNadueDateme(String nadueDateme) {
        this.nadueDateme = nadueDateme;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}