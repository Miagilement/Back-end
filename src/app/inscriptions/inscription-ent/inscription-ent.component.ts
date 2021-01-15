import { Component, OnInit } from '@angular/core';
import { Validators,FormBuilder, FormGroup } from '@angular/forms';

import { Entreprise } from 'src/app/interfaces/entreprise';
import { EntrepriseService } from 'src/app/services/entreprise.service';

@Component({
  selector: 'app-inscription-ent',
  templateUrl: './inscription-ent.component.html',
  styleUrls: ['./inscription-ent.component.css']
})
export class InscriptionEntComponent implements OnInit {

  entreprise : Entreprise[]=[];

  constructor(
    private fb : FormBuilder,
    private entrepriseService : EntrepriseService
  ) { }

  ngOnInit(): void {
    this.getApiEntreprise();
  }


    inscriptionsForm = this.fb.group({
      nameEnterprise: ['', Validators.required],
      password: ['', Validators.required],
      groupAffiliated: ['', Validators.required],
      sectorActivity: ['', Validators.required],
      region: ['', Validators.required],
      turnOver: ['', Validators.required],
      description: ['', Validators.required],
      siret: ['', Validators.required]
    });

    getApiEntreprise():void{
      this.entrepriseService.getEntreprise()
      .subscribe((entreprise :Entreprise[])=>{
        console.log(entreprise);
        this.entreprise = entreprise;
      });
    }

    addEntreprise():void{
      this.entrepriseService.addEntreprise(this.inscriptionsForm.value)
      .subscribe(baseResVO =>  {this.entreprise.push(<Entreprise>baseResVO.data)});
      this.resetInscriptionForm();
    }
    delete(entreprise:Entreprise):void{
      this.entreprise = this.entreprise.filter(h => h.id!==entreprise.id);
      this.entrepriseService.deleteEntreprise(entreprise)
      .subscribe((x) => {
        this.entreprise.splice(this.entreprise.indexOf(entreprise),1)
      });
    }

  resetInscriptionForm(){
    this.inscriptionsForm.reset();
  }
  onSubmitInscriptionEnt(){
    const newEntreprise : Entreprise = this.inscriptionsForm.value;
    console.log(newEntreprise);
    this.resetInscriptionForm();
  }

}
