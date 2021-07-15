package entities;

enum Status
{
    AVAILABLE, MOTION, DONE;
}
public class Trip
{

    protected long id;
    protected Status status;
    protected String placeBegin;
    protected String destination;
    protected String hourBegin;
    protected String hourEnd;
    protected String costumerName;
    protected String costumerTel;
    protected String costumerEmail;

    public Trip() {
        this.id = 0;
        this.status = Status.AVAILABLE;
        this.placeBegin = "";
        this.destination = "";
        this.hourBegin = "";
        this.hourEnd = "";
        this.costumerName = "";
        this.costumerTel = "";
        this.costumerEmail = "";
    }

    public Trip(long id, Status status, String placeBegin, String destination, String hourBegin, String hourEnd, String costumerName, String costumerTel, String costumerEmail) {
        this.id = id;
        this.status = status;
        this.placeBegin = placeBegin;
        this.destination = destination;
        this.hourBegin = hourBegin;
        this.hourEnd = hourEnd;
        this.costumerName = costumerName;
        this.costumerTel = costumerTel;
        this.costumerEmail = costumerEmail;
    }

    public Trip(Trip t) {
        this.id = t.getId();
        this.status = t.getStatus();
        this.placeBegin = t.getPlaceBegin();
        this.destination = t.getDestination();
        this.hourBegin = t.hourBegin;
        this.hourEnd = t.getHourEnd();
        this.costumerName = t.getCostumerName();
        this.costumerTel = t.getCostumerTel();
        this.costumerEmail = t.getCostumerEmail();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPlaceBegin() {
        return placeBegin;
    }

    public void setPlaceBegin(String placeBegin) {
        this.placeBegin = placeBegin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHourBegin() {
        return hourBegin;
    }

    public void setHourBegin(String hourBegin) {
        this.hourBegin = hourBegin;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getCostumerTel() {
        return costumerTel;
    }

    public void setCostumerTel(String costumerTel) {
        this.costumerTel = costumerTel;
    }

    public String getCostumerEmail() {
        return costumerEmail;
    }

    public void setCostumerEmail(String costumerEmail) {
        this.costumerEmail = costumerEmail;
    }

    public void toString(Trip trip){
        System.out.println("begining place: "+placeBegin+", costumers name: "+costumerName+", costumers number: "+ costumerTel+"/n");
    }
}

