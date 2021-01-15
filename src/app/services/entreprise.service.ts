import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Entreprise } from '../interfaces/entreprise';
import { tap, catchError } from 'rxjs/operators';
import { EnterpriseRegisterReqVO } from "../interfaces/VO/req/EnterpriseRegisterReqVO";
import {BaseResVO} from "../interfaces/VO/res/BaseResVO";

@Injectable({
  providedIn: 'root'
})
export class EntrepriseService {
  // private apiEntrepriseUrl = "localhost:8000/user/enterprise/register";


  httpOptions ={
    headers : new HttpHeaders({'Content-Type':'application/json'})
  };
  constructor(private http:HttpClient) { }

  getEntreprise():Observable<Entreprise[]>{
    return this.http.get<Entreprise[]>("/api/user/enterprise/register");
  }

  getEntrepriseById(id :number):Observable<Entreprise>{
    const url = `${"/api/user/enterprise/register"}/${id}`;
    return this.http.get<Entreprise>(url)
    .pipe(tap(_=>console.log(`detail Entreprise avec id=${id}`)));
  }

  addEntreprise(entreprise : Entreprise): Observable<BaseResVO>{
    let enterpriseRegisterReqVO = new EnterpriseRegisterReqVO(entreprise);
    console.log(enterpriseRegisterReqVO)
    return this.http.post<BaseResVO>("/api/user/enterprise/register", enterpriseRegisterReqVO, this.httpOptions)
    .pipe(tap((baseResVO:BaseResVO) => console.log(baseResVO)));
  }

  updateEntreprise(entreprise : Entreprise): Observable<any>{
    const id = typeof entreprise === 'number'?entreprise:entreprise.id;
    const url = `${"/api/user/enterprise/register"}/${id}`;

    return this.http.put(url, entreprise, this.httpOptions)
    .pipe(tap(_=> console.log(`Entreprise avec l'id = ${entreprise.id} a été mis à jour `)));
  }

  deleteEntreprise(entreprise : Entreprise|number): Observable<Entreprise>{
    const id = typeof entreprise === 'number'?entreprise:entreprise.id;
    const url = `${"/api/user/enterprise/register"}/${id}`;
    return this.http.delete<Entreprise>(url, this.httpOptions)
    .pipe(tap(_=> console.log(`Entreprise avec id=${id} a été supprimer`)));
  }

}
