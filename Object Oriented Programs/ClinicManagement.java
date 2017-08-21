import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/*
  Created By: Bharathi B.M.S
  Date: 19-08-2017
  Purpose: A Clinic Management program that can add doctors and patients, prints all the doctor and
  patient records, search doctor and patient records that are available and fix appointment with a doctor.

*/

class Appointment
{
  int noOfAppointment=0;
  Doctor doctor;
  Patient patient;
  String strDate;
  DateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
  Map<Date,Doctor> appointment = new HashMap<Date,Doctor>();
  Map<Map,String> patientAppointmentMap = new HashMap<Map,String>();

  //To set appointment with a particular doctor on a particular date
  void setAppointment(Date date, Doctor d, Patient p) throws ParseException {    
    doctor = d;
    patient = p;

    // To check if the doctor has other appointment on that day
    if(doctor.appointmentCount.containsKey(date))   
    {
      noOfAppointment = doctor.appointmentCount.get(date);
      if( noOfAppointment >= 2){      // To check if the doctor has more than 2 appointments on that day
        System.out.println("\nAppointments full for the doctor on the particular day");
      }
      else                            //Creating an appointment and puttingit in appointment Map
      {
        noOfAppointment++;
        appointment.put(date,doctor);
        doctor.appointmentCount.put(date,noOfAppointment);
        strDate = simpleFormat.format(date);
        
        
        doctor.patientsList.add(patient.patId);
        System.out.println("\nAppointment set with Doctor: "+doctor.name+" Specialist in "+doctor.specialization+" on "+simpleFormat.format(date));
      }
    }
      
    else{                             //Creating an appointment and puttingit in appointment Map
          appointment.put(date,doctor);
          doctor.appointmentCount.put(date,1);
          strDate = simpleFormat.format(date);
          
          doctor.patientsList.add(patient.patId);
          System.out.println("\nAppointment set with Doctor: "+doctor.name+" Specialist in "+doctor.specialization+" on "+simpleFormat.format(date));
    }

  }

  //Printing all the available appointments
  void printAllAppointments()
  {
    int i=0,size;
    Set patMapSet = appointment.entrySet();
    Iterator mapIter = patMapSet.iterator(); 
    
    if(appointment.isEmpty()){
      System.out.println("No appointments yet!");
    }
    
    for (Object obj : appointment.entrySet()) {
     Map.Entry<Date, Doctor> entry = (Map.Entry) obj;
     System.out.println("");
     Date date = entry.getKey();
     Doctor d = entry.getValue();
     System.out.println("\n#:");

     System.out.print("Name of the Doctor: " + d.name);
     System.out.println("\nWith Patient: " + d.patientsList.get(i));

     System.out.println("on : " + simpleFormat.format(date));
     System.out.println("\n");
     i++;
    }

  }
}

class Doctor
{
  //declare the Datamembers of doctor
  String docId,name,specialization,availability;
  Map<Date,Integer> appointmentCount = new HashMap<Date,Integer>();
  ArrayList<String> patientsList = new ArrayList<String>();

  //Constructor to initialize the datamembers
  Doctor(String id,String dname,String spec, String availa)
  {
    docId = id;
    name = dname;
    specialization = spec;
    availability = availa;
  }

  //toString method to print the details of the object
  public String toString()
  {
    return "\nDoctor ID: "+docId+" \nDoctor Name: "+name+" \nSpecialization: " +specialization+
    " \navailability: "+availability+"\n";
  }
}

class Patient
{
  //declare the Datamembers of doctor
  String patId,patName,mobileNo,appointmentWith;
  int age;

  //Constructor to initialize the datamembers
  Patient(String pid,String pname,String mobno, int ag)
  {
    patId = pid;
    patName = pname;
    mobileNo = mobno;
    age = ag;
  }

  //toString method to print the details of the object
  public String toString()
  {
    return "\nPatient ID: "+patId+" \nPatient Name: "
    +patName+" \nMobile Number: "+mobileNo+" \nAge: "+age+"\n";
  }
}

