import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({providedIn: "root"})
export class SmartService{
  constructor(private httpClient: HttpClient) {
  }

  public getBooleanFromButton(bool: boolean): Observable<boolean>{
    const data: any = {
      bool: bool
    }
    return this.httpClient.get("http://localhost:8080", {params: data}) as Observable<boolean>;
  }
}
