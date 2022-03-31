import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseURL = environment.apiBaseUrl;

  constructor(private httpClient: HttpClient) { }


  getPatientList(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>(`${this.baseURL}/api/v1/patients/`,);


  }

  createPatient(patient: Patient): Observable<Object> {
    return this.httpClient.post(
      `${this.baseURL}/api/v1/patients/`, patient);
  }

  getPatientById(id: number): Observable<Patient> {
    return this.httpClient.get<Patient>(`${this.baseURL}/api/v1/patients/${id}`);
  }

  updatePatient(id: number, patient: Patient): Observable<Object> {

    return this.httpClient.put(`${this.baseURL}/api/v1/patients/${id}`, patient);
  }

  deletePatient(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/api/v1/patients/${id}`);
  }


}