class ClinicManagement
{
  //Searches Doctor ArrayList using name and prints the details if found
  public void findDoctorByName(ArrayList<Doctor> doctorList, String dname)
  {
    int flag =0;
    Iterator iter = doctorList.iterator();

    while(iter.hasNext())
    {
      Doctor d = (Doctor)iter.next();
      if(dname.equals(d.name))
      {
        flag =1;
        System.out.println("flag!!!");
        System.out.println("\nDoctor Found!");
        System.out.println("Doctor ID: "+d.docId);
        System.out.println("Doctor Name: "+d.name);
        System.out.println("Specialization: "+d.specialization);
        System.out.println("Availability: "+d.availability);

      }

    }
    if(flag == 0)
    {
      System.out.println("Doctor Not Found");
    }
  }

  //Searches Doctor ArrayList using Specialization and prints the details if found
  public void findDoctorBySpec(ArrayList<Doctor> doctorList, String spec)
  {
    int flag =0;
    Iterator iter = doctorList.iterator();

    while(iter.hasNext())
    {
      Doctor d = (Doctor)iter.next();
      if(spec.equals(d.specialization))
      {
        flag =1;
        System.out.println("\nDoctor Found!");
        System.out.println("Doctor ID: "+d.docId);
        System.out.println("Doctor Name: "+d.name);
        System.out.println("Specialization: "+d.specialization);
        System.out.println("Availability: "+d.availability);
      }
    }
    if(flag == 0)
    {
      System.out.println("Doctor Not Found");
    }
  }

  //Searches Doctor ArrayList using Availability and prints the details if found
  public void findDoctorByAvaila(ArrayList<Doctor> doctorList, String availa)
  {
    int flag =0;
    Iterator iter = doctorList.iterator();

    while(iter.hasNext())
    {
      Doctor d = (Doctor)iter.next();
      if(availa.equals(d.availability))
      {
        flag =1;
        System.out.println("\nDoctor Found!");
        System.out.println("Doctor ID: "+d.docId);
        System.out.println("Doctor Name: "+d.name);
        System.out.println("Specialization: "+d.specialization);
        System.out.println("Availability: "+d.availability);
      }
    }
    if(flag == 0)
    {
      System.out.println("Doctor Not Found");
    }
  }

  //Searches Doctor ArrayList using Doctor ID and prints the details if found
  public void findDoctorByID(ArrayList<Doctor> doctorList, String did)
  {
    int flag =0;
    Iterator iter = doctorList.iterator();
    while(iter.hasNext())
    {
      Doctor d = (Doctor)iter.next();
      if(did.equals(d.docId))
      {
        flag =1;
        System.out.println("\nDoctor Found!");
        System.out.println("Doctor ID: "+d.docId);
        System.out.println("Doctor Name: "+d.name);
        System.out.println("Specialization: "+d.specialization);
        System.out.println("Availability: "+d.availability);
      }
    }
    if (flag ==0)
    {
      System.out.println("Doctor Not Found");
    }
  }

  //Searches Patient ArrayList using Patient ID and prints the details if found
  public void findPatientByID(ArrayList<Patient> patientList, String pid)
  {
    int flag =0;
    Iterator iter = patientList.iterator();
    while(iter.hasNext())
    {
      Patient p = (Patient)iter.next();
      if(pid.equals(p.patId))
      {
        flag =1;
        System.out.println("\nPatient Found!");
        System.out.println("Patient ID: "+p.patId);
        System.out.println("Patient Name: "+p.patName);
        System.out.println("Age: "+p.age);
        System.out.println("Mobile Number: "+p.mobileNo);
      }
    }
    if (flag ==0)
    {
      System.out.println("Patient Not Found");
    }
  }

  //Searches the Patient ArrayList using Name and prints the details if found
  public void findPatientByName(ArrayList<Patient> patientList, String pname)
  {
    int flag =0;
    Iterator iter = patientList.iterator();
    while(iter.hasNext())
    {
      Patient p = (Patient)iter.next();
      if(pname.equals(p.patName))
      {
        flag =1;
        System.out.println("\nPatient Found!");
        System.out.println("Patient ID: "+p.patId);
        System.out.println("Patient Name: "+p.patName);
        System.out.println("Age: "+p.age);
        System.out.println("Mobile Number: "+p.mobileNo);
      }
    }
    if (flag ==0)
    {
      System.out.println("Patient Not Found");
    }
  }

