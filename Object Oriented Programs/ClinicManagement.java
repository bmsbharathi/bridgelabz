import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

class Doctor
{
  //declare the Datamembers of doctor
  String docId,name,specialization,availability;
  int noOfAppointments = 0;
  String appointmentWith[] = new String[5];
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
  String appointmentOn;
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


  public static void main(String args[])
  {
    Scanner scan = new Scanner(System.in);
    Doctor doc;
    Patient pat;
    String name,id,mobno,spec,availa;
    int age,choice,searchChoice;

    Doctor bharathi = new Doctor("DIM10012","Bharathi","Cardiology","PM");
    Doctor Yog = new Doctor("DIM32112","Yog","Pediatrician","AM/PM");
    Doctor Dharsh = new Doctor("DIM45635","Dharshaanaa","Radiology","AM");
    Doctor Vik = new Doctor("DIM67843","Vikram","Opthalmology","AM");

    Patient p1 = new Patient("PID001","Patient1","9865639022",22);
    Patient p2 = new Patient("PID003","Patient2","9487315110",21);

    ClinicManagement CM = new ClinicManagement();

    //Creating an arraylist of Doctors and Patients
    ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    ArrayList<Patient> patientList = new ArrayList<Patient>();

    doctorList.add(bharathi);
    doctorList.add(Yog);
    doctorList.add(Vik);
    doctorList.add(Dharsh);

    patientList.add(p1);
    patientList.add(p2);

    do {
      System.out.println("\n--------------------\nEnter your choice\n1:Add Doctor \n2:Add Patient\n3:Print all Doctor's records \n4:Print all Patient's records \n5:Search Doctor \n6:Search Patient \n7:Exit");
      choice = scan.nextInt();

      switch(choice)
      {
        case 1:

        System.out.println("Enter the Doctor ID, Name, Specialization and Availability");
        id = scan.next();
        name = scan.next();
        spec = scan.next();
        availa = scan.next();

        doc = new Doctor(id,name,spec,availa);
        doctorList.add(doc);
        break;

        case 2:

        System.out.println("Enter the Patient ID, Name, Age and Mobile number");
        id = scan.next();
        name = scan.next();
        age = scan.nextInt();
        mobno = scan.next();

        pat = new Patient(id,name,mobno,age);
        patientList.add(pat);
        break;

        case 3:
        CM.printDoctorRecords(doctorList);
        break;

        case 4:
        CM.printPatientRecords(patientList);
        break;

        case 5:
        do {
          System.out.println("\n------------\nSearch Doctor\n1:By Name \n2:By ID \n3:By Specialization\n4:By Availability");
          searchChoice = scan.nextInt();
          switch(searchChoice)
          {
            case 1:
            System.out.println("Enter the Name of the Doctor");
            name = scan.next();
            CM.findDoctorByName(doctorList,name);
            break;

            case 2:
            System.out.println("Enter the ID of the Doctor");
            id = scan.next();
            CM.findDoctorByID(doctorList,id);
            break;

            case 3:
            System.out.println("Enter the Specialization of the Doctor");
            spec = scan.next();
            CM.findDoctorBySpec(doctorList,spec);
            break;

            case 4:
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

        case 6:
        do {
          System.out.println("\n------------\nSearch Patient\n1:By Name \n2:By ID \n3:By Mobile Number");
          searchChoice = scan.nextInt();
          switch(searchChoice)
          {
            case 1:
            System.out.println("Enter the Name of the Patient");
            name = scan.next();
            CM.findPatientByName(patientList,name);
            break;

            case 2:
            System.out.println("Enter the ID of the Patient");
            id = scan.next();
            CM.findPatientByID(patientList,id);
            break;

            case 3:
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

        case 7:
        System.out.println("\nThank You!");
        System.exit(0);

        default:
        System.out.println("Enter a valid choice");
      }
    } while (choice != 7);

  }
}
