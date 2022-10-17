package org.launchcode.techjobs.oo;

import java.util.Objects;
import java.lang.reflect.Field;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;
    //private String value;



    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.


        public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType posType, CoreCompetency coreComp){
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = posType;
        this.coreCompetency = coreComp;
        //System.out.println("object check"+this);
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String[] labels = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        Field[] fields = Job.class.getDeclaredFields();
        String unavailable = "Data not available";


        String message = "\n";
        int index = 0;

        for (Field f : fields) {
            if (f.getName() == "nextId") {
                // don't do anything
            } else {
                try {
                    // if this is a job field...
                    if (f.get(this) instanceof JobField) {
                        // if this job field is not completed...
                        if (((JobField) f.get(this)).getValue() == "") {
                            // print unavailable
                            message = message + labels[index] + unavailable + "\n";
                        } else {
                            // else, print job field value
                            message = message + labels[index] + f.get(this) + "\n";
                        }
                    } else if (f.get(this) == null || f.get(this) == "") { // not a job field, null or empty
                        // print unavailable
                        message = message + labels[index] + unavailable + "\n";
                    } else {
                        // else, print non-job-field value (eg. name value)
                        message = message + labels[index] + f.get(this) + "\n";
                    }
                    index++;
                } catch (Exception e) {
                    message = message + labels[index] + unavailable + "\n";
                    index++;
                }
            }
        }

        if(this.getLocation()==null && this.getEmployer() == null && this.getCoreCompetency() == null && this.getPositionType() == null && this.getName() == null)
            message = "OOPS! This job does not seem to exist.";

        return message;
    }


          /*  String unavailable = "Data Not Available";
            String jobDetails = String.format("ID: " + this.getId()
                    + "\n" + "Name: " + this.getName()
                    + "\n" + "Employer: " + this.getEmployer().getValue()
                    + "\n" + "Location: " + this.getLocation().getValue()
                    + "\n" + "Position Type: " + this.getPositionType().getValue()
                    + "\n" + "Core Competency: " + this.getCoreCompetency().getValue()
            );


            if (this.getEmployer().getValue()==null || this.getEmployer().getValue() == " ") {
                jobDetails = String.format("ID: "+this.getId()
                        +"\n"+"Name: "+this.getName()
                        +"\n"+"Employer: "+unavailable
                        +"\n"+"Location: "+this.getLocation()
                        +"\n"+"Position Type: "+this.getPositionType()
                        +"\n"+"Core Competency: "+this.getCoreCompetency()
                );
            }
            if (this.getLocation().getValue()==null || this.getLocation().getValue() == "") {
                jobDetails = String.format("ID: "+this.getId()
                        +"\n"+"Name: "+this.getName()
                        +"\n"+"Employer: "+this.getEmployer()
                        +"\n"+"Location: "+ unavailable
                        +"\n"+"Position Type: "+this.getPositionType()
                        +"\n"+"Core Competency: "+this.getCoreCompetency()
                );
             }
            if (this.getPositionType().getValue()==null || this.getPositionType().getValue() == "") {
                jobDetails = String.format("ID: "+this.getId()
                        +"\n"+"Name: "+this.getName()
                        +"\n"+"Employer: "+this.getEmployer()
                        +"\n"+"Location: "+this.getLocation()
                        +"\n"+"Position Type: "+unavailable
                        +"\n"+"Core Competency: "+this.getCoreCompetency()
                );

            }
            if (this.getCoreCompetency().getValue()==null || this.getCoreCompetency().getValue() == "") {
                jobDetails = String.format("ID: "+this.getId()
                        +"\n"+"Name: "+this.getName()
                        +"\n"+"Employer: "+this.getEmployer()
                        +"\n"+"Location: "+this.getLocation()
                        +"\n"+"Position Type: "+this.getPositionType()
                        +"\n"+"Core Competency: "+unavailable
                );
            }

            System.out.println("from to string : "+ jobDetails);
            return "\n"+jobDetails+"\n";
    }*/

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


}