  //Searches Patient ArrayList using Mobile number and prints the details if found
  public void findPatientByMobNo(ArrayList<Patient> patientList, String mobno)
  {
    int flag =0;
    Iterator iter = patientList.iterator();
    while(iter.hasNext())
    {
      Patient p = (Patient)iter.next();
      if(mobno.equals(p.mobileNo))
      {
        flag =1;
        System.out.println("\nPatient Found!");
        System.out.println("Patient ID: "+p.patId);
        System.out.println("Patient Name: "+p.patName);
        System.out.println("Age: "+p.age);
        System.out.println("Mobile Number: "+p.mobileNo);
      }
    }
    if (flag ==0)
    {
      System.out.println("Patient Not Found");
    }
  }

  //Prints all the available details in the Doctor ArrayList
  void printDoctorRecords(ArrayList<Doctor> doc)
  {
    Iterator iter = doc.iterator();

    while(iter.hasNext())
    {
      Doctor d = (Doctor)iter.next();

      System.out.println("\nDoctor ID: "+d.docId);
      System.out.println("Doctor Name: "+d.name);
      System.out.println("Specialization: "+d.specialization);
      System.out.println("Availability: "+d.availability);
      System.out.println("");

    }
  }

  //Prints all the available details in the Patient ArrayList
  void printPatientRecords(ArrayList<Patient> p)
  {
    Iterator iter = p.iterator();
    while(iter.hasNext())
    {
      Patient pat = (Patient)iter.next();
      System.out.println("\nPatient ID: "+pat.patId);
      System.out.println("Patient Name: "+pat.patName);
      System.out.println("Age: "+pat.age);
      System.out.println("Mobile Number: "+pat.mobileNo);
      System.out.println("");
    }
  }


