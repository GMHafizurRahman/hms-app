import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {


  patients!: Patient[];

  constructor(private patientService: PatientService, private router: Router) { }

  ngOnInit(): void {
    this.getPatients();
  }

  getPatients() {
    this.patientService.getPatientList().subscribe(data => {
      this.patients = data;
    });
  }

  patientDetails(id: number){
    this.router.navigate(['patient-details', id]);
  }

  updatePatient(id: number) {
    this.router.navigate(['update-patient', id]);
  }

  deletePatient(id: number) {
    this.patientService.deletePatient(id).subscribe(data => {
      console.log(data);
      this.getPatients();
    })

  }

  url = "https://images.unsplash.com/photo-1498598457418-36ef20772bb9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80";
  selectFile(event: any) {
    if (event.target.files) {
      var reader = new FileReader()
      reader.readAsDataURL(event.target.files[0])
      reader.onload = (event: any) => {
        this.url = event.target.result
      }
    }
  }


}