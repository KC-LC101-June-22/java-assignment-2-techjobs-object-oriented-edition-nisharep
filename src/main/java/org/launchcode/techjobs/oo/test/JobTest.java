package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job testJob2;
    Job testJob3;

    @Test
    public void testSettingJobId()
    {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
        //assertNotEquals(empty job constructor);
        assertNotEquals(emptyJob1.getId(),emptyJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields()
    {
        assertTrue(testJob1 instanceof Job);

        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob1.getId()!=0);

        assertEquals("Product tester", testJob1.getName());
        assertEquals("ACME", testJob1.getEmployer().getValue());
        assertEquals("Desert", testJob1.getLocation().getValue());
        assertEquals("Quality control", testJob1.getPositionType().getValue());
        assertEquals("Persistence", testJob1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        testJob2 = new Job("Data Analyst", new Employer("INE"), new Location("Raleigh"), new PositionType("Data Analyst Full Time"), new CoreCompetency("SQL"));
        testJob3 = new Job("Data Analyst", new Employer("INE"), new Location("Raleigh"), new PositionType("Data Analyst Full Time"), new CoreCompetency("SQL"));
        assertFalse(testJob2.equals(testJob3));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine()
    {
        assertEquals('\n', testJob1.toString().charAt(0));
        assertEquals('\n', testJob1.toString().charAt(testJob1.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData()
    {
        String[] splitLines = testJob1.toString().trim().split("\n");

       // System.out.println(testJob1.toString());

        assertTrue(splitLines[0].startsWith("ID:"));
        assertTrue(splitLines[1].startsWith("Name:"));
        assertTrue(splitLines[2].startsWith("Employer:"));
        assertTrue(splitLines[3].startsWith("Location:"));
        assertTrue(splitLines[4].startsWith("Position Type:"));
        assertTrue(splitLines[5].startsWith("Core Competency:"));

        assertTrue(splitLines[0].endsWith(Integer.toString(testJob1.getId())));
        assertTrue(splitLines[1].endsWith(testJob1.getName()));
        assertTrue(splitLines[2].endsWith(testJob1.getEmployer().toString()));
        assertTrue(splitLines[3].endsWith(testJob1.getLocation().toString()));
        assertTrue(splitLines[4].endsWith(testJob1.getPositionType().toString()));
        assertTrue(splitLines[5].endsWith(testJob1.getCoreCompetency().toString()));

        assertEquals("Product tester", testJob1.getName());
        assertEquals("ACME", testJob1.getEmployer().getValue());
        assertEquals("Desert", testJob1.getLocation().getValue());
        assertEquals("Quality control", testJob1.getPositionType().getValue());
        assertEquals("Persistence", testJob1.getCoreCompetency().getValue());
    }

    @Test
    public void testToStringHandlesEmptyField(){

        Job job2 = new Job("Senior Data Scientist",
                new Employer(""),
                new Location("OHIO"),
                new PositionType("Data Scientist Full Time"),
                new CoreCompetency(""));

        //System.out.println("test Obj"+job2.toString());

        String[] lines = job2.toString().trim().split("\n");

        for (int i=0; i<lines.length; i++) {
            String[] field = lines.toString().trim().split(":");
            if (field[0].equals("Employer")){
                assertEquals(field[1],"Data not available");
            } else if (field[0].equals("Core Competency")) {
                assertEquals(field[1],"Data not available");
            }
        }

        //Bonus Mission

        Job testJob = new Job();
       // System.out.println("test Obj"+ testJob.toString());
        assertEquals(testJob.toString(), "OOPS! This job does not seem to exist.");

    }


}
