import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SearchFilter, Transaction} from "./transaction";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private  http: HttpClient) {}

  public getTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.apiServerUrl}/transaction/all`);
  }

  public getTransactionById(id: number): Observable<Transaction> {
    return this.http.get<Transaction>(`${this.apiServerUrl}/transaction/${id}`);
  }

  public addTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(`${this.apiServerUrl}/transaction/add`,transaction);
  }

  public updateTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.put<Transaction>(`${this.apiServerUrl}/transaction/update`,transaction);
  }

  public removeTransactionById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/transaction/${id}`);
  }

  public removeAllTransactions(): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/transaction/all`);
  }

  public findTransactions(searchFilter: SearchFilter): Observable<Transaction[]> {
    return this.http.post<Transaction[]>(`${this.apiServerUrl}/transaction/find`,searchFilter);
  }
}
