import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from 'model/student';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private getUrl: string;
  private addUrl: string;
  private updateUrl: string;
  private getByIdUrl: string;
  private deleteByIdUrl: string;
  constructor(private http:HttpClient)
   {
    this.getUrl="http://localhost:8080/studentdetails";
    this.addUrl="http://localhost:8080/student";
    this.updateUrl="http://localhost:8080/";
    this.getByIdUrl="http://localhost:8080";
    this.deleteByIdUrl="http://localhost:8080/student/delete/{studentId}";
    
   }
    findAll():Observable<Student[]>
   {
    return this.http.get<Student[]>(this.getUrl);
   }
    save(student:Student)
   {
    return this.http.post<Student>(this.addUrl,student);
   }
   updatetudent(studentId:number, student:Student):Observable<Object>{
    return this.http.put<Student>(`${this.updateUrl}/${studentId}`, student)
  }
  getHospital(studentId:number):Observable<Student>
  {
    return this.http.get<Student>(`${this.getByIdUrl}/${studentId}`)
  }
  deleteStudent(studentId: number): Observable<any> {
    return this.http.delete(`${this.deleteByIdUrl}/${studentId}`, { responseType: 'text' });
  }

}