  public static void main(String args[]) throws ParseException
  {
    //Initializing all the variables
    Scanner scan = new Scanner(System.in);
    Doctor doc;
    Patient pat;
    String name,id,mobno,spec,availa,dateString;
    int age,choice,searchChoice,flag=0,flag1=0;
    Date date;

    //Creating objects of Doctor class
    Doctor bharathi = new Doctor("DIM10012","Bharathi","Cardiology","PM");
    Doctor Yog = new Doctor("DIM32112","Yog","Pediatrician","AM/PM");
    Doctor Dharsh = new Doctor("DIM45635","Dharshaanaa","Radiology","AM");
    Doctor Vik = new Doctor("DIM67843","Vikram","Opthalmology","AM");

    //Creating objects of Patient class
    Patient p1 = new Patient("PID001","Patient1","9865639022",22);
    Patient p2 = new Patient("PID003","Patient2","9487315110",21);
    Patient p3 = new Patient("PID002","Patient3","9489317201",23);

    //Creating an object of ClinicManagement class
    ClinicManagement CM = new ClinicManagement();

    //Creating an object of Appointment class
    Appointment appoint = new Appointment();

    //Creating an arraylist of Doctors and Patients
    ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    ArrayList<Patient> patientList = new ArrayList<Patient>();

    //Adding the created objects of Doctor class to the Doctor ArrayList
    doctorList.add(bharathi);
    doctorList.add(Yog);
    doctorList.add(Vik);
    doctorList.add(Dharsh);

    //Adding the created objects of Patient class to the Patient ArrayList
    patientList.add(p1);
    patientList.add(p2);
    patientList.add(p3);

    //do..while(); to get the create the user driven menu
    do {
      System.out.println("\n--------------------\nEnter your choice\n1:Add Doctor \n2:Add Patient"
      +"\n3:Print all Doctor's records \n4:Print all Patient's records \n5:Search Doctor \n6:Search Patient "
      +"\n7:Set Appointment\n8:Print all appointments \n9:Exit");
      choice = scan.nextInt();

      switch(choice)
      {
        case 1:       //Adding a new Doctor to the ArrayList
        System.out.println("Enter the Doctor ID, Name, Specialization and Availability");
        id = scan.next();
        name = scan.next();
        spec = scan.next();
        availa = scan.next();

        doc = new Doctor(id,name,spec,availa);
        doctorList.add(doc);
        break;

        case 2:                                     //Adding a new Patient to the ArrayList
        System.out.println("Enter the Patient ID, Name, Age and Mobile number");
        id = scan.next();
        name = scan.next();
        age = scan.nextInt();
        mobno = scan.next();

        pat = new Patient(id,name,mobno,age);
        patientList.add(pat);
        break;

        case 3:
        CM.printDoctorRecords(doctorList);          //Prints all the details of Doctor available in
        break;

        case 4:
        CM.printPatientRecords(patientList);        //Prints all the details of Patient available in
        break;

        case 5:                                     //Searches Doctor by ID, Name, Availability and Specialization
        do {
          System.out.println("\n------------\nSearch Doctor\n1:By Name \n2:By ID \n"
          +"3:By Specialization\n4:By Availability");
          searchChoice = scan.nextInt();
          switch(searchChoice)
          {
            case 1:                               //Searches Doctor by Name
            System.out.println("Enter the Name of the Doctor");
            name = scan.next();
            CM.findDoctorByName(doctorList,name);
            break;

            case 2:                               //Searches Doctor by ID
            System.out.println("Enter the ID of the Doctor");
            id = scan.next();
            CM.findDoctorByID(doctorList,id);
            break;

            case 3:                               //Searches Doctor by Specialization
            System.out.println("Enter the Specialization of the Doctor");
            spec = scan.next();
            CM.findDoctorBySpec(doctorList,spec);
            break;

            case 4:                               //Searches Doctor by Availability
            System.out.println("Enter the Availability of the Doctor");
            spec = scan.next();
            CM.findDoctorByAvaila(doctorList,spec);
            break;
            case 5:
            System.exit(0);
            default:
            System.out.println("Enter a valid choice");
          }
        } while ( searchChoice!=4);
        break;

        case 6:                                 //Searches Patient by Name, ID, Mobile Number
        do {
          System.out.println("\n------------\nSearch Patient\n1:By Name \n2:By ID \n3:By Mobile"
          +" Number");
          searchChoice = scan.nextInt();
          switch(searchChoice)
          {
            case 1:                             //Searches Patient by Name
            System.out.println("Enter the Name of the Patient");
            name = scan.next();
            CM.findPatientByName(patientList,name);
            break;

            case 2:                             //Searches Patient by ID
            System.out.println("Enter the ID of the Patient");
            id = scan.next();
            CM.findPatientByID(patientList,id);
            break;

            case 3:                             //Searches Patient by Mobile Number
            System.out.println("Enter the Mobile Number of the Patient");
            mobno = scan.next();
            CM.findPatientByMobNo(patientList,mobno);
            break;

            case 4:
            System.exit(0);
            default:
            System.out.println("Enter a valid choice");
          }
        } while ( searchChoice!=4);
        break;

        case 7:                                 //Sets up appointment for patient by getting Doctor name, patient ID and Date
        System.out.println("Enter the Doctor name");
        name = scan.next();
        System.out.println("Enter the Patient ID");
        id = scan.next();
        System.out.println("Enter the date");
        dateString = scan.next();
        DateFormat format = new SimpleDateFormat("dd/MM/yy");
        date = format.parse(dateString); 

        Iterator docIter = doctorList.iterator();
        Iterator patIter = patientList.iterator();
        Doctor d = null;
        while(docIter.hasNext())
        {
          d = (Doctor)docIter.next();
          if(d.name.equals(name))
          {
            flag = 1;
            break;
          }
        }
        if(flag ==1)
        {
          while(patIter.hasNext())
          {
            Patient p = (Patient)patIter.next();
            if(p.patId.equals(id))
            {
              appoint.setAppointment(date,d,p);         //Set appointment function from Appointment class is called
              flag1=1;
            }
          }
        }
        if(flag == 0)
        {
          System.out.println("\nDoctor not found");
        }
        if(flag1 == 0)
        {
          System.out.println("\nPatient not found");
        }

        break;
        case 8:
        System.out.println("\nAppointments: ");
        appoint.printAllAppointments();
        break;

        case 9:                                 //Exit case
        System.out.println("\nThank You!");
        System.exit(0);

        default:
        System.out.println("Enter a valid choice");
      }
    } while (choice != 9);

  }
}
