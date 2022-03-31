import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {

  submitted = false;
  patient: Patient = new Patient();
  registerForm!: FormGroup;

  constructor(private patientService: PatientService, private router: Router, private formBuilder: FormBuilder) {
  }


  ngOnInit(): void {

    this.registerForm = this.formBuilder.group({
      patientName: ['', Validators.required]

    });

  }

  onSubmit() {

    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }

    alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value))

    console.log(this.patient);
    this.savePatient();
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }



  savePatient() {
    this.patientService.createPatient(this.patient).subscribe(data => {
      console.log(data);
      this.goToPatientList();
    });
  }





  goToPatientList() {
    this.router.navigate(['/patients']);
